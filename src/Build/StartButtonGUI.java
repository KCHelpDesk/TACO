package Build;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

class StartButtonGUI implements gridPaneAlignment {
	private static Button buttonStart = new Button();
	
	static GridPane createGUI() {
		GridPane gridPane = new GridPane();
		
		gridPaneAlignment.gridPaneAlign(gridPane);
		
		gridPane.setAlignment(Pos.BOTTOM_CENTER);
		
		getButtonStart().setId("start-button");
		
		gridPane.add(getButtonStart(), 0, 0);
				
		return gridPane;
	}
	
	public static Button getButtonStart() {
		return buttonStart;
	}
	
	public static void buttonAction() {
		StartButtonController.executeStartButton();
 	}

}
