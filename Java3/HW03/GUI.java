/*
Samantha Oxley
Homework 3 - Consumer/Producer Threads
GUI - creates user interface
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI{
	//attributes
	private JTextArea jtaMain;
	
	private JTextField jtfMaxNumber;
	private JTextField jtfTargetNumber;
	private Buffer buffer;
	
	private JButton jbStart;
	private JButton jbReset;
	private JButton jbExit;
	
	//constructor
	public GUI(){
		//create frame and panels
		JFrame frame = new JFrame();
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		
		//add components to each panel.. north
		JLabel jlMaxNum = new JLabel("Max #: ");
		jtfMaxNumber = new JTextField(8);
		JLabel jlTargetNum = new JLabel("Target #: ");
		jtfTargetNumber = new JTextField(8);
		JLabel jlBufferNum = new JLabel("Buffer #: ");
		buffer = new Buffer();
		jpNorth.add(jlMaxNum);
		jpNorth.add(jtfMaxNumber);
		jpNorth.add(jlTargetNum);
		jpNorth.add(jtfTargetNumber);
		jpNorth.add(jlBufferNum);
		jpNorth.add(buffer);
			//center..
		jtaMain = new JTextArea(20, 40);
		jtaMain.setLineWrap(true);
		JScrollPane pane = new JScrollPane(jtaMain,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jpCenter.add(pane);
			//south..
		jbStart = new JButton("Start");
		jbReset = new JButton("Reset");
		jbExit = new JButton("Exit");
		jpSouth.add(jbStart);
		jpSouth.add(jbReset);
		jpSouth.add(jbExit);
		
		//add each panel to frame
		frame.add(jpNorth, BorderLayout.NORTH);
		frame.add(jpCenter, BorderLayout.CENTER);
		frame.add(jpSouth, BorderLayout.SOUTH);
		
		//add action listeners
		Listener listener = new Listener();
		jbStart.addActionListener(listener);
		jbReset.addActionListener(listener);
		jbExit.addActionListener(listener);
		//frame properties
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setLocation(200, 200);
	}//--END GUI constructor 
	
	public static void main(String []args){
		new GUI(); } //--End main
		
	class Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent ae){
			if(ae.getActionCommand().equals("Start")){
				try{
					if(jtfMaxNumber.equals("")){
						JOptionPane.showMessageDialog(null, "Please enter a value into \"Max #:\"");
					}
					else if(jtfTargetNumber.equals("")){
						JOptionPane.showMessageDialog(null, "Please enter a value into \"Target #:\"");
					}
					else if(Integer.parseInt(jtfTargetNumber.getText()) > Integer.parseInt(jtfMaxNumber.getText())){
						JOptionPane.showMessageDialog(null, "Target number must be smaller than max number.");
					}
					else{
						jbStart.setEnabled(false);
						jbReset.setEnabled(false);
						Thread pro = new Producer(jtfMaxNumber, jtfTargetNumber, buffer, jtaMain);
						Thread con = new Consumer(jtfTargetNumber, buffer, jtaMain);
						pro.start();
						con.start();
						try{
							pro.join();
							con.join();
						}catch(InterruptedException ie){}
					}//end inner if
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please only enter numbers into the fields..");
				}
				jbStart.setEnabled(true);
				jbReset.setEnabled(true);
			}
			else if(ae.getActionCommand().equals("Reset")){
				jtaMain.setText("");
				jtfMaxNumber.setText("");
				jtfTargetNumber.setText("");
				buffer.setText("");
			}
			else if(ae.getActionCommand().equals("Exit")){
				System.exit(0);
			}
		}
	}
}//--END GUI CLASS
