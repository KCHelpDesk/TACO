package Build;


import java.util.ArrayList;

public class ModReg {
	static ArrayList<String> regKeysAdd = new ArrayList<String>();
	static ArrayList<String> regKeysDelete = new ArrayList<String>();
	
	public static String buildRegAddString(String string) {
		return "reg add \"HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VolumeCaches\\" + string + "\" /v StateFlags5000 /t REG_DWORD /d 2 /f";
	}

	public static void addRegServicePackCleanup() {
		getRegKeysAdd().add(buildRegAddString("Service Pack Cleanup"));		
	}

	public static void addRegOldChkDskFiles() {
		getRegKeysAdd().add(buildRegAddString("Old ChkDsk Files"));
	}

	public static void addRegSystemErrorMemoryDumpFiles() {
		getRegKeysAdd().add(buildRegAddString("System error memory dump files"));
	}

	public static void addRegSystemErrorMinidumpFiles() {
		getRegKeysAdd().add(buildRegAddString("System error minidump files"));
	}

	public static void addRegMemoryDumpFiles() {
		getRegKeysAdd().add(buildRegAddString("Memory Dump Files"));
	}

	public static void addRegUpdateCleanup() {
		getRegKeysAdd().add(buildRegAddString("Update Cleanup"));
	}

	public static void addRegWindowsErrorReportingArchiveFiles() {
		getRegKeysAdd().add(buildRegAddString("Windows Error Reporting Archive Files"));
	}

	public static void addRegWindowsErrorReportingQueueFiles() {
		getRegKeysAdd().add(buildRegAddString("Windows Error Reporting Queue Files"));
	}

	public static void addRegWindowsErrorReportingSystemArchiveFiles() {
		getRegKeysAdd().add(buildRegAddString("Windows Error Reporting System Archive Files"));
	}

	public static void addRegWindowsErrorReportingSystemQueueFiles() {
		getRegKeysAdd().add(buildRegAddString("Windows Error Reporting System Queue Files"));
	}

	public static void addRegActiveSetupTempFolders() {
		getRegKeysAdd().add(buildRegAddString("Active Setup Temp Folders"));
	}

	public static void addRegDownloadedProgramFiles() {
		getRegKeysAdd().add(buildRegAddString("Downloaded Program Files"));
	}

	public static void addRegInternetCacheFiles() {
		getRegKeysAdd().add(buildRegAddString("Internet Cache Files"));
	}

	public static void addRegTemporaryFiles() {
		getRegKeysAdd().add(buildRegAddString("Temporary Files"));
	}

	public static void addRegTemporarySetupFiles() {
		getRegKeysAdd().add(buildRegAddString("Temporary Setup Files"));
	}

	public static void addRegBranchCache() {
		getRegKeysAdd().add(buildRegAddString("BranchCache"));
	}

	public static void addRegThumbnailCache() {
		getRegKeysAdd().add(buildRegAddString("Thumbnail Cache"));
	}

	public static void addRegWindowsDefender() {
		getRegKeysAdd().add(buildRegAddString("Windows Defender"));
	}

	public static void addRegSetupLogFiles() {
		getRegKeysAdd().add(buildRegAddString("Setup Log Files"));
	}

	public static void addRegWindowsUpgradeLogFiles() {
		getRegKeysAdd().add(buildRegAddString("Windows Upgrade Log Files"));
	}

	public static void addRegUserFilesVersions() {
		getRegKeysAdd().add(buildRegAddString("User file versions"));
	}

	public static void addRegRecycleBin() {
		getRegKeysAdd().add(buildRegAddString("Recycle Bin"));
	}

	public static void addRegPreviousInstallations() {
		getRegKeysAdd().add(buildRegAddString("Previous Installations"));
	}

	public static void addRegUpgradeDiscardedFiles() {
		getRegKeysAdd().add(buildRegAddString("Upgrade Discarded Files"));
	}
	
	public static ArrayList<String> getRegKeysAdd() {
		return regKeysAdd;
	}
	
	public static ArrayList<String> getRegKeysDelete(){
		return regKeysDelete;
	}



}
