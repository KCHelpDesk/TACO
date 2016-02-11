package Build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StartButtonController {
	
	public static boolean executeStartButton() {
		try {
			//Add get admin priv to top of bat
			addAdminShell();
			//Add reg add keys
			addModRegKeyArray();
			//Add execute cleanmgr
			BuildExecuteBat.appendBat("cleanmgr /d %SYSTEMROOT% /sagerun:5000");
			
			
			BuildExecuteBat.buildAndExecuteBat();
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
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void addModRegKeyArray() {
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

}
