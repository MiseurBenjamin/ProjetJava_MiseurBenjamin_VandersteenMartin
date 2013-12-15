package LevelEditor;
import java.awt.Color; 

import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.PanneauJeu;
 
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
  public MainFrame(){             
    this.setTitle("Jeu 2D");
    this.setSize(685, 535); //20*34 / 15 * 34    685*535
    this.setLocationRelativeTo(null); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new PanneauJeu());   
    this.setResizable(false);
    this.setVisible(true);
  }       
  
  public static void main(String[] args){
	    MainFrame fenetre = new MainFrame();
	    fenetre.setVisible(true);
	  }   
}