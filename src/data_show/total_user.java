/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_show;

import static Login.admin_login.curr_user;
import Login.admin_pass;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Root
 */
public class total_user {
    public static int total_member;
   public total_user()
   {
   try{  
             
             
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  
                 Connection    con= DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home;create=true;user=root;password=toor");
    String query="select * from login";
            
            
              PreparedStatement ps=con.prepareStatement(query);
                 
                 //Statement stmt=con.createStatement();   
                 ResultSet rs=ps.executeQuery();
        
       

while(rs.next())
{
    total_member=total_member+1;
}
      System.out.println(total_member);
      ps.close();
  
             con.close();
        }
 catch(Exception ee){
           // ee.printStackTrace();
        }
        
   }
    public static void main(String[] args) {
        new total_user();
    }
}
