/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import static Login.admin_login.curr_user;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import static smarthome.Button.login_continue;

import static smarthome.Button.user_id_box;
import static smarthome.Label.jLabel1;
import smarthome.Panel;


/**
 *
 * @author Root
 */
public class admin_login implements ActionListener{
    public static String curr_user;
    
   // private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
    JPanel jPanel1=new JPanel();
    JComboBox type=new JComboBox();
    public static JFrame login_frame=new JFrame();
    public admin_login()
    {
       
        
        jPanel1.setLayout(null);
        login_frame.setUndecorated(true);
        login_frame.setLayout(null);
       // login_frame.setBackground(new Color(0,0,0,125));
       jPanel1.setBackground(new Color(0,0,0,125));
        jLabel2 = new javax.swing.JLabel("User ID : ",SwingConstants.CENTER);

        
        
        jLabel2.setForeground(Color.red);
        jLabel1.setForeground(Color.WHITE);
        login_frame.setBackground(new Color(0, 0, 0,65));
        jPanel1.setBorder(new BevelBorder(1, Color.GREEN, Color.lightGray));
        jLabel1.setFont(new Font("Arial",Font.BOLD, 15));
        jLabel3 = new javax.swing.JLabel("User_Type : ",SwingConstants.CENTER);
        jLabel3.setForeground(Color.red);
        AWTUtilities.setWindowOpacity(login_frame, 0.4f);
       
        
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN","NORMAL USER" }));
        login_frame.setBounds(250,290,300,220);
        jLabel1.setBounds(1,1,295,30);
        
        
        jLabel2.setBounds(10,60,100,30);
        
        user_id_box.setBounds(120,60,150,30);
        user_id_box.setForeground(Color.black);
        login_continue.addActionListener(this);
        jLabel3.setBounds(10,120,100,30);
        type.setBounds(120,115,120,30);
        
        type.setToolTipText("Click to choose user_type");
        user_id_box.setBorder(new BorderUIResource.LineBorderUIResource(Color.black, 2));
        type.setBorder(new BorderUIResource.LineBorderUIResource(Color.black, 2));
        login_continue.setBounds(50,160,200,30);
        jPanel1.setBounds(1,1,295,200);
        login_frame.add(jPanel1);
        jPanel1.add(type);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel1);
        jPanel1.add(login_continue);
        jPanel1.add(user_id_box);
   // login_frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        

try{  
             String user=user_id_box.getText();
             String u_type=type.getSelectedItem().toString();
             
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  
                 Connection    con= DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home","root","toor");
       String query="select * from login where name = '" + user +"' and user_type='"+u_type+"'";
                File file=new File(System.getProperty("user.dir")+"\\png\\loggeduser.png");
            FileOutputStream fos=new FileOutputStream(file);
            byte b[];
            Blob blob;
            
              PreparedStatement ps=con.prepareStatement(query);
                 
                 //Statement stmt=con.createStatement();   
                 ResultSet rs=ps.executeQuery();
        
       

if(rs.next())
{
    blob=rs.getBlob("image");
    if(blob!=null)
    {
    b=blob.getBytes(1,(int)blob.length());
    fos.write(b);
    }
 curr_user=user; 
    login_frame.setVisible(false);
    new admin_pass();
 ps.close();
             con.close();    
}
else
{
    
user_id_box.setText("Invalid ID/Type");
user_id_box.setForeground(Color.red);
  
}
        }
 catch(Exception ee){
            ee.printStackTrace();
        }


//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
