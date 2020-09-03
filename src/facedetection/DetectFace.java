/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facedetection;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static javafx.util.Duration.hours;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;
import smarthome.*;
import static smarthome.Button.memberin;
import static smarthome.Label.head_show;
import static smarthome.Label.noface_img;
import static smarthome.Label.yesface_img;

public class DetectFace implements Panel,Label{
public static String numberofface;
public static int num_face;
	static JFrame frame;
	static JLabel lbl;
	static ImageIcon icon;
 
	
	public DetectFace() throws IOException{
            File dir = new File(System.getProperty("user.dir")+"\\cctvvideo");
        boolean di=dir.mkdirs();
            System.out.println(di);
            long millis=System.currentTimeMillis();  
             java.sql.Date  d=new java.sql.Date(millis);  
             Calendar cal = Calendar.getInstance();
             int hours = cal.get( Calendar.HOUR_OF_DAY );
    
   int minutes = cal.get( Calendar.MINUTE );
   int seconds = cal.get( Calendar.SECOND );
    
             SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
    String videoname = formatter.format( d )+"-"+Integer.toString(hours)+Integer.toString(minutes)+Integer.toString(seconds);
    
            System.out.println(videoname);
            //System.setProperty("java.library.path","C:\\opencv\\opencv\\build\\java\\x64");
        System.loadLibrary("opencv_java340");

		CascadeClassifier cascadeFaceClassifier = new CascadeClassifier(System.getProperty("user.dir")+"\\OpenCvObjectDetection-master\\data\\haarcascade files\\haarcascade_frontalface_default.xml");
		//CascadeClassifier cascadeEyeClassifier = new CascadeClassifier(
		//		"C:\\Users\\Root\\Videos\\png\\OpenCvObjectDetection-master\\data\\haarcascade files\\haarcascade_eye.xml");
		
		//CascadeClassifier cascadeNoseClassifier = new CascadeClassifier(
		//		"C:\\Users\\Root\\Videos\\png\\OpenCvObjectDetection-master\\data\\haarcascade files\\haarcascade_mcs_nose.xml");
	    //CascadeClassifier cascadeMouthClassifier = new CascadeClassifier("OpenCV/haarcascades/haarcascade_mcs_mouth.xml"); haarcascade_mcs_mouth on 2.4.11
		//Varsayylan kamera aygytyny ba?lat
		VideoCapture videoDevice = new VideoCapture();
                int fourcc = VideoWriter.fourcc('m','j','p','g');
		videoDevice.open(0);
                
                Size frameSize = new Size((int) videoDevice.get(Videoio.CAP_PROP_FRAME_WIDTH),(int) videoDevice.get(Videoio.CAP_PROP_FRAME_HEIGHT));
                 
                VideoWriter writer = new VideoWriter(System.getProperty("user.dir")+"\\cctvvideo\\"+videoname+".avi", fourcc, 5, frameSize, true);

		if (videoDevice.isOpened()) {
	
			while (true) {		
				Mat frameCapture = new Mat();
				videoDevice.read(frameCapture);
				Mat f = frameCapture.clone();
            Imgproc.putText(f, (clock.getText() ), new Point(10,50), Core.FONT_HERSHEY_PLAIN, 2, new Scalar(200,0,0),3);
            writer.write(f);
		
				MatOfRect faces = new MatOfRect();
				cascadeFaceClassifier.detectMultiScale(frameCapture, faces);								
			
				for (Rect rect : faces.toArray()) {
					
					Imgproc.putText(frameCapture, "Face", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));								
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(0, 100, 0),3);
				}
				
				
				//MatOfRect eyes = new MatOfRect();
				/*cascadeEyeClassifier.detectMultiScale(frameCapture, eyes);
				for (Rect rect : eyes.toArray()) {
					//Sol üst kö?esine metin yaz
					Imgproc.putText(frameCapture, "Eye", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));				
					//Kare çiz
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(200, 200, 100),2);
				}

				MatOfRect nose = new MatOfRect();
				cascadeNoseClassifier.detectMultiScale(frameCapture, nose);
				for (Rect rect : nose.toArray()) {
				
					Imgproc.putText(frameCapture, "Nose", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));				
				
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(50, 255, 50),2);
				}
				
				
			   MatOfRect mouth = new MatOfRect();
				cascadeMouthClassifier.detectMultiScale(frameCapture, mouth);
				for (Rect rect : mouth.toArray()) {
					
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(129, 90, 50),2);
				}
				
				*/
				
			
				PushImage(ConvertMat2Image(frameCapture));
                                num_face=faces.toArray().length;
                                for(int i=0;i<data_show.total_user.total_member;i++)
                                {
                                    if(i<num_face)
                    head_show[i].setIcon(yesface_img);
                    else
                    head_show[i].setIcon(noface_img); 
                                
                                }
				numberofface=Integer.toString(faces.toArray().length);
                                memberin.setText(numberofface);
                                System.out.println(String.format("%s FACES detected.", faces.toArray().length));
			}
		} else {
			System.out.println("problm");
			return;
		}
	}
	
	private static BufferedImage ConvertMat2Image(Mat m) {
	
		
		MatOfByte byteMat = new MatOfByte();
	
		Imgcodecs.imencode(".jpg", m, byteMat);
	
		byte[] byteArray = byteMat.toArray();
		BufferedImage bimg = null;
		try {
			InputStream in = new ByteArrayInputStream(byteArray);
			bimg = ImageIO.read(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bimg;
	}
  	

	
	public static void PushImage(Image img2) {
		
		if (frame == null)
		//newframe();
		
		if (lbl != null)
			cctv.remove(lbl);
		icon = new ImageIcon(img2.getScaledInstance(345, 320, Image.SCALE_DEFAULT));
		lbl = new JLabel();
                lbl.setBounds(1,30,345,320);
                
		lbl.setIcon(icon);
		cctv.add(lbl);
	
	cctv.updateUI();
	
	}
        public static void main(String[] args) throws IOException {
new DetectFace();
}
}