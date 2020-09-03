/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

import static Login.admin_login.curr_user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import static smarthome.Label.noti_disp;
import static smarthome.Label.txtDate;

/**
 *
 * @author Root
 */
public class destroy_msg {
  
  public destroy_msg()
  {
  long millis=System.currentTimeMillis();  
             java.sql.Date  d=new java.sql.Date(millis);  
             SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
   
    String s_date= formatter.format( d );
            
            
          
           String usr=curr_user;
         try{  
             
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  
                 Connection    con= DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home","root","toor");
  
             Statement  stmt=con.createStatement();   
             int r=stmt.executeUpdate("delete from notification where e_date=str_to_date('"+s_date+"','%d-%m-%Y')");
             if(r==1)
             {
                 System.out.println("notification deleted");
                 noti_disp.setText("READ BY USER");
             
             }
             
        }
 catch(Exception ee){
            ee.printStackTrace();
        }
  }
    public static void main(String[] args) {
        new destroy_msg();
    }
}
