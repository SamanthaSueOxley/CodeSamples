/*
Samantha Oxley
Kelley Scanlon 

class Button's function is to create the buttons and set the actionCommand for
each button and allow the other classes to easily reference each button's row and
column and the player icon 
*/

import java.awt.*;
import javax.swing.*;

public class Buttons extends JButton{
	public int row;
	public int col;
	
	public Buttons(final int r,final int c){
		super();
		row = r;
		col = c;
		this.setActionCommand("BoardButton");
	}
	public int getRow(){
		return row;	
	}
	public int getColumn(){
		return col;
	}
	//returns the imageIcon for the player based on an input p value
	public static ImageIcon getPlayerIcon(int p){
		if(p == 1){
			ImageIcon icon1 = new ImageIcon("../media/mustache.png");
			return icon1;
		}
		else if(p == 2){
			ImageIcon icon2 = new ImageIcon("../media/beard.png");
			return icon2;
		}
		else{
			return null;
		}
	}
	//sets the image icon for the update buttons method
	public void setButtons(int c){
		ImageIcon icon = null;
		if(c == 1)
			icon = new ImageIcon("media/mustache.png");
		else if(c == 2)
			icon = new ImageIcon("media/beard.png");
		else
			icon = null;
		this.setIcon(icon);
	}

}