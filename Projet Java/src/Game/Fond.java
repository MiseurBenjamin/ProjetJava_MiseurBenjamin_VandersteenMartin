package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Cette classe repr�sente un bloc de fond dans le jeu.
 * Elle est caract�ris�e uniquement par ses coordonn�es.
 * @author MartinVandersteen
 *
 */

public class Fond {				
	private int x,y;					//Coordonn�es
	ImageIcon IIfond = new ImageIcon(getClass().getResource("/img/fond.png"));		//Image
	private Image fond = IIfond.getImage();
	
	public Fond(int X,int Y){				//Constructeur en fonction des coordonn�es pass�es en param�tre
		this.x = X;
		this.y = Y;
	}
	
	public Image getImage(){				//Renvoie l'image de fond
		return fond;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
