/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;





import static Login.admin_login.curr_user;
import com.sun.awt.AWTUtilities;
import data_show.main_visual;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import smarthome.*;
import org.jdatepicker.*;
import static smarthome.Label.log;
import static smarthome.Panel.adminmenu_frame;
//import static smarthome.Panel.noti_panel;
import static smarthome.Panel.usersetting_menu;

//import static smarthome.smarthome.*;
/**
 *
 * @author Root
 */
public class add implements Label,Button, ActionListener{
   
    
    JLabel lab=new JLabel("Priority :");
    JTextArea raw_data=new JTextArea();
    JSlider priority=new JSlider(0);
    //JLabel lab1=new JLabel("hello users we are helping you to make your world much smarter");
    JButton submit=new JButton("submit");
    JLabel datelbl=new JLabel("TARGET DATE");
    JLabel pr_status=new JLabel("LOW               NORMAL               HIGH");
    JLabel heading=new JLabel("ADD NOTIFICATIONS",SwingConstants.CENTER);
   ImageIcon backimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\prev.jpg").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));   
     JButton noti_back_button=new JButton(backimg);
      ImagePanelframe noti_panel = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\editied.jpg").getImage());
       
        
    public add(){
       noti_frame.setUndecorated(true);
        AWTUtilities.setWindowOpacity(noti_frame, 0.4f);
        noti_frame.setBounds(800,200,430,430);
        noti_frame.setLayout(null);
        noti_frame.setUndecorated(true);
        noti_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10,5,5,5,Color.GRAY));
        
        //noti_panel.setBounds(800,200,430,430);
        noti_frame.add(noti_panel);
        heading.setBounds(31,5,400,40);
        heading.setFont(new Font("Courier New", Font.BOLD,30));
        noti_panel.add(heading);
        noti_back_button.setBounds(5,10,30,30);
        noti_back_button.addActionListener(this);
        raw_data.setBounds(40,60,360,100);
        raw_data.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.black));
        raw_data.setFocusable(true);
                
        lab.setBounds(20,170,100,30);
         priority.setBounds(130,170,200,30);
         pr_status.setBounds(130,203,200,20);
         datelbl.setBounds(20,260,130,30);
         txtDate.setBounds(135,260,100,30);
        txtDate.setEditable(false);
        txtDate.setText("00/00/0000");
         
         picker.setBounds(240,260,30,30);
         submit.setBounds(155,330,100,40);
        noti_panel.add(raw_data);
        noti_panel.add(noti_back_button);
        noti_panel.add(lab);
        noti_panel.add(pr_status);
        noti_panel.add(priority);
        noti_panel.add(datelbl);
        noti_panel.add(submit);
          noti_panel.add(picker);
            noti_panel.add(txtDate);
            picker.addActionListener(this);
            submit.addActionListener(this);
        //noti_frame.setVisible(true);
        
        
             
            
    } 
    public static void main(String[] args) {
    
        //new add();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s;
        if(e.getSource()==picker)
        {  
        s=new DatePicker(adminmenu_frame).setPickedDate();
        txtDate.setText(s);
    }
        if(e.getSource()==submit)
        {
            //for current time
        long millis=System.currentTimeMillis();  
             java.sql.Date  d=new java.sql.Date(millis);  
             SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
   
    String s_date=d.toString();
            
            String msg=raw_data.getText();
            int pr=priority.getValue();
           String e_date=txtDate.getText();
           String usr=curr_user;
         try{  
             
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  
                 Connection    con= DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home","root","toor");
  
             Statement  stmt=con.createStatement();   
             int r=stmt.executeUpdate("insert into notification(message,priority,e_date,s_date,by_user) values('"+msg+"',"+pr+",'"+e_date+"','"+s_date+"','"+usr+"')");
             if(r==1)
             {
                 System.out.println("notification added");
             noti_frame.setVisible(false);
            // adminmenu_frame.setVisible(true);
             stmt.close();
             con.close();
             detailpos.setVisible(true);
             
             detailpos.setText("Notification ADDED");
             }
             else{
             raw_data.setForeground(Color.red);
             raw_data.setText("SOME ERRORS..RETRY");
             }
             
        }
 catch(Exception ee){
     ee.printStackTrace();
            raw_data.setForeground(Color.red);
             raw_data.setText("SOME ERRORS..RETRY");
        }
        
//     throw new UnsupportedOperationException("Not supported yet."); //To chan
        }
        
        if(e.getSource()==noti_back_button)
        adminmenu_frame.setVisible(true);
        //noti_frame.setVisible(false);
     
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
