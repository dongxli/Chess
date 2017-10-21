package ChessPiece;


import Board.Board;
import Board.Cell;


public class Bishop extends ChessPiece{
	
	private Cell [][] cells;
	
	public Bishop(Type bishop,int x, int y,Player color){
		super(bishop, x,y,color);
		if(color==Player.BLACK){
			image = reSize("/bishopb.png");
		}
		else if(color==Player.WHITE)
			image = reSize("/bishopw.png");
	}
	
	public boolean validMoves(){
		
		cells= Board.getCell();
		//lower right
		for(int i =1;i<8;i++){
			if(x+i<8 && y+i<8 && !cells[x][y].sameTeam(cells[x+i][y+i])){
				cells[x+i][y+i].setValidMove(true);
				
				if(x+i+1<8 && y+i+1<8 &&cells[x][y].sameTeam(cells[x+i+1][y+i+1])) break;
				
				if(x+i<8 && y+i<8 && cells[x][y].oppTeam(cells[x+i][y+i])) break;
			}
			else break;
		}
		
		//lower left
		for(int i =1;i<8;i++){
			if(x+i<8 && y-i>=0 && !cells[x][y].sameTeam(cells[x+i][y-i])){
				cells[x+i][y-i].setValidMove(true);
				
				if(x+i+1<8 && y-i-1>=0 && cells[x][y].sameTeam(cells[x+i+1][y-i-1])) break;
				
				if(x+i<8 && y-i>=0 && cells[x][y].oppTeam(cells[x+i][y-i])) break;
			}
			else break;
		}
		
		//upper right
		for(int i =1;i<8;i++){
			if(x-i>=0 && y+i<8 && !cells[x][y].sameTeam(cells[x-i][y+i])){
				cells[x-i][y+i].setValidMove(true);
				
				if(x-i-1>=0 && y+i+1<8 && cells[x][y].sameTeam(cells[x-i-1][y+i+1])) break;
				
				if(x-i>=0 && y+i<8 && cells[x][y].oppTeam(cells[x-i][y+i])) break;
			}
			else break;
		}
		
		//upper left
		for(int i =1;i<8;i++){
			if(x-i>=0 && y-i>=0 && !cells[x][y].sameTeam(cells[x-i][y-i])){
				cells[x-i][y-i].setValidMove(true);
				
				if(x-i-1>=0 && y-i-1>=0 && cells[x][y].sameTeam(cells[x-i-1][y-i-1]))	break;
				
				if(x-i>=0 && y-1>=0 && cells[x][y].oppTeam(cells[x-i][y-i])) break;
				
			}
			else break;
		}
		
		return true;
	}
	
	public boolean validCheckMateMoves(){
		
		cells= Board.getCell();
		//lower right
		for(int i =1;i<8;i++){

			if(x+i<8 && y+i<8 && !cells[x][y].sameTeam(cells[x+i][y+i]) && !cells[x][y].oppTeamK(cells[x+i][y+i])){
				cells[x+i][y+i].setCheckMateMove(true);
				System.out.println(x+i+" "+y+i);
				
				if(x+i+1<8 && y+i+1<8 &&cells[x][y].sameTeam(cells[x+i+1][y+i+1])) break;
				
			}
			else break;
		}
		
		//lower left
		for(int i =1;i<8;i++){
			if(x+i<8 && y-i>=0 && !cells[x][y].sameTeam(cells[x+i][y-i]) && !cells[x][y].oppTeamK(cells[x+i][y-i])){
				cells[x+i][y-i].setCheckMateMove(true);
				System.out.println(x+i+" "+(y-i));
				
				if(x+i+1<8 && y-i-1>=0 && cells[x][y].sameTeam(cells[x+i+1][y-i-1])) break;
				
			}
			else break;
		}
		
		//upper right
		for(int i =1;i<8;i++){
			if(x-i>=0 && y+i<8 && !cells[x][y].sameTeam(cells[x-i][y+i]) && !cells[x][y].oppTeamK(cells[x-i][y+i])){
				cells[x-i][y+i].setCheckMateMove(true);
				
				if(x-i-1>=0 && y+i+1<8 && cells[x][y].sameTeam(cells[x-i-1][y+i+1])) break;
				
			}
			else break;
		}
		
		//upper left
		for(int i =1;i<8;i++){
			if(x-i>=0 && y-i>=0 && !cells[x][y].sameTeam(cells[x-i][y-i])&& !cells[x][y].oppTeamK(cells[x-i][y-i])){
				cells[x-i][y-i].setCheckMateMove(true);
				
				if(x-i-1>=0 && y-i-1>=0 && cells[x][y].sameTeam(cells[x-i-1][y-i-1]))	break;
				
			}
			else break;
		}
			
		return true;
	}
	
	
}
