/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_show;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author Root
 */
public class video_list implements ActionListener,MouseListener{
public static String video_name=null;
     JFrame jf=new JFrame("CCTV-VIDEOS");
 
     private JPanel Pnl = new JPanel();
      private JScrollPane Scrl = new JScrollPane(Pnl,
      ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      final JPopupMenu popupMenu = new JPopupMenu();
     JMenuItem Item2 = new JMenuItem("Delete");
     JMenuItem Item1 = new JMenuItem("View"); 
int total_file=0;
     public video_list()
{
    
      
      
      popupMenu.add(new JPopupMenu.Separator());
      
      popupMenu.add(Item1);
      popupMenu.add(Item2);
      Item1.addActionListener(this);
      Item2.addActionListener(this);
       
    
    File file = new File(System.getProperty("user.dir")+"\\cctvvideo");
        File[] files = file.listFiles();
        File[] files2 = file.listFiles();
        System.out.println(files2.length);
    for(File f: files){
           total_file++; 
        }
    JButton[] labels=new JButton[total_file];
jf.setBounds(800,200,475,430);

Pnl.setLayout(null);
jf.setLayout(new GridLayout());
Scrl.setLayout(new ScrollPaneLayout());
//jf.getContentPane().setBackground(new Color(33,97,140));


//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
             
              jf.add(Scrl);
              
int a=1;
int i=1;
int y=5;

        
while (a<=total_file/4)
{
    int x=5;
    int b=1;
while(b<5)
{
   if(total_file==i)
       break;
    labels[i]=new JButton();
    labels[i].setBounds(x,y,100,100);
    
    Pnl.add(labels[i]);
    i++;
    x=x+110;
    
b++;
}
y=y+120;
a++;
}    
int num=1;
for(File fi: files2){
    System.out.println(num);
    if(num>=total_file-2)
    {
    //System.out.println(num);
    break;
    }
         labels[num].setText(fi.getName());
         labels[num].setToolTipText(fi.getName());
         labels[num].setName(fi.getName());
         labels[num].addActionListener(this);
         labels[num].addMouseListener(this);
        num=1+num;
        System.out.println(num);
         }




jf.setVisible(true);
}
   public static void main(String[] args) {
    
   new video_list();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==Item1){
    //video_name=System.getProperty("user.dir")+"\\cctvvideo\\"+e.getActionCommand();
    new videoplay();
        System.out.println(e.getActionCommand());
      }
      if(e.getSource()==Item2){
    
    
    
        File f=new File(video_name);
        f.delete();
        jf.dispose();
        new video_list();
      }
      
     
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e1) {
        if (SwingUtilities.isRightMouseButton(e1) )
        {
         video_name=System.getProperty("user.dir")+"\\cctvvideo\\"+e1.getComponent().getName();   
           // System.out.println(video_name);
            
        popupMenu.show(Pnl,e1.getX(), e1.getY());
        }        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
