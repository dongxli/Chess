package Board;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ChessPiece.*;

public class PawnPromotionPanel  extends JPanel{

	private JButton rook;
	private JButton knight;
	private JButton bishop;
	private JButton queen;
	private int row,column;
	private Player player;
	
	public PawnPromotionPanel(int row, int column,Player player){
		this.setLayout(new FlowLayout());
		rook = new JButton("Rook");
		rook.setPreferredSize(new Dimension(80,40));
		knight = new JButton("Knight");
		knight.setPreferredSize(new Dimension(80,40));
		bishop = new JButton("Bishop");
		bishop.setPreferredSize(new Dimension(80,40));
		queen = new JButton("Queen");
		queen.setPreferredSize(new Dimension(80,40));
		this.add(rook);
		this.add(knight);
		this.add(bishop);
		this.add(queen);
		this.row=row;
		this.column=column;
		this.player=player;
		PromotionHandler promo = new PromotionHandler();
		rook.addActionListener(promo);
		knight.addActionListener(promo);
		bishop.addActionListener(promo);
		queen.addActionListener(promo);
		
	}
	
	private class PromotionHandler implements ActionListener{

	Cell[][] cells = Board.getCell();
	
		public void actionPerformed(ActionEvent e) {
			Object point = e.getSource();
			
			if(point == rook){
				Rook newRook = new Rook(Type.ROOK,row,column,player);
				cells[row][column].setPiece(newRook);	
			}
			else if(point == knight){
				Knight newKnight = new Knight(Type.KNIGHT,row,column,player);
				cells[row][column].setPiece(newKnight);	
			}
			else if(point == bishop){
				Bishop newBishop = new Bishop(Type.BISHOP,row,column,player);
				cells[row][column].setPiece(newBishop);	
			}
			else if(point ==queen){
				Queen newQueen = new Queen(Type.QUEEN,row,column,player);
				cells[row][column].setPiece(newQueen);	
			}
			
		}

		
	}

}

