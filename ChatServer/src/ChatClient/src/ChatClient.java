package ChatClient.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatClient extends Application{
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	Socket socket;

	public static void main(String[] args){		
		Application.launch(args);	
	}

	public void start(Stage primaryStage){
		primaryStage.setTitle("Chat Client");
		primaryStage.setScene(ChatClientGUI.createUI());
		primaryStage.show();
		try {
			socket = new Socket("www.mkoussa.com", 9000);				
			fromServer = new DataInputStream(socket.getInputStream());			
			toServer = new DataOutputStream(socket.getOutputStream());
			ChatClientGUI.getTextArea().setText("Connected at " + new Date());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		ChatClientGUI.getButton().setOnAction(e -> {		
			try{
				String outgoingMessage = ChatClientGUI.getInputField().getText();
				toServer.writeUTF(outgoingMessage);
				
				toServer.flush();
				
				String incomingMessage = fromServer.readUTF();
				
				ChatClientGUI.getTextArea().appendText(new Date() + " " + incomingMessage + "\n");
			}
			catch (IOException ex){
				ChatClientGUI.getTextArea().appendText(ex.toString() + "\n");
			}			
		});
	}

}
