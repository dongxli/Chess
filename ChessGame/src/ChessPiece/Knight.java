package ChessPiece;

import Board.Board;
import Board.Cell;

public class Knight extends ChessPiece{

	private Cell [][] cells;
	
	public Knight(Type knight, int x, int y,Player color){
		super(knight,x,y,color);
		if(color==Player.BLACK){
			image = reSize("/knightb.png");
		}
		else if(color==Player.WHITE) 
			image = reSize("/knightw.png");
	}
	
	public boolean validMoves(){
		
		cells= Board.getCell();
		//x+2 y+1
		if(x+2<8 && y+1<8 && !cells[x][y].sameTeam(cells[x+2][y+1])){
			cells[x+2][y+1].setValidMove(true);
		}
				
		//x+2 y-1
		if(x+2<8 && y-1>=0 && !cells[x][y].sameTeam(cells[x+2][y-1])){
			cells[x+2][y-1].setValidMove(true);
		}
		
		//x-2 y+1
		if(x-2>=0 && y+1<8 && !cells[x][y].sameTeam(cells[x-2][y+1])){
			cells[x-2][y+1].setValidMove(true);
		}
		
		//x-2 y-1
		if(x-2>=0 && y-1>=0 && !cells[x][y].sameTeam(cells[x-2][y-1])){
			cells[x-2][y-1].setValidMove(true);
		}
		
		//x-1 y+2
		if(x-1>=0 && y+2<8 && !cells[x][y].sameTeam(cells[x-1][y+2])){
			cells[x-1][y+2].setValidMove(true);
		}
		
		//x+1 y+2
		if(x+1<8 && y+2<8 && !cells[x][y].sameTeam(cells[x+1][y+2])){
			cells[x+1][y+2].setValidMove(true);
		}
		
		//x-1 y-2
		if(x-1>=0 && y-2>=0 && !cells[x][y].sameTeam(cells[x-1][y-2])){
			cells[x-1][y-2].setValidMove(true);
		}
		
		//x+1 y-2
		if(x+1<8 && y-2>=0 && !cells[x][y].sameTeam(cells[x+1][y-2])){
			cells[x+1][y-2].setValidMove(true);
		}
				
		return true;
	}
	
	public boolean validCheckMateMoves(){
		
		cells= Board.getCell();
		//x+2 y+1
		if(x+2<8 && y+1<8 && !cells[x][y].sameTeam(cells[x+2][y+1])&& !cells[x][y].oppTeamK(cells[x+2][y+1])){
			cells[x+2][y+1].setCheckMateMove(true);
		}
				
		//x+2 y-1
		if(x+2<8 && y-1>=0 && !cells[x][y].sameTeam(cells[x+2][y-1])&& !cells[x][y].oppTeamK(cells[x+2][y-1])){
			cells[x+2][y-1].setCheckMateMove(true);
		}
		
		//x-2 y+1
		if(x-2>=0 && y+1<8 && !cells[x][y].sameTeam(cells[x-2][y+1])&& !cells[x][y].oppTeamK(cells[x-2][y+1])){
			cells[x-2][y+1].setCheckMateMove(true);
		}
		
		//x-2 y-1
		if(x-2>=0 && y-1>=0 && !cells[x][y].sameTeam(cells[x-2][y-1])&& !cells[x][y].oppTeamK(cells[x-2][y-1])){
			cells[x-2][y-1].setCheckMateMove(true);
		}
		
		//x-1 y+2
		if(x-1>=0 && y+2<8 && !cells[x][y].sameTeam(cells[x-1][y+2])&& !cells[x][y].oppTeamK(cells[x-1][y+2])){
			cells[x-1][y+2].setCheckMateMove(true);
		}
		
		//x+1 y+2
		if(x+1<8 && y+2<8 && !cells[x][y].sameTeam(cells[x+1][y+2])&& !cells[x][y].oppTeamK(cells[x+1][y+2])){
			cells[x+1][y+2].setCheckMateMove(true);
		}
		
		//x-1 y-2
		if(x-1>=0 && y-2>=0 && !cells[x][y].sameTeam(cells[x-1][y-2])&& !cells[x][y].oppTeamK(cells[x-1][y-2])){
			cells[x-1][y-2].setCheckMateMove(true);
		}
		
		//x+1 y-2
		if(x+1<8 && y-2>=0 && !cells[x][y].sameTeam(cells[x+1][y-2])&& !cells[x][y].oppTeamK(cells[x+1][y-2])){
			cells[x+1][y-2].setCheckMateMove(true);
		}
				
		return true;
	}
}
