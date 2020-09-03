package musicplayer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


public class music_start {
    public static int a;
public Player player;
     public music_start()
    {
 
    try {
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(chooser.link));
     
     player=new Player(buffer);
   
      player.play();
     
    } catch (Exception e) {
        System.out.println(e);
    }}
    
    public static void main(String[] args) {
        new music_start();
    }
 
     
     
}