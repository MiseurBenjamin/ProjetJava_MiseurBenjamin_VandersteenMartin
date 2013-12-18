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
 

/**
 * Cette classe est le panneau de l'éditeur de jeu, il gère l'entiereté de celui-ci.
 * @author MartinVandersteen
 *
 */

@SuppressWarnings("serial")
public class PanneauEditeur extends JPanel { 
	DataOutputStream dos = null;												//On crée un DOS pour pouvoir enregistrer les modifications
	ImageIcon IIblock = new ImageIcon(getClass().getResource("/img/block.png"));	//On récupère les images de blocs et du fond
	private Image block = IIblock.getImage();
	ImageIcon IIfond = new ImageIcon(getClass().getResource("/img/fond.png"));
	private Image fond = IIfond.getImage();
	level niveau;																//Variable contenant un objet level	
	
	public PanneauEditeur(){	
		super();
		niveau = new level();													//On instancie un objet level
		addMouseListener(new MouseAdapter() {									//On ajoute un mouseListener sur le panel qui ajoute ou supprime un bloc
            @Override
            public void mouseClicked(MouseEvent e) {
            	niveau.inverserLvl(e.getX()/34,e.getY()/34);
            	repaint();
            	save();															//On sauvegarde le changement
            }
        });
	}
	
	public void save(){												//Fonction de sauvegarde
		try {
			dos = new DataOutputStream(
			        new BufferedOutputStream(
			         new FileOutputStream(
			           new File("level.txt"))));					//On initialise le DOS
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      for(int i = 0;i<20;i++){									//On enregistre le niveau modifié dans le fichier level.txt
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
			dos.close();										//On ferme ensuite le DOS
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  public void paintComponent(Graphics g){						//Fonction d'affichage des différents blocs, un par un.
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
  