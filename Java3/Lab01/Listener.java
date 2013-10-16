/*
Samantha Oxley

Lab04 - MultiThreaded Server
Listener class handles button clicks for GUI class
*/

import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Listener implements ActionListener{
	//attributes
	private JTextArea jtaChat;
	private JTextField jtfMessage;
	private JTextField jtfName;
	private JTextField jtfIP;
	private JTextField jtfPortNum;
	private JButton jbSend;
	private JButton jbConnect;
	
	private String clientMsg;
	private String clientName;
	private PrintWriter pout;
	private Socket s;
	private Client client;
	//constructor
	public Listener(JTextArea jtaChat, JTextField jtfMessage, JTextField jtfName, JTextField jtfIP, JTextField jtfPortNum, JButton jbSend, JButton jbConnect){
		this.jtaChat = jtaChat;
		this.jtfMessage = jtfMessage;
		this.jtfName = jtfName;
		this.jtfIP = jtfIP;
		this.jtfPortNum = jtfPortNum;
		this.jbSend = jbSend;
		this.jbConnect = jbConnect;
	}
	//actionperformed method
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Connect")){
			if(jtfName.getText().equals("") || jtfIP.getText().equals("") || jtfPortNum.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please enter your User Name, IP Adress, and Port Number before trying to connect.");
			}else{
				try{
					//create a socket using the given IP address and Port Num
					String IP = jtfIP.getText();
					int port = Integer.parseInt(jtfPortNum.getText());
					s = new Socket(IP, port);
					//open input from server
					InputStream in = s.getInputStream();
					BufferedReader bin = new BufferedReader(new InputStreamReader(in));
					//open output to server
					OutputStream out = s.getOutputStream();
					pout = new PrintWriter(out);
					
					clientName = jtfName.getText();
					System.out.println("ClientName: " + clientName);
					if(sendName(clientName, bin) == true){
						client = new Client(bin);
						client.start();
						//set text fields to uneditable
						jtfName.setEditable(false);
						jtfIP.setEditable(false);
						jtfPortNum.setEditable(false);
						jbSend.setEnabled(true);
						//change text of connect button to disconnect
						jbConnect.setText("Disconnect");
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "ERROR: connection failed");
				}
			}
		}//--end connect button
		else if(ae.getActionCommand().equals("Disconnect")){
			try{
				pout.println(clientName + " disconnected.");
				pout.flush();
				
				//set text fields back to editable
				jtfName.setEditable(false);
				jtfIP.setEditable(false);
				jtfPortNum.setEditable(false);
				jbSend.setEnabled(true);
				
				//change text of button back to connect
				jtaChat.setText("");
				jbConnect.setText("Connect");
				
				s.close();
				client.interrupt();
				
			}catch(Exception e){
				System.out.println("Exception in Disconnect");
			}
		}//--end disconnect button
		else if(ae.getActionCommand().equals("Send Message")){
			Calendar calendar = Calendar.getInstance();
			Date timeStamp = calendar.getTime();
			String msg = jtfMessage.getText();
			sendMsg(clientName + " ("+ timeStamp.getHours() + ":" + timeStamp.getMinutes()+ ") :" + msg);
			jtfMessage.setText("");
		}
	}//--END ACTION PERFORMED
	public boolean sendName(String _name, BufferedReader br){
		System.out.println("Entered sendName, _name = " + _name);
		try{
			pout.println(_name);
			pout.flush();
			if(br.readLine().equals("DENY")){
				JOptionPane.showMessageDialog(null, "Sorry, that name already exists. Please try another.");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}//--END OF sendName method
	public void sendMsg(String _clientMessage){
		try{
			int counter = 0;
			clientMsg = _clientMessage;
			while(counter < 2){
				pout.println(clientMsg);
				pout.flush();
				counter++;
			}
		}catch(Exception e){}
	}//--END of sendMsg method
//----CLIENT--------
	class Client extends Thread{
		private BufferedReader br;
		
		public Client(BufferedReader _br){
			br = _br;
		}
		public void run(){
			String message;
			try{
				//forever..
				while(true){
					//if the message is not blank, send to server
					if((message = br.readLine())!=null)
						jtaChat.append(br.readLine()+"\n");
				}
			//catch server disconnect with socket exception
			}catch(SocketException se){
				JOptionPane.showMessageDialog(null, "ERROR: server has disconnected.");
				pout.println(clientName + "Disconnected");
				pout.flush();
				
				client.interrupt();
				jtfName.setEditable(true);
				jtfIP.setEditable(true);
				jtfPortNum.setEditable(true);
				jbSend.setEnabled(false);
				jtaChat.setText("");
				jbConnect.setEnabled(true);
				jbConnect.setText("Connect");
				try{
					s.close();
					br.close();
				}catch(IOException ioe){}
				
			}catch(IOException ioe){
				JOptionPane.showMessageDialog(null, "IO Exception occured in Client.");
			}
		}
	}
}