/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

//import musicplayer.*;
import aboutus.*;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import smarthome.Label;

public class folderchooser implements Label
{
   static String folderpath;
    public folderchooser(){
  JFrame parent=new JFrame();
JFileChooser fileChooser = new JFileChooser("D:\\Music");
fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    fileChooser.setAcceptAllFileFilterUsed(false);
//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
int result = fileChooser.showOpenDialog(parent);
if (result == JFileChooser.APPROVE_OPTION) {
    
    File selectedFile = fileChooser.getSelectedFile();
    folderpath=selectedFile.getAbsolutePath();
    
    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    // user selects a file

}

}

    /* public static void main(String[] args) {
    new folderchooser();
    }*/
 
}