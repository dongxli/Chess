package Board;
import ChessPiece.*;
import java.awt.Color;
import javax.swing.JButton;

public class Cell extends JButton {

	private ChessPiece m_c;
	private boolean validMove;
	private boolean checkMateMove;
	
	public Cell(){
		m_c=null;
		validMove=false;
		checkMateMove=false;
	}
	
	public void setValidMove(boolean b){
		if(b)this.setBackground(Color.orange);
		validMove=b;
	}
	
	public boolean getValidMove(){
		return validMove;
	}
	
	public void setCheckMateMove(boolean b){
		checkMateMove=b;;
	}
	
	public boolean getCheckMateMove(){
		return checkMateMove;
	}
	
	
	public void setPiece(ChessPiece c){
			if( c==null){
				m_c=null;
				this.setIcon(null);
			}
			else{
				m_c=c;
				this.setIcon(c.getImageIcon());
			}
			
	}
	
	public ChessPiece getC(){
		return m_c;
	}
	
	public boolean sameTeam(Cell c){
		if(c.m_c==null) return false;
		if(m_c.player==c.m_c.player)return true;
		else return false;
	}
	public boolean sameTeamK(Cell c){
		if(c.m_c==null || c.m_c.type==Type.KING) return false;
		else if(m_c.getPlayer()==c.m_c.player){
			return true;
		}
		else return false;
	}
	
	public boolean oppTeam(Cell c){
		if(c.m_c==null || m_c==null) return false;
		else if(m_c.getOppPlayer()==c.m_c.player){
			return true;
		}
		else return false;
	}
	
	public boolean oppTeamK(Cell c){
		if(c.m_c==null || c.m_c.type==Type.KING) return false;
		else if(m_c.getOppPlayer()==c.m_c.player){
			return true;
		}
		else return false;
	}
	
	public void setColor(boolean color){
		if(color){
			this.setBackground(Color.DARK_GRAY);
		}
		else if(!color){
			this.setBackground(Color.WHITE);
		}
	}
	
}
