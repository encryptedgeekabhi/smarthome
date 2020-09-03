/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

/**
 *
 * @author Root
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import smarthome.*;
import static smarthome.Label.song_name;
//import static smarthome.Smarthome.a;
import static smarthome.Smarthome.song_num;
/**
 * This program demonstrates how to read characters from a text file
 * using a BufferedReader for efficiency.
 * @author www.codejava.net
 *
 */
public class allsongsplay {

    public allsongsplay() {
    
    int a=0;
 
     {
        try {
            
            FileReader reader = new FileReader(System.getProperty("user.dir")+"\\music.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
           
            while ((line = bufferedReader.readLine()) != null) {
           a=a+1;
           
              
            
          if(a==song_num)  
          {
          chooser.link=new File(line);
          song_name.setText(line);
          }
            
          }
            
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    }}