package ChessPiece;

import Board.Board;
import Board.Cell;


public class Rook extends ChessPiece{

	private Cell [][] cells;
	public boolean moved= false;
	
	public Rook(Type rook,int x, int y,Player color){
		super(rook, x, y,color);
		if(color==Player.BLACK){
			image = reSize("/rookb.png");
		}
		else if(color==Player.WHITE) 
			image = reSize("/rookw.png");
	}
	
	
	
	//Highlights valid moves that can be made by rook
	public boolean validMoves(){
		
		cells = Board.getCell();
		//goes in to a loop to highlight the positive row
		for(int i=1;i<8;i++){
			
			//if the next cell is not on the same team as current cell, highlight the next cell first
			if(y+i<8 && !cells[x][y].sameTeam(cells[x][y+i])){
				cells[x][y+i].setValidMove(true);
				
				//checks the next next cell if it is on the same team then stops at the next cell(check in advance)( can't highlight the same team)
				if(y+i+1<8 && cells[x][y].sameTeam(cells[x][y+i+1])) break;
				
				//checks if the next cell is on the opposite team, if it is then stop highlighting immediately( since the next cell is already highlighted)
				else if(cells[x][y].oppTeam(cells[x][y+i])) break;
			}
			
			//needs this if the if statement fails, break the loop right away or else it continues
			else break;
				
		}
		
		//negative rows
		for(int i=1;i<8;i++){
				if(y-i>=0 && !cells[x][y].sameTeam(cells[x][y-i])){
					cells[x][y-i].setValidMove(true);
					
				if(y-i-1>=0 && cells[x][y].sameTeam(cells[x][y-i-1])) break;
				
				else if(cells[x][y].oppTeam(cells[x][y-i])) break;
				}
				else break;
		}
		//same logic, just the positive columns	
		for(int i=1;i<8;i++){	
			
			if(x+i<8 && !cells[x][y].sameTeam(cells[x+i][y])){
				cells[x+i][y].setValidMove(true);
			
				if(x+i+1<8 && cells[x][y].sameTeam(cells[x+i+1][y])) break;
				
				else if(cells[x][y].oppTeam(cells[x+i][y])) break;
				
			}
			
			else break;
		}
		//negative columns
		for(int i=1;i<8;i++){	
			
			if(x-i>=0 && !cells[x][y].sameTeam(cells[x-i][y])){
				cells[x-i][y].setValidMove(true);
			
				if(x-i-1>=0 && cells[x][y].sameTeam(cells[x-i-1][y])) break;
				
				else if(cells[x][y].oppTeam(cells[x-i][y])) break;
				
			}
			else break;
		}
		
		return true;
	}
	
	//same as validMoves() but this method sets the boolean variable checkMateMove
	public boolean validCheckMateMoves(){
		
		
		cells = Board.getCell();
		//goes in to a loop to highlight the positive row
		for(int i=1;i<8;i++){
			
			//if the next cell is not on the same team as current cell, highlight the next cell first
			if(y+i<8 && !cells[x][y].sameTeam(cells[x][y+i])){
				cells[x][y+i].setCheckMateMove(true);
				
				//checks the next next cell if it is on the same team then stops at the next cell(check in advance)( can't highlight the same team)
				if(y+i+1<8 && cells[x][y].sameTeam(cells[x][y+i+1])) break;
				
				//checks if the next cell is on the opposite team, if it is then stop highlighting immediately( since the next cell is already highlighted)
				else if(cells[x][y].oppTeamK(cells[x][y+i])) break;
			}
			
			//needs this if the if statement fails, break the loop right away or else it continues
			else break;
				
		}
		
		//negative rows
		for(int i=1;i<8;i++){
				if(y-i>=0 && !cells[x][y].sameTeam(cells[x][y-i])){
					cells[x][y-i].setCheckMateMove(true);
					
				if(y-i-1>=0 && cells[x][y].sameTeam(cells[x][y-i-1])) break;
				
				else if(cells[x][y].oppTeamK(cells[x][y-i])) break;
				}
				else break;
		}
		//same logic, just the positive columns	
		for(int i=1;i<8;i++){	
			
			if(x+i<8 && !cells[x][y].sameTeam(cells[x+i][y])){
				cells[x+i][y].setCheckMateMove(true);
			
				if(x+i+1<8 && cells[x][y].sameTeam(cells[x+i+1][y])) break;
				
				else if(cells[x][y].oppTeamK(cells[x+i][y])) break;
				
			}
			
			else break;
		}
		//negative columns
		for(int i=1;i<8;i++){	
			
			if(x-i>=0 && !cells[x][y].sameTeam(cells[x-i][y])){
				cells[x-i][y].setCheckMateMove(true);
			
				if(x-i-1>=0 && cells[x][y].sameTeam(cells[x-i-1][y])) break;
				
				else if(cells[x][y].oppTeamK(cells[x-i][y])) break;
				
			}
			else break;
		}
		

		
		return true;
	}
	
}
