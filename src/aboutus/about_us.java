/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutus;
import static aboutus.page.d_f;
import com.sun.awt.AWTUtilities;
import data_show.main_visual;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
//import Smarthome1.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import smarthome.ImagePanelframe;
import static smarthome.Label.lbl;
import static smarthome.Label.t;
import smarthome.RoundButton;
import smarthome.Smarthome;
import smarthome.home;
import static smarthome.Button.*;


public class about_us implements ActionListener {
       
       JPanel p;
       
       JLabel lab;
       public about_us(){
           new page();
		JFrame f=new JFrame();
                f.setBounds(100,50,1100,550);
                 JLabel lab=new JLabel("ABOUT US",SwingConstants.CENTER);
                 f.setTitle("ABOUT US");
                 f.setAlwaysOnTop(true);
      //  f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
		
                 f.getRootPane().setBorder(BorderFactory.createMatteBorder(20,20,20,20,Color.black));
        ImagePanelframe panel = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\d.jpg").getImage());
        panel.setBounds(0,0,1045,550);
        f.getContentPane().add(panel);
        lab.setBounds(1,1,1045,100);
        lab.setForeground(Color.red);
        lab.setFont(new Font("Segoe Print",Font.BOLD, 110));
        panel.add(lab);
        
        bt1.setText("Power Controls");
        bt1.setForeground(Color.red);
        bt1.setBounds(800,340,130,130);
        bt1.addActionListener(this);
        panel.add(bt1);
       
        bt2.setText("Sensor Data");
        bt2.setForeground(Color.red);
        bt2.setBounds(700,190,130,130);
        bt2.addActionListener(this);
        panel.add(bt2);
       
        bt3.setText("Login Panel");
        bt3.setForeground(Color.red);
        bt3.setBounds(140,190,130,130);
        bt3.addActionListener(this);
        panel.add(bt3);
      
        bt4.setText("CCTV");
        bt4.setForeground(Color.red);
        bt4.setBounds(35,340,130,130);
        bt4.addActionListener(this);
        panel.add(bt4);
        
        bt5.setText("Web Contacts");
        bt5.setForeground(Color.red);
        bt5.setBounds(420,105,130,130);
        bt5.addActionListener(this);
        panel.add(bt5);
     
        bt6.setText("Notification");
        bt6.setForeground(Color.red);
        bt6.setBounds(600,340,130,130);
        bt6.addActionListener(this);
        panel.add(bt6);
        
        bt7.setText("Music System");
        bt7.setForeground(Color.red);
        bt7.setBounds(245,340,130,130);
        bt7.addActionListener(this);
        panel.add(bt7);
        
        
        f.setLayout(null);
        f.setVisible(true);
       
                
       }
       public static void main(String[] args) {
        new about_us();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            t.setText("This panel deals with the electrical appliances of house where we can control two bulbs , two fans, turn on the AC and maintain the temperature of the house using slider.We can control our TV.");
            lbl.setText("POWER CONTROLS");
            d_f.setVisible(true);
            
            disable();
        }
        if(e.getSource()==bt2){
            
         t.setText("   Here,using face detection technique we can get data about number of person present inside the house. Here,you will get the current temperature of the house.This panel consist of door status label that shows the current status of door(i.e.,Open or Close).");
         lbl.setText("SENSOR DATA");  
         d_f.setVisible(true);
            disable();
        }
        if(e.getSource()==bt3){
           
            t.setText("This Panel consist of two buttons ,one for user login and another for administator login where admin has the authorization for viewing as well as modifying data regarding CCTV, user credentials, notification and other settings. Through the user login we can see the data but cannot manupulate it.");
            lbl.setText("LOGIN PANEL");
            d_f.setVisible(true);
            disable();
        }
        if(e.getSource()==bt4){
          
            t.setText("This panel consist video screen for live visuals from camera." );
            lbl.setText("CCTV");
            d_f.setVisible(true);
            disable();
        }
        if(e.getSource()==bt5){
            
            t.setText("Through this Panel we can browse google , YouTube , Gmail without exiting the main Panel.");
            lbl.setText("WEB CONTACTS");
            d_f.setVisible(true);
            disable();
        }
        if(e.getSource()==bt6){
            t.setText("Here we have the notification of the day which has been set by the user or the administrator. We can destroy the notification after reading . We can set the priority for the notification for the proper alert. It  produces sound if the priority is high.");
            lbl.setText("NOTIFICATION");
            d_f.setVisible(true);
            disable();
        }
        if(e.getSource()==bt7){
            t.setText("This panel consist tools for playing songs. We can select the song one-by-one or select the folder directly to play all the songs. Using the forward and backward button we can listen the next and previous song respectively.");
            lbl.setText("MUSIC SYSTEM");
            d_f.setVisible(true);
            disable();
        }
    }
   void disable()
   {
            bt1.setEnabled(false);
            bt2.setEnabled(false);
            bt3.setEnabled(false);
            bt4.setEnabled(false);
            bt5.setEnabled(false);
            bt6.setEnabled(false);
            bt7.setEnabled(false);
   }
 
}
   
   