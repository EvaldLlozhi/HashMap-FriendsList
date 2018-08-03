/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends;

import static friends.FriendsList.readInput;
import static friends.FriendsList.writeOutput;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author alexandros
 */
public class Friends {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        HashMap<String ,ArrayList<String>> map = null;
		try{
			map = readInput("input.txt");
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
		
		try{
			writeOutput("output.txt", map);
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(0);
		}
	
        
    }
    
}
