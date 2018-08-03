/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 *
 * @author alexandros
 */
public class FriendsList {
    public FriendsList(){
        
    }
    public static HashMap<String,ArrayList<String>> readInput(String filename) throws FileNotFoundException{
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        Scanner inputStream = new Scanner (new FileInputStream(filename));
        while(inputStream.hasNext()){
            String line = inputStream.nextLine();
            String[] names = line.split("\t");
            if(!map.containsKey(names[0])){
                map.put(names[0],  new ArrayList<String>());
            }
            map.get(names[0]).add(names[1]);
            if (!map.containsKey(names[1])){
                map.put(names[1], new ArrayList<String>());
            }
            map.get(names[1]).add(names[0]);
            
        }
        inputStream.close();
        return map;
    } 
    public static void writeOutput(String filename , HashMap<String,ArrayList<String>> map) throws FileNotFoundException{
        PrintWriter outputStream = new PrintWriter(new FileOutputStream(filename));
        for(String name : map.keySet()){
            outputStream.print(name+":");
            for (String friend : map.get(name)){
                outputStream.print(friend+" ");
            }
            outputStream.println();
        }
        outputStream.close();
    }
}
