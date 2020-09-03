package smarthome;
import org.opencv.core.*;
import org.opencv.imgproc.*;
import org.opencv.videoio.*;

class SimpleSample {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    //~ static int fcc(char a, char b, char c, char d) {
        //~ return (d<<24 | c<<16 | b<<8 | a);
    //~ }

    public static void main(String[] args) {
 VideoCapture videoCapture = new VideoCapture();   
      int fourcc = VideoWriter.fourcc('m','j','p','g');
      videoCapture.open(0);
Size frameSize = new Size((int) videoCapture.get(Videoio.CAP_PROP_FRAME_WIDTH),(int) videoCapture.get(Videoio.CAP_PROP_FRAME_HEIGHT));
VideoWriter writer = new VideoWriter("testfile.avi", fourcc, 20, frameSize, true);

 if (!writer.isOpened()) {
System.out.println("bummer!");

}
       while (true) {
        Mat frame = new Mat(640,480,CvType.CV_8UC3,Scalar.all(127)); 
   
        
		
 videoCapture.read(frame);          
            
            Mat f = frame.clone();
            Imgproc.putText(f, ("frame" ), new Point(100,100), Core.FONT_HERSHEY_PLAIN, 2, new Scalar(200,0,0),3);
            writer.write(f);
        
    }
}}