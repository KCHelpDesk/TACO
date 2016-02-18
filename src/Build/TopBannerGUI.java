package Build;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class TopBannerGUI {
	private static Button exitButton = new Button();
	private static Image banner = new Image("file:src/Build/resources/img/banner.png");
	
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
