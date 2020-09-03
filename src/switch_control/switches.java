package switch_control;
import jssc.SerialPort;
import jssc.SerialPortException;
import static smarthome.Smarthome.fan1_value;

/**
*
* @author root
*/
public class switches{
public static SerialPort serialPort;
public static int set_value;
    /**
     * @param args the command line arguments
     * @throws InterruptedException 
     */

    public switches() throws InterruptedException, SerialPortException{
       
       
       
           // Thread.sleep(3000);
            
         serialPort.writeInt(set_value);
            Thread.sleep(1000);
            System.out.println(serialPort.readString());
            
       
    }
   public static void main(String[] args) throws InterruptedException, SerialPortException {
   
   new switches();
   }
    
}
