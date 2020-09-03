package Login;
import static Login.admin_login.curr_user;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import static smarthome.Button.login_continue;
import static smarthome.Button.login_submit;

import static smarthome.Button.user_id_box;
import static smarthome.Label.jLabel1;
import smarthome.Panel;

/**
 *
 * @author Root
 */
public class admin_pass implements ActionListener{
   
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel3;
    JPasswordField user_pass=new JPasswordField();
   private JFrame pass_frame=new JFrame();
    
    
    private JPanel jPanel1=new JPanel();
    public admin_pass()
    {
       
        
        jPanel1.setLayout(null);
        pass_frame.setUndecorated(true);
        pass_frame.setLayout(null);
       // login_frame.setBackground(new Color(0,0,0,125));
       jPanel1.setBackground(new Color(0,0,0,125));
        jLabel2 = new javax.swing.JLabel("welcome "+curr_user,SwingConstants.CENTER);
         jLabel3 = new javax.swing.JLabel("Secret Key : ",SwingConstants.CENTER);        
        jLabel2.setForeground(Color.red);
        jLabel1.setForeground(Color.WHITE);
        jLabel3.setForeground(Color.red);
        pass_frame.setBackground(new Color(0, 0, 0,65));
        jPanel1.setBorder(new BevelBorder(1, Color.GREEN, Color.lightGray));
        jLabel1.setFont(new Font("Arial",Font.BOLD, 15));
        jLabel5 = new javax.swing.JLabel();
       ImageIcon img= new javax.swing.ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\loggeduser.png").getImage().getScaledInstance(125, 120, Image.SCALE_DEFAULT)); // NOI18N
        if(img.getIconWidth()<=0)
        jLabel5.setIcon(new javax.swing.ImageIcon(new ImageIcon(System.getProperty("user.dir")+"\\png\\edit.jpg").getImage().getScaledInstance(125, 120, Image.SCALE_DEFAULT))); // NOI18N
        else
        jLabel5.setIcon(img);
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5,Color.BLUE));
        pass_frame.setUndecorated(true);
        AWTUtilities.setWindowOpacity(pass_frame, 0.4f);
       
        
        
        pass_frame.setBounds(250,200,300,300);
        jLabel1.setBounds(1,1,295,30);
        jLabel2.setBounds(10,155,200,40);
        jLabel3.setBounds(10,205,100,30);
        user_pass.setBounds(120,205,150,30);
        login_submit.addActionListener(this);
        jLabel5.setBounds(90,40,120,120);
        
        
        
        user_pass.setBorder(new BorderUIResource.LineBorderUIResource(Color.black, 2));
        
        login_submit.setBounds(50,260,200,30);
        jPanel1.setBounds(1,1,295,300);
        pass_frame.add(jPanel1);
       
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel1);
        jPanel1.add(login_submit);
        jPanel1.add(user_pass);
    pass_frame.setVisible(true);
}
    public static void main(String[] args) {
        new admin_pass();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        try{  
             
             String pass=user_pass.getText();
             String user=curr_user;
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");  
                 Connection    con= DriverManager.getConnection("jdbc:derby:"+System.getProperty("user.dir")+"\\db\\s_home","root","toor");
    String query="select * from login where name = '" + user +"' and password='"+pass+"'";
              PreparedStatement ps=con.prepareStatement(query);
                 
                 //Statement stmt=con.createStatement();   
                 ResultSet rs=ps.executeQuery();
        
       

if(rs.next())
{
   
 pass_frame.setVisible(false);
 smarthome.Panel.adminmenu_frame.setVisible(true);
 ps.close();
 con.close();
}
else
{
user_pass.setText("Invalid ID/Type");
user_pass.setForeground(Color.red);
}

        }
 catch(Exception ee){
            ee.printStackTrace();
        }
    }
}