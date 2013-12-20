package Game;

import java.awt.Image;


/**
 * Cette classe représente un bloc de pierre dans le jeu. Elle est caractérisée par ses coordonnées et son image.
 */

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block {
	private int x,y;							//Coordonnées
	ImageIcon IIblock = new ImageIcon(getClass().getResource("/img/block.png"));	//Image
	private Image block = IIblock.getImage();
	
	public Block(int X,int Y){					//Constructeur en fonction des coordonnées
		this.x = X;
		this.y = Y;
	}
	
	/**
	 * Calcul de Hitbox du bloc
	 * @return Rectangle
	 */
	public Rectangle getBounds(){				//Calcul de Hitbox du bloc
		Rectangle box = new Rectangle(x,y,33,33);
		return box;
	}

	/**
	 * 
	 * @return int
	 */
	public int getX() {			
		return x;
	}

	/**
	 * 
	 * @return int
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Renvoie l'image du bloc
	 * @return Image
	 */
	public Image getImage(){					//Renvoie l'image du bloc
		return block;
	}
}
