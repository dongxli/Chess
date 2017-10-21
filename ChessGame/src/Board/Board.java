package Board;

import java.awt.*;
import javax.swing.*;
import ChessPiece.*;

public class Board extends JPanel{
	
	public static Cell[][] cells;
	
	public Board(){
		cells = new Cell[8][8];
		this.setLayout(new GridLayout(8,8));
		setUpCells();
		setUpPieces();
		initializePieces();
	}
	
	public static Cell[][] getCell(){
		return cells;
	}
	
	public static void reColorCells(){
		for(int i =0;i<8;i++){
			for(int j=0;j<8;j++){
				if((i+j)%2!=0){
					cells[i][j].setColor(true);
				}
				else
					cells[i][j].setColor(false);
				cells[i][j].setValidMove(false);
			}
		}
	}
	
	
	public void setUpCells(){
		CellEvents cellEvents = new CellEvents();
		for(int i =0;i<8;i++){
			for(int j=0;j<8;j++){
				cells[i][j]=new Cell();
				if((i+j)%2!=0){
					cells[i][j].setColor(true);
				}
				else
					cells[i][j].setColor(false);
				
				this.add(cells[i][j]);
				
				cells[i][j].addActionListener(cellEvents);
			}
		}
		
	}
	
	
	public static Rook rookb1,rookb2,rookw1,rookw2;
	public static Knight knightb1,knightb2,knightw1,knightw2;
	public static Bishop bishopb1,bishopb2,bishopw1,bishopw2;
	public static Queen queenb,queenw;
	public static King kingb,kingw;
	public static Pawn pawnb1,pawnb2,pawnb3,pawnb4,pawnb5,pawnb6,pawnb7,pawnb8;
	public static Pawn pawnw1,pawnw2,pawnw3,pawnw4,pawnw5,pawnw6,pawnw7,pawnw8;

	public void setUpPieces(){
		rookb1 = new Rook(Type.ROOK,0,0,Player.BLACK);
		rookb2 = new Rook(Type.ROOK,0,7,Player.BLACK);
		knightb1 = new Knight(Type.KNIGHT,0,1,Player.BLACK);
		knightb2 = new Knight(Type.KNIGHT,0,6,Player.BLACK);
		bishopb1 = new Bishop(Type.BISHOP,0,2,Player.BLACK);
		bishopb2 = new Bishop(Type.BISHOP,0,5,Player.BLACK);
		queenb = new Queen(Type.QUEEN,0,4,Player.BLACK);
		kingb = new King(Type.KING,0,3,Player.BLACK);
		pawnb1 = new Pawn(Type.PAWN,1,0,Player.BLACK);
		pawnb2 = new Pawn(Type.PAWN,1,1,Player.BLACK);
		pawnb3 = new Pawn(Type.PAWN,1,2,Player.BLACK);
		pawnb4 = new Pawn(Type.PAWN,1,3,Player.BLACK);
		pawnb5 = new Pawn(Type.PAWN,1,4,Player.BLACK);
		pawnb6 = new Pawn(Type.PAWN,1,5,Player.BLACK);
		pawnb7 = new Pawn(Type.PAWN,1,6,Player.BLACK);
		pawnb8 = new Pawn(Type.PAWN,1,7,Player.BLACK);
		rookw1 = new Rook(Type.ROOK,7,0,Player.WHITE);
		rookw2 = new Rook(Type.ROOK,7,7,Player.WHITE);
		knightw1 = new Knight(Type.KNIGHT,7,1,Player.WHITE);
		knightw2 = new Knight(Type.KNIGHT,7,6,Player.WHITE);
		bishopw1 = new Bishop(Type.BISHOP,7,2,Player.WHITE);
		bishopw2 = new Bishop(Type.BISHOP,7,5,Player.WHITE);
		queenw = new Queen(Type.QUEEN,7,3,Player.WHITE);
		kingw = new King(Type.KING,7,4,Player.WHITE);
		pawnw1 = new Pawn(Type.PAWN,6,0,Player.WHITE);
		pawnw2 = new Pawn(Type.PAWN,6,1,Player.WHITE);
		pawnw3 = new Pawn(Type.PAWN,6,2,Player.WHITE);
		pawnw4 = new Pawn(Type.PAWN,6,3,Player.WHITE);
		pawnw5 = new Pawn(Type.PAWN,6,4,Player.WHITE);
		pawnw6 = new Pawn(Type.PAWN,6,5,Player.WHITE);
		pawnw7 = new Pawn(Type.PAWN,6,6,Player.WHITE);
		pawnw8 = new Pawn(Type.PAWN,6,7,Player.WHITE);
		if(pawnw1.player!=pawnb1.player){
			System.out.println("hehexd");
		}
		
	}
	
	public void initializePieces(){

		ChessPiece[] pieces = {rookb1,rookb2,rookw1,rookw2,knightb1,knightb2,knightw1,knightw2,bishopb1,bishopb2,bishopw1,bishopw2,queenb,queenw,
				kingb,kingw,pawnb1,pawnb2,pawnb3,pawnb4,pawnb5,pawnb6,pawnb7,pawnb8,pawnw1,pawnw2,pawnw3,pawnw4,pawnw5,pawnw6,pawnw7,pawnw8};
		
		for(int i=0;i<32;i++){
			ChessPiece temp = pieces[i];
			cells[temp.x][temp.y].setPiece(pieces[i]);
		}
//		cells[rookb1.x][rookb1.y].setPiece(rookb1);
//		cells[rookb2.x][rookb2.y].setPiece(rookb2);
//		cells[4][4].setPiece(new Bishop(Type.BISHOP,4,4,Player.BLACK));
//		cells[knightb1.x][knightb1.y].setPiece(knightb1);
//		cells[3][3].setPiece(new Knight(Type.KNIGHT,3,3,Player.BLACK));
//		cells[kingw.x][kingw.y].setPiece(kingw);
//		
//		cells[kingb.x][kingb.y].setPiece(kingb);
//		cells[pawnw1.x][pawnw1.y].setPiece(pawnw1);
//		cells[pawnw3.x][pawnw3.y].setPiece(pawnw3);
//		cells[pawnw4.x][pawnw4.y].setPiece(pawnw4);
//		cells[pawnw5.x][pawnw5.y].setPiece(pawnw5);
//		cells[pawnw6.x][pawnw6.y].setPiece(pawnw6);
//		cells[pawnw7.x][pawnw7.y].setPiece(pawnw7);
//		cells[rookb1.x][rookb1.y].setPiece(rookb1);
//		cells[rookb2.x][rookb2.y].setPiece(rookb2);
//		cells[rookw1.x][rookw1.y].setPiece(rookw1);
//		cells[rookw2.x][rookw2.y].setPiece(rookw2);
		
	}	
	
	
}
