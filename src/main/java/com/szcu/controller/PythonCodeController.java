package com.szcu.controller;

import com.szcu.model.CodeWrapper;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PythonCodeController {

	@PostMapping("/executePython")
	@ResponseBody
	public String executePythonCode(@RequestBody CodeWrapper codeWrapper) {
		String code = codeWrapper.getCode();
		String params = codeWrapper.getParams();
		List<String> command = new ArrayList<>(Arrays.asList("python3", "-c", code));

		ProcessBuilder processBuilder = new ProcessBuilder(command);

		try {
			Process process = processBuilder.start();

			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
				// Write the input to the process's input stream
				writer.write(params);
				writer.newLine();
				writer.flush();
			}

			StringBuilder output = new StringBuilder();
			StringBuilder errors = new StringBuilder();

			try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
				 BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {

				String line;
				while ((line = stdInput.readLine()) != null) {
					output.append(line).append("\n");
				}

				while ((line = stdError.readLine()) != null) {
					errors.append(line).append("\n");
				}
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				return output.toString();
			} else {
				return "Error in executing the script:\n\n" + errors.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred during script execution.";
		}
	}
}
