package Build;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Master extends Application{
	Stage stage;
	@SuppressWarnings("unused")
	private double xOffset = 0;
	@SuppressWarnings("unused")
	private double yOffset = 0;
	private static class Delta {
		double x, y;
	}
	final Delta dragDelta = new Delta();
	final BooleanProperty inDrag = new SimpleBooleanProperty();
	
	/*
    private Scene createPreloaderScene() {
    	//File imageFile = new File("src/Build/resources/hellokitty.jpg");
    	Image image = new Image("file:src/Build/resources/hellokitty.jpg");
    	ImageView imageView = new ImageView();
        imageView.setImage(image);
        BorderPane p = new BorderPane();
        p.setCenter(imageView);
        return new Scene(p, 600, 575);        
    }
    */
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

	
	public void start(Stage primaryStage) throws IOException {	
		//this.stage = primaryStage;
		//primaryStage.setScene(createPreloaderScene());

		//primaryStage.show();
		
		PullSysInfo.pullSysInfo();
		
		
		primaryStage.setTitle("T.A.C.O.");
		
		BorderPane borderpane = new BorderPane();
		
		
		borderpane.setTop(TopBannerGUI.createGUI());
		borderpane.setLeft(SysInfoGUI.createGUI());
		borderpane.setRight(CleanerGUI.createGUI());
		borderpane.setBottom(StartButtonGUI.createGUI());
		
		borderpane.setOnMousePressed(new EventHandler<MouseEvent>() {			
			@Override
			public void handle(MouseEvent event) {
				dragDelta.x = primaryStage.getX() - event.getScreenX();
	            dragDelta.y = primaryStage.getY() - event.getScreenY();
	            xOffset = event.getSceneX();
	            yOffset = event.getSceneY();
			}
 		});
		
		borderpane.setOnMouseDragged(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            primaryStage.setX(event.getScreenX() + dragDelta.x);
	            primaryStage.setY(event.getScreenY() + dragDelta.y);
	            primaryStage.getWidth();
	            primaryStage.getHeight();
	            primaryStage.getX();
	            primaryStage.getY();
	            inDrag.set(true);

	        }
	    });
		
		Scene scene = new Scene(borderpane);
		scene.getStylesheets().add("file:src/Build/resources/guiStyle.css");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
		
		StartButtonGUI.getButtonStart().setOnAction(e -> StartButtonGUI.buttonAction());
		TopBannerGUI.getExitButton().setOnAction(e -> TopBannerGUI.exitButtonAction());
	}

}
