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

import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class PanneauEditeur extends JPanel { 
	DataOutputStream dos = null;
	ImageIcon IIblock = new ImageIcon(getClass().getResource("/img/block.png"));
	private Image block = IIblock.getImage();
	ImageIcon IIfond = new ImageIcon(getClass().getResource("/img/fond.png"));
	private Image fond = IIfond.getImage();
	level niveau;
	
	public PanneauEditeur(){
		super();
		niveau = new level();
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	niveau.inverserLvl(e.getX()/34,e.getY()/34);
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
			           new File("level.txt"))));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      for(int i = 0;i<20;i++){
	    	  for(int j = 0;j<15;j++){
	    		  try {
					dos.writeInt(niveau.getLvl()[i][j]);
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
  