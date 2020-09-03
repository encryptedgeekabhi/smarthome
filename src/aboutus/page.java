/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import static smarthome.Button.about_back_button;
import static smarthome.Button.bt1;
import static smarthome.Button.bt2;
import static smarthome.Button.bt3;
import static smarthome.Button.bt4;
import static smarthome.Button.bt5;
import static smarthome.Button.bt6;
import static smarthome.Button.bt7;
import smarthome.ImagePanelframe;
import static smarthome.Label.lbl;
import static smarthome.Label.t;

public class page implements ActionListener{
   static JFrame d_f;
     public page(){
         d_f=new JFrame("About us");
         d_f.setUndecorated(true);
         d_f.setBounds(450,200,500,550);
        about_back_button.setBounds(10,20,30,30);
        about_back_button.addActionListener(this);
         lbl.setFont(new Font("Segoe Print",Font.BOLD, 40));
         
         lbl.setForeground(Color.red);
         
         lbl.setBounds(30,2,500,50);
         
         
         ImagePanelframe p=new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\d.jpg").getImage());
         d_f.add(p);
         
         t.setBounds(47,115,390,395);
         t.setBackground(Color.DARK_GRAY);
         p.add(t);
         p.add(lbl);
         p.add(about_back_button);
         t.setFont(new Font("Segoe Print",Font.BOLD, 20));
         t.setForeground(Color.WHITE);
         d_f.setVisible(false);
         d_f.setAlwaysOnTop(true);
         
     }
     public static void main(String[] args) {
        new page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==about_back_button)
{
 d_f.setVisible(false);
    enable();
}
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void enable()
   {
           bt1.setEnabled(true);
           bt2.setEnabled(true);
            bt3.setEnabled(true);
            bt4.setEnabled(true);
            bt5.setEnabled(true);
            bt6.setEnabled(true);
            bt7.setEnabled(true);
   } 
    
}
