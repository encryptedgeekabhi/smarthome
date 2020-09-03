/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;
import static smarthome.Button.volume;
import static smarthome.Label.vol0;
import static smarthome.Label.vol1;
import static smarthome.Label.vol_lbl;

public class SoundVolume 
{

    public SoundVolume() 
{        
    Info source = Port.Info.SPEAKER;
    //        source = Port.Info.LINE_OUT;
    //        source = Port.Info.HEADPHONE;

        if (AudioSystem.isLineSupported(source)) 
        {
            try 
            {
                Port outline = (Port) AudioSystem.getLine(source);
                outline.open();                
                FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);                
             
                volumeControl.setValue(volume.getValue()/100f);
                if(volume.getValue()/100f<0.1f)
                vol_lbl.setIcon(vol0);
                else
                    vol_lbl.setIcon(vol1);
            }   
            catch (LineUnavailableException ex) 
            {
                System.err.println("source not supported");
                ex.printStackTrace();
            }            
        }
    } 

 }
