package smarthome;
import data_show.Roundlbl;
import data_show.total_user;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Root
 */
public interface Label{
   ImageIcon smrt_img =new ImageIcon(System.getProperty("user.dir")+"\\png\\smarthome-program.png");
    JLabel design=new JLabel("===========================");
    JLabel div=new JLabel("===========================");
      JLabel div1=new JLabel("===========================");
    JLabel head=new JLabel("SMART HOME SYSTEM");
    JLabel lights=new JLabel("Lights & Fans Control");
    //ImageIcon img = new ImageIcon("C:\\Users\\Root\\Videos\\png\\rfan.png");
    ImageIcon fan = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\fan.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
    ImageIcon bulb = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\bulb.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
     //ImageIcon fridgelbl = new ImageIcon(new ImageIcon("C:\\Users\\Root\\Videos\\png\\fridge.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    ImageIcon img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\bulb.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));   
    JLabel fri_label=new JLabel("Fridge & AC Control");
    JLabel f_label=new JLabel(fan);
    JLabel b_label=new JLabel(bulb);
    JLabel music1=new JLabel("Music Player Control");
    //JLabel house1=new JLabel("House Status");
        JLabel lblcctv=new JLabel("MONITER MODE",SwingConstants.CENTER);
  
    JLabel noti=new JLabel("Notification Control");
    JLabel g_search=new JLabel("Whats On Your Mind");
    JLabel clock=new JLabel();
    //JLabel numbofface=new JLabel();
    //paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    JLabel noti_title=new JLabel("NOTIFICATION OF THE DAY");
    JTextPane noti_disp=new JTextPane();
JLabel memberlabel=new JLabel("Head Count :");
JLabel musicplayer=new JLabel("MUSIC SYSTEM");
JLabel log=new JLabel();

    JLabel song_name=new JLabel("No song selected..",SwingConstants.CENTER);
    JLabel empty=new JLabel();
 JTextField txtDate=new JTextField();  
JLabel memberin_status=new JLabel("MEMBER INSIDE ");
JLabel memberout_status=new JLabel("MEMBER OUTSIDE ");
JLabel lbltmp_status=new JLabel("CURRENT TEMPERATURE ");
JLabel lbldoor_status=new JLabel("DOOR CURRENT STATUS");

//weblbl
JLabel weblbl=new JLabel("WEB CONTACTS",SwingConstants.CENTER);

//picslider
JLabel pic_lbl=new JLabel("FEATURED CLICKS",SwingConstants.CENTER);
 
JLabel picslider=new JLabel();

//tv&rest
JLabel tvlbl=new JLabel("TV & OTHER CONTROLS");
JLabel tvstatus=new JLabel("STATUS :");
JLabel lbl=new JLabel("Detail-window",SwingConstants.CENTER);
JTextPane t=new JTextPane();

//weather
JLabel loc=new JLabel("set location");
RoundButton weather_temp=new RoundButton();
JProgressBar jp=new JProgressBar();

 ImageIcon yesface_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\member.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));   
         ImageIcon noface_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\no_member.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));   
    JLabel head_show[]=new JLabel[10];    
    JLabel wind_data=new JLabel();
    JLabel gust_data=new JLabel();
    
    JLabel jLabel1=new JLabel("Login Panel",SwingUtilities.CENTER);
    
      ImageIcon vol1 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\volume.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));   
      ImageIcon vol0 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\mute.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));   
 
      JLabel vol_lbl=new JLabel(vol1);    
   JLabel door_show=new JLabel();
    
}