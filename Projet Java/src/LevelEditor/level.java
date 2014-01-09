package LevelEditor;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Cette classe représente la carte de jeu sous forme d'un tableau à deux dimensions de int (0 = fond, 1 = bloc ).
 * @author MartinVandersteen
 *
 */

public class level {
	private int lvl[][];
	DataInputStream dis;
	
	public level() {				//On lit ce qu'il est écrit dans le fichier level.txt
		lvl = new int[20][15];
		try {
			dis = new DataInputStream(
			        new BufferedInputStream(
			                 new FileInputStream(
			                   new File("level.txt"))));
			for(int i = 0;i<20;i++){
		    	  for(int j = 0;j<15;j++){
		    		  lvl[i][j] = dis.readInt();
		    	  }
		      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found level.txt, fichier créé.");		//Si on ne trouve pas le fichier on le crée
			new FileInit();
		} catch (EOFException e) {
			new FileInit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 * @return int[][] Le niveau sous forme de tableau binaire ( 0 = fond, 1 = block de pierre )
	 */
	public int[][] getLvl(){								//Renvoie la map sous forme de tableau
		return this.lvl;
	}
	
	/**
	 * 
	 * @param x Indice horizontal de la case à inverser dans le tableau
	 * @param y Indice vertical de la case à inverser dans le tableau
	 */
	public void inverserLvl(int x, int y){			//Inverse une case en fonction de ses coordonnées dans le tableau (coordonnées graphiques /34 )
		if(this.lvl[x][y]==0) this.lvl[x][y] = 1;
		else this.lvl[x][y] = 0;
	}
}
