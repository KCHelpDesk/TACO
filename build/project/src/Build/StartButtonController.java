package Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class StartButtonController {
	private static File adminShellFile = new File("resources/getAdminShell.taco");
	private static File deleteRegKeysFile = new File("resources/deleteStateFlags.taco");
	private static File browserCleanFile = new File("resources/browserClean.taco");
	
	public static boolean executeStartButton() {
		try {
			//Cleans bat and marks for deletion
			BuildExecuteBat.buildBat();	 		 
			
			//Add get admin priv to top of bat
			BuildExecuteBat.appendBat(getAdminShellFile());
			
			//Check if browser lean is selected, if so, add config to bat
			if (CleanerGUI.getCheckBoxBrowserClean().isSelected()) BuildExecuteBat.appendBat(getBrowserCleanFile());
			
			//Add reg add keys
			buildModRegAddKeyArray();
			BuildExecuteBat.appendBat(ModReg.getRegKeysAdd());
			
			//Speed up registry
			BuildExecuteBat.appendBat("regedit /s skipCleanMGRScan.reg");
			
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
	
	private static void buildModRegDeleteKeyArray() {
		ModReg.getRegKeysDelete().clear();
		try {
			BufferedReader input = new BufferedReader(new FileReader(getDeleteRegKeysFile()));
			String string;
			while((string = input.readLine()) != null){
				ModReg.getRegKeysDelete().add(string);
			}
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void buildModRegAddKeyArray() {
		ModReg.getRegKeysAdd().clear();
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
	
	private static File getDeleteRegKeysFile() {
		return deleteRegKeysFile;
	}
	
	private static File getBrowserCleanFile() {
		return browserCleanFile;
	}
}
