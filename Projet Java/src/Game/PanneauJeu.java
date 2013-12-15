package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import LevelEditor.level;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel implements KeyListener{
	level niveau = new level();
	static private ArrayList<Block> blocks = new ArrayList<Block>();
	static private ArrayList<Fond> fonds = new ArrayList<Fond>();
	static private ArrayList<Shot> shots = new ArrayList<Shot>();
	Player CurrentPlayer;
	Player player1,player2;
    Block block;
    Fond fond;
    Shot shot;
	
	public PanneauJeu(){
		setFocusable(true);
		addKeyListener(this);
		initArrayList();
		repaint();	
	}
	
	public void initArrayList(){
		int stop1=0,stop2=0,i,j;
		int lvlCopy[][] = niveau.getLvl();
		
		for(i=0;i<20;i++){
			for(j=0;j<15;j++){
				if(lvlCopy[i][j]==1){
					block = new Block(i*34,j*34);
					blocks.add(block);
				}
				else{
					fond = new Fond(i*34,j*34);
					fonds.add(fond);
				}
			}
		}
		while(stop2==0){
			for(i=0;i<20;i++){
				for(j=0;j<15;j++){
					if(this.niveau.getLvl()[i][j]==0){
						this.player2 = new Player(i*34,j*34,2);
						stop2=1;
					}
				}
				
			}
		}
		while(stop1==0){
			for(i=19;i>=0;i--){
				for(j=14;j>=0;j--){
					if(this.niveau.getLvl()[i][j]==0){
						this.player1 = new Player(i*34,j*34,1);
						stop1=1;
					}
				}
				
			}
		}
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for(int i=0;i < blocks.size();i++){
			block = blocks.get(i);
			g2d.drawImage(block.getImage(),block.getX(),block.getY(),null);
		}
		for(int i=0;i < fonds.size();i++){
			fond = fonds.get(i);
			g2d.drawImage(fond.getImage(),fond.getX(),fond.getY(),null);
		}
		for(int i=0;i < shots.size();i++){
			shot = shots.get(i);
			shot.Move();
			g2d.drawImage(shot.getImage(),shot.getX(),shot.getY(),null);
		}
		
		g2d.drawImage(player1.getImage(),player1.getX(),player1.getY(),null);
		g2d.drawImage(player2.getImage(),player2.getX(),player2.getY(),null);
		
		}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_DOWN){
			player1.setPlayerDir("BAS");
			player1.Move();
			CheckCollision();
		}
		else if(key == KeyEvent.VK_UP){
			player1.setPlayerDir("HAUT");
			player1.Move();
			CheckCollision();
		}
		else if(key == KeyEvent.VK_LEFT){
			player1.setPlayerDir("GAUCHE");
			player1.Move();
			CheckCollision();
		}
		else if(key == KeyEvent.VK_RIGHT){
			player1.setPlayerDir("DROITE");
			player1.Move();
			CheckCollision();
		}	
		
		repaint();
	}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if(arg0.getKeyCode() == KeyEvent.VK_SPACE){
				shot = new Shot(player1.getX(),player1.getY(),1,player1.getPlayerDir());
				shots.add(shot);
			}			
		}
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void CheckCollision(){
			Rectangle player1Rec,player2Rec;
			
			player1Rec = player1.getBounds();
			player2Rec = player2.getBounds();
			
			for(int i = 0;i < blocks.size();i++){
				block = (Block)blocks.get(i);
				Rectangle BlockRec = block.getBounds();
				if(player1Rec.intersects(BlockRec)){
					String PlayerDir = player1.getPlayerDir();
					if( PlayerDir=="BAS") player1.addY(-5);
					if( PlayerDir=="HAUT") player1.addY(+5);
					if( PlayerDir=="GAUCHE") player1.addX(+5);
					if( PlayerDir=="DROITE") player1.addX(-5);					
				}
				if(player2Rec.intersects(BlockRec)){
					String PlayerDir = player1.getPlayerDir();
					if( PlayerDir=="BAS") player1.addY(-5);
					if( PlayerDir=="HAUT") player1.addY(+5);
					if( PlayerDir=="GAUCHE") player1.addX(+5);
					if( PlayerDir=="DROITE") player1.addX(-5);					
				}
			}
			if(player1Rec.intersects(player2Rec)){
				String PlayerDir = player1.getPlayerDir();
				if( PlayerDir=="BAS") player1.addY(-5);
				if( PlayerDir=="HAUT") player1.addY(+5);
				if( PlayerDir=="GAUCHE") player1.addX(+5);
				if( PlayerDir=="DROITE") player1.addX(-5);					
			}
		}
	}
