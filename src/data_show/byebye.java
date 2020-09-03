/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_show;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import static java.awt.Event.DOWN;
import java.awt.Font;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import smarthome.ImagePanelframe;

/**
 *
 * @author Root
 */
public class byebye {
    JProgressBar jp=new JProgressBar(0, 100);
   ImagePanelframe noti_panel = new ImagePanelframe(new ImageIcon(System.getProperty("user.dir")+"\\png\\editied.jpg").getImage());
       JLabel heading=new JLabel("Destroying program");
       JFrame j=new JFrame("SHUTING DOWN");
   JLabel status=new JLabel("BYE Bye..",SwingConstants.CENTER);
   public byebye() throws InterruptedException
   {
       th2.start();
       j.setUndecorated(true);
        AWTUtilities.setWindowOpacity(j, 0.8f);
       j.setBounds(380,200,430,430);
       j.setLayout(null);
        j.setUndecorated(true);
        j.getRootPane().setBorder(BorderFactory.createMatteBorder(10,5,5,5,Color.GRAY));
        
        //noti_panel.setBounds(800,200,430,430);
        j.add(noti_panel);
        heading.setBounds(31,55,400,40);
        heading.setFont(new Font("Courier New", Font.BOLD,30));
        status.setFont(new Font("Courier New", Font.BOLD,45));
        jp.setBounds(30,140,370,35);
        noti_panel.add(jp);
        noti_panel.add(heading);
        j.setVisible(true);
        
         status.setBounds(30,200,370,50);
         noti_panel.add(status);
         jp.setForeground(Color.GREEN);
   }
    public static void main(String[] args) throws InterruptedException {
        new byebye();
    
    }
    
    
    
     Thread th2=new Thread(){
    @Override
    public void run() {
        
    for(int i=1;i<100;i++)
        {
            if(jp.getValue()<=80)
                status.setText(Integer.toString(i)+"%");
        jp.setValue(i);
        if(jp.getValue()>=50){
            jp.setForeground(Color.YELLOW);
        status.setForeground(Color.YELLOW);
        }
        if(jp.getValue()>=80)
        {   jp.setForeground(Color.RED);
        status.setForeground(Color.RED);
        status.setText("Bye Bye....");
        try {  
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
              DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home;user=root;password=toor;shutdown=true");
         // System.exit(DOWN);
        } catch (Exception ex) {
            Logger.getLogger(byebye.class.getName()).log(Level.SEVERE, null, ex);
        }
        j.dispose();
        System.exit(0);
        }
        jp.setBorderPainted(true);
        jp.setString(Integer.toString(i)+"%");
        
        try {
            Thread.sleep(1000/30);
        } catch (InterruptedException ex) {
            Logger.getLogger(byebye.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
       
      
      
    }} ;
    
}
