package smarthome;

import Login.admin_login;
import static Login.admin_login.login_frame;
//import Login.login;
import ss.weathercast;
import musicplayer.*;
import facedetection.DetectFace;
import java.awt.Color;
import aboutus.*;
import com.sun.awt.AWTUtilities;
import data_show.total_user;
import facedetection.headshow;
import img_slide.slide_show;
//import static java.awt.BorderLayout.CENTER;
import java.awt.Dimension;
import static java.awt.FlowLayout.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.RoundEnvironment;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javazoom.jl.decoder.JavaLayerException;
import jssc.SerialPortException;
import musicplayer.*;
import musicplayer.chooser;
import net.aksingh.owmjapis.api.APIException;
import notification.add;
import notification.destroy_msg;
import notification.setnotification;
import static smarthome.Button.login_btn;
import static smarthome.Button.noti_popup;
import static smarthome.Label.door_show;
import static smarthome.Panel.*;
import static smarthome.Smarthome.j;
import ss.Clock;
import static switch_control.switches.set_value;

//import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;
import web.google;
import web.youtube;

public class Smarthome extends Thread implements Label,Button,Panel,ActionListener,Runnable,MouseListener{
    public static int fan1_value=10;
    public static int fan2_value=20;
    public static int lig1_value=30;
    public static int lig2_value=40;
    public static int fridge_value=50;
    public static int tv_value=60;
    public static int door_value=70;
    boolean noti_seen=false;
    
public static int song_num=0;
    Thread t=null; 
    Thread t1=null;
    Thread th3=null;
    
int hours=0, minutes=0, seconds=0;  
String timeString = "";  
    public static JFrame j=new JFrame();
    //picslider
    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public Smarthome(){
       
  Smarthome.j.setEnabled(true);
  j.setIconImage(smrt_img.getImage());
        j.setUndecorated(true);
        j.setTitle("SmartHome System");
        j.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.getRootPane().setBorder(BorderFactory.createMatteBorder(20,20,20,20,Color.black));
        t = new Thread(this);
        
        t1 = new Thread();
        t1.start();
        t.start();
        th1.start();
        th2.start();
        th5.start();
        noti_thread.start();
        vol.start();
        d_thread.start();
        //setting layouts null
        power.setLayout(null);
        
        login.setLayout(null);
        cctv.setLayout(null);
        music.setLayout(null);
        notification.setLayout(null);
        search.setLayout(null);
        music2.setLayout(null);
        
        gust_data.setBounds(40,420,150,30);
        gust_data.setBackground(new Color(0,0,0,65));
        gust_data.setFont(new Font("Arial",Font.BOLD,15));
        gust_data.setForeground(Color.GREEN);
        
        wind_data.setBounds(40,460,150,30);
        wind_data.setBackground(new Color(0,0,0,65));
        wind_data.setFont(new Font("Arial",Font.BOLD,15));
        wind_data.setForeground(Color.GREEN);
        
        weather_temp.setBounds(40,500,150,150);
        weather_temp.setBackground(new Color(0,0,0,65));
        weather_temp.setFont(new Font("Arial",Font.BOLD,50));
        weather_temp.setForeground(Color.red);
        
        jp.setBounds(10,400,20,250);
        jp.setOrientation(jp.VERTICAL);
        jp.setMaximum(60);
        jp.setMinimum(-20);
        jp.setValue(-20);
        jp.setForeground(Color.red);
         
        
        a.setBounds(800,200,200,200);
        a.setLayout(null);
        a.setBackground(new Color(0,0,0,125));
        
        b.setBounds(1000,420,200,240);
        b.setLayout(null);
        b.setBackground(new Color(0,0,0,125));
        
        
        house.setLayout(null);
        house.setBackground(Color.BLACK);
        
        //headshow
        new total_user();
        
        int x=1;
        for(int i=0;i<total_user.total_member;i++)
        {
            house.setBounds(320,10,0+(total_user.total_member*50),60);
        head_show[i]=new JLabel();
        
        head_show[i].setIcon(noface_img);
        head_show[i].setBounds(x,10,30,30);
        x=x+45;
        house.add(head_show[i]);
        }
       //door_show
       door_show.setBounds(220,220,70,80);
       
       
       
        house2.setBounds(10,250,180,50);
        house2.setLayout(null);
        house2.add(loc);
        loc.setBounds(1,1,175,48);
        loc.setForeground(Color.red);
        loc.setFont(new Font("Arial",Font.BOLD,30));
        house2.setBackground(Color.BLACK);
        
        house3.setBounds(220,400,190,150);
        house3.setLayout(null);
        house3.setBackground(new Color(0,0,0,125));
        
        
        login.setBounds(250,300,345,150);
        login.setLayout(null);
       login.setBackground(new Color(0,0,0,125));
        
        cctv.setBounds(775,10,250,350);
        cctv.setLayout(null);
        cctv.setBackground(new Color(0,0,0,125));
        
        
        search.setBounds(460,530,345,130);
        search.setLayout(null);
        search.setBackground(new Color(0,0,0,125));
        
        pic.setBounds(1035,10,270,300);
        pic.setLayout(null);
        pic.setBackground(new Color(0,0,0,125));
        
        notification.setBounds(380,200,265,200);
        notification.setLayout(null);
        notification.setBackground(new Color(0,0,0,125));
        
        music2.setBounds(370,145,300,300);
        music2.setLayout(null);
        music2.setBackground(new Color(0,0,0,125));
        
        power_btn.setBounds(1060,335,90,80);
        power_btn.setIcon(a_img);
        power_btn.setOpaque(false);
        power_btn.addActionListener(this);
        
        internet_btn.setBounds(850,510,80,80);
        internet_btn.setIcon(internet_img);
        internet_btn.setOpaque(false);
        internet_btn.addActionListener(this);
        
        cctv_btn.setBounds(700,180,80,80);
        cctv_btn.setIcon(cctv_img);
        cctv_btn.setOpaque(false);
        cctv_btn.addActionListener(this);
        
login_btn.setBounds(420,460,80,80);
        login_btn.setIcon(login_img);
        login_btn.setOpaque(false);
        login_btn.addActionListener(this);
        
        mus_btn.setBounds(665,385,80,80);
        mus_btn.setIcon(m_img);
        mus_btn.setOpaque(false);
        mus_btn.addActionListener(this);
        
         face_btn.setBounds(500,500,80,80);
        face_btn.setIcon(face_img);
        face_btn.setOpaque(false);
        face_btn.addActionListener(this);
        
        //noti_popup
        noti_popup.setBounds(300,300,80,80);
        noti_popup.setVisible(false);
        noti_popup.addMouseListener(this);

        //for fan
        lights.setBounds(1,1,150,30);
        a.add(lights);
        f_label.setBounds(1,1+50,100,40);
        fan1.setBounds(35,50+50,30,30);
        fan1.addActionListener(this);
        
        a.add(f_label);
        a.add(fan1);
        fan2.setBounds(35,102+50,30,30);
        fan2.addActionListener(this);
       a.add(fan2);
        //for bulb
        b_label.setBounds(80,1+50,100,40);
        lig1.setBounds(115,50+50,30,30);
        lig1.addActionListener(this);
        a.add(b_label);
        a.add(lig1);
        lig2.setBounds(115,102+50,30,30);
        lig2.addActionListener(this);
        a.add(lig2);
        design.setForeground(Color.black);
        design.setBounds(1,140+50,300,20);
        a.add(design);
       
        //for fridge&ac
        
       fri_label.setBounds(1,10,160,20);
       fridge.setBounds(25,50,50,40);
       b.add(fri_label);
       fridge.addActionListener(this);
       b.add(fridge); 
       AC.setBounds(95,50,50,40);
       AC.addActionListener(this);
       b.add(AC);
       ac_slider.setBounds(15,110,150,30);
       b.add(ac_slider);
       //tv
       tvlbl.setBounds(1,145,160,20);
       tv_button.setBounds(15,175,45,50);
       tv_button.addActionListener(this);
       door_status.setBounds(100,175,45,50);
       door_status.addActionListener(this);
       b.add(door_status);
       b.add(tvlbl);
       b.add(tv_button);
       
     
       
       notification.add(noti);
       search.add(g_search);
       
       
       
       
       //house status
//       house1.setBounds(70,5,200,30);
       //house.add(house1);     
       house.setForeground(Color.WHITE);
       memberin_status.setBounds(5,50,110,40);
       memberin_status.setForeground(Color.red);
       memberin.setBounds(120,50,50,30);
       memberin.setBackground(Color.GRAY);
       memberout_status.setBounds(5,110,110,40);
       memberout_status.setForeground(Color.red);
       memberout.setBounds(120,110,50,30);
       memberout.setBackground(Color.GRAY);
       /*house.add(memberin);
       house.add(memberin_status);
       house.add(memberout);
       house.add(memberout_status);*/
      div.setBounds(1,165,300,20);
      div.setForeground(Color.white);
     lbltmp_status.setBounds(1,5,100,40);
       lbltmp_status.setForeground(Color.red);
      
       c.add(div);
     
       
       div1.setBounds(1,280,300,20);
      div1.setForeground(Color.white);
      lbldoor_status.setBounds(25,5,200,40);
       lbldoor_status.setForeground(Color.red);
       //door_status.setBounds(27,65,140,30);
       //door_status.setBackground(Color.GRAY);
       c.add(div1);
       //house3.add(door_status);
       house3.add(lbldoor_status);
        //login
        log.setBounds(115,5,200,30);
        log.setText("LOGIN");
        log.setForeground(Color.red);
        log.setFont(new Font("Courier New", Font.BOLD,30));
        usr_log.setBounds(30,105,130,30);
        adm_log.setBounds(190,105,130,30);
        login.add(adm_log);
        usr_log.addActionListener(this);
        adm_log.addActionListener(this);
        login.add(usr_log);
        login.add(log);
        
        //cctv
        lblcctv.setBounds(1,1,400,30);
        lblcctv.setForeground(Color.red);
        cctv.add(lblcctv);
       
       //websearch
       weblbl.setBounds(1,1,400,30);
       weblbl.setForeground(Color.red);
       search.add(weblbl);
       google_button.setBounds(30,40,50,50);
       gmail_button.setBounds(150,40,50,50);
       youtube_button.setBounds(280,40,50,50);
       search.add(google_button);
       search.add(gmail_button);
       search.add(youtube_button);
       google_button.addActionListener(this);
       gmail_button.addActionListener(this);
       youtube_button.addActionListener(this);
       
       
       
       
       //notifications
       noti_title.setBounds(70,5,200,30);
       
       noti_title.setForeground(Color.YELLOW);
       noti_disp.setBounds(10,35,240,155);
       noti_disp.setBackground(Color.white);
       
       
       noti_disp.setForeground(Color.black);
       noti_disp.setFont(new Font("Verdana", Font.BOLD,11));
       notification.add(noti_title); 
       notification.add(noti_disp);
      
       
       
      //musicplayer
      musicplayer.setBounds(70,1,200,30);
      select_song.setBounds(40,45,50,50);
      play_all.setBounds(130,45,100,40);
      song_name.setBounds(5,100,270,30);
      song_name.setForeground(Color.white);
      song_name.setHorizontalTextPosition(AC.CENTER);
      music_play.setBounds(10,150,70,30);
      music_pause.setBounds(105,150,70,30);
      music_stop.setBounds(200,150,70,30);
      forward.setBounds(156,210,70,30);
      backward.setBounds(50,210,70,30);
      vol_lbl.setBounds(15,255,30,30);
      volume.setBounds(65,260,150,20);
      musicplayer.setForeground(Color.red);
      musicplayer.setFont(new Font("Arial", Font.BOLD, 20));
      music2.add(musicplayer);
      music2.add(vol_lbl);
      music2.add(volume);
      music2.add(music_play);
      music2.add(music_pause);
      music2.add(music_stop);
      music2.add(forward);
      music2.add(backward);
      music2.add(song_name);
      music2.add(select_song);
      music2.add(play_all);
      play_all.addActionListener(this);
      music_play.addActionListener(this);
        music_pause.addActionListener(this);
          music_stop.addActionListener(this);

      select_song.addActionListener(this);
      forward.addActionListener(this);
      backward.addActionListener(this);
      
      //picslider
      pic_lbl.setBounds(1,1,250,40);
      pic_lbl.setForeground(Color.red);
      picslider.setBounds(10,45,250,250);
      pic.add(pic_lbl);
      pic.add(picslider);
      
       //clock
      
      
      

      clock.setBounds(10,10,300,160);
    clock.setFont(new Font("Arial",Font.BOLD,60));
    clock.setForeground(Color.red);
    mainpanel.setLayout(null);
     
       
       
       
       j.setLayout(null);
       mainpanel.setSize(j.getSize());
        
       j.getContentPane().add(mainpanel);
       mainpanel.add(a);
       mainpanel.add(b);
       mainpanel.add(weather_temp);
       mainpanel.add(wind_data);
          mainpanel.add(gust_data);
       mainpanel.add(jp);
       
       mainpanel.add(clock);
       mainpanel.add(c);
       mainpanel.add(cctv);
       mainpanel.add(login);
       mainpanel.add(pic);
      mainpanel.add(search);
      mainpanel.add(door_show);
      mainpanel.add(notification);
     mainpanel.add(music2);
     mainpanel.add(house);
     mainpanel.add(house2);
     mainpanel.add(house3);
     mainpanel.add(mus_btn);
     mainpanel.add(power_btn);
     mainpanel.add(cctv_btn);
     mainpanel.add(login_btn);
     mainpanel.add(internet_btn);
     mainpanel.add(noti_popup);
     //mainpanel.add(face_btn);
     //setting visiblity of panle
     music2.setVisible(false);
     a.setVisible(false);
     b.setVisible(false);
     login.setVisible(false);
     cctv.setVisible(false);
     search.setVisible(false);
     notification.setVisible(false);
     
   
     house3.setVisible(false);
        //j.pack();
         j.setVisible(true);
    
    }
    
   Thread vol=new Thread(){
    @Override
    public void run() {
        while (true) {
            
            new SoundVolume();
           
        }}} ;
    Thread th5= new Thread(){
            @Override
            public void run() {
                
                try {
                    new slide_show();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }};
    
    Thread th1=new Thread(){
    @Override
    
    public void run() {
    try {
    while (true) {
    
    Calendar cal = Calendar.getInstance();
    hours = cal.get( Calendar.HOUR_OF_DAY );
    if ( hours > 12 ) hours -= 12;
    minutes = cal.get( Calendar.MINUTE );
    seconds = cal.get( Calendar.SECOND );
    
    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
    Date date = cal.getTime();
    timeString = formatter.format( date );
    
    t.sleep( 1000 );  // interval given in milliseconds
     clock.setText(timeString);
    
   
    
    }
    }
    catch (Exception e) { }
    
    }}  ;
    Thread th2=new Thread(){
    @Override
    public void run() {
        while (true) {
            try {
                new DetectFace();
            } catch (IOException ex) {
                Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }}} ;
     
   Thread noti_thread=new Thread(){
    @Override
    public void run() {
        
        while (true) {
            if(noti_seen==false){
           new setnotification();
            if(setnotification.found==true)
            {
             noti_popup.setVisible(true);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
                }
            noti_popup.setVisible(false);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
            }}
        }}} ;  
    
   Thread d_thread=new Thread(){
    @Override
    public void run() {
        
        while (true) {
            if(door_status.getIcon()==door_open)
            {
             door_show.setVisible(true);
               
                try {
                    Thread.sleep(2000);
                    door_show.setVisible(false);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        }}} ;  
    
    
    int state;
    boolean flag=true;
    @Override
    
    public void actionPerformed(ActionEvent e) {
      
       if(e.getSource()==mus_btn)
       {
           if(music2.isVisible()==true)
       music2.setVisible(false);
           else
       music2.setVisible(true);        
       
       }
        if(e.getSource()==login_btn)
       {
           if(login_frame.isVisible()==true)
           login_frame.setVisible(false);
           else
           login_frame.setVisible(true);
           
           
           
       }
       
        if(e.getSource()==power_btn)
       {
       if(a.isVisible()==true)
       {
       a.setVisible(false);
       b.setVisible(false);
       }   else
       {
           a.setVisible(true);    
       b.setVisible(true);
       }
       }
        
         if(e.getSource()==internet_btn)
       {
       if(search.isVisible()==true)
       search.setVisible(false);
           else
       search.setVisible(true);    
       
       }
        
        
         if(e.getSource()==cctv_btn)
       {
       if(cctv.isVisible()==true)
       cctv.setVisible(false);
           else
       cctv.setVisible(true);    
       
       }
        
        if(e.getSource()==noti_del){
        new destroy_msg();
        }
        if(e.getSource()==music_play)
        {
            if(state==1)
            th3.stop();
           th3=new Thread(){
   
   
    public void run() {
        new music_start();
        
    }} ;
            th3.start();
      state=1;
        }
        if(e.getSource()==music_stop)
        {
          
         th3.stop();
            
        }
        if(e.getSource()==music_pause)
        {
           if(flag==true)
           {
            th3.suspend();
            flag=false;
           }
           else
           {
           th3.resume();
           flag=true;
           }
        }
        if(e.getSource()==play_all)
        {
            new folderchooser();
        new add_all();
        }
        if(e.getSource()==forward)
        {
            if(state==1)
            th3.stop();
        song_num=song_num+1;
        new allsongsplay();
        th3=new Thread(){
   
   
    public void run() {
        new music_start();
        
    }} ;
            th3.start();
            state=1;
      
        }
        
        if(e.getSource()==backward)
        {
            if(state==1)
            th3.stop();
        song_num=song_num-1;
        new allsongsplay();
        th3=new Thread(){
   
   
    public void run() {
        new music_start();
        
    }} ;
            th3.start();
            state=1;
      
        }
        
       
       
        if(e.getSource()==select_song)
        {
           new chooser();
           
        }
        //web
        if(e.getSource()==google_button)
        {
        SwingUtilities.invokeLater(new Runnable() {  
            @Override
            public void run() {  
                final JFrame frame = new JFrame();  
                 
                frame.getContentPane().add(new google());  
                 
                frame.setMinimumSize(new Dimension(640, 480));  
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                frame.setVisible(true);  
            }  
        });     
        }
        if(e.getSource()==youtube_button)
        {
        SwingUtilities.invokeLater(new Runnable() {  
            @Override
            public void run() {  
                final JFrame frame = new JFrame();  
                 
                frame.getContentPane().add(new youtube());  
                 
                frame.setMinimumSize(new Dimension(640, 480));  
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                frame.setVisible(true);  
            }  
        });     
        }
        
        if(e.getSource()==fan1)
        {
           try {
               if(fan1_value==10){fan1_value=11;fan1.setIcon(powerup);}
               else if(fan1_value==11){fan1_value=10;fan1.setIcon(power_low);}
               set_value=fan1_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        
        if(e.getSource()==fan2)
        {
           try {
               if(fan2_value==20){fan2_value=21;fan2.setIcon(powerup);}
               else if(fan2_value==21){fan2_value=20;fan2.setIcon(power_low);}
               set_value=fan2_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        
         if(e.getSource()==lig1)
        {
           try {
               if(lig1_value==30){lig1_value=31;lig1.setIcon(powerup);}
               else if(lig1_value==31){lig1_value=30;lig1.setIcon(power_low);}
               set_value=lig1_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
         
          if(e.getSource()==lig2)
        {
           try {
               if(lig2_value==40){lig2_value=41;lig2.setIcon(powerup);}
               else if(lig2_value==41){lig2_value=40;lig2.setIcon(power_low);}
               set_value=lig2_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
          
           if(e.getSource()==fridge)
        {
           try {
               if(fridge_value==50){fridge_value=51;}
               else if(fridge_value==51){fridge_value=50;}
               set_value=fridge_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        
             if(e.getSource()==tv_button)
        {
           try {
               if(tv_value==60){tv_value=61;}
               else if(tv_value==61){tv_value=60;}
               set_value=tv_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
              if(e.getSource()==door_status)
        {
           try {
               if(door_value==70){door_value=71;door_status.setIcon(door_open);door_show.setIcon(door_open1);}
               else if(door_value==71){door_value=70;door_status.setIcon(door_close);door_show.setIcon(door_close1);}
               set_value=door_value;
               new switch_control.switches();
               
           } catch (InterruptedException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main (String a[])
    {
     
    new Smarthome();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(e.getSource()==noti_popup)
    {
    notification.setVisible(true);
    }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     if(e.getSource()==noti_popup)
    {
    notification.setVisible(true);
    }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if(e.getSource()==noti_popup)
    {
    notification.setVisible(true);
    }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(e.getSource()==noti_popup)
    {
    notification.setVisible(false);
    noti_seen=true;
    }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
         
}

 