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
	boolean haut=false,bas=false,gauche=false,droite=false;
	
	public Player(int startX,int startY,int numPlayer){
		x = startX;
		y = startY;
		if((numPlayer==1)||(numPlayer==2)){
			num = numPlayer;
		}
		else num = 2;
		playerBas = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerGauche = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerDroite = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));
		playerHaut = new ImageIcon(getClass().getResource("/img/player"+this.num+".png"));		
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
		Rectangle box = new Rectangle(x,y,30,26);
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
	
	public void Move(){ //test avec 4px de déplacement
		if((playerDir == "BAS")&&(bas==true)){
			this.y+=4;
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

	public boolean isMoving(){
		return haut || bas || gauche || droite;
	}
	
	public boolean isHaut() {
		return haut;
	}

	public void setHaut(boolean haut) {
		this.haut = haut;
	}

	public boolean isBas() {
		return bas;
	}

	public void setBas(boolean bas) {
		this.bas = bas;
	}

	public boolean isGauche() {
		return gauche;
	}

	public void setGauche(boolean gauche) {
		this.gauche = gauche;
	}

	public boolean isDroite() {
		return droite;
	}

	public void setDroite(boolean droite) {
		this.droite = droite;
	}
	
}
