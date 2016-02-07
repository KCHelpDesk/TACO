package Build;

import javafx.geometry.HPos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

class CleanerGUI implements gridPaneAlignment{
	private static CheckBox checkBoxWinUpClean = new CheckBox();
	private static CheckBox checkBoxWinErrorClean = new CheckBox();
	private static CheckBox checkBoxTempFilesClean = new CheckBox();
	private static CheckBox checkBoxCacheClean = new CheckBox();
	private static CheckBox checkBoxLogClean = new CheckBox();
	private static CheckBox checkBoxFileHistoryClean = new CheckBox();
	private static CheckBox checkBoxRecycleBinEmpty = new CheckBox();
	private static CheckBox checkBoxWinOldClean = new CheckBox();

	
	static GridPane createGUI() {
		
		GridPane gridPane = new GridPane();
		
		gridPane.setId("CleanerGUI");
		
		gridPaneAlignment.gridPaneAlign(gridPane);
				
		ColumnConstraints leftColumn = new ColumnConstraints();
		leftColumn.setHalignment(HPos.RIGHT);
		ColumnConstraints rightColumn = new ColumnConstraints();
		gridPane.getColumnConstraints().addAll(leftColumn, rightColumn);
		
		Text winUpTxt = new Text("Windows Update Cleanup");
		Tooltip winUpTip = new Tooltip("Windows keeps copies of all installed\n"
				+ "updates from Windows Update, even after\n"
				+ "installing newer versions of updates.\n"
				+ "Check this box to clean up Windows Updates\n"
				+ "cache files.");
		Tooltip.install(winUpTxt, winUpTip);
		gridPane.add(getCheckBoxWinUpClean(), 0, 0);
		gridPane.add(winUpTxt, 1, 0);
		
		Text winErrorTxt = new Text("Windows Error Cleanup");
		Tooltip winErrorTip = new Tooltip("Windows keeps log files for\n"
				+ "error reporting and solution checking.\n"
				+ "In addition, is also keeps dump files\n"
				+ "that can be safely removed.\n"
				+ "Check this box to remove these files.");
		Tooltip.install(winErrorTxt, winErrorTip);
		gridPane.add(getCheckBoxWinErrorClean(), 0, 1);
		gridPane.add(winErrorTxt, 1, 1);
		
		Text tempFilesCleanTxt = new Text("Temporary File Cleanup");
		Tooltip tempFileTip = new Tooltip("When installing programs and updates\n"
				+ "the computer keeps temporary files to\n"
				+ "speed up the install process. Once the\n"
				+ "install is finished though, these files\n"
				+ "are sometimes left behind. Check this\n"
				+ "box to remove these files.");
		Tooltip.install(tempFilesCleanTxt, tempFileTip);
		gridPane.add(getCheckBoxTempFilesClean(), 0, 2);
		gridPane.add(tempFilesCleanTxt, 1, 2);
		
		Text cacheCleanTxt = new Text("Cache File Cleanup");
		Tooltip cacheTip = new Tooltip("Instead of searching the entire hard drive\n"
				+ "for trivial information, Windows will\n"
				+ "create cache files that allow it to\n"
				+ "find these files quickly. However, these\n"
				+ "files quickly accumulate and become useless.\n"
				+ "Check this box to remove these files.");
		Tooltip.install(cacheCleanTxt, cacheTip);
		gridPane.add(getCheckBoxCacheClean(), 0, 3);
		gridPane.add(cacheCleanTxt, 1, 3);
		
		Text logCleanTxt = new Text("Log File Cleanup");
		Tooltip logCleanTip = new Tooltip("Everything that Windows does creates\n"
				+ "a log file. These files can be used\n"
				+ "for error reporting and checking.\n"
				+ "Unless you are experiencing serious\n"
				+ "issues with your computer, these\n"
				+ "files can be safely removed.\n"
				+ "Check this box to remove these files.");
		Tooltip.install(logCleanTxt, logCleanTip);
		gridPane.add(getCheckBoxLogClean(), 0, 4);
		gridPane.add(logCleanTxt, 1, 4);
		
		Text fileHistCleanTxt = new Text("File History Cleanup");
		Tooltip fileHistTip = new Tooltip("Windows temporarily stores file\n"
				+ "versions on disk before copying them\n"
				+ "to disk. Check this box to remove\n"
				+ "these files.");
		Tooltip.install(fileHistCleanTxt, fileHistTip);
		gridPane.add(getCheckBoxFileHistoryClean(), 0, 5);
		gridPane.add(fileHistCleanTxt, 1, 5);
		
		Text recycleBinEmptyTxt = new Text("Empty Recycle Bin");
		Tooltip recycleBinTip = new Tooltip("Check this box to Empty Recycle Bin.");
		Tooltip.install(recycleBinEmptyTxt, recycleBinTip);
		gridPane.add(getCheckBoxRecycleBinEmpty(), 0, 6);
		gridPane.add(recycleBinEmptyTxt, 1, 6);
		
		Text winOldCleanTxt = new Text("Previous Windows Install Cleanup");
		if (!PullSysInfo.isExistWindowsOld()) {
			getCheckBoxWinOldClean().setDisable(true);
			Tooltip winOldDisabledTip = new Tooltip("This computer doesn't have a Windows.old directory.");
			Tooltip.install(winOldCleanTxt, winOldDisabledTip);
		}
		else {
			Tooltip winOldTip = new Tooltip("When installing a new version of Windows\n"
					+ "the previous system files are placed\n"
					+ "inside windows.old. Check this box\n"
					+ "to remove these files.\n"
					+ "WARNING: Make sure you have all\n"
					+ "your personal files saved from the\n"
					+ "previous installation as this removal\n"
					+ "is irreversable.");
			Tooltip.install(winOldCleanTxt, winOldTip);
		}
		gridPane.add(getCheckBoxWinOldClean(), 0, 7);
		gridPane.add(winOldCleanTxt, 1, 7);
		
		return gridPane;
	}

	public static CheckBox getCheckBoxWinUpClean() {
		return checkBoxWinUpClean;
	}

	public static CheckBox getCheckBoxWinErrorClean() {
		return checkBoxWinErrorClean;
	}
	
	public static CheckBox getCheckBoxTempFilesClean() {
		return checkBoxTempFilesClean;
	}
	
	public static CheckBox getCheckBoxCacheClean() {
		return checkBoxCacheClean;
	}
	
	public static CheckBox getCheckBoxLogClean() {
		return checkBoxLogClean;
	}
	
	public static CheckBox getCheckBoxFileHistoryClean() {
		return checkBoxFileHistoryClean;
	}
	
	public static CheckBox getCheckBoxRecycleBinEmpty() {
		return checkBoxRecycleBinEmpty;
	}
	
	public static CheckBox getCheckBoxWinOldClean() {
		return checkBoxWinOldClean;
	}
}
