import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;


public class ChatServerGUI {
	private static TextArea textArea;
	
	public static Scene creatUI() {
		GridPane gridPaneTop = new GridPane();
		textArea = new TextArea();
		textArea.setDisable(true);
		gridPaneTop.add(textArea, 0, 0);
		Scene scene = new Scene(gridPaneTop);
		return scene;
	}
	
	static TextArea getTextArea(){
		return textArea;
	}

}
