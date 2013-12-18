package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Cette classe représente un joueur dans le jeu au travers de ses coordonnées, de sa vie, des ses booléens de mouvement
 * et de sa direction.
 * @author MartinVandersteen
 *
 */

public class Player {
	private int x,y,num,life=3;				//Coordonnées, numéro et vie du joueur
	private String playerDir = "BAS";		//Direction du joueur, BAS par défaut
	Image playerCurrentImage;				//Image actuelle du joueur
	ImageIcon playerBas;					//Image pour les différentes directions ( pas encore utilisées )
	ImageIcon playerGauche;
	ImageIcon playerDroite;
	ImageIcon playerHaut;
	boolean haut=false,bas=false,gauche=false,droite=false;	//Booléens de mouvement du joueur
	
	public Player(int startX,int startY,int numPlayer){			//Constructeur en fonction des coordonnées de départ et du numéro du 
		x = startX;												//joueur pour l'attribution des sprites
		y = startY;
		if((numPlayer==1)||(numPlayer==2)){						//On vérifie que les numéros sont 1 ou 2 (pas nécessaire)
			num = numPlayer;
		}
		else num = 2;
		playerBas = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));		//On charge les images
		playerGauche = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerDroite = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerHaut = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));		
	}
								
	public int getLife() {							//Setters et Getters divers	
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void addLife(int life){
		this.life += life;
	}

	public Rectangle getBounds(){					//Fonction de calcul de la Hitbox des joueurs
		Rectangle box = new Rectangle(x,y,30,26);
		return box;
	}

	public int getX() {								//Setters et Getters divers	
		return x;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		this.y = newY;
	}
	
	public void addY(int add){						//Setters et Getters divers	
		this.y += add;
	}
	
	public void addX(int add){
		this.x += add;
	}	

	public String getPlayerDir() {
		return playerDir;
	}

	public void setPlayerDir(String newPlayerDir) {				//Changement de la direction du joueur
		this.playerDir = newPlayerDir;
	}
	
	public Image getImage(){									//Fonction renvoyant l'image correspondant à la direction du joueur
		if(playerDir == "BAS"){
			playerCurrentImage = playerBas.getImage();
		}
		if(playerDir == "HAUT"){
			playerCurrentImage = playerHaut.getImage();
		}
		if(playerDir == "GAUCHE"){
			playerCurrentImage = playerGauche.getImage();
		}
		if(playerDir == "DROITE"){
			playerCurrentImage = playerDroite.getImage();
		}
		return playerCurrentImage;
		
	}
	
	public void Move(){ //test avec 4px de déplacement			//Fonction de déplacement
		if((playerDir == "BAS")&&(bas==true)){					//Si la direction est à "BAS" et que le booléen correspondant est true
			this.y+=4;											//alors l'on descend le joueur de 4pixels par rafraichissement du Timer
		}
		if((playerDir == "HAUT")&&(haut==true)){
			this.y-=4;
		}
		if((playerDir == "GAUCHE")&&(gauche==true)){
			this.x-=4;
		}
		if((playerDir == "DROITE")&&(droite==true)){
			this.x+=4;
		}		
	}

	public boolean isMoving(){								//Renvoie si le joueur est en mouvement ou pas
		return haut || bas || gauche || droite;
	}


	public void setHaut(boolean haut) {
		this.haut = haut;
	}


	public void setBas(boolean bas) {
		this.bas = bas;
	}

	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}

	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	
}
