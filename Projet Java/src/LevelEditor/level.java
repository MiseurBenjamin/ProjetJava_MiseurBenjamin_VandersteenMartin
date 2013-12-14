package LevelEditor;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class level {
	private int lvl[][];
	DataInputStream dis;
	DataOutputStream dos;
	
	public level() {
		lvl = new int[20][15];
		try {
			dis = new DataInputStream(
			        new BufferedInputStream(
			                 new FileInputStream(
			                   new File("lvl/level.txt"))));
			for(int i = 0;i<20;i++){
		    	  for(int j = 0;j<15;j++){
		    		  lvl[i][j] = dis.readInt();
		    	  }
		      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int[][] getLvl(){
		return this.lvl;
	}
	
	public void inverserLvl(int x, int y){
		if(this.lvl[x][y]==0) this.lvl[x][y] = 1;
		else this.lvl[x][y] = 0;
	}
}
