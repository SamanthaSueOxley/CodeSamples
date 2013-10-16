/*
Samantha Oxley
Homework 3 - Producer Consumer Threads
Buffer to handle pro/con processes
*/
import java.awt.*;
import javax.swing.*;

public class Buffer extends JTextField{
	//attributes
	private String number;
	
	//constructor
	public Buffer(){
		super(8);
		number = "";
		this.setEditable(false);
	}
	public synchronized void setValue(String num){
		number = num;
		this.setText(number);
	}
	public synchronized String getValue(){
		return number;
	}
}