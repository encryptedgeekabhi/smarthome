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
import java.io.File;
 
public class FilesListFromFolder {
     
    public static void main(String a[]){
        File file = new File("D:\\Music\\panjab");
        File[] files = file.listFiles();
        for(File f: files){
            
            System.out.println(f.getName());
        }
    }
}