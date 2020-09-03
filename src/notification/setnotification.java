/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

import static Login.admin_login.curr_user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import static smarthome.Label.noti_disp;

/**
 *
 * @author Root
 */
public class setnotification {
 public static boolean found=false;
    public setnotification()
  {
  long millis=System.currentTimeMillis();  
             java.sql.Date  d=new java.sql.Date(millis);  
             SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-d");
   
    String s_date= d.toString();
            
            System.out.println(s_date);
          
           String usr=curr_user;
           
         try{  
             
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  
                 Connection    con= DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home","root","toor");
  
             Statement  stmt=con.createStatement();   
             ResultSet r=stmt.executeQuery("select * from notification where e_date ='"+s_date+"'");
             String note="";
             while(r.next())
             {
                 
                 found=true;
                note=note+"\n\n*"+r.getString(1);
                 
                 System.out.println(r.getString(1));
             
             }
            noti_disp.setText(note);
            stmt.close();
            con.close();  
        }
 catch(Exception ee){
            ee.printStackTrace();
        }
  }
    public static void main(String[] args) {
        new setnotification();
    }


}
