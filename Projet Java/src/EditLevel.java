import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class EditLevel extends JFrame {
  public EditLevel(){             
    this.setTitle("Ma première fenêtre Java");
    this.setSize(685, 535); //20*34 / 15 * 34
    this.setLocationRelativeTo(null); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau());   
    this.setResizable(false);
    this.setVisible(true);
  }       
  
  public static void main(String[] args){
	    EditLevel fenetre = new EditLevel();
	    fenetre.setVisible(true);
	  }   
}