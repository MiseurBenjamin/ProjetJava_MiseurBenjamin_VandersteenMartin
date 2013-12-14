package LevelEditor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class PanneauEditeur extends JPanel { 
	DataOutputStream dos = null;
	Image block;
	Image fond;
	level niveau;
	
	public PanneauEditeur(){
		super();
		try {
			block = ImageIO.read(new File("img/block.png"));
			fond = ImageIO.read(new File("img/fond.png"));
			niveau = new level();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int x = e.getX();
            	int y = e.getY();
            	x = x/34;
            	y = y/34;
            	niveau.inverserLvl(x, y);
            	repaint();
            	save();	
            }
        });
	}
	
	public void save(){
		try {
			dos = new DataOutputStream(
			        new BufferedOutputStream(
			         new FileOutputStream(
			           new File("lvl/level.txt"))));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      for(int i = 0;i<20;i++){
	    	  for(int j = 0;j<15;j++){
	    		  try {
					dos.writeInt(niveau.getLvl()[i][j]);
					System.out.println(niveau.getLvl()[i][j]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  }
	      }
	    try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  public void paintComponent(Graphics g){
	  for(int i = 0;i<20;i++){
    	  for(int j = 0;j<15;j++){
    		  if(niveau.getLvl()[i][j]==1){
    			  g.drawImage(block, i*34, j*34, this);
    		  }
    		  if(niveau.getLvl()[i][j]==0){
    			  g.drawImage(fond, i*34, j*34, this);
    		  }    		  
    	  }
      }
  }
}
  