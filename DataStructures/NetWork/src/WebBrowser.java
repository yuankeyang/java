import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class WebBrowser extends JApplet {

	//JEditor pane to view HTML files
	private JEditorPane jePane=new JEditorPane();
	//label for URL
	private JLabel jlbURL=new JLabel("URL");
	//Text field for entering URL
	private JTextField jtfURL=new JTextField();
	/*initialize the applet*/
	public void init() {
		//Create a panel jpURL to hold the label and text field
		JPanel jpURL=new JPanel();
		JButton jButton=new JButton("Go");
		jpURL.setLayout(new BorderLayout());
		jpURL.add(jlbURL,BorderLayout.WEST);
		jpURL.add(jtfURL,BorderLayout.CENTER);
		jpURL.add(jButton,BorderLayout.EAST);
		//Create a scroll pane to hold JEditorPane
		JScrollPane jspViewer=new JScrollPane();
		jspViewer.getViewport().add(jePane,null);
		//place jpURL and jspViewer in the applet
		add(jspViewer,BorderLayout.CENTER);
		add(jpURL,BorderLayout.NORTH);
		//set jePane noneditable
		jePane.setEditable(false);
		//register listener
		jePane.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				try {
					jePane.setPage(e.getURL());
				} catch (IOException e2) {
					System.out.println(e2);
				}
			}
		});
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//get the URL from text field
					URL url=new URL(jtfURL.getText().trim());
					jePane.setPage(url);
				} catch (IOException e2) {
					System.out.println(e2);
				}
			}
		});
		
	}
	
}
