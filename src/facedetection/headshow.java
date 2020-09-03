/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facedetection;

import data_show.total_user;
import javax.swing.JLabel;
import static smarthome.Label.noface_img;
import static smarthome.Label.yesface_img;
import static smarthome.Panel.house;

/**
 *
 * @author Root
 */
public class headshow {
    public headshow()
    {
    JLabel head[]=new JLabel[total_user.total_member];
           int x=1;
        for(int i=0;i<total_user.total_member;i++)
                {
                    head[i]=new JLabel();
                    if(i<=facedetection.DetectFace.num_face)
                    head[i].setIcon(yesface_img);
                    else
                    head[i].setIcon(noface_img);    
                head[i].setBounds(x,50,30,30);
                x=x+25;
                house.add(head[i]);
                }
    
    }
    public static void main(String[] args) {
        new headshow();
    }
}
