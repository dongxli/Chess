package Board;

import javax.swing.JFrame;
import javax.swing.JPanel;
import ChessPiece.*;

public class PawnPromotionFrame extends JFrame{

	
	public PawnPromotionFrame(int row, int column,Player player){
		JPanel p = new PawnPromotionPanel(row,column,player);
		this.setTitle("Pawn Promotion");
		this.add(p);
		this.setVisible(true);
		this.setSize(400,90);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
}
