/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import static data_show.find1.imageupd;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import smarthome.Label;
import static smarthome.Label.song_name;
import javax.swing.filechooser.FileFilter;


public class imgchooser extends user_register implements Label 
        
{

public  static String i;
    public imgchooser(){
  JFrame parent=new JFrame();
JFileChooser fileChooser = new JFileChooser("c:");
fileChooser.setAcceptAllFileFilterUsed(false);


int result = fileChooser.showOpenDialog(parent);
if (result == JFileChooser.APPROVE_OPTION) {
    
    File selectedFile = fileChooser.getSelectedFile();
    
    user_register.image=selectedFile;
    image=selectedFile;
    imageupd=selectedFile;
    System.out.println(imageupd);
    i=selectedFile.getAbsolutePath();
     ImageIcon img1 = new ImageIcon(new ImageIcon("\\img\\d.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));   
     jLabel7.setIcon(img1);
    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    // user selects a file

}
}

   
}
