package Game;
import Board.*;
import ChessPiece.*;

public class CheckMate {

	private static Cell[][] cells = Board.getCell();
	
	
	public static boolean checkMate(King king){
	
		ChessPiece current;
		Player player =king.getPlayer();
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				
				current =cells[i][j].getC();
				
				//if the current box is not null and it's the enemy piece then see possible moves from them
				if(current!=null && (player!=current.player)){
					if(current instanceof Rook) ((Rook)current).validCheckMateMoves();
					else if(current instanceof Knight) ((Knight)current).validCheckMateMoves();
					else if(current instanceof Bishop) ((Bishop)current).validCheckMateMoves();
					else if(current instanceof Queen) ((Queen)current).validCheckMateMoves();
					//pawn has two scenarios, black or white. Needs to get the moves from the opposite team pieces
					else if(current instanceof Pawn) ((Pawn)current).validCheckMateMoves(king.getOppPlayer());
					//gets valid check mate moves from other king
					else if(current instanceof King) ((King)current).validCheckMateMoves();
					
				}
			}
		}
		int x = king.x;
		int y = king.y;
		int[][] kingCells = {{x-1,x,x+1},{y-1,y,y+1}};
		int numberOfBoxes=9;
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				//check if the numbers are out of index
				if(kingCells[0][i]<8 && kingCells[0][i]>=0 && kingCells[1][j]<8 && kingCells[1][j]>=0 ){
					//if one of the king's box can be reached by other enemy piece, then delete that box
					if(cells[kingCells[0][i]][kingCells[1][j]].getCheckMateMove()==true || cells[x][y].sameTeamK(cells[kingCells[0][i]][kingCells[1][j]])){
						System.out.println(kingCells[0][i]+" "+kingCells[1][j]);
						numberOfBoxes--;
					}
				}
				//it means there are boxes out of index, delete them
				else{
					
					numberOfBoxes--;
				}
			}
		
		}
		System.out.println(cells[kingCells[0][1]][kingCells[1][1]].getCheckMateMove()==true);
		System.out.println(numberOfBoxes);
		if(numberOfBoxes==0) {
			return true;

		}		
		return false;
		
	}
	
	public static void resetCheckMateMoves(){
		
		Cell current;
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				
				current =cells[i][j];
				
				if(current!=null) current.setCheckMateMove(false);
		
			}
		}
	}
	
}