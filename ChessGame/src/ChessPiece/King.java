package ChessPiece;

import Board.Board;
import Board.Cell;


public class King extends ChessPiece{
	
	private Cell[][] cells;
	public boolean moved = false;
	
	public King(Type king, int x, int y,Player color){
		super(king,x,y,color);
		if(color==Player.BLACK){
			image = reSize("/kingb.png");
		}
		else if(color==Player.WHITE) 
			image = reSize("/kingw.png");
	}
	
	public boolean validMoves(){
		
		cells = Board.getCell();
		//the 9 cells that king can move to
		int[][] kingCells = {{x-1,x,x+1},{y-1,y,y+1}};
		
		cells[x][y].setValidMove(true);
		
		//highlights the cells
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				//check if the numbers are out of index
				if(kingCells[0][i]<8 && kingCells[0][i]>=0 && kingCells[1][j]<8 && kingCells[1][j]>=0)
					//checks if it is the same team(no highlight)
					if(cells[kingCells[0][i]][kingCells[1][j]].getCheckMateMove()==false && !cells[x][y].sameTeam(cells[kingCells[0][i]][kingCells[1][j]])){
						cells[kingCells[0][i]][kingCells[1][j]].setValidMove(true);
					}
				}
		}
		
		return true;
	}

	public boolean validCheckMateMoves(){
		
		cells = Board.getCell();
		//the 9 cells that king can move to
		int[][] kingCells = {{x-1,x,x+1},{y-1,y,y+1}};
		
		//highlights the cells
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				//check if the numbers are out of index
				if(kingCells[0][i]<8 && kingCells[0][i]>=0 && kingCells[1][j]<8 && kingCells[1][j]>=0)
					//checks if it is the same team(no highlight) && not the opposite team(excluding k)
					if(cells[kingCells[0][i]][kingCells[1][j]].getCheckMateMove()==false && !cells[x][y].sameTeam(cells[kingCells[0][i]][kingCells[1][j]])
					&& !cells[x][y].oppTeamK(cells[kingCells[0][i]][kingCells[1][j]])){
						cells[kingCells[0][i]][kingCells[1][j]].setCheckMateMove(true);
					}
				}
		}
		
		return true;
	}
	
	public void validCastle(Player player){
		
		//checks the black rooks
		if(player==Player.BLACK){
			
			//check the first black rook
			ChessPiece temp= cells[0][0].getC();
			//this piece can't be null
			if(temp!=null && temp instanceof Rook){
				if(((Rook)temp).moved==false){
					if(cells[0][1].getC()==null && cells[0][2].getC()==null && cells[0][0].getCheckMateMove()==false){
						cells[0][0].setValidMove(true);
					}
				}
			}
			temp = cells[0][7].getC();
			if(temp!=null && temp instanceof Rook){
				
				if(((Rook)temp).moved==false){
					if(cells[0][4].getC()==null && cells[0][5].getC()==null&& cells[0][6].getC()==null && cells[0][7].getCheckMateMove()==false){
						cells[0][7].setValidMove(true);
					}
				}
			}
		}
		
		else{
			ChessPiece temp= cells[7][0].getC();
			if(temp!=null && temp instanceof Rook){
				if(((Rook)temp).moved==false){
					if(cells[7][1].getC()==null && cells[7][2].getC()==null && cells[7][3].getC()==null && cells[7][0].getCheckMateMove()==false){
						cells[7][0].setValidMove(true);
					}
				}
			}
			temp = cells[7][7].getC();
			if(temp!=null && temp instanceof Rook){
				if(((Rook)temp).moved==false){
					if(cells[7][5].getC()==null && cells[7][6].getC()==null &&cells[7][7].getCheckMateMove()==false ){
						cells[7][7].setValidMove(true);
					}
				}
			}
		}
	}
	
	
	
}
