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
	private ImageIcon playerBas;					//Image pour les différentes directions ( pas encore utilisées )
	private ImageIcon playerGauche;
	private ImageIcon playerDroite;
	private ImageIcon playerHaut;
	private boolean haut=false,bas=false,gauche=false,droite=false;	//Booléens de mouvement du joueur
	
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
	 * @param life Le nombre de vies à ajouter ( ou retirer dans le cas d'un nombre négatif )
	 */
	public void addLife(int life){
		this.life += life;
	}

	/**
	 * Fonction de calcul de la Hitbox des joueurs
	 * @return Rectangle Représentant les limites du joueur pour les collisions
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
	 * @param add La valeur à ajouter à la position verticale du joueur
	 * @return void
	 */
	public void addY(int add){						//Setters et Getters divers	
		this.y += add;
	}
	
	/**
	 * @param add La valeur à ajouter à la position horizontale du joueur
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
	 * Fonction renvoyant l'image correspondant à la direction du joueur
	 * @return Image L'image du joueur.
	 */
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
	
	/**
	 * Fonction de déplacement
	 * Exemple de fonctionnement : Si la direction est à "BAS" et que le booléen correspondant est true
	 * alors l'on descend le joueur de 4pixels par rafraichissement du Timer
	 * @return void
	 */
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

	/**
	 * Renvoie si le joueur est en mouvement ou pas
	 * @return boolean Etat de déplacement du joueur ( en mouvement ou pas )
	 */
	public boolean isMoving(){								//Renvoie si le joueur est en mouvement ou pas
		return haut || bas || gauche || droite;
	}

	/**
	 * @param haut booléen de déplacement vers le haut
	 * @return void
	 */
	public void setHaut(boolean haut) {
		this.haut = haut;
	}

	/**
	 * @param bas booléen de déplacement vers le bas
	 * @return void
	 */
	public void setBas(boolean bas) {
		this.bas = bas;
	}

	/**
	 * @param gauche booléen de déplacement vers la gauche
	 * @return void
	 */
	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}

	/**
	 * @param droite booléen de déplacement vers la droite
	 * @return void
	 */
	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	
}
