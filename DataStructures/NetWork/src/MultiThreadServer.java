import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer {

	public static void main(String[] args) {
		new MultiThreadServer();
	}
	public MultiThreadServer() {
		try {
			ServerSocket serverSocket=new ServerSocket(8000);
			System.out.println("MutiThreadServer started at "+new Date()+'\n');
			int clientNo=1;
			while (true) {
				//Listen for a new connect request
				Socket socket=serverSocket.accept();
				System.out.println("Starting thread for client "+clientNo+" at "
						+new Date()+"\n");
				//get the client's host name and IP address
				InetAddress inetAddress=socket.getInetAddress();
				System.out.println("Client "+clientNo+"'s host name is "
				+inetAddress.getHostName()+"\n");
				System.out.println("Client "+clientNo+"'s IP Address is "
						+inetAddress.getHostAddress());
				//Create a new task for the connection
				HandleAClient task=new HandleAClient(socket);
				//start the new thread
				new Thread(task).start();
				clientNo++;
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
class HandleAClient implements Runnable{

	@Override
	public void run() {
		try {
			//Create data input and output streams
			DataInputStream inputFromClient=new DataInputStream(socket.getInputStream());
			DataOutputStream outputToClient=new DataOutputStream(socket.getOutputStream());
			while (true) {
				//Receive radius from the client
				double radius=inputFromClient.readDouble();
				//Compute area
				double area=radius*radius*Math.PI;
				//send area back to the client
				outputToClient.writeDouble(area);
				System.out.println("radius received from client: "+radius+"\n");
				System.out.println("Area found: "+area+"\n");
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	private Socket socket;
	public HandleAClient(Socket socket){
		this.socket=socket;
	}
}