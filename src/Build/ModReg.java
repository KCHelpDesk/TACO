package Build;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class ModReg {
	static ArrayList<String> regKeys = new ArrayList<String>();
	
	public static String buildRegString(String string) {
		return "reg add \"HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VolumeCaches\\" + string + "\" /v StateFlags5000 /t REG_DWORD /d 2 /f";
	}

	public static void addRegServicePackCleanup() {
		getRegKeys().add(buildRegString("Service Pack Cleanup"));		
	}

	public static void addRegOldChkDskFiles() {
		getRegKeys().add(buildRegString("Old ChkDsk Files"));
	}

	public static void addRegSystemErrorMemoryDumpFiles() {
		getRegKeys().add(buildRegString("System error memory dump files"));
	}

	public static void addRegSystemErrorMinidumpFiles() {
		getRegKeys().add(buildRegString("System error minidump files"));
	}

	public static void addRegMemoryDumpFiles() {
		getRegKeys().add(buildRegString("Memory Dump Files"));
	}

	public static void addRegUpdateCleanup() {
		getRegKeys().add(buildRegString("Update Cleanup"));
	}

	public static void addRegWindowsErrorReportingArchiveFiles() {
		getRegKeys().add(buildRegString("Windows Error Reporting Archive Files"));
	}

	public static void addRegWindowsErrorReportingQueueFiles() {
		getRegKeys().add(buildRegString("Windows Error Reporting Queue Files"));
	}

	public static void addRegWindowsErrorReportingSystemArchiveFiles() {
		getRegKeys().add(buildRegString("Windows Error Reporting System Archive Files"));
	}

	public static void addRegWindowsErrorReportingSystemQueueFiles() {
		getRegKeys().add(buildRegString("Windows Error Reporting System Queue Files"));
	}

	public static void addRegActiveSetupTempFolders() {
		getRegKeys().add(buildRegString("Active Setup Temp Folders"));
	}

	public static void addRegDownloadedProgramFiles() {
		getRegKeys().add(buildRegString("Downloaded Program Files"));
	}

	public static void addRegInternetCacheFiles() {
		getRegKeys().add(buildRegString("Internet Cache Files"));
	}

	public static void addRegTemporaryFiles() {
		getRegKeys().add(buildRegString("Temporary Files"));
	}

	public static void addRegTemporarySetupFiles() {
		getRegKeys().add(buildRegString("Temporary Setup Files"));
	}

	public static void addRegBranchCache() {
		getRegKeys().add(buildRegString("BranchCache"));
	}

	public static void addRegThumbnailCache() {
		getRegKeys().add(buildRegString("Thumbnail Cache"));
	}

	public static void addRegWindowsDefender() {
		getRegKeys().add(buildRegString("Windows Defender"));
	}

	public static void addRegSetupLogFiles() {
		getRegKeys().add(buildRegString("Setup Log Files"));
	}

	public static void addRegWindowsUpgradeLogFiles() {
		getRegKeys().add(buildRegString("Windows Upgrade Log Files"));
	}

	public static void addRegUserFilesVersions() {
		getRegKeys().add(buildRegString("User file versions"));
	}

	public static void addRegRecycleBin() {
		getRegKeys().add(buildRegString("Recycle Bin"));
	}

	public static void addRegPreviousInstallations() {
		getRegKeys().add(buildRegString("Previous Installations"));
	}

	public static void addRegUpgradeDiscardedFiles() {
		getRegKeys().add(buildRegString("Upgrade Discarded Files"));
	}
	
	public static ArrayList<String> getRegKeys() {
		return regKeys;
	}

	public static void buildAndExecuteBat() {
		boolean isBatBuilt = false;
		isBatBuilt = buildBat();
		if (isBatBuilt) executeBat();
	}
	
	static boolean buildBat() {
		File batFile = new File("src/Build/resources/execute.bat");
		Path getAdmin = new File("src/Build/resources/getAdminShell.taco").toPath();
		Path deleteStateFlagsPath = new File("src/Build/resources/deleteStateFlags.taco").toPath();
		BufferedWriter output = null;
		try {
			output =  new BufferedWriter(new FileWriter(batFile));
			
			List<String> getAdminPriv = Files.readAllLines(getAdmin);
			for (String admin : getAdminPriv){
				output.write(admin);
				output.newLine();
			}
			
			for (String regKeys : getRegKeys()){
				output.write(regKeys);
				output.newLine();
			}
			
			output.write("cleanmgr /d %SYSTEMROOT% /sagerun:5000");
			
			List<String> deleteStateFlags = Files.readAllLines(deleteStateFlagsPath);
			for (String deleteSFlags : deleteStateFlags) {
				output.write(deleteSFlags);
				output.newLine();
			}
			output.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
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
