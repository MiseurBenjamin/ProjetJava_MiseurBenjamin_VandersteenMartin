package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block {
	private int x,y;
	Image block;
	
	public Block(int X,int Y){
		this.x = X;
		this.y = Y;
		ImageIcon IIblock = new ImageIcon("img/block.png");
		block = IIblock.getImage();
	}
	
	public Rectangle getBounds(){
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getImage(){
		return block;
	}
}
