package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Shot repr�sente un tir dans le jeu. Elle est caract�ris�e par ses coordonn�es et le num�ro du joueur � qui elle appartient
 * @author MartinVandersteen
 *
 */

public class Shot {
	private int x,y,num;					//Coordonn�es et num�ro du joueur propri�taire
	private String Dir = "BAS";				//Contient la direction dans laquelle �tait le joueur quand il a tir�
	ImageIcon IIshot = new ImageIcon(getClass().getResource("/img/shot1.png"));		//Importation du skin du tir
	private Image shot = IIshot.getImage();
	
	public Shot(int X,int Y,int Number,String Dir){		//Constructeur en fonction des coordonn�es du joueur, de son num�ro et de
		this.x = X;										//sa direction
		this.y = Y;
		this.num = Number;
		this.Dir = Dir;
	}
	
	public void Move(){								//Mouvement du tir, 11px par rafraichissement
		if(Dir=="BAS") this.y+=11;
		if(Dir=="HAUT") this.y-=11;
		if(Dir=="GAUCHE") this.x-=11;
		if(Dir=="DROITE") this.x+=11;
	}
	
	public Rectangle getBounds(){					//M�thode de calcul de Hitbox du tir
		Rectangle box = new Rectangle(x,y,16,16);
		return box;
	}
	
	public Image getImage(){						//Renvoie l'image du tir
		return shot;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNum() {
		return num;
	}
}
