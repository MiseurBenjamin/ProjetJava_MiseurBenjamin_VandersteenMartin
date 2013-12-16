package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Shot {
	private int x,y,num;
	private String Dir = "BAS";
	ImageIcon IIshot = new ImageIcon("./img/shot1.png");
	private Image shot = IIshot.getImage();
	
	public Shot(int X,int Y,int Number,String Dir){
		this.x = X;
		this.y = Y;
		this.num = Number;
		this.Dir = Dir;
	}
	
	public void Move(){
		if(Dir=="BAS") this.y+=11;
		if(Dir=="HAUT") this.y-=11;
		if(Dir=="GAUCHE") this.x-=11;
		if(Dir=="DROITE") this.x+=11;
	}
	
	public Rectangle getBounds(){
		Rectangle box = new Rectangle(x,y,16,16);
		return box;
	}
	
	public Image getImage(){
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
