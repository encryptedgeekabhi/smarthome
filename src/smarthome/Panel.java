package smarthome;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Root
 */
public interface Panel {
    JFrame usersetting_menu=new JFrame();
    JFrame adminlogin_frame=new JFrame();
        JFrame adminmenu_frame=new JFrame();
         JFrame j=new JFrame("Smarthome");
        JPanel cctv=new JPanel();
        JPanel house=new JPanel();
        JPanel house2=new JPanel();
        JPanel house3=new JPanel();
        JPanel search=new JPanel();
        JPanel login=new JPanel();
      
        JPanel music = new JPanel();
        JPanel notification = new JPanel();
        JPanel power=new JPanel();
        JPanel music2=new JPanel();
        JPanel pic=new JPanel();
        JPanel a=new JPanel();
        JPanel b=new JPanel();
        JPanel c=new JPanel();
        JPanel adm_login=new JPanel();
        ImagePanelframe mainpanel = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\A.jpg").getImage());
        
       }
