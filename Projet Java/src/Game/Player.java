package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
	private int x,y;
	private String playerDir = "BAS";
	Image playerCurrentImage;
	ImageIcon playerBas = new ImageIcon("img/player1.png");
	ImageIcon playerGauche = new ImageIcon("img/player1.png");
	ImageIcon playerDroite = new ImageIcon("img/player1.png");
	ImageIcon playerHaut = new ImageIcon("img/player1.png");
	
	public Player(int startX,int startY){
		x = startX;
		y = startY;
	}
	
	public Rectangle getBounds(){
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
	}

	public int getX() {
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

	public String getPlayerDir() {
		return playerDir;
	}

	public void setPlayerDir(String newPlayerDir) {
		this.playerDir = newPlayerDir;
	}
	
	public Image getImage(){
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
	
	public void Move(){
		if(playerDir == "BAS"){
			this.y+=34;
		}
		if(playerDir == "HAUT"){
			this.y-=34;
		}
		if(playerDir == "GAUCHE"){
			this.x-=34;
		}
		if(playerDir == "DROITE"){
			this.x+=34;
		}		
	}
	
}
