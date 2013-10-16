/*
Samantha Oxley

Lab 04 - Multi-threaded Server
GUI for the chat server
*/
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame{
	//attributes
	private JTextField jtfName;
	private JTextField jtfIP;
	private JTextField jtfPortNum;
	private JTextField jtfMessage;
	private JTextArea jtaChat;
	private JButton jbConnect;
	private JButton jbSend;
	
	//construct 
	public GUI(){
		//create panels
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		
		//create north panel
		JLabel jlName = new JLabel("User Name: ");
		jtfName = new JTextField(15);
		JLabel jlIP = new JLabel("IP Adress: ");
		jtfIP = new JTextField(20);
		JLabel jlPort = new JLabel("Port Number: ");
		jtfPortNum = new JTextField(10);
		jbConnect = new JButton("Connect");
		jpNorth.add(jlName);
		jpNorth.add(jtfName);
		jpNorth.add(jlIP);
		jpNorth.add(jtfIP);
		jpNorth.add(jlPort);
		jpNorth.add(jtfPortNum);
		jpNorth.add(jbConnect);
		//create center panel
		jtaChat = new JTextArea(20, 50);
		JScrollPane jsp = new JScrollPane(jtaChat, 
									ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
									ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jpCenter.add(jsp);
		//create south panel
		JLabel jlMessage = new JLabel("Enter Message Here: ");
		jtfMessage = new JTextField(30);
		jbSend = new JButton("Send Message");
		jpSouth.add(jlMessage);
		jpSouth.add(jtfMessage);
		jpSouth.add(jbSend);
		//add panels to frame
		add(jpNorth, BorderLayout.NORTH);
		add(jpCenter, BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);
		//add action listeners
		Listener listener = new Listener(jtaChat, jtfMessage, jtfName, jtfIP, jtfPortNum, jbSend, jbConnect);
		jbSend.addActionListener(listener);
		jbConnect.addActionListener(listener);
		//set frame properties
		setLocation(250, 250);
		setVisible(true);
		setTitle("Samantha's Chat Server!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	public static void main(String []args){
	new GUI();}
}