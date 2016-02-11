package Build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BuildExecuteBat {
	private static File batFile = new File("src/Build/resources/execute.bat");
	
	public static File getBatFile() {
		return batFile;
	}
	
	public static void buildAndExecuteBat() {
		boolean isBatBuilt = false;
		isBatBuilt = buildBat();
		if (isBatBuilt) executeBat();
	}
	
	static boolean buildBat() {		
		Path getAdmin = new File("src/Build/resources/getAdminShell.taco").toPath();
		Path deleteStateFlagsPath = new File("src/Build/resources/deleteStateFlags.taco").toPath();
		BufferedWriter output = null;
		try {
			output =  new BufferedWriter(new FileWriter(getBatFile()));
			
			List<String> getAdminPriv = Files.readAllLines(getAdmin);
			for (String admin : getAdminPriv){
				output.write(admin);
				output.newLine();
			}
			
			for (String regKeys : ModReg.getRegKeysAdd()){
				output.write(regKeys);
				output.newLine();
			}
			
			appendBat(("cleanmgr /d %SYSTEMROOT% /sagerun:5000"));
			
			List<String> deleteStateFlags = Files.readAllLines(deleteStateFlagsPath);
			for (String deleteSFlags : deleteStateFlags) {
				output.write(deleteSFlags);
				output.newLine();
			}
			output.close();
			getBatFile().deleteOnExit();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
	
	public static void appendBat(List<String> list){
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(getBatFile()));
			for (String string : list){
				output.write(string);
				output.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static boolean appendBat(String string){
		try {
			BufferedWriter output =  new BufferedWriter(new FileWriter(getBatFile()));
			output.write(string);
			output.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static boolean appendBat(File file){
		Path path = file.toPath();
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(getBatFile()));
			
			List<String> lines = Files.readAllLines(path);
			for (String line : lines){
				output.write(line);
				output.newLine();
			}
			output.close();
			return true;
		}
		catch (IOException e){
			return false;
		}
	}
	
	static void executeBat() {
		String executeBat = new File("src/Build/resources/execute.bat").toPath().toString();
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
