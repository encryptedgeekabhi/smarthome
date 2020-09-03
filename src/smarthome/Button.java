package smarthome;

import data_show.Roundlbl;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Root
 */
public interface Button {
  
    JButton aboutus=new JButton("About Us");
    ImageIcon power_low = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\power.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));   
    ImageIcon powerup = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\power_on.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));   
    
    JButton lig1=new JButton(power_low);
    JButton lig2=new JButton(power_low);
    JButton fan1=new JButton(power_low);
    JButton fan2=new JButton(power_low);
    ImageIcon img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\fridge.jpg").getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT));   
    JButton fridge=new JButton(img);
    ImageIcon ac_icon = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\AC.png").getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT));   
    JButton AC=new JButton(ac_icon);
    JSlider ac_slider=new JSlider();
     ImageIcon door_open = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\dooropen.png").getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT));   
   ImageIcon door_close = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\doorlock.png").getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT));   
   ImageIcon door_open1 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\dooropen.png").getImage().getScaledInstance(70,80, Image.SCALE_DEFAULT));   
   ImageIcon door_close1 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\doorlock.png").getImage().getScaledInstance(70, 80, Image.SCALE_DEFAULT));   
   
   JButton door_status=new JButton(door_close);
    JButton noti_del=new JButton("DISTROY");
    JButton usr_log=new JButton("USER LOGIN");
    JButton adm_log=new JButton("ADMIN LOGIN");
    
    //musicplayer
     JSlider volume=new JSlider();
    JButton play_all=new JButton("PLAY ALL");
    ImageIcon choose_song = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\choose.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    JButton select_song=new JButton(choose_song);
    ImageIcon img5 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\forward.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    JButton forward=new JButton(img5);
    ImageIcon img6 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\backward.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    JButton backward=new JButton(img6);
    ImageIcon img2 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\play.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    ImageIcon img3 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\pause1.jpg").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    ImageIcon img4 = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\stop.jpg").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    JButton music_play=new JButton(img2);
    JButton music_pause=new JButton(img3);
    JButton music_stop=new JButton(img4);
    
    ImageIcon cal = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\calander.jpg").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    
     JButton picker = new JButton(cal);
       JButton memberin=new JButton();
         JButton memberout=new JButton();
         JButton temp_status=new JButton();
         //JButton door_status=new JButton();
         
//web
            
    ImageIcon g = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\search.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));   
     JButton google_button=new JButton(g);
  
    ImageIcon gm = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\gmail.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));   
     JButton gmail_button=new JButton(gm);
     
     
    ImageIcon ytube = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\youtube.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));   
     JButton youtube_button=new JButton(ytube);

//TV
     
ImageIcon tvimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\tv.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));   
     JButton tv_button=new JButton(tvimg);
     
//admin_menu
    ImageIcon settingimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\setting-icon.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));   
     JLabel setting_button=new JLabel();
ImageIcon cctvimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\cctv.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));   
     JLabel cctv_button=new JLabel();
     

ImageIcon userimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\user-setting.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));   
     JLabel user_button=new JLabel(); 

     ImageIcon closeimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\close.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));   
     JLabel close_button=new JLabel();
     ImageIcon notiimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\notification.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));   
     JLabel noti_button=new JLabel();
     JLabel noti_popup=new JLabel(notiimg);
//user setting
     //admin_menu
    ImageIcon addimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\add-user.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));   
     JLabel user_add_button=new JLabel(addimg); 
ImageIcon delimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\del-user.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));   
     JLabel user_del_button=new JLabel(delimg); 

ImageIcon updateimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\update-user.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));   
     JLabel user_update_button=new JLabel(updateimg); 

     ImageIcon listimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\all-user.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));   
     JLabel user_all_button=new JLabel(listimg); 
     ImageIcon backimg = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\prev.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));   
     JButton about_back_button=new JButton(backimg);
     JButton main_visual_back=new JButton(backimg);
     JFrame noti_frame=new JFrame();

//aboutus
 JButton bt1=new RoundButton();  
JButton bt2=new RoundButton(); 
JButton bt3=new RoundButton();
JButton bt4=new RoundButton();
JButton bt5=new RoundButton(); 
JButton bt6=new RoundButton();
JButton bt7=new RoundButton();


ImageIcon m_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\Music-icon.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));   
    RoundButton mus_btn=new RoundButton();
    ImageIcon a_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\power_btn.png").getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));   
    RoundButton power_btn=new RoundButton();
ImageIcon cctv_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\cctv_button.png").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));   
    RoundButton cctv_btn=new RoundButton();
  ImageIcon login_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\log_btn.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));   
    RoundButton login_btn=new RoundButton();
    
    ImageIcon internet_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\internet_button.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));   
    RoundButton internet_btn=new RoundButton();
    ImageIcon face_img = new ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\face_button.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));   
    RoundButton face_btn=new RoundButton();
    JButton login_continue=new JButton("Continue");
    JButton login_submit=new JButton("Submit");
    JTextField user_id_box=new JTextField();
    
    JButton detailpos=new RoundButton();
}