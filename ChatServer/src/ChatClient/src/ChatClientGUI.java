package ChatClient.src;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ChatClientGUI {
	private static TextArea textArea;
	private static TextField inputField;
	private static Button sendButton;

	public static Scene createUI(){
		GridPane gridPaneTop = new GridPane();
		textArea = new TextArea();
		textArea.setDisable(true);
		textArea.setStyle("-fx-text-fill: black;");
		gridPaneTop.add(textArea, 0, 0);
		
		inputField = new TextField();
		gridPaneTop.add(inputField, 0, 1);
		
		sendButton = new Button("Send");
		gridPaneTop.add(sendButton, 0, 2);
		
		Scene scene = new Scene(gridPaneTop);
		return scene;
	}
	
	static TextField getInputField() {
		return inputField;
	}
	
	static TextArea getTextArea(){
		return textArea;
	}
	
	static Button getButton(){
		return sendButton;
	}

}
