
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PythonCodeExecutionController {

	@PostMapping("/executePython")
	public String executePythonCode(@RequestBody String pythonCode) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		// Assuming Python is installed and in the system's PATH
		processBuilder.command("python", "-c", pythonCode);

		try {
			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line).append("\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				return output.toString();
			} else {
				// Handle the case where the script execution fails
				return "Error in executing the script";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred during script execution.";
		}
	}
}
