package Build;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public interface gridPaneAlignment {
	
	public static void gridPaneAlign(GridPane gridpane){
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(8));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
	}

}
