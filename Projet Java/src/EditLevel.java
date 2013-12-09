import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class EditLevel extends JFrame {
  public EditLevel(){             
    this.setTitle("Editeur de niveaux");
    this.setSize(685, 535); //20*34 / 15 * 34
    this.setLocationRelativeTo(null); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau());   
    this.setResizable(false);
    this.setVisible(true);
    
    //gskrngdsnsodkn^sdlfknb sdknh^psdnh^sdh
    //gsdkhpsdlfkhsdlfhjdslkfh,ds^fkhjsdfljhsdjhskdd
    //gdsrgsdgsdrg
  }       
  
  public static void main(String[] args){
	    EditLevel fenetre = new EditLevel();
	    fenetre.setVisible(true);
	  }   
}