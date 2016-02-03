import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Platform;

public class HandleAClient implements Runnable {
	private Socket socket;
	
	public HandleAClient(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
			//DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
			
			while (true){
				Platform.runLater( () -> {
					try {
						ChatServerGUI.getTextArea().appendText(inputFromClient.readUTF());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}

}
