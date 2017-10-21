package ChessPiece;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class ChessPiece {
	
	public int x,y;
	public Type type;
	public Player player;
	public ImageIcon image;
	
	public ChessPiece(Type type,int x, int y,Player player){
		this.x=x;
		this.y=y;
		this.type=type;
		this.player=player;
		image=null;
	}
		
	public void move(int x, int y){
		this.x=x;
		this.y=y;
	}
		
	public Type getType(){
		return type;
	}
		
	public Player getOppPlayer(){
		if(player==Player.BLACK){
			return Player.WHITE;
		}
		else if(player==Player.WHITE){
			return Player.BLACK;
		}
		return null;
	}
		
	public Player getPlayer(){
		return player;
	}
		
	public ImageIcon getImageIcon(){
		return image;
	}
		
	public ImageIcon reSize(String location){
		image = new ImageIcon(this.getClass().getResource(location));
		Image resizedImage = image.getImage();
		resizedImage=resizedImage.getScaledInstance(75,75,java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	
}
