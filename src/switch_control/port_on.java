/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switch_control;

import jssc.SerialPort;
import jssc.SerialPortException;
import static switch_control.switches.serialPort;

/**
 *
 * @author Root
 */
public class port_on {
  public port_on()
{
 serialPort = new SerialPort("COM3");
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
             }
        catch (SerialPortException ex){
            System.out.println(ex);
        }


}
}
