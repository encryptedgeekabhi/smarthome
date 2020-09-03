/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_show;

import Login.user_register;
import aboutus.*;
import data_show.*;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import notification.add;
import smarthome.Button;
import static smarthome.Button.*;
import smarthome.ImagePanelframe;
import static smarthome.Label.smrt_img;
import static smarthome.Panel.adminmenu_frame;
import static smarthome.Panel.usersetting_menu;
import smarthome.RoundButton;

/**
 *
 * @author Root
 */
public class main_visual  implements ActionListener{
   
    JLabel lab=new JLabel("Customization Window",SwingConstants.CENTER);
    
    JButton back;
   int prey,prex;
   JLabel selectedLabel;
   boolean check=true;
   String a=null;
 user_register reg=new user_register();
        delete_user del =new delete_user();
        find1 find1=new find1();
    public main_visual(final String[] args){
       
        //adminmenu_frame.setAlwaysOnTop(true);
        
        new add();
        
        adminmenu_frame.setIconImage(smrt_img.getImage());
        lab.setFont(new Font("Courier New", Font.BOLD,20));
        lab.setForeground(Color.WHITE);
        adminmenu_frame.setTitle("INTERNAL DATA MANNAGER WINDOW");
        adminmenu_frame.setUndecorated(true);
       
        adminmenu_frame.setBounds(50,20,1275,670);
         ImagePanelframe detailwindow = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\edit.jpg").getImage());
       adminmenu_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.gray));
        
        
        
        adminmenu_frame.setLayout(null);
        
        ImagePanelframe panel = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\admin_login_pic.jpg").getImage());
        
        adminmenu_frame.getContentPane().add(panel);
        
        
        
        final MouseAdapter ma = new MouseAdapter() {
             //Clicked label.
            private Point selectedLabelLocation = null; //Location of label in panel when it was clicked.
            private Point panelClickPoint = null; //Panel's click point.

            //Selection of label occurs upon pressing on the panel:
            boolean value=true;
            int x,y;
            @Override
            public void mousePressed(final MouseEvent e) {

                //Find which label is at the press point:
                final Component pressedComp = panel.findComponentAt(e.getX(), e.getY());
                
                //If a label is pressed, store it as selected:
                if (pressedComp != null && pressedComp instanceof JLabel) {
                    
                   selectedLabel = (JLabel) pressedComp;
                    selectedLabelLocation = selectedLabel.getLocation();
                    if(value==true){
                   prex=selectedLabelLocation.x;
                   prey=selectedLabelLocation.y;
                    }
                    value=false;
                    panelClickPoint = e.getPoint();
                    //Added the following 2 lines in order to make selectedLabel
                    //paint over all others while it is pressed and dragged:
                   panel.setComponentZOrder(pressedComp,0);
                    selectedLabel.repaint();
                    
                }
                else {
                  
                    selectedLabel = null;
                    selectedLabelLocation = null;
                    panelClickPoint = null;
                }
            }

            //Moving of selected label occurs upon dragging in the panel:
            @Override
            public void mouseDragged(final MouseEvent e) {
                if (selectedLabel != null
                        && selectedLabelLocation != null
                        && panelClickPoint != null) {

                    final Point newPanelClickPoint = e.getPoint();

                    //The new location is the press-location plus the length of the drag for each axis:
                    final int newX =selectedLabelLocation.x + (newPanelClickPoint.x - panelClickPoint.x),
                              newY = selectedLabelLocation.y + (newPanelClickPoint.y - panelClickPoint.y);

                    selectedLabel.setLocation(newX, newY);
                    
                    selectedLabel.getName();
                    a=selectedLabel.getName();
                    System.out.println(selectedLabel.getText());
                    System.out.println(selectedLabel.getLocation());
                    
                }
                
                
                if(a.equalsIgnoreCase("noti")||a.equalsIgnoreCase("setting")||a.equalsIgnoreCase("cctv")||a.equalsIgnoreCase("user")||a.equalsIgnoreCase("close")){
                del.setVisible(false);
                    reg.setVisible(false);
                user_add_button.setVisible(false);
        user_all_button.setVisible(false);
        user_del_button.setVisible(false);
        user_update_button.setVisible(false);
        noti_frame.setVisible(false);
        find1.setVisible(false);
                    
                    if(selectedLabel.getLocation().x>=500){
                    System.out.println(a);
                    if(a.equalsIgnoreCase("noti")){
                        detailpos.setVisible(false);
                        System.out.println("opened");
                       noti_frame.setVisible(true);
                    }
                    if(a.equalsIgnoreCase("close")){
                        adminmenu_frame.setVisible(false);
                        try {
                            
                            new byebye();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(main_visual.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(a.equalsIgnoreCase("setting")){
                        detailpos.setVisible(false);
                       new settings();
                       
                    }
                    if(a.equalsIgnoreCase("cctv")){
                        
                       new video_list();
                       
                    }
                    if(a.equalsIgnoreCase("user")){
                        //System.out.println("opened");
                        user_add_button.setVisible(true);
        user_all_button.setVisible(true);
        user_del_button.setVisible(true);
        user_update_button.setVisible(true);
                    }
                    
                        selectedLabel.setLocation(prex,prey);
                        value=true;        
                    }}
                
                
                if(a.equalsIgnoreCase("uadd")||a.equalsIgnoreCase("udel")||a.equalsIgnoreCase("uupd")||a.equalsIgnoreCase("uall")){
                detailpos.setVisible(false);
                if(selectedLabel.getLocation().x>=800)
                {
                    del.setVisible(false);
               new  find1().setVisible(false);
                reg.setVisible(false);
                if(a.equalsIgnoreCase("uadd")){
                
                
                reg.setVisible(true);
                    //System.out.println("register");
                }
                if(a.equalsIgnoreCase("udel")){
                
                find1.setVisible(false);
                reg.setVisible(false);
                del.setVisible(true);
                    //System.out.println("register");
                }
                if(a.equalsIgnoreCase("uupd")){
                        System.out.println("opened");
                    find1.setVisible(true);
                    reg.setVisible(false);
                     del.setVisible(false);
                    }
                selectedLabel.setLocation(prex,prey);
                        value=true;   
                     //detailpos.setVisible(true);
                }
                
                }
                if(selectedLabel.getLocation().x<prex ||selectedLabel.getLocation().y<prey){
                        
                        selectedLabel.setLocation(prex,prey);
                        value=true;
                    }
                
                
            }
            
           
        };
        
        panel.addMouseMotionListener(ma); //For mouseDragged().
        panel.addMouseListener(ma); //For mousePress
        
    
//adminmenu_frame.setAlwaysOnTop(true);
        //adminmenu_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.black));
        
        
        
        lab.setBounds(1,1,1100,30);
         
        panel.add(lab);
       // jf.add(lab1);
        cctv_button.setBounds(250,70,80,80);
        cctv_button.setIcon(cctvimg);
        cctv_button.setName("cctv");
        panel.add(cctv_button);
        setting_button.setBounds(175,190,80,80);
        setting_button.setIcon(settingimg);
        setting_button.setName("setting");
        panel.add(setting_button);
        noti_button.setBounds(120,310,80,80);
        noti_button.setIcon(notiimg);
        noti_button.setName("noti");
        panel.add(noti_button);
        
        user_button.setBounds(175,430,80,80);
        user_button.setIcon(userimg);
        user_button.setName("user");
        panel.add(user_button);
       
        close_button.setBounds(250,550,80,80);
        close_button.setIcon(closeimg);
        close_button.setName("close");
        
        panel.add(close_button);
        
      main_visual_back.setBounds(20,20,100,100);
        panel.add(main_visual_back);
        main_visual_back.addActionListener(this);
        
        
        
        user_add_button.setBounds(500,130,70,70);
        panel.add(user_add_button);
        user_add_button.setName("uadd");
        user_del_button.setBounds(500,240,70,70);
        panel.add(user_del_button);
        user_del_button.setName("udel");
        user_update_button.setBounds(500,350,70,70);
        user_update_button.setName("uupd");
        panel.add(user_update_button);
        user_all_button.setName("uall");
        
        user_all_button.setBounds(500,460,70,70);
        panel.add(user_all_button);
        user_add_button.setVisible(false);
        user_all_button.setVisible(false);
        user_del_button.setVisible(false);
        user_update_button.setVisible(false);
      //  panel.setBounds(350,50,200,620);
     //adminmenu_frame.add(panel1);   
        //back to main screen
        /* back=new JButton("LOG-OUT CONTROL");
        back.setBounds(345,220,300,30);
        panel.add(back);
        back.addActionListener(this);
        noti_button.addActionListener(this);
        adminmenu_frame.setVisible(true);
        */
        detailpos.setBounds(700,50,470,570);
        detailpos.setText("Drag here");
        detailpos.setBackground(new Color(0,0,0,65));
        detailpos.setForeground(Color.green);
        panel.add(detailpos);
        //adminmenu_frame.setVisible(true);
    } 
       public static void main(String[] args) {
        new main_visual(args );
    }

    @Override
    public void actionPerformed(ActionEvent efg) {
if(efg.getSource()==main_visual_back)
{
adminmenu_frame.setVisible(false);
 del.setVisible(false);
                    reg.setVisible(false);
                user_add_button.setVisible(false);
        user_all_button.setVisible(false);
        user_del_button.setVisible(false);
        user_update_button.setVisible(false);
        noti_frame.setVisible(false);
        find1.setVisible(false);

}
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
       

}

