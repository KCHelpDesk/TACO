package Build;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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
	
	public static void main(String[] args) {
		Application.launch(args);		
	}

	
	public void start(Stage primaryStage) throws IOException {	
		
		PullSysInfo.pullSysInfo();
		BannerControl.buildDateFile();
		BannerControl.checkDate();
		
		primaryStage.setTitle("T.A.C.O.");
		primaryStage.getIcons().add(new Image("file:src/Build/resources/img/icon.png"));
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
		scene.setFill(Color.TRANSPARENT);
		scene.getRoot().getStyleClass().add("main-root");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
		
		StartButtonGUI.getButtonStart().setOnAction(e -> StartButtonGUI.buttonAction());
		TopBannerGUI.getExitButton().setOnAction(e -> TopBannerGUI.exitButtonAction());
	}

}
