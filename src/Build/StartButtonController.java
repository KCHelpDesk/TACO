package Build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StartButtonController {
	private static File adminShellFile = new File("src/Build/resources/getAdminShell.taco");
	
	public static boolean executeStartButton() {
		try {
			//Add get admin priv to top of bat
			BuildExecuteBat.appendBat(getAdminShellFile());
			//Add reg add keys
			buildModRegAddKeyArray();
			BuildExecuteBat.appendBat(ModReg.getRegKeysAdd());
			//Add execute cleanmgr
			BuildExecuteBat.appendBat("cleanmgr /d %SYSTEMROOT% /sagerun:5000");
			//Add delete regkeys
			buildModRegDeleteKeyArray();
			BuildExecuteBat.appendBat(ModReg.getRegKeysDelete());
			
			BuildExecuteBat.executeBat();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	

	private static void addAdminShell(File batFile){
		Path getAdmin = new File("src/Build/resources/getAdminShell.taco").toPath();
		try {
			BufferedWriter output =  new BufferedWriter(new FileWriter(batFile));
			
			List<String> getAdminPriv = Files.readAllLines(getAdmin);
			for (String admin : getAdminPriv){
				output.write(admin);
				output.newLine();
			}
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void buildModRegDeleteKeyArray() {
		List<String> deleteArr = ModReg.getRegKeysDelete();
		String deleteStateFlagsFileLocation = "src/Build/resources/deleteStateFlags.taco";
		try (Stream<String> stream = Files.lines(Paths.get(deleteStateFlagsFileLocation))){
			deleteArr = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void buildModRegAddKeyArray() {
		if (CleanerGUI.getCheckBoxWinUpClean().isSelected()) {
			ModReg.addRegServicePackCleanup();
			ModReg.addRegUpdateCleanup();			
		}
		
		if (CleanerGUI.getCheckBoxWinErrorClean().isSelected()) {
			ModReg.addRegMemoryDumpFiles();
			ModReg.addRegOldChkDskFiles();
			ModReg.addRegSystemErrorMemoryDumpFiles();
			ModReg.addRegSystemErrorMinidumpFiles();
			ModReg.addRegWindowsErrorReportingArchiveFiles();
			ModReg.addRegWindowsErrorReportingQueueFiles();
			ModReg.addRegWindowsErrorReportingSystemArchiveFiles();
			ModReg.addRegWindowsErrorReportingSystemQueueFiles();
		}
		
		if (CleanerGUI.getCheckBoxTempFilesClean().isSelected()) {
			ModReg.addRegActiveSetupTempFolders();
			ModReg.addRegDownloadedProgramFiles();
			ModReg.addRegInternetCacheFiles();
			ModReg.addRegTemporaryFiles();
			ModReg.addRegTemporarySetupFiles();
		}
		
		if (CleanerGUI.getCheckBoxCacheClean().isSelected()) {
			ModReg.addRegBranchCache();
			ModReg.addRegThumbnailCache();
			ModReg.addRegWindowsDefender();
		}
		
		if (CleanerGUI.getCheckBoxLogClean().isSelected()) {
			ModReg.addRegSetupLogFiles();
			ModReg.addRegWindowsUpgradeLogFiles();
		}
		
		if (CleanerGUI.getCheckBoxFileHistoryClean().isSelected()) {
			ModReg.addRegUserFilesVersions();
		}
		
		if (CleanerGUI.getCheckBoxRecycleBinEmpty().isSelected()) {
			ModReg.addRegRecycleBin();
		}
		
		if (CleanerGUI.getCheckBoxWinOldClean().isSelected()) {
			ModReg.addRegPreviousInstallations();
			ModReg.addRegUpgradeDiscardedFiles();
		}
	}

	private static File getAdminShellFile() {
		return adminShellFile;
	}
}
