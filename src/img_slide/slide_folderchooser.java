/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img_slide;

//import musicplayer.*;
import aboutus.*;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import smarthome.Label;

public class slide_folderchooser implements Label
        
{
   static String slide_path;
    public slide_folderchooser(){
  JFrame parent=new JFrame();
JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    fileChooser.setAcceptAllFileFilterUsed(false);
//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
int result = fileChooser.showOpenDialog(parent);
if (result == JFileChooser.APPROVE_OPTION) {
    
    File selectedFile = fileChooser.getSelectedFile();
   slide_path=selectedFile.getAbsolutePath();
    
    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    // user selects a file
    
    try {
        File previous=new File(System.getProperty("user.dir")+"\\slide.txt");
        previous.delete();
            FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\slide.txt", true);
            File file = new File(slide_path);
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

}

    /* public static void main(String[] args) {
    new folderchooser();
    }*/
 
}