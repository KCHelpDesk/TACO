package Build;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

class SysInfoGUI implements gridPaneAlignment{
	private static Text winVers = new Text(PullSysInfo.getWinVersion());
	private static Text sysMan = new Text(PullSysInfo.getSysManufacturer());
	private static Text sysModel = new Text(PullSysInfo.getSysModel());
	private static Text sysSerial = new Text(PullSysInfo.getSysSerial());
	private static Text compName = new Text(PullSysInfo.getCompName());
	private static Text procModel = new Text(PullSysInfo.getProcessorModel());
	private static Text totalMem = new Text(PullSysInfo.getTotalMem());  
	private static Text hddSize = new Text(PullSysInfo.getHddTotalGB());
	private static Text hddFree = new Text(PullSysInfo.getHddFreeGB());
	private static Text localIP = new Text(PullSysInfo.getLocalIP());
	private static Text subnet = new Text(PullSysInfo.getSubnet());
	private static Text gateway = new Text(PullSysInfo.getGateway());	
	private static Text publicIP = new Text(PullSysInfo.getPublicIP());
	
	static GridPane createGUI() {
		/**
		 * TODO update
		 */
		GridPane gridpane = new GridPane();
		
		gridpane.setId("SysInfoGUI");
		
		//Setting alignment
		gridPaneAlignment.gridPaneAlign(gridpane);
		gridpane.setAlignment(Pos.CENTER);
		
		/**
		 * Column constraints to set the min, pref and max width for the columns.
		 * Only applies to the topgridpane, hence the top preface :)
		 */
		ColumnConstraints topLeftColumn = new ColumnConstraints(75, 125, 300);
		topLeftColumn.setHalignment(HPos.RIGHT);
		//ColumnConstraints topCenterColumn = new ColumnConstraints(150, 250, 300);
		//ColumnConstraints topRightColumn = new ColumnConstraints(50, 100, 300);
		gridpane.getColumnConstraints().addAll(topLeftColumn);
		

		/**
		 * Left Column
		 */
		Label labelWinVer = new Label("Windows Version: ");
		gridpane.add(labelWinVer, 0, 0);
		gridpane.add(getWinVers(), 1, 0);
		
		Label labelSysManufac = new Label("Manufacturer: ");
		gridpane.add(labelSysManufac, 0, 1);
		gridpane.add(getSysMan(), 1, 1);
		
		Label labelSysModel = new Label("Model: ");
		gridpane.add(labelSysModel, 0, 2);
		gridpane.add(getSysModel(), 1, 2);
		
		Label labelSysSerial = new Label("Serial: ");
		gridpane.add(labelSysSerial, 0, 3);
		gridpane.add(getSysSerial(), 1, 3);
		
		Label labelCompName = new Label("Computer Name: ");
		gridpane.add(labelCompName, 0, 4);
		gridpane.add(getCompName(), 1, 4);
		
		/**
		 * Center Column
		 */
		Label labelProcessor = new Label("Processor: ");
		gridpane.add(labelProcessor, 0, 5);
		gridpane.add(getProcModel(), 1, 5);
		
		Label labelInstalledMem = new Label("Installed Memory: ");
		gridpane.add(labelInstalledMem, 0, 6);
		gridpane.add(getTotalMem(), 1, 6);
		
		Label labelHDDSize = new Label("Hard Drive Size: ");
		gridpane.add(labelHDDSize, 0, 7);
		gridpane.add(getHddSize(), 1, 7);
		
		Label labelHDDFreeSpace = new Label("Free Space: ");
		gridpane.add(labelHDDFreeSpace, 0, 8);
		gridpane.add(getHddFree(), 1, 8);
		
		/**
		 * Right Column
		 */
		Label labelIPAddress = new Label("Local IP Address: ");
		gridpane.add(labelIPAddress, 0, 9);
		gridpane.add(getLocalIP(), 1, 9);
		
		Label labelSubnet = new Label("Subnet: ");
		gridpane.add(labelSubnet, 0, 10);
		gridpane.add(getSubnet(), 1, 10);
		
		Label labelGateway = new Label("Gateway: ");
		gridpane.add(labelGateway, 0, 11);
		gridpane.add(getGateway(), 1, 11);
		
		Label labelPublicIP = new Label("Public IP: ");
		gridpane.add(labelPublicIP, 0, 12);
		gridpane.add(getPublicIP(), 1, 12);
		
		
		return gridpane;
	}
	
	static Text getWinVers() {
		return winVers;
	}
	public static Text getSysMan() {
		return sysMan;
	}

	public static Text getSysModel() {
		return sysModel;
	}
	
	public static Text getSysSerial() {
		return sysSerial;
	}

	public static Text getCompName() {
		return compName;
	}

	public static Text getProcModel() {
		return procModel;
	}

	public static Text getTotalMem() {
		return totalMem;
	}

	public static Text getHddSize() {
		return hddSize;
	}

	public static Text getHddFree() {
		return hddFree;
	}

	public static Text getLocalIP() {
		return localIP;
	}

	public static Text getSubnet() {
		return subnet;
	}

	public static Text getGateway() {
		return gateway;
	}

	public static Text getPublicIP() {
		return publicIP;
	}
}
