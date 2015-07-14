import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Client extends JFrame {
	//Text area to display radius
	private JTextArea jta=new JTextArea();
	//Text field for receiving radius
	private JTextField jtf=new JTextField();
	
	private DataOutputStream toServer;
	private DataInputStream fromServer;

	public static void main(String[] args) {
		new Client();
	}
	public Client(){
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Enter radius"),BorderLayout.WEST);
		JButton sendButton=new JButton("send");
		p.add(sendButton,BorderLayout.EAST);
		
		jtf.setHorizontalAlignment(JTextField.LEFT);
		p.add(jtf,BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		add(p,BorderLayout.NORTH);
		add(new JScrollPane(jta),BorderLayout.CENTER);
		sendButton.addActionListener(new ButtonListener());
		
		setTitle("Client");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String localhostString="127.0.0.1";
		String centosString="192.168.9.132";
		
		try {
			//create a socket to connect to the server
			Socket socket=new Socket(localhostString,8000);
			fromServer=new DataInputStream(socket.getInputStream());
			toServer=new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
		jta.append(e.toString()+'\n');
		}
		
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				//get the radius from the text field
				double radius=Double.parseDouble(jtf.getText().trim());
//				System.out.println("radius="+radius);
				//send radius to the server
				toServer.writeDouble(radius);
				toServer.flush();
				
				//get area from the server
				double area=fromServer.readDouble();
				//display to the text area
				jta.append("Radius is "+radius+"\n");
				jta.append("Area recevied from the server is "+area+"\n");
			} catch (IOException e2) {
				System.err.println(e2);
			}
		}
		
	}
}
