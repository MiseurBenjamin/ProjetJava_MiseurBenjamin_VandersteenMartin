package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fond {
	private int x,y;
	static ImageIcon IIfond = new ImageIcon("./img/fond.png");
	static private Image fond = IIfond.getImage();
	
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
