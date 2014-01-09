package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Shot représente un tir dans le jeu. Elle est caractérisée par ses coordonnées et le numéro du joueur à qui elle appartient
 * @author MartinVandersteen
 *
 */

public class Shot {
	private int x,y,num;					//Coordonnées et numéro du joueur propriétaire
	private String Dir = "BAS";				//Contient la direction dans laquelle était le joueur quand il a tiré
	ImageIcon IIshot = new ImageIcon(getClass().getResource("/img/shot1.png"));		//Importation du skin du tir
	private Image shot = IIshot.getImage();
	
	public Shot(int X,int Y,int Number,String Dir){		//Constructeur en fonction des coordonnées du joueur, de son numéro et de
		this.x = X;										//sa direction
		this.y = Y;
		this.num = Number;
		this.Dir = Dir;
	}
	
	/**
	 * Mouvement du tir, 11px par rafraichissement
	 * @return void
	 */
	public void Move(){								//Mouvement du tir, 11px par rafraichissement
		if(Dir=="BAS") this.y+=11;
		if(Dir=="HAUT") this.y-=11;
		if(Dir=="GAUCHE") this.x-=11;
		if(Dir=="DROITE") this.x+=11;
	}
	
	/**
	 * Méthode de calcul de Hitbox du tir
	 * @return Rectangle Les limites du tir
	 */
	public Rectangle getBounds(){					//Méthode de calcul de Hitbox du tir
		Rectangle box = new Rectangle(x,y,16,16);
		return box;
	}
	
	/**
	 * Renvoie l'image du tir
	 * @return Image L'icone du tir
	 */
	public Image getImage(){						//Renvoie l'image du tir
		return shot;
	}
	
	/**
	 * 
	 * @return int Position horizontale du tir
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return int Position verticale du tir
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 
	 * @return int Le numero du joueur qui a tiré le tir
	 */
	public int getNum() {
		return num;
	}
}
