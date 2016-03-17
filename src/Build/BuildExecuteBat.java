package Build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BuildExecuteBat {
	private static final File batFile = new File("resources/execute.bat");
	
	public static File getBatFile() {
		return batFile;
	}
	
	static void buildBat() {
		//Cleans the bat and marks it for deletion.
		try {
			BufferedWriter output =  new BufferedWriter(new FileWriter(getBatFile()));
			output.write("");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getBatFile().deleteOnExit();
	}
	
	public static void appendBat(List<String> list){
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(getBatFile(), true));
			for (String string : list){
				output.write(string);
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static boolean appendBat(String string){
		try {
			BufferedWriter output =  new BufferedWriter(new FileWriter(getBatFile(), true));
			output.write(string);
			output.newLine();
			output.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static void appendBat(File file){
		Path path = file.toPath();
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(getBatFile(),true));
			
			List<String> lines = Files.readAllLines(path);
			for (String line : lines){
				output.write(line);
				output.newLine();
			}
			output.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	static void executeBat() {
		String executeBat = getBatFile().toString();
		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", executeBat);
		processBuilder.redirectErrorStream(true);
		Process process;
		try {
			process = processBuilder.start();
			process.waitFor();
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
