package Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

class PullSysInfo {
	private static Double hddFreeGB;
	private static Double hddTotalGB;
	
	public static void pullSysInfo() {
		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "fsutil volume diskfree C:");
		processBuilder.redirectErrorStream(true);
		Process process;
		try {
			process = processBuilder.start();
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (int i = 0; i < 3; i++) {
				if (i == 0){
					String hddFree = reader.readLine();
					Double conversion = (((Double.valueOf(hddFree.substring(30))) / 1024) / 1024) / 1024;
					setHddFreeGB(conversion);
				}
				if (i == 1) {
					String hddTotal = reader.readLine();
					Double conversion = (((Double.valueOf(hddTotal.substring(30))) / 1024) / 1024) / 1024;
					setHddTotalGB(conversion);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getWinVersion() {
		/*
		String osName = System.getProperty("os.name");
		String osVersion = "Ver: " + System.getProperty("os.version");
		return osName + " " + osVersion;
		*/
		return runWMICcmd("wmic OS GET Caption");
	}
	
	public static String getSysManufacturer() {
		return runWMICcmd("wmic csproduct get vendor");
	}
	
	public static String getSysModel() {
		return runWMICcmd("wmic computersystem get model");
	}
	
	public static String getSysSerial() {
		return runWMICcmd("wmic bios get serialnumber");
	}
	
	public static String getCompName() {
		return runWMICcmd("wmic computersystem get name");
	}
	
	public static String getProcessorModel() {
		return runWMICcmd("wmic cpu get name");		
	}
	
	public static String getTotalMem() {
		ArrayList<String> totalMem = runCMD("wmic memorychip get capacity");
		double mem = 0;
		for (String string : totalMem){
			mem = mem + Double.valueOf(string);
		}
		mem = ((mem / 1024) / 1024);
		return mem + " MB";
	}
	
	public static String getLocalIP() {
		String localIP = runWMICcmd("wmic nicconfig where ipenabled=true get ipaddress");
		if (!localIP.equals("")) return localIP.split("\"")[1];
		else return "Not Connected";
	}
	
	public static String getSubnet() {
		String subnet = runWMICcmd("wmic nicconfig where ipenabled=true get ipsubnet");
		if (!subnet.equals("")) return subnet.split("\"")[1];
		else return "Not Connected";
	}
	
	public static String getGateway() { 
		String gateway = runWMICcmd("wmic nicconfig where ipenabled=true get defaultipgateway");
		if (!gateway.equals("")) return gateway.split("\"")[1];
		else return "Not Connected";		
	}
	
	public static String getPublicIP() {
		String address = null;
		BufferedReader reader;
		try {
			URL publicIP = new URL("http://checkip.amazonaws.com");
			reader = new BufferedReader(new InputStreamReader(publicIP.openStream()));
			address = reader.readLine();
			if (address.length() <= 15) {
				return address;
			}else return "No Public IP";
		} catch (Exception e) {
			return "No Public IP";
		}
	}
	
	private static String runWMICcmd(String string){
		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", string);
		processBuilder.redirectErrorStream(true);
		Process process;
		try {
			process = processBuilder.start();
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String cmdOutput = null;
			for (int i = 0; i < 3; i++) {
				cmdOutput = reader.readLine();
			}
			return cmdOutput;
		}
		catch (IOException e) {
			return "Error building Process";
		} catch (InterruptedException e) {
			return "Error building Process";
		}
	}
	
	private static ArrayList<String> runCMD(String string){
		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", string);
		processBuilder.redirectErrorStream(true);
		Process process;
		ArrayList<String> returnArr = new ArrayList<String>();
		try {
			process = processBuilder.start();
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String temp = null;
			for (int i = 0; i <= 20; i++){
				temp = reader.readLine();
				if (i > 1){
					System.out.println(temp);
					if (temp.equals("")){
						break;
					}else returnArr.add(temp);
					}
				}
			return returnArr;
		}
		catch (Exception e){
			ArrayList<String> error = new ArrayList<String>();
			error.add("Error");
			return error;
		}
	}

	public static String getHddTotalGB() {
		return String.format("%.2f GB", hddTotalGB);
	}

	public static void setHddTotalGB(Double hddTotalGB) {
		PullSysInfo.hddTotalGB = hddTotalGB;
	}

	public static String getHddFreeGB() {
		return String.format("%.2f GB", hddFreeGB);
	}

	public static void setHddFreeGB(Double hddFreeGB) {
		PullSysInfo.hddFreeGB = hddFreeGB;
	}
	
	public static boolean isExistWindowsOld() {
		File winOld = new File("C:\\Windows.old");
		return winOld.exists();
	}

}
