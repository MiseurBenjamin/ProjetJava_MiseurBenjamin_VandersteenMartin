package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Cette classe représente un bloc de fond dans le jeu.
 * Elle est caractérisée uniquement par ses coordonnées.
 * @author MartinVandersteen
 *
 */

public class Fond {				
	private int x,y;					//Coordonnées
	ImageIcon IIfond = new ImageIcon(getClass().getResource("/img/fond.png"));		//Image
	private Image fond = IIfond.getImage();
	
	public Fond(int X,int Y){				//Constructeur en fonction des coordonnées passées en paramètre
		this.x = X;
		this.y = Y;
	}
	
	/**
	 * Renvoie l'image de fond
	 * @return Image
	 */
	public Image getImage(){				//Renvoie l'image de fond
		return fond;
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
}
