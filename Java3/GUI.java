/*
Samantha Oxley &
Kelley Scanlon

Java MiniProject -
creates GUI for the client

*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GUI{
	
	private Timer time;
	public final Buttons[][] buttons;
	Buttons buttonSelected;
	public final Game game;
	public final GameClient gClient;
	private JTextArea jtaChat;
	private JTextArea jtaMessage;
	private JButton jbSend;
	String player2;
	String player1;
	int playerNum;
	
	/*
	Constructor of main GUI
	*/
	public GUI(GameClient gc,String p2name,String name, int playerId){
		gClient = gc;
		game = new Game();
		player2 = p2name;
		player1 = name;
		playerNum = playerId;
	
		//create frame and panels
		JFrame frame = new JFrame();
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpWest = new JPanel();
		JPanel jpEast = new JPanel(new BorderLayout());
		JPanel jpSouth = new JPanel();
		
		//create center panel
		jpCenter.setLayout(new GridLayout(8,8));
		jpCenter.setBackground(Color.WHITE);
		buttons = new Buttons[8][8];
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				final int r = row;
				final int c = col;
				//create buttons sending row and column of button
				buttons[r][c] = new Buttons(r, c);
				jpCenter.add(buttons[r][c]);
				if(c%2 != 0 && r%2 == 0)
					buttons[r][c].setBackground(Color.BLACK);
				else if(c%2 == 0 && r%2 != 0)
					buttons[r][c].setBackground(Color.BLACK);
				else
					buttons[r][c].setBackground(Color.WHITE);
				// button listener sends message to client when valid, 
				// client sends to server
				buttons[r][c].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						Buttons buttonClicked = (Buttons)ae.getSource();
						int clickR = buttonClicked.getRow();
						int clickC = buttonClicked.getColumn();
						System.out.println("BUTTON CLICKED CONTROL " + game.getButtons(clickR, clickC));
						System.out.println("PLAYER NUMBER IS " + playerNum);
						System.out.println("GET ACTING PLAYER IS : " + game.getActingPlayer());
						if(buttonSelected == null){
							if(game.getButtons(clickR, clickC) != game.getActingPlayer()){
								JOptionPane.showMessageDialog(null, "You cannot move that piece.");
							}else if(playerNum != game.getActingPlayer()){
								JOptionPane.showMessageDialog(null, "It is not your turn!");
							}else{	
								buttonSelected = buttonClicked;
								System.out.println("buttonSelected equals buttonclicked");
							}
						}
						else{
								int currR = buttonSelected.getRow();
								int currC = buttonSelected.getColumn();
								int tarR = buttonClicked.getRow();
								int tarC = buttonClicked.getColumn();
								gClient.sendButtonMove(currR, currC, tarR, tarC);
								System.out.println("SEND BUTTON MOVE " + currR + currC + tarR + tarC);
								
								buttonSelected = null;
								buttonClicked = null;
						}
					}
				}); //end action performed
				//image icons
				if(c == 0 || c == 1)
					buttons[r][c].setIcon(new ImageIcon("../media/mustache.png"));
				else if(c == 6 || c == 7)
					buttons[r][c].setIcon(new ImageIcon("../media/beard.png"));
			}
		}
		frame.add(jpCenter, BorderLayout.CENTER);
		//create south panel
		jpSouth.setLayout(new GridLayout(1,8));
		jpSouth.setBackground(Color.WHITE);
		for(int r=1; r<9; r++){
			//disregard my shitty spacing technique. I'm a professional.
			String num = "                     " +Integer.toString(r);
			JLabel jl = new JLabel(num);
			jpSouth.add(jl);
		}
		frame.add(jpSouth, BorderLayout.SOUTH);
		//create east (chat) panel
		jtaChat = new JTextArea(20, 25);
		jtaChat.setEditable(false);
		jtaChat.setWrapStyleWord(true);
		jtaChat.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(jtaChat,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, 
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jpEast.add(jsp, BorderLayout.CENTER);
		//message
		JPanel innerPanel = new JPanel();
		new BoxLayout(innerPanel, BoxLayout.X_AXIS);
		jtaMessage = new JTextArea(2, 15);
		jtaMessage.setLineWrap(true);
		jtaMessage.setWrapStyleWord(true);
		jtaMessage.setText("Type here to send a message to your competitor.");
		jbSend = new JButton("Send Message");
		innerPanel.add(jtaMessage, BoxLayout.X_AXIS);
		innerPanel.add(jbSend, BoxLayout.X_AXIS);
		jpEast.add(innerPanel, BorderLayout.SOUTH);
		frame.add(jpEast, BorderLayout.EAST);
		
		//create west panel
		jpWest.setLayout(new GridLayout(8,1));
		jpWest.setBackground(Color.WHITE);
		for(int c=8; c>0; c--){
			String num = "   " + Integer.toString(c) + "   ";
			JLabel jl = new JLabel(num);
			jpWest.add(jl);
		}
		frame.add(jpWest, BorderLayout.WEST);
		
		//create north panel - the Player play(1/2) grabs the input from player
		jpNorth.setBackground(Color.WHITE);
		JLabel jlGame = new JLabel(String.format("Player 1: %1s - VS - Player 2: %2s", player1, player2));	
		jpNorth.add(jlGame);
		frame.add(jpNorth, BorderLayout.NORTH);
		
		//create menu
		JMenuBar menu = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenu jmHelp = new JMenu("Help");
		menu.add(jmFile);
		menu.add(jmHelp);
		JMenuItem jmiNewGame = new JMenuItem("New Game");
		JMenuItem jmiExit = new JMenuItem("Exit");
		JMenuItem jmiAbout = new JMenuItem("About");
		JMenuItem jmiRules = new JMenuItem("Rules");
		jmFile.add(jmiNewGame);
		jmFile.add(jmiExit);
		jmHelp.add(jmiAbout);
		jmHelp.add(jmiRules);
		
		frame.setTitle("Breakthrough");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocation(200, 200);
		jtaMessage.addMouseListener(new MouseListener(){
			public void mouseEntered(MouseEvent me){
			}public void mouseClicked(MouseEvent me){
			}public void mouseReleased(MouseEvent me){
			}public void mouseExited(MouseEvent me){
			}public void mousePressed(MouseEvent me){
				jtaMessage.setText("");
			}
		});
		jmiNewGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				game.reset();
			}
		});
		jmiExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JOptionPane.showMessageDialog(null, "Thanks for Playing. You will now be disconnected");
				gClient.destruct();
				System.exit(0);
			}
		});	
		jmiAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JOptionPane.showMessageDialog(null, "About BreakThrough:"
													+ "\n Remake of classic game for Java III sequence. Final Project."
													+ "\n Developed by: Samantha Oxley & Kelley Scanlon" );
			}
		});
		jbSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String message = jtaMessage.getText();
				gClient.sendChatMessage(message);
			}
		});
		
		}//end GUI constructor
		public void updateButtons(){
		try{
			for(int r=0; r<8; r++){
				for(int c=0; c<8; c++){
					int cont = game.getButtons(r,c);
					if(cont == 0)
						buttons[r][c].setButtons(0);
					else if(cont == 1)
						buttons[r][c].setButtons(1);
					else if(cont == 2)
						buttons[r][c].setButtons( 2);
				}
			}
		}catch(NullPointerException npe){
			System.out.println("Null Pointer Exception in updateButtons.");
		}
	}
		public Buttons[][] getButtons(){
			return buttons;
		}
		public Game getGame(){
			return game;
		}
		public void updateChat(String name, String message){
			jtaChat.append(String.format("\n" + name + " says : " + message));
		}
}