package Game;

import java.util.ArrayList;

import javax.swing.JPanel;

import LevelEditor.level;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel implements KeyListener{
	level niveau = new level();
	private static ArrayList<Block> blocks;
	Player player1,player2;
	
	public PanneauJeu(){
		setFocusable(true);
		addKeyListener(this);
		initArrayList();
				
	}
	
	public void initArrayList(){
		int stop1,stop2=0,i,j;
		
		for(i=0;i<20;i++){
			for(j=0;j<15;j++){
				if(this.niveau.lvl[i][j]=1){
					Block mur = new Block(i*34,j*34);
					blocks.add(mur);
				}
				if(this.niveau.lvl[i][j]=0){
					
				}
			}
			
		}
		while(stop1=0){
			for(i=0;i<20;i++){
				for(j=0;j<15;j++){
					if(this.niveau.lvl[i][j]=0){
						this.player1 = new Player(i*34,j*34,1);
						stop1=1;
					}
				}
				
			}
		}
		while(stop2=0){
			for(i=20;i>0;i--){
				for(j=15;j>0;j--){
					if(this.niveau.lvl[i][j]=0){
						this.player2 = new Player(i*34,j*34,2);
						stop2=1;
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
			block = (Block) blocks.get(i);
			g2d.drawImage(block.getImage(),block.getX,block.getY,null);
		}
		g2d.drawImage(player1.getImage(),player1.getX,player1.getY,null);
		g2d.drawImage(player2.getImage(),player2.getX,player2.getY,null);
		
	}
	
}
