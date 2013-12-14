package LevelEditor;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileInit {
	
	
	public static void main(String[] args){
		DataOutputStream dos;
		try {
			dos = new DataOutputStream(
			        new BufferedOutputStream(
			                 new FileOutputStream(
			                   new File("lvl/level.txt"))));
			for(int i = 0;i<20;i++){
		    	  for(int j = 0;j<15;j++){
		    		  try {
						dos.writeInt(0);
						System.out.println("0");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("shit");
						e.printStackTrace();
					}
		    	  }
		      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("shit");
		}
			
	}

}
