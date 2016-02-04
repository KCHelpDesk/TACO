package Build;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TopBannerGUI {
	private static Button exitButton = new Button();
	private static Image banner = new Image("file:src/Build/resources/img/banner.jpg");

	public static GridPane createGUI() {
		//Build gridpane
		GridPane gridpane = new GridPane();
		
		//Build ImageView
		ImageView bannerView = new ImageView(getBanner());
		
		//Set ID's
		bannerView.setId("banner");
		getExitButton().setId("exit-button");
		
		//Build top column for button(s)
		ColumnConstraints topCol = new ColumnConstraints();
		topCol.setHalignment(HPos.RIGHT);
		topCol.setHgrow(Priority.ALWAYS);
		
		//Build middle column for banner(s)
		ColumnConstraints midCol = new ColumnConstraints();
		midCol.setHalignment(HPos.CENTER);
		midCol.setHgrow(Priority.ALWAYS);
		
		//Add columns
		gridpane.getColumnConstraints().addAll(midCol, topCol);
		
		//Add nodes to gridpane
		gridpane.add(getExitButton(), 1, 0);	
		gridpane.add(bannerView, 0, 1);
		
		return gridpane;
	}

	public static ButtonBase getExitButton() {
		return exitButton;
	}

	public static Image getBanner() {
		return banner;
	}

	public static void setBanner(Image banner) {
		TopBannerGUI.banner = banner;
	}

	public static void exitButtonAction() {
		System.exit(0);
	}

}
