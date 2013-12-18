package Game;

import java.awt.Image;

/**
 * Cette classe repr�sente un bloc de pierre dans le jeu. Elle est caract�ris�e par ses coordonn�es et son image.
 */

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block {
	private int x,y;							//Coordonn�es
	ImageIcon IIblock = new ImageIcon(getClass().getResource("/img/block.png"));	//Image
	private Image block = IIblock.getImage();
	
	public Block(int X,int Y){					//Constructeur en fonction des coordonn�es
		this.x = X;
		this.y = Y;
	}
	
	public Rectangle getBounds(){				//Calcul de Hitbox du bloc
		Rectangle box = new Rectangle(x,y,33,33);
		return box;
	}

	public int getX() {			
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getImage(){					//Renvoie l'image du bloc
		return block;
	}
}
