package LevelEditor;
import javax.swing.JFrame;
import Game.PanneauJeu;
 
/**
 * La frame contenant le jeu.
 * @author MartinVandersteen
 *
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
  public MainFrame(){             
    this.setTitle("Jeu 2D");
    this.setSize(685, 535); 				//20 cases *34px / 15 cases  *34px   =>  685*535
    this.setLocationRelativeTo(null); 			//On centre la fenêtre
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new PanneauJeu());   		//On crée un PanneauJeu et le met en ContentPane
    this.setResizable(false);						//La fenêtre n'est pas redimensionnable
    this.setVisible(true);							//La frame est visible
  }       
  
  public static void main(String[] args){
	    MainFrame fenetre = new MainFrame();
	  }   
}