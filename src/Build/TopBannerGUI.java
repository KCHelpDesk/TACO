package Build;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TopBannerGUI {
	private static Button exitButton = new Button();
	private static Image banner = new Image("file:src/Build/resources/img/banner.png");
	
	/*
	public static GridPane createGUI() {
		//Build gridpane
		GridPane topGridPane = new GridPane(); 
		GridPane bannerGridPane = new GridPane();
		
		//Build ImageView
		ImageView bannerView = new ImageView(getBanner());
		
		//Set ID's
		bannerView.setId("banner");
		getExitButton().setId("exit-button");
		
		
		//set alignment 
		topGridPane.setAlignment(Pos.TOP_RIGHT);
		bannerGridPane.setAlignment(Pos.CENTER);		
		
		//Add nodes
		topGridPane.add(getExitButton(), 0, 0);
		bannerGridPane.add(bannerView, 0, 1);
		
		//Build master gridpane
		GridPane masterGridPane = new GridPane();
		
		masterGridPane.add(topGridPane, 0, 0);
		masterGridPane.add(bannerGridPane, 0, 1);
				
		return masterGridPane;
	}
	*/
	
	public static BorderPane createGUI(){
		//Build ImageView
		ImageView bannerView = new ImageView(getBanner());
		
		//bannerView.
				
		//Set ID's
		bannerView.setId("banner");
		getExitButton().setId("exit-button");
		
		BorderPane.setAlignment(getExitButton(), Pos.TOP_RIGHT);
		
		BorderPane bp = new BorderPane();
		bp.setTop(getExitButton());
		bp.setCenter(bannerView);
		
		return bp;
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
