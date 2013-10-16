/*
Samantha Oxley
Homework 3 - Producer Consumer Threads
Consumer to read the text field
*/
import java.awt.*;
import javax.swing.*;
import java.lang.System.*;

public class Consumer extends Thread{
	//attributes
	Buffer buffer;
	long timeStart;
	long timeFinish;
	private JTextArea jtaMain;
	private String targetNumText;
	private String bufferNumText;
	private int targetNum;
	private int bufferNum;
	private boolean go = true;
	//constructor
	public Consumer(JTextField jtfTargetNum, Buffer buffer, JTextArea jtaMain){
		timeStart = System.currentTimeMillis();
		this.buffer = buffer;
		this.jtaMain = jtaMain;
		targetNumText = jtfTargetNum.getText();
		targetNum = Integer.parseInt(targetNumText);
	}
	//run method
	public void run(){
		while(go){
			try{
				if(buffer.getValue().equals(targetNumText)){
					timeFinish = System.currentTimeMillis();
					Long timeBetween = timeFinish - timeStart;
					jtaMain.append(String.format("\nIt took %1$s milliseconds", timeBetween));
					go = false;
				}else{
					
				}
			}catch(NumberFormatException nfe){
				nfe.printStackTrace();
			}catch(NullPointerException npe){}
		}
	}//end run
}