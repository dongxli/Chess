package ChessPiece;

import Board.Board;
import Board.Cell;

public class Pawn extends ChessPiece{
	
	private Cell [][] cells;
	
	public Pawn(Type pawn,int x, int y, Player color){
		super(pawn, x,y,color);
		if(color==Player.BLACK){
			image = reSize("/pawnb.png");
		}
		else if(color==Player.WHITE)
			image = reSize("/pawnw.png");
	}
	
	public boolean validMoves(){
		
		cells = Board.getCell();
		//cells[x][y].setValidMove(false);
		
		if(player==Player.BLACK){
			
			//check one or two cells in front of the pawn
			for(int i =1;i<3;i++){
				if(x+i<8 && cells[x+i][y].getC()==null)
					cells[x+i][y].setValidMove(true);
				//stops intermediately when a cell in front is not valid
				else break;
			}
			// checks the lower right corner of black pawn
			if(x+1<8 && y+1<8 &&cells[x][y].oppTeam(cells[x+1][y+1])){
				cells[x+1][y+1].setValidMove(true);
			}
			//checks the lower left corner of black pawn
			if(y-1>=0&& x+1<8 && cells[x][y].oppTeam(cells[x+1][y-1])){
				cells[x+1][y-1].setValidMove(true);
			}
			
		}
		
		if(player==Player.WHITE){
			//check one or two cells in front of the pawn
			for(int i =1;i<3;i++){
				if(x-i>=0 && cells[x-i][y].getC()==null)
					cells[x-i][y].setValidMove(true);
				//stops intermediately when a cell in front is not valid
				else break;
			}
			//checks upper left corner of white pawn
			if(x-1>=0 && y-1>=0 &&cells[x][y].oppTeam(cells[x-1][y-1])){
				cells[x-1][y-1].setValidMove(true);
			}
			//checks upper right corner of white pawn
			if(x-1>=0 &&y+1<8 && cells[x][y].oppTeam(cells[x-1][y+1])){
				cells[x-1][y+1].setValidMove(true);
			}
			
		}
		return true;
	}
	
	public boolean validCheckMateMoves(Player player){
		
		cells = Board.getCell();
		if(player==Player.BLACK){
			
			// checks the lower right corner of black pawn
			if(x+1<8 && y+1<8 && !cells[x][y].oppTeamK(cells[x+1][y+1])&& !cells[x][y].sameTeam(cells[x+1][y+1])){
				cells[x+1][y+1].setCheckMateMove(true);
			}
			//checks the lower left corner of black pawn
			if(y-1>=0&& x+1<8 && !cells[x][y].oppTeamK(cells[x+1][y-1]) && !cells[x][y].sameTeam(cells[x+1][y-1])){
				cells[x+1][y-1].setCheckMateMove(true);
			}
			
		}
		
		if(player==Player.WHITE){
			
			//checks upper left corner of white pawn
			if(x-1>=0 && y-1>=0 && !cells[x][y].oppTeamK(cells[x-1][y-1]) && !cells[x][y].sameTeam(cells[x-1][y-1])){
				cells[x-1][y-1].setCheckMateMove(true);
			}
			//checks upper right corner of white pawn
			if(x-1>=0 &&y+1<8 && !cells[x][y].oppTeamK(cells[x-1][y+1])&& !cells[x][y].sameTeam(cells[x-1][y+1])){
				cells[x-1][y+1].setCheckMateMove(true);
			}
			
		}
		
		return true;
	}
}
