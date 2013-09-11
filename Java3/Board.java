/*
Kelley Scanlon &
Samantha Oxley

MiniProject - Breakthrough Game
The board class handles building the board for each game, this is NOT a GUI !!!!
*/
public class Board{
	//attributes of the Board
	private int[][] board = new int[8][8];
	
	public Board(){
		this.reset();
	}
	//reset function for board
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
		}}//--END double for loop
	}//--END reset
	public int getButtons(int r, int c){
		return board[r][c];
	}
	//moves piece- not validated, 
	//cr/cc = current row/column : tr/tc = target row/column
	public void move(int cr, int cc, int tr, int tc){ //change vars
		board[tr][tc] = board[cr][cc];
		board[cr][cc] = 0;
	}
	//method checks for Win based on column number
	public int checkWin(){
		for(int r=0; r<8; r++){
			if(board[r][7] == 1)
				return 1;
			else if(board[r][0] == 2)
				return 2;
		}
		return -1;
	}
}