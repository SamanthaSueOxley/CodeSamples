import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class GameClient implements Runnable, ActionListener{
	//GUI attributes
	private JTextArea jtaChat;
	private JTextArea jtaMessage;
	private JTextArea jtaPlayers;
	private JLabel jlLobby;
	private JLabel jlPlayerList;
	private JLabel jlReady;
	private JButton jbSend;
	private JButton jbMatchMe;
	//CLIENT attributes
	ArrayList<String> usernames = new ArrayList();
	public final String username;
	public final Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Board board = null;
	private boolean disconnect = false;
	private int timeOut = 20;
	private int myPlayerId;
	public GUI gui;
	private JButton currClicked = null;
		
	public GameClient(String username, final Socket socket){
		this.username = username;
		this.socket = socket;
		
		JFrame jf = new JFrame();
		JPanel jpNorth = new JPanel(new FlowLayout());
		JPanel jpSouth = new JPanel(new BorderLayout());
		
		//NORTH PANEL
		jlLobby = new JLabel("Welcome to the lobby!");
		jlLobby.setForeground(Color.red);
		jlLobby.setFont(new Font("Serif", Font.PLAIN, 18));
		jlLobby.setHorizontalAlignment( SwingConstants.CENTER );
		jtaChat = new JTextArea(20, 30);
		jtaChat.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.pink));
		jtaChat.setEditable(false);
		jtaChat.setWrapStyleWord(true);
		jtaChat.setLineWrap(true);
		jtaChat.setForeground(Color.blue);
		JScrollPane jsp = new JScrollPane(jtaChat,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel jpChat = new JPanel(new BorderLayout());
		jpChat.add(jlLobby, BorderLayout.NORTH);
		jpChat.add(jtaChat, BorderLayout.SOUTH);
				
		jlPlayerList = new JLabel("Player List");
		jlPlayerList.setForeground(Color.red);
		jlPlayerList.setFont(new Font("Serif", Font.PLAIN, 18));
		jlPlayerList.setHorizontalAlignment( SwingConstants.CENTER );
		jtaPlayers = new JTextArea(20, 10);
		jtaPlayers.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.pink));
		jtaPlayers.setEditable(false);
		JPanel jpPlayers = new JPanel(new BorderLayout() );
		jpPlayers.add(jlPlayerList, BorderLayout.NORTH);
		jpPlayers.add(jtaPlayers, BorderLayout.SOUTH);
		//add to panel
		// jpNorth.add(jlLobby, BorderLayout.NORTH);
// 		jpNorth.add(jlPlayerList, BorderLayout.EAST);
// 		jpNorth.add(jsp, BorderLayout.CENTER);
// 		jpNorth.add(jtaPlayers, BorderLayout.EAST);
		jpNorth.add(jpChat, BorderLayout.CENTER);
		jpNorth.add(jpPlayers, BorderLayout.EAST);
		jf.add(jpNorth, BorderLayout.NORTH);
		
		//SOUTH PANEL
		ImageIcon myImage=new ImageIcon("../media/image.jpg");
		JLabel picture = new JLabel(myImage);
		JPanel jpPicture = new JPanel();
		jpPicture.add(picture);
		
		jtaMessage = new JTextArea(8,8);
		jtaMessage.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.pink));
		jtaMessage.setLineWrap(true);
		jtaMessage.setWrapStyleWord(true);
		jtaMessage.setText("Type here to send a message to your competitor.");
		jbSend = new JButton("Send Message");
		jbSend.setPreferredSize( new Dimension(25,25) );
		JPanel jpMessage = new JPanel(new BorderLayout());
		jpMessage.add(jtaMessage, BorderLayout.NORTH);
		jpMessage.add(jbSend, BorderLayout.SOUTH);
		
		jlReady = new JLabel("Ready to Play?");
		jlReady.setForeground(Color.red);
		jlReady.setFont(new Font("Serif", Font.PLAIN, 18));
		jlReady.setHorizontalAlignment( SwingConstants.CENTER );
		jbMatchMe = new JButton("Match Me With A Competitor");
		//jbMatchMe.setPreferredSize(new Dimension(50,50));
		JPanel jpMatch = new JPanel(new BorderLayout() );
		jpMatch.add(jlReady, BorderLayout.CENTER);
		jpMatch.add(jbMatchMe, BorderLayout.SOUTH);
		
		jpSouth.add(jpPicture, BorderLayout.WEST);
		jpSouth.add(jpMessage, BorderLayout.CENTER);
		jpSouth.add(jpMatch, BorderLayout.EAST);
		jf.add(jpSouth, BorderLayout.SOUTH);		//add listeners
		jtaMessage.addMouseListener(new MouseListener(){
			public void mouseEntered(MouseEvent me){
			}public void mouseClicked(MouseEvent me){
			}public void mouseReleased(MouseEvent me){
			}public void mouseExited(MouseEvent me){
			}public void mousePressed(MouseEvent me){
				jtaMessage.setText("");
			}
		});
		jbSend.addActionListener(this);
		jbMatchMe.addActionListener(this);
		//properties of frame
		jf.setTitle("Breakthrough Lobby Chat Room");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setLocation(300, 300);
	}
	public GUI getGUI(){
		return gui;
	}
	public String getName(){
		return username;
	}
	public int getMyPlayerId(){
		return myPlayerId;
	}
	public JTextArea getChat(){
		return jtaChat;
	}
	public void setCurrentClicked(JButton currClicked){
		this.currClicked = currClicked;
	}
	public JButton getCurrentClicked(){
		return currClicked;
	}
	public String getMessage(){
		String message = jtaMessage.getText();
		return message;
	}
	public void run(){
		try{
				this.dis = new DataInputStream(socket.getInputStream());
				this.dos = new DataOutputStream(socket.getOutputStream());
				//write the name to the server
				dos.writeUTF(username);
				dos.flush();
				//show a message saying loggin in to server...
				while(dis.available() == 0){
					//wait until returnCode is recieved
					JOptionPane.showMessageDialog(null, "You have connected to the server.");
				}
				int returnCode = dis.readInt();
				if(returnCode == -1){
					JOptionPane.showMessageDialog(null, "Your username is not unique");
					this.destruct();
					return;
				}else{
					executePacket(0);
				}
		}catch(SocketException se){
			JOptionPane.showMessageDialog(null,null,"There was an error. \nThe game must close.", JOptionPane.ERROR_MESSAGE);
			destruct();
		}catch(Exception e){ 
			JOptionPane.showMessageDialog(null, "ERROR", "The Server is not available at this time. Please try again shortly.", JOptionPane.ERROR_MESSAGE);
			destruct();
		}
		//runs a loop waiting for info from the server..
		while(disconnect == false){
			if(packetProcess() == false){
				destruct();
			}
			try{
				Thread.sleep(500);
			}catch(Exception e){ e.printStackTrace(); }
		}
	}//end run method
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand().equals("Send Message")){
			try{
				dos.write(1);
				dos.writeUTF(getMessage());
				dos.flush();
			}catch(IOException ioe){ System.out.println(ioe.toString());
				ioe.printStackTrace();
			}
		}else if(ae.getActionCommand().equals("Match Me With A Competitor")){
			try{
				dos.write(3);
				dos.flush();
			}catch(Exception e){ System.out.println(e.toString()); }
		}
	}
	public void sendButtonMove(int cr,int cc,int tr, int tc){
		try{
			dos.write(4);
			dos.writeInt(cr);
			dos.writeInt(cc);
			dos.writeInt(tr);
			dos.writeInt(tc);
			dos.flush();
			System.out.println("I SENT THAT SHIT TO THE SERVER, Yo.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void destruct(){
		disconnect = true;
		try{
			dis.close();
			dos.close();
			socket.close();
		}catch(Exception e){ e.printStackTrace(); }
	}
	public boolean packetProcess(){
		if(socket == null || socket.isClosed() == true){
			return false;
		}
		if(timeOut <=0)
			return false;
		try{
			int avail = dis.available();
			if(avail <= 0){
				timeOut -=1;
				return true;
			}
			timeOut = 20;
			int pktType = dis.read();
			executePacket(pktType);
		}catch(Exception e){ e.printStackTrace(); return false; }
		return true;
	}//end packetProcess
	public void executePacket(int pktType) throws IOException {
		switch(pktType){
			case 0: //Heartbeat packet write to server
				dos.write(0);
				dos.flush();
			break;
			case 1: //recieve lobby chat message
					//show message to the lobby chat box 
				System.out.println("Entered Client Case 1");
				String from = dis.readUTF();
				String message = dis.readUTF();		
				jtaChat.append(String.format("\n%1$s says : %2$s", from, message));		
			break;
			case 2: //recieve game chat message show message to game chatbox
				from = dis.readUTF();
				message = dis.readUTF(); 
				getGUI().updateChat(from, message);
			break;
			case 3: //recieve that client has joined a game
				//initialize and show the game board here
				myPlayerId = dis.readInt();
				String p2name = dis.readUTF(); //player two's name
				String name = dis.readUTF();//show your game gui
				gui = new GUI(this, p2name, name, myPlayerId);
			break;
			case 4://recieve the game board layout
					 // update game board layout
				int whoseTurn = dis.readInt();
				String boardInfo = dis.readUTF();
				readBoardString(boardInfo);
			break;
			case 5://recieve player game error(invalid move)
					// show the player a message saying there was an error
				String errorMessage = dis.readUTF();
				String server = "Server";
				getGUI().updateChat(server, errorMessage);
			break;
			case 6: // recieve game message (win)
				// show the player a message from the game
				message = dis.readUTF();
			break;
			case 7:// dynamic list of players
				usernames.clear();
				int numPlayers = dis.readInt();
				for(int i = 0; i < numPlayers; i++){
					String player = dis.readUTF();
					usernames.add(player);
				}
				updateJTAPlayers(usernames);
			break;
			case 8:// game over
				String playerwin = dis.readUTF();
				JOptionPane.showMessageDialog(null, String.format("$1s has won. Game Over.", playerwin));
			break;
		}
	}// end execute packet
	public void updateJTAPlayers(ArrayList<String> usernames){
		jtaPlayers.setText("");
		// jtaPlayers.append("Last update" + time);
		for(int i = 0; i < usernames.size(); i++){
			jtaPlayers.append("\n" + usernames.get(i));
		}
	}
	public void sendChatMessage(String message){
		try{
			dos.write(2);
			dos.writeUTF(message);
			dos.flush();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public void readBoardString(String boardInfo){
		String[] pieceInfo = boardInfo.split(",");
		int piece = 0;
		Buttons [][] buttons = getGUI().getButtons();
		for(int r=0; r<8; r++){
			for(int c=0; c<8; c++){
				int buttonState = Integer.parseInt(pieceInfo[piece]);
				if(buttonState == 0)
					buttons[r][c].setButtons(0);
				else if(buttonState == 1)
					buttons[r][c].setButtons(1);
				else if(buttonState == 2)
					buttons[r][c].setButtons( 2);
				piece++;
			}
		}
	}
}