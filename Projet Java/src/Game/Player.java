package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Cette classe repr�sente un joueur dans le jeu au travers de ses coordonn�es, de sa vie, des ses bool�ens de mouvement
 * et de sa direction.
 * @author MartinVandersteen
 *
 */

public class Player {
	private int x,y,num,life=3;				//Coordonn�es, num�ro et vie du joueur
	private String playerDir = "BAS";		//Direction du joueur, BAS par d�faut
	Image playerCurrentImage;				//Image actuelle du joueur
	private ImageIcon playerBas;					//Image pour les diff�rentes directions ( pas encore utilis�es )
	private ImageIcon playerGauche;
	private ImageIcon playerDroite;
	private ImageIcon playerHaut;
	private boolean haut=false,bas=false,gauche=false,droite=false;	//Bool�ens de mouvement du joueur
	
	public Player(int startX,int startY,int numPlayer){			//Constructeur en fonction des coordonn�es de d�part et du num�ro du 
		x = startX;												//joueur pour l'attribution des sprites
		y = startY;
		if((numPlayer==1)||(numPlayer==2)){						//On v�rifie que les num�ros sont 1 ou 2 (pas n�cessaire)
			num = numPlayer;
		}
		else num = 2;
		playerBas = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));		//On charge les images
		playerGauche = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerDroite = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerHaut = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));		
	}
				
	/**
	 * 
	 * @return int Le nombre de vie restantes du joueur
	 */
	public int getLife() {							//Setters et Getters divers	
		return life;
	}
	/**
	 * @param life La nouvelle valeur de la vie du joueur ( > 0 )
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
	/**
	 * @param life Le nombre de vies � ajouter ( ou retirer dans le cas d'un nombre n�gatif )
	 */
	public void addLife(int life){
		this.life += life;
	}

	/**
	 * Fonction de calcul de la Hitbox des joueurs
	 * @return Rectangle Repr�sentant les limites du joueur pour les collisions
	 */
	public Rectangle getBounds(){					//Fonction de calcul de la Hitbox des joueurs
		Rectangle box = new Rectangle(x,y,30,26);
		return box;
	}

	/**
	 * 
	 * @return int La position horizontale du joueur
	 */
	public int getX() {								//Setters et Getters divers	
		return x;
	}

	/**
	 * @param newX Nouvelle position horizontale du joueur
	 * @return void
	 */
	public void setX(int newX) {
		this.x = newX;
	}

	/**
	 * 
	 * @return int La position verticale du joueur
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param newY La nouvelle position verticale du joueur
	 * @return void
	 */
	public void setY(int newY) {
		this.y = newY;
	}
	
	/**
	 * @param add La valeur � ajouter � la position verticale du joueur
	 * @return void
	 */
	public void addY(int add){						//Setters et Getters divers	
		this.y += add;
	}
	
	/**
	 * @param add La valeur � ajouter � la position horizontale du joueur
	 * @return void
	 */
	public void addX(int add){
		this.x += add;
	}	

	/**
	 * Renvoie la direction du joueur.
	 * @return String Le direction actuelle du joueur
	 */
	public String getPlayerDir() {
		return playerDir;
	}

	/**
	 * Changement de la direction du joueur
	 * @param newPlayerDir Nouvelle direction du joueur.
	 */
	public void setPlayerDir(String newPlayerDir) {				//Changement de la direction du joueur
		this.playerDir = newPlayerDir;
	}
	
	/**
	 * Fonction renvoyant l'image correspondant � la direction du joueur
	 * @return Image L'image du joueur.
	 */
	public Image getImage(){									//Fonction renvoyant l'image correspondant � la direction du joueur
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
	
	/**
	 * Fonction de d�placement
	 * Exemple de fonctionnement : Si la direction est � "BAS" et que le bool�en correspondant est true
	 * alors l'on descend le joueur de 4pixels par rafraichissement du Timer
	 * @return void
	 */
	public void Move(){ //test avec 4px de d�placement			//Fonction de d�placement
		if((playerDir == "BAS")&&(bas==true)){					//Si la direction est � "BAS" et que le bool�en correspondant est true
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

	/**
	 * Renvoie si le joueur est en mouvement ou pas
	 * @return boolean Etat de d�placement du joueur ( en mouvement ou pas )
	 */
	public boolean isMoving(){								//Renvoie si le joueur est en mouvement ou pas
		return haut || bas || gauche || droite;
	}

	/**
	 * @param haut bool�en de d�placement vers le haut
	 * @return void
	 */
	public void setHaut(boolean haut) {
		this.haut = haut;
	}

	/**
	 * @param bas bool�en de d�placement vers le bas
	 * @return void
	 */
	public void setBas(boolean bas) {
		this.bas = bas;
	}

	/**
	 * @param gauche bool�en de d�placement vers la gauche
	 * @return void
	 */
	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}

	/**
	 * @param droite bool�en de d�placement vers la droite
	 * @return void
	 */
	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	
}
