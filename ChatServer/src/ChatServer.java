import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class ChatServer extends Application{
	static int clientNumber = 0;
	private static ServerSocket serverSocket;
	Socket socket;
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	public void start(Stage primaryStage){
		primaryStage.setTitle("Multi-Client Chat Server");
		primaryStage.setScene(ChatServerGUI.creatUI());
		primaryStage.show();
		
		//ChatServerGUI.getTextArea().appendText("Chat Server started at " + new Date() + "\n");
		new Thread( () -> {
			try{
				serverSocket = new ServerSocket(9000);
				Platform.runLater(() -> ChatServerGUI.getTextArea().appendText("Chat Server started at " + new Date() + "\n"));
				socket = serverSocket.accept();
				
				DataInputStream inputFromclient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				while (true) {
					String incomingMessage = inputFromclient.readUTF();
					Platform.runLater(() -> ChatServerGUI.getTextArea()
							.appendText("Received " + incomingMessage + " on " + new Date() + "\n"));
					outputToClient.writeUTF(incomingMessage);
					Platform.runLater(() -> ChatServerGUI.getTextArea()
							.appendText("Sent " + incomingMessage + " on " + new Date() + "\n"));
				}
			}
			catch (IOException ex) {
				System.err.println(ex);
			}
		}).start();
	}
}
