package LevelEditor;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Cette classe initialise le fichier level.txt s'il n'existe pas.
 * @author MartinVandersteen
 *
 */
public class FileInit {
	
	
	public FileInit(){
		DataOutputStream dos;		//Création du canal de sortie (DataOutputStream plus efficace que FileOutputStream
		try {
			dos = new DataOutputStream(
			        new BufferedOutputStream(
			                 new FileOutputStream(
			                   new File("./level.txt"))));		//On sélectionne le fichier en écriture
			for(int i = 0;i<20;i++){							//On écrit une map vide
		    	  for(int j = 0;j<15;j++){
		    		  try {
						dos.writeInt(0);
						System.out.println("0");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
