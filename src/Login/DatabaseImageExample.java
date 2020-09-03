/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.*;
import java.sql.*;
 
public class DatabaseImageExample {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/smarthome","root","");
            
            File file=new File("d:\\image1.png");
            FileOutputStream fos=new FileOutputStream(file);
            byte b[];
            Blob blob;
            
            PreparedStatement ps=con.prepareStatement("select * from trn_imgs"); 
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                blob=rs.getBlob("img_data");
                b=blob.getBytes(1,(int)blob.length());
                fos.write(b);
            }
            
            ps.close();
            fos.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}