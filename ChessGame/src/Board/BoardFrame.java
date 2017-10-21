package Board;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardFrame extends JFrame{
	public BoardFrame(){
		this.setTitle("Chess");
		JPanel p = new Board();
		this.add(p);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

	}
	
}
