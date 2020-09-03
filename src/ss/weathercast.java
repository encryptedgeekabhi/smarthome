package ss;



import data_show.settings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.*;
import net.aksingh.owmjapis.model.*;
import net.aksingh.owmjapis.model.DailyWeatherForecast;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.Weather;
import smarthome.Label;
import static smarthome.Label.gust_data;
import static smarthome.Label.jp;
import static smarthome.Label.loc;
import static smarthome.Label.weather_temp;
import static smarthome.Label.wind_data;
import smarthome.Smarthome;
public class weathercast implements Label{
static Double temp;
static String wind_speed;
static String gust="0.0";
static String l=null;
OWM owm =null;
    CurrentWeather cwd=null;
        
      HourlyWeatherForecast s=null;

            // checking if max. temp. and min. temp. is available
    public weathercast() throws APIException, FileNotFoundException, IOException
    {
        FileReader reader = new FileReader(System.getProperty("user.dir")+"\\location.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            l=bufferedReader.readLine();
            loc.setText(l+",India");
            bufferedReader.close();
            reader.close();
            
     owm = new OWM("6f4d77491340ecff37d0136446bbe3ca");   
     cwd = owm.currentWeatherByCityName(l);
     s=owm.hourlyWeatherForecastByCityName(l);
    we.start();
    }
            
            
            Thread we=new Thread(){
    @Override
    public void run() {
    while (true) {
    try {
   if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

            
            if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                
                temp=cwd.getMainData().getTemp()-273.15;
                
                
                int a=temp.intValue();
                
                weather_temp.setText(Integer.toString(a));
                jp.setValue(a);
                if(a>30)
                    jp.setString("HIGH TEMP");
                else if(a>15 &&a<31)
                    jp.setString("Normal temp");
                jp.setStringPainted(true);
                //System.out.println("Temperature: " + temp);
               wind_data.setText("Wind spd- "+wind_speed);
                wind_speed=(cwd.getWindData().component1().toString());
                if(cwd.getWindData().hasGust())
                gust=(cwd.getWindData().getGust().toString());
                gust_data.setText("Gust value- "+gust);
            }}
    } catch (Exception ex) {
        
    Logger.getLogger(Smarthome.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }}} ;
            
            
        
   
            
            }                       
            
                
              
  
            
        
            

    

            