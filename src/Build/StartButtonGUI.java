package Build;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

class StartButtonGUI implements gridPaneAlignment {
	private static Button buttonStart = new Button();
	
	static GridPane createGUI() {
		GridPane gridPane = new GridPane();
		
		gridPaneAlignment.gridPaneAlign(gridPane);
		
		//getButtonStart().setText("Start");
		getButtonStart().setId("start-button");
		
		gridPane.add(getButtonStart(), 0, 0);
				
		return gridPane;
	}
	
	public static Button getButtonStart() {
		return buttonStart;
	}
	
	public static void buttonAction() {
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
		
		ModReg.buildAndExecuteBat();
 	}

}
