/*
Samantha Oxley
Homework 3 - Producer Consumer Threads
Producer to write to text field
*/
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Producer extends Thread{
	//attributes
	Random randomGen = new Random();
	Buffer buffer;
	
	private JTextArea jtaMain;
	private String randomNumText;
	private String targetNum;
	private int randomNum;
	//constructor
	public Producer(JTextField jtfMax, JTextField jtfTarget, Buffer buffer, JTextArea jtaMain){
		this.buffer = buffer;
		this.jtaMain = jtaMain;
		targetNum = jtfTarget.getText();
		String textMaxNum = jtfMax.getText();
		randomNum = Integer.parseInt(textMaxNum);
	}
	//run method
	public void run(){
		do{
			int nextRandom = randomGen.nextInt(randomNum);
			randomNumText = Integer.toString(nextRandom);
			//System.out.println(randomNumText);
			buffer.setValue(randomNumText);
			jtaMain.append(randomNumText);
			
		}while(!(buffer.getValue().equals(targetNum)));
	}//end run
}