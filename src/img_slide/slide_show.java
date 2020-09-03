/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_slide;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import musicplayer.chooser;
import static smarthome.Label.picslider;
import static smarthome.Label.song_name;
import static smarthome.Smarthome.song_num;

public class slide_show{

 public slide_show() throws InterruptedException {
    
    int a=0;
 
     {
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir")+"\\slide.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
           
            while ((line = bufferedReader.readLine()) != null) {
          
           ImageIcon pic_img = new ImageIcon(new ImageIcon(line).getImage().getScaledInstance(260, 250, Image.SCALE_DEFAULT));   
           picslider.setIcon(pic_img);
                System.out.println(line);
            Thread.sleep(3000);
            
          
            
          }
            new slide_show();
            
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    }}

