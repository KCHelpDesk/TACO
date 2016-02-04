package Build;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TopBannerGUI {
	private static Button exitButton = new Button();
	private static Image banner = new Image("file:src/Build/resources/img/banner.jpg");

	public static GridPane createGUI() {
		getExitButton().setId("exit-button");
		
		ImageView bannerView = new ImageView(getBanner());
		
		GridPane gridpane = new GridPane();
		
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
