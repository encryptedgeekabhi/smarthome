/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_slide;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
/**
 * This program demonstrates how to write characters to a text file.
 * @author www.codejava.net
 *
 */
public class pic_path {
 public pic_path()
 {
 try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\pic_path.txt", true);
            File file = new File("C:\\smarthome\\png");
        File[] files = file.listFiles();
        for(File f: files){
            writer.write(f.getAbsolutePath());
            writer.write("\r\n"); 
        }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 }
    public static void main(String[] args) {
        
 new pic_path();
    }
 
}