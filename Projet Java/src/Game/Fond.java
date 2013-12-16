package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fond {
	private int x,y;
	ImageIcon IIfond = new ImageIcon(getClass().getResource("/img/fond.png"));
	private Image fond = IIfond.getImage();
	
	public Fond(int X,int Y){
		this.x = X;
		this.y = Y;
	}
	
	public Image getImage(){
		return fond;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
