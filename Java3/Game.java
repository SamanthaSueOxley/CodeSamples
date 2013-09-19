/*
Kelley Scanlon
Samantha Oxley

Java MiniProject -
creates the game from the GUI 

*/
import javax.swing.*;

public class Game{
	//attributes for the board
	private int[][] board = new int[8][8];
	private int moves;
	
	public Game(){
		//create a new board for the new game
		this.reset();		
	}
	public int getButtons(int r, int c){
		return board[r][c];
	}
	public void move(int cr, int cc, int tr, int tc){
		board[tr][tc] = board[cr][cc];
		board[cr][cc] = 0;
	}
	public int checkWin(){
		for(int r=0; r<8; r++){
			if(board[r][7] == 1)
				return 1;
			else if(board[r][0] == 2)
				return 2;
		}
		return -1;
	}
	//resets moves to 0 and resets the board
	public void reset(){
		for(int r=0; r<8; r++){
			for(int c=0; c<8; c++){
				//replaces the buttons
				if(c == 0 || c == 1){
					board[r][c] = 1;			
				}
				else if(c == 6 || c == 7){
					board[r][c] = 2;	
				}
				else{
					board[r][c] = 0;
				}
		}}
		moves = 0;
	}
	//method to add move
	public void addMove(){
		moves++;
		//call the board class checkWin() method...
		int winner = checkWin();
		ImageIcon winnerIcon;
		//if there is a winner...
		if(winner == 1 || winner == 2){
			if(winner == 1){
				//mustache icon
				winnerIcon = new ImageIcon("mustache.png");
			}
			else if(winner == 2){
				//beard icon
				winnerIcon = new ImageIcon("beard.png");
			}
			else{
				winnerIcon = null;
			}
			JOptionPane.showMessageDialog(null, String.format("Player %1$s won!!", winner),
													"Game over!", JOptionPane.PLAIN_MESSAGE, winnerIcon);
			reset();
		}//--END IF
	}//--END addMove
	//actingPlayer is determined by even numbers from the moves counter... simple
	public int getActingPlayer(){
		if(moves%2 == 0)
			return 1;
		else
			return 2;
	}
}