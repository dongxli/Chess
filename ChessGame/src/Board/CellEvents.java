package Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ChessPiece.*;
import Game.CheckMate;

public class CellEvents implements ActionListener{
	
	private Cell[][] cells=Board.getCell();
	boolean readyToMove=false;
	private Cell previous = null;
	private Player previousPlayer=null;
	
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				Cell temp = cells[i][j];
				if(source ==temp){
					ChessPiece piece = temp.getC();
					
					//cells are highlighted, ready to move
					if(readyToMove ==true){
						
						readyToMove=false;
						//if the cell is highlighted
						if(cells[i][j].getValidMove()==true){
							
							//previous piece
							ChessPiece previousPiece = previous.getC();
							//if the previous piece was not null and it is not the same piece
							//then move the previous piece to the current cell
							//set the previous player with the chess piece just moved
							//reset the cell to null
							if(previousPiece!=null && previousPiece!=temp.getC()){
								//check if it's castling
								if(piece!=null && previousPiece.player==piece.player){
									piece.move(previousPiece.x, previousPiece.y);
									previousPiece.move(i, j);
									cells[i][j].setPiece(previousPiece);
									previous.setPiece(piece);
									previousPlayer=previous.getC().player;
								}
								//it's not castling, move to other cell(either null or opposite team)
								else{
									previousPiece.move(i, j);
									cells[i][j].setPiece(previousPiece);
									previousPlayer=previous.getC().player;
									previous.setPiece(null);
									previous=null;
								}
								//pawn promotion
								if(previousPiece instanceof Pawn ){
									pawnPromo(i,j,previousPlayer);
								}
								else if(previousPiece instanceof King){
									((King)previousPiece).moved= true;
								}
								else if  (previousPiece instanceof Rook){
									((Rook)previousPiece).moved=true;
								}
							}
						
						}

						//recolor the board and set valid moves(highlighted) to null
						Board.reColorCells();
					}
					
					//compares the player now and previous if it's same then do not do anything
					else if(piece instanceof Rook &&previousPlayer!=piece.player){
						
						System.out.println("You clicked on rook!");
						readyToMove=((Rook) piece).validMoves();
						previous = cells[i][j];
					}
					else if(piece instanceof Knight &&previousPlayer!=piece.player){
						System.out.println("You clicked on knight!");
						readyToMove=((Knight) piece).validMoves();
						previous = cells[i][j];
					}
					else if(piece instanceof Bishop &&previousPlayer!=piece.player){
						System.out.println("You clicked on bishop!");
						readyToMove=((Bishop)piece).validMoves();
						previous =cells[i][j];
					}
					else if(piece instanceof Queen &&previousPlayer!=piece.player){
						System.out.println("You clicked on queen!");
						readyToMove=((Queen) piece).validMoves();
						previous = cells[i][j];
					}
					else if(piece instanceof Pawn &&previousPlayer!=piece.player){
						
						System.out.println("You clicked on pawn!");
						readyToMove=((Pawn) piece).validMoves();
						previous = cells[i][j];
					}
					
					else if(piece instanceof King && piece.player==Player.WHITE && previousPlayer!=piece.player){
						CheckMate.checkMate(Board.kingw);
						System.out.println("You cl");
						King king = (King)piece;
						readyToMove= king.validMoves();
						if(king.moved==false){
							king.validCastle(Player.WHITE);
						}
						previous = cells[i][j];
						CheckMate.resetCheckMateMoves();
						
						}
					
					else if(piece instanceof King && piece.player==Player.BLACK && previousPlayer!=piece.player){
						CheckMate.checkMate(Board.kingb);
						System.out.println("You clicked on king!");
						King king = (King)piece;
						readyToMove= king.validMoves();
						if(king.moved==false){
							king.validCastle(Player.BLACK);
						}
						previous = cells[i][j];
						CheckMate.resetCheckMateMoves();
					}
					if(CheckMate.checkMate(Board.kingb)){
						JOptionPane.showMessageDialog(null, "White Side Wins!");
						return;
					}
					else CheckMate.resetCheckMateMoves();
					if(CheckMate.checkMate(Board.kingw)){
						JOptionPane.showMessageDialog(null, "Black Side Wins!");
						return;
					}
					else CheckMate.resetCheckMateMoves();
					
				}
			}
		}
		
		
	}
	
	public void pawnPromo(int row, int column,Player player){
			if(row==0 || row==7){
				PawnPromotionFrame pawnPromo = new PawnPromotionFrame(row,column,player);
			}
	}
}
