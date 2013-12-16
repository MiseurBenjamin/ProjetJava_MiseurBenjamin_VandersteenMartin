package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
	private int x,y,num,life=3;
	private String playerDir = "BAS";
	Image playerCurrentImage;
	ImageIcon playerBas;
	ImageIcon playerGauche;
	ImageIcon playerDroite;
	ImageIcon playerHaut;
	
	public Player(int startX,int startY,int numPlayer){
		x = startX;
		y = startY;
		if((numPlayer==1)||(numPlayer==2)){
			num = numPlayer;
		}
		else num = 2;
		playerBas = new ImageIcon("./img/player"+this.num+".png");
		playerGauche = new ImageIcon("./img/player"+this.num+".png");
		playerDroite = new ImageIcon("./img/player"+this.num+".png");
		playerHaut = new ImageIcon("./img/player"+this.num+".png");		
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void addLife(int life){
		this.life += life;
	}

	public Rectangle getBounds(){
		Rectangle box = new Rectangle(x,y,34,31);
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
	
	public void addY(int add){
		this.y += add;
	}
	
	public void addX(int add){
		this.x += add;
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
	
	public void Move(){ //test avec 5px de déplacement
		if(playerDir == "BAS"){
			this.y+=6;
		}
		if(playerDir == "HAUT"){
			this.y-=6;
		}
		if(playerDir == "GAUCHE"){
			this.x-=6;
		}
		if(playerDir == "DROITE"){
			this.x+=6;
		}		
	}
	
}
