package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import LevelEditor.level;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel implements KeyListener, ActionListener{
	level niveau = new level();
	private final Timer timer = new Timer(25,this);
	static private ArrayList<Block> blocks = new ArrayList<Block>();
	static private ArrayList<Fond> fonds = new ArrayList<Fond>();
	static private ArrayList<Shot> shots = new ArrayList<Shot>();
	Player CurrentPlayer;
	Player player1,player2;
	int p1Points,p2Points=0;
    Block block;
    Fond fond;
    Shot shot;
	
	public PanneauJeu(){
		setFocusable(true);
		addKeyListener(this);
		initArrayList();
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
		player1.setLife(3);
		player2.setLife(3);
		repaint();
		timer.start();
	}
	
	public void paint(Graphics g){ 
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("SansSerif", Font.BOLD, 20));
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
		g.drawString("P1: "+p1Points+" Points",10,500);
		g.drawString("P2: "+p2Points+" Points",525,500);
		
		
		if(player2.getLife()<=0){
			p1Points+=1;
			timer.stop();
			initArrayList();
		}
		if(player1.getLife()<=0){
			p2Points+=1;
			timer.stop();
			initArrayList();
		}
		
		}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_DOWN){
			player1.setPlayerDir("BAS");
			player1.setBas(true);
		}
		else if(key == KeyEvent.VK_UP){
			player1.setPlayerDir("HAUT");
			player1.setHaut(true);
		}
		else if(key == KeyEvent.VK_LEFT){
			player1.setPlayerDir("GAUCHE");
			player1.setGauche(true);
		}
		else if(key == KeyEvent.VK_RIGHT){
			player1.setPlayerDir("DROITE");
			player1.setDroite(true);
		}
		else if(key == KeyEvent.VK_Z){
			player2.setPlayerDir("HAUT");
			player2.setHaut(true);
		}
		else if(key == KeyEvent.VK_Q){
			player2.setPlayerDir("GAUCHE");
			player2.setGauche(true);
		}
		else if(key == KeyEvent.VK_S){
			player2.setPlayerDir("BAS");
			player2.setBas(true);
		}
		else if(key == KeyEvent.VK_D){
			player2.setPlayerDir("DROITE");
			player2.setDroite(true);
		}
		
		repaint();
	}

		@Override
		public void keyReleased(KeyEvent arg0) {
			int key = arg0.getKeyCode();
			if(key == KeyEvent.VK_SPACE){
				shot = new Shot(player1.getX(),player1.getY(),1,player1.getPlayerDir());
				shots.add(shot);
			}	
			else if(key == KeyEvent.VK_SHIFT){
				shot = new Shot(player2.getX(),player2.getY(),2,player2.getPlayerDir());
				shots.add(shot);
			}	
			else if(key == KeyEvent.VK_DOWN){
				player1.setPlayerDir("BAS");
				player1.setBas(false);
			}
			else if(key == KeyEvent.VK_UP){
				player1.setPlayerDir("HAUT");
				player1.setHaut(false);
			}
			else if(key == KeyEvent.VK_LEFT){
				player1.setPlayerDir("GAUCHE");
				player1.setGauche(false);
			}
			else if(key == KeyEvent.VK_RIGHT){
				player1.setPlayerDir("DROITE");
				player1.setDroite(false);
			}
			else if(key == KeyEvent.VK_Z){
				player2.setPlayerDir("HAUT");
				player2.setHaut(false);
			}
			else if(key == KeyEvent.VK_Q){
				player2.setPlayerDir("GAUCHE");
				player2.setGauche(false);
			}
			else if(key == KeyEvent.VK_S){
				player2.setPlayerDir("BAS");
				player2.setBas(false);
			}
			else if(key == KeyEvent.VK_D){
				player2.setPlayerDir("DROITE");
				player2.setDroite(false);
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
					if( PlayerDir=="BAS") player1.addY(-4);
					if( PlayerDir=="HAUT") player1.addY(+4);
					if( PlayerDir=="GAUCHE") player1.addX(+4);
					if( PlayerDir=="DROITE") player1.addX(-4);					
				}
				if(player2Rec.intersects(BlockRec)){
					String PlayerDir = player2.getPlayerDir();
					if( PlayerDir=="BAS") player2.addY(-4);
					if( PlayerDir=="HAUT") player2.addY(+4);
					if( PlayerDir=="GAUCHE") player2.addX(+4);
					if( PlayerDir=="DROITE") player2.addX(-4);					
				}
				for(int j = 0;j < shots.size();j++){
					shot = shots.get(j);
					Rectangle ShotRec = shot.getBounds();
					if(BlockRec.intersects(ShotRec)) shots.remove(j);				
				}
			}
			for(int j = 0;j < shots.size();j++){
				shot = shots.get(j);
				Rectangle ShotRec = shot.getBounds();
				int num = shot.getNum();
				if(num==1){
					if(ShotRec.intersects(player2Rec)){
						player2.addLife(-1);
						shots.remove(j);
					}
				}
				else if(num==2){
					if(ShotRec.intersects(player1Rec)){
						player1.addLife(-1);
						shots.remove(j);
					}
				}
			}
			
			if(player1Rec.intersects(player2Rec)){
				String PlayerDir = player1.getPlayerDir();
				if( PlayerDir=="BAS") player1.addY(-4);
				if( PlayerDir=="HAUT") player1.addY(+4);
				if( PlayerDir=="GAUCHE") player1.addX(+4);
				if( PlayerDir=="DROITE") player1.addX(-4);					
			}
			if((player1.getY()>535)||(player1.getY()<0)) initArrayList();
			if((player1.getX()>685)||(player1.getX()<0)) initArrayList();
			if((player2.getY()>535)||(player2.getY()<0)) initArrayList();
			if((player2.getX()>685)||(player2.getY()<0)) initArrayList();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			player1.Move();
			player2.Move();
			repaint();
			CheckCollision();
		}
	}
