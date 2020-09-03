package smarthome;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Root
 */
import Login.admin_login;
import aboutus.Developers;
import data_show.main_visual;
//import data_show.user_setting;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.aksingh.owmjapis.api.APIException;
import notification.setnotification;
import smarthome.*;
import static smarthome.Label.smrt_img;
import static smarthome.Smarthome.j;
/**
 *
 * @author Root
 */
public class home extends RoundButton implements ActionListener{
    
   JButton touchme;
   JButton about;
   JButton devlopers;
    JFrame jf=new JFrame();
    JLabel lab=new JLabel("SMART-HOME",SwingConstants.CENTER);
    JLabel quote=new JLabel("One  More Step Towards Smartness..",SwingConstants.LEFT);
  
    public home(){
       th2.start();
       jf .setIconImage(smrt_img.getImage());
    jf.setUndecorated(true);
    jf.setTitle("SMART HOME");
        jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        jf.getRootPane().setBorder(BorderFactory.createMatteBorder(20,20,20,20,Color.black));
        System.out.println(System.getProperty("user.dir")+"\\png\\d.jpg");
        ImagePanelframe panel = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\d.jpg").getImage());
        
        jf.getContentPane().add(panel);
        
        jf.setLayout(null);
        lab.setBounds(1,10,1300,180);
        lab.setForeground(Color.red);
        lab.setFont(new Font("Segoe Print",Font.BOLD, 120));
        panel.add(lab);
        quote.setBounds(700,190,600,80);
        quote.setForeground(Color.red);
        quote.setFont(new Font("Segoe Print",Font.BOLD, 30));
        panel.add(quote);
        touchme=new RoundButton();
        touchme.setText("Touch Me");
        touchme.setForeground(Color.red);
        touchme.setBounds(280,450,200,200);
        panel.add(touchme);
        touchme.addActionListener((ActionListener) this);
        about=new RoundButton();
        about.setText("KNOW MORE");
        about.setForeground(Color.red);
        about.setBounds(550,300,200,200);
        about.addActionListener(this);
        panel.add(about);
        devlopers=new RoundButton();
        devlopers.setText("DEVELOPERS");
        devlopers.setForeground(Color.red);
        devlopers.setBounds(810,450,200,200);
        devlopers.addActionListener(this);
        panel.add(devlopers);
        jf.setVisible(true);
        //Smarthome.j.setEnabled(false);
    } 
   
   Thread th2=new Thread(){
    @Override
    public void run() {
        while (true) {
            try {
                new ss.weathercast();
            } catch (APIException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }}} ;
   

 

 
    public static void main(String[] args) throws APIException {
        new home();
        new switch_control.port_on();
        new main_visual(args);
        new admin_login();
        
        new setnotification();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==touchme)
{
 jf.setVisible(false);

new borderstart();

}
if(e.getSource()==devlopers)
{
 jf.setVisible(true);
new Developers().setVisible(true);
}

if(e.getSource()==about)
{
 jf.setVisible(true);
new aboutus.about_us();
}

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*class ImagePanel extends JPanel {

private Image img;

public ImagePanel(String img) {
this(new ImageIcon(img).getImage());
}

public ImagePanel(Image img) {
this.img = img;
Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
setPreferredSize(size);
setMinimumSize(size);
setMaximumSize(size);
setSize(size);
setLayout(null);
}

public void paintComponent(Graphics g) {
g.drawImage(img, 0, 0, null);
}

}*/