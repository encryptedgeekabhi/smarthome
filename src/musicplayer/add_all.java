/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static musicplayer.folderchooser.folderpath;
 
/**
 * This program demonstrates how to write characters to a text file.
 * @author www.codejava.net
 *
 */
public class add_all {
 public add_all()
 {
 try {
           File previous=new File(System.getProperty("user.dir")+"\\music.txt");
        previous.delete();
            FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\music.txt", true);
            File file = new File(folderpath);
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
        
 new add_all();
    }
 
}