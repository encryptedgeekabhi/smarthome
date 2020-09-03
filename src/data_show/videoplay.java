package data_show;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

    public class videoplay {

        private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

        public static void main(final String[] args) {
          
         
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new videoplay();
                }
            });
        }

        public videoplay() {
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
         Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
            JFrame frame = new JFrame("vlc");

            mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

            frame.setContentPane(mediaPlayerComponent);
            frame.setAlwaysOnTop(true);
            frame.setBounds(800,200,430,430);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            mediaPlayerComponent.getMediaPlayer().playMedia(video_list.video_name);
            
        }
    }