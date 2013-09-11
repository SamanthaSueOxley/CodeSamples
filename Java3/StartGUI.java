/*
This is the prompt window
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object.*;
import java.io.*;
import java.net.*;
public class StartGUI {
	JButton jbConnect;
	JButton jbLearn;
	JFrame frame = new JFrame();
	private int port = 16238;
	
	public StartGUI(){
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		//north panel
		JLabel jlWelcome = new JLabel("Welcome to Breakthrough!");
		jpNorth.add(jlWelcome);
		frame.add(jpNorth, BorderLayout.NORTH);
		//center panel
		JLabel jlAction = new JLabel("What would you like to do?");
		jpCenter.add(jlAction);
		frame.add(jpCenter, BorderLayout.CENTER);
		//south panel
		jbConnect = new JButton("Connect To The Lobby");
		jbLearn = new JButton("Learn How To Play.");
		jpSouth.add(jbConnect);
		jpSouth.add(jbLearn);
		frame.add(jpSouth, BorderLayout.SOUTH);
		//menu
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		frame.setJMenuBar(jmb);
		
		frame.setVisible(true);
		frame.setLocation(250, 250);
		frame.pack();
		frame.setTitle("Breakthrough Launcher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//button listeners
		jmiExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
		jbConnect.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					String username = JOptionPane.showInputDialog(null, "Please enter an unique username:");
					String socketIP = JOptionPane.showInputDialog(null, "What is the IP Address of the Server?");
					try{
	 					Socket socket = new Socket(socketIP, port);
						GameClient gc = new GameClient(username, socket);
						Thread gClient = new Thread(gc);
						gClient.start();
					}catch(UnknownHostException uhe){ uhe.printStackTrace(); 
					}catch(IOException ioe){ ioe.printStackTrace(); }
				}
			});
		jbLearn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					JFrame frame = new JFrame();
					JPanel jp = new JPanel();
					JTextArea jtaRules = new JTextArea(10, 20);
					jtaRules.setWrapStyleWord(true);
					jtaRules.setLineWrap(true);
					JScrollPane jsp = new JScrollPane(jtaRules,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					jp.add(jsp);
					frame.add(jp, BorderLayout.CENTER);
					frame.setTitle("How To Play Breakthrough");
					frame.setVisible(true);
					frame.setLocation(250, 250);
					frame.pack();
					try{
						File file = new File("readMe.txt");
						BufferedReader in = new BufferedReader(new FileReader(file));
						StringBuffer sb = new StringBuffer();
						String line = "";
						while((line = in.readLine())!= null){
							sb.append(line + "\n");
						}
						jtaRules.setText(sb.toString());
						
					}catch(IOException ioe){ ioe.printStackTrace(); }
					
				}
			});
	}
}