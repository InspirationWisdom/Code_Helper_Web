package com.szcu.controller;

import com.szcu.model.CodeWrapper;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@CrossOrigin("*")
public class PythonCodeController {

	@PostMapping("/executePython")
	@ResponseBody
	public String executePythonCode(@RequestBody CodeWrapper codeWrapper) {
		String code = codeWrapper.getCode();
		ProcessBuilder processBuilder = new ProcessBuilder();
		// Assuming Python is installed and in the system's PATH
		processBuilder.command("python3", "-c", code);

		try {
			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			StringBuilder errors = new StringBuilder();

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			String line;
			while ((line = stdInput.readLine()) != null) {
				output.append(line).append("\n");
			}

			while ((line = stdError.readLine()) != null) {
				errors.append(line).append("\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				return output.toString();
			} else {
				// Return error information if the script execution fails
				return "Error in executing the script:\n\n" + errors.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred during script execution.";
		}
	}
}
