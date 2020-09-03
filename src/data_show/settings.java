/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_show;

import img_slide.slide_folderchooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author Root
 */
public class settings implements ActionListener{
    JFrame jf=new JFrame();
    JButton back=new JButton("Discard");
    JButton browse1=new JButton("Browse");
    JButton browse2=new JButton("Browse");
    JButton select_state=new JButton("explore");
    JButton select_District=new JButton("Next");
    JComboBox state=new JComboBox();
    JComboBox district=new JComboBox();
    JLabel home_background=new JLabel("CHANGE BACKGROUND(Home)");
    JLabel slide_location=new JLabel("LOCATION FOR SLIDE-SHOW");
    JLabel background=new JLabel("CHANGE BACKGROUND(Home)");
    JLabel curr_location=new JLabel("CHANGE LOCATION(Home)");
    JInternalFrame jstate=new JInternalFrame("select state");
    JButton set=new JButton("SET LOCATION");
    JButton btn=new JButton("SETTINGS");
  public static String location=null;  
   public settings()
{
jf.setBounds(800,200,430,430);
jstate.setOpaque(true);

jf.setLayout(null);
jf.getContentPane().setBackground(new Color(33,97,140));
home_background.setBounds(20,70,200,30);
home_background.setForeground(new Color(255,255,255));

browse1.setBounds(230,70,100,30);
slide_location.setBounds(20,120,200,30);
slide_location.setForeground(new Color(255,255,255));


browse2.setBounds(230,120,100,30);
browse2.addActionListener(this);
curr_location.setBounds(20,170,200,30);
curr_location.setForeground(new Color(255,255,255));

select_state.setBounds(230,170,100,30);
select_state.addActionListener(this);
back.setBounds(150,300,150,30);
back.addActionListener(this);

jstate.setBounds(1,201,400,200);
jstate.setLayout(null);
state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bihar","Panjab","Delhi","Uttar Pradesh","Madhya Pradesh","Assam","Andhra Pradesh","Arunachal Pradesh","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","West Bengal" }));
state.setBounds(10,10,120,30);
set.setBounds(180,90,100,30);
set.addActionListener(this);
jstate.add(state);
jstate.add(set);
select_District.setBounds(150,10,50,30);
select_District.addActionListener(this);
jstate.add(select_District);
jstate.getContentPane().setBackground(new Color(55,117,140));
district.setBounds(220,10,120,30);
jstate.add(district);
jf.add(btn);
jf.add(back);
btn.setBackground(new Color(248,148,6));
btn.setBounds(0, 0, 430, 40);
btn.setFont(new Font("Arial",Font.BOLD,25));
btn.setForeground(new Color(255,255,255));

//jstate.setVisible(true);
jf.add(home_background);
jf.add(slide_location);
jf.add(curr_location);
jf.add(browse1);
jf.add(browse2);
jf.add(select_state);

jf.add(jstate);
//jf.add(state);
//jf.add(district);

jf.setVisible(true);
}
   /*public static void main(String[] args) {
   new settings();
   }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==set)
        {
            location=district.getSelectedItem().toString();
            System.out.println(location);
        
        
            // writer=null;
            try {
                File previous=new File(System.getProperty("user.dir")+"\\location.txt");
        previous.delete();
              FileWriter  writer = new FileWriter(System.getProperty("user.dir")+"\\location.txt", true);
                writer.write(location);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        if(e.getSource()==browse2)
        {
        new slide_folderchooser();
        
        }
        if(e.getSource()==back)
        {
        jf.dispose();
        
        }
        if(e.getSource()==select_state)
        {
            if(jstate.isVisible()==true)
            {
                back.setVisible(true);
             jstate.setVisible(false);  
             select_state.setText("Explore");
            }
            else
            {
                back.setVisible(false);
        jstate.setVisible(true);
        select_state.setText("Discard");
        }}
        if(e.getSource()==select_District)
        {
        if(state.getSelectedItem()=="Bihar")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "patna","muzzafarpur","darbhanga","madhubani","hazipur" }));
        if(state.getSelectedItem()=="West Bengal")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bankura", "Birbhum", "Burdwan","Kolkata"," Darjeeling", "Jalpaiguri", "Hooghly", "Howrah", "Malda", "Midnapore", "Murshidabad", "Nadia", "West Dinajpur","Parganas" }));
             if(state.getSelectedItem()=="Panjab")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amritsar", "Bathinda", "Faridkot"," Firozpur", "Fatehgarh Sahib", "Kapurthala", "Gurdaspur", "Hoshiarpur", "Jalandhar", "Ludhiana", "Mansa", "Moga", "Muktsar", "Nawanshahr", "Patiala", "Rupnagar", "Sangrur", "Tarn Taran" }));
    if(state.getSelectedItem()=="Jharkhand")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Palamu", "Garhwa", "Latehar", "Chatra", "Hazaribagh", "Koderma", "Giridih", "Ramgarh", "Bokaro", "Dhanbad", "Lohardaga", "Gumla", "Simdega", "Ranchi", "Khunti","West Singhbhum", "Saraikela Kharsawan" ,"East Singhbhum","Jamtara", "Deoghar"," Dumka", "Pakur", "Godda", "Sahebganj" }));
    if(state.getSelectedItem()=="Maharashtra")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ahmednagar","Jalgaon","Pune","Akola","Jalna","Raigad","Amravat","Kolhapur","Ratnagiri","Aurangabad","Latur","Sangli Beed","Mumbai City","Satara","Bhandara","Mumbai Sub-urban", "Sindhudurg" ,"Buldhana" ,"Nagpur","Solapur","Chandrapur","Nanded" ,"Thane","Dhule","Nandurbar" ,"Wardha","Gadchiroli","Nashik", "Washim", "Gondia","Osmanabad","Yavatmal","Hingoli","Parbhani"}));
       if(state.getSelectedItem()=="Punjab")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amritsar", "Bathinda", "Faridkot", "Firozpur"," Fatehgarh Sahib", "Kapurthala", "Gurdaspur", "Hoshiarpur", "Jalandhar", "Ludhiana", "Mansa", "Moga", "Muktsar", "Nawanshahra", "Patiala", "Rupnagar", "Sangrur","Tarn Taran"}));
 if(state.getSelectedItem()=="Uttar Pradesh")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agra","Aligarh","Allahabad"," Ambedkar Nagar"," Auraiya"," Azamgarh"," Baghpat","Bahraich"," Ballia","Balrampur"," Banda","Barabanki","Bareilly"," Basti","Bhim Nagar","Bijnor","Budaun","Bulandshahr","Chandauli"," Chatrapati Sahuji Mahraj Nagar","Chitrakoot","Deoria","Etah","Etawah","Faizabad","Farrukhabad","Fatehpur","Firozabad","Gautam Buddha Nagar","Ghaziabad","Ghazipur","Gonda","Gorakhpur","Hamirpur","Hardoi","Hathras","Jalaun","Jaunpur","Jhansi"," Jyotiba Phule Nagar"," Kannauj","Kanpur Dehat","Kanpur Nagar","Kanshiram Nagar","Kaushambi","Kushinagar","Lakhimpur","Lalitpur"," Lucknow"," Maharajganj","Mahoba"," Mainpuri","Mathura"," Mau","Meerut","Mirzapur","Moradabad","Muzaffarnagar","Panchsheel Nagar","Pilibhit","Prabuddh Nagar","Pratapgarh", "RaeBareli","Rampur", "Saharanpur","Sant Kabir Nagar","Sant Ravidas Nagar","Shahjahanpur","Shravasti","Siddharth Nagar","Sitapur","Sonbhadra","Sultanpur","Unnao","Varanasi"}));
 if(state.getSelectedItem()=="Delhi")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"New Delhi","North Delhi","North West Delhi","West Delhi","South West Delhi","South Delhi","South East Delhi","Central Delhi","North East Delhi","Shahdara","East Delhi"}));
         if(state.getSelectedItem()=="Madhya Pradesh")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agarmalwa","Chhindwara","Jabalpur","Raisen","Sheopur"," Alirajpur","Damoh","Jhabua","Rajgarh","Shivpuri" ,"Anuppur", "Datia"," Katni"," Ratlam	", "Sidhi"," Ashoknagar	"," Dewas"," Khandwa","Rewa"," Tikamgarh"," Balaghat"," Dhar"," Khargone"," Sagar"," Ujjain", "Barwani","Dindori"," Mandla","Satna"," Umaria","Betul"," Guna"," Mandsaur"," Sehore"," Vidisha","Bhind"," Gwalior"," Morena"," Seoni"	,"Bhopal","Harda","Narsinghpur"," Singrauli","Burhanpur","Hoshangabad","Neemuch"," Shahdol"," Chhatarpur"," Indore","Panna","Shajapur"}));
         if(state.getSelectedItem()=="Assam")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Cachar"," Darrang"," Goalpara", "Kamrup", "Lakhimpur", "Nagaon", "Sivsagar", "Jayantia parganas", "Garo hills", "Lushai hills", "Naga hills", "Sylhet","NEFA"}));
        if(state.getSelectedItem()=="Andhra Pradesh")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {" East Godavari"," West Godavari"," Krishna"," Guntur"," Prakasam"," Sri Potti Sri Ramulu Nellore"," Srikakulam"," Vizianagaram","Visakhapatnam"," Kurnool", "Chittoor", "Kadapa" ,"Anantapur"}));
         if(state.getSelectedItem()=="ArunachalPradesh")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Changlang District","Tirap","Anjaw ","Lohit District","Upper Dibang Valley","Lower Dibang Valley","West Siang District","East Siang District","Lower Subansiri District","Upper Siang ","Kurung Kumey ","Upper Subansiri ","East Kameng ","Papum Pare ","Tawang ","West Kameng "}));
         if(state.getSelectedItem()=="Chhattisgarh")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Koriya","Balrampur-Ramanujganj","Surajpur","Jashpur","Surguja","Bilaspur","Mungeli","Korba","Janjgir-Champa","Raigarh","Kabirdham","Bemetara","Durg","Balod","Rajnandgaon","Mahasamund","Baloda Bazar","Gariaband","Raipur","Dhamtari","Kanker","Narayanpur","Kondagaon","Bastar","Dantewada" ,"Bijapur","Sukma"}));
         if(state.getSelectedItem()=="Goa")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"North Goa","South Goa"}));
         if(state.getSelectedItem()=="Gujarat")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ahmedabad","Vadodara","Anand","Chhota Udaipur","Dahod","Kheda","Mahisagar","Panchmahal","North Gujarat","Gandhinagar","Aravalli","Banaskantha","Mehsana","Patan","Sabarkantha","Rajkot","Amreli","Bhavnagar","Botad","Devbhoomi Dwarka","Gir Somnath","Jamnagar","Junagadh","Morbi","Porbandar","Surendranagar","Kachchh","Surat","Bharuch","Dang","Narmada","Navsari","Tapi","Valsa"}));
         if(state.getSelectedItem()=="Himachal Pradesh")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Changlang ","Tirap","Anjaw District","Lohit District","Upper Dibang Valley","Lower Dibang Valley","West Siang","East Siang ","Lower Subansiri","Upper Siang ","Kurung Kumey","Upper Subansiri ","East Kameng ","Papum Pare ","Tawang","West Kameng"}));
         if(state.getSelectedItem()=="Jammu and Kashmir")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Anantnag","Bandipore","Baramulla","Budgam","Doda","Ganderbal","Jammu","Kargil","Kathua","Kishtwar","Kulgam","Kupwara","Leh","Poonch","Pulwama","Rajouri","Ramban","Reasi","Samba","Shopian","Srinagar","Udhampur"}));
         if(state.getSelectedItem()=="Karnataka")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Bagalkot","Belagavi","Vijayapura","Dharwad","Gadag","Haveri","Uttara Kannada","Bengaluru Urban","Bengaluru Rural","Chikkaballapur","Chitradurga","Davanagere","Kolar","Ramanagara","Shivamogga","Tumakuru","Ballari","Bidar","Kalaburagi","Koppal","Raichur","Yadgi","Chamarajanagar","Chikkamagaluru","Dakshina Kannada","Hassan","Kodagu","Mandya","Mysuru","Udupi"}));
         if(state.getSelectedItem()=="Kerala")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {" Kasaragod", "Kannur", "Wayanad", "Kozhikode","Palakkad"," Thrissur"," Ernakulam"," Idukki"," Malappuram", "Kottayam "," Thiruvananthapuram", "Kollam"," Alappuzha", "Pathanamthitta"}));
         if(state.getSelectedItem()=="Manipur")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {" Bishnupur", "Imphal West", "Imphal East", "Thoubal", "Kakching"," Tamenglong"," Kangpokpi", "Senapati"," Ukhrul", "Kamjong"," Jiribam"," Noney"," Pherzawl"," Churachandpur"," Chandel"," Tengnoupal"}));
         if(state.getSelectedItem()=="Meghalaya")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"West Jaintia Hills","East Jaintia Hills ","East Khasi Hills","West Khasi Hills","South West Khasi Hills","Ri-Bhoi ","North Garo Hills","East Garo Hills","South Garo Hills","West Garo Hills","South West Garo Hills"}));
         if(state.getSelectedItem()=="Mizoram")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Aizawl","Champhai","Kolasib","Lawngtlai	","Lunglei","Mamit","Saiha","Serchhip	"}));
         if(state.getSelectedItem()=="Nagaland")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Dimapur","Kiphire","Kohima","Longleng","Mokokchung","Mon","Peren","Phek","Tuensang","Wokha","Zunheboto"}));
         if(state.getSelectedItem()=="Odisha")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Angul","Balasore","Bargarh","Bhadrak","Balangir","Boudh","Cuttack","Debagarh","Dhenkanal","Gajapati","Ganjam","Jagatsinghpur","Jajpur","Jharsuguda","Kalahandi","Kandhamal","Kendrapara","Kendujhar","Khordha","Koraput","Malkangiri","Mayurbhanj","Nabarangpur","Nayagarh","Nuapada","Puri","Rayagada","Sambalpur","Subarnapur","Sundargarh"}));
         if(state.getSelectedItem()=="Sikkim")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"East Sikkim","North Sikkim","South Sikkim","West Sikkim"}));
         if(state.getSelectedItem()=="Tamil Nadu")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Kanchipuram","Tiruvallur","Cuddalore","Villupuram","Vellore","Tiruvannamalai","Salem","Namakkal","Dharmapuri","Erode","Coimbatore","The Nilgiris","Thanjavur","Nagapattinam","Tiruvarur","Tiruchirappalli","Karur","Perambalur"}));
         if(state.getSelectedItem()=="Rajasthan")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Ajmer","Alwar","Banswara","Baran","Barmer","Bharatpur","Bhilwara","Bikaner","Bundi","Chittorgarh","Churu" ,"Dausa","Dholpur","Dungarpur","Hanumangarh","Jaipur","Jaisalmer","Jalore","Jhalawar","Jhunjhunu","Jodhpur","Karauli","Kota","Nagaur","Pali","Pratapgarh","Rajsamand","Sawai Madhopur","Sikar","Sirohi","Sri Ganganagar","Tonk","Udaipur"}));
         if(state.getSelectedItem()=="Telangana")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Manchiryala","Adilabad","Nirmal","Karimnagar","Peddapally","Jagityal","Mahabubabad","Warangal","Hanmakonda","Bhoopal Pally","	Siddipet","Medak","Sangareddy","Nizamabad","Kamareddy","Nalgonda","Suryapet","Yadagiri","Mahaboobnagar","NagarkarnoolVanaparthy","Khammam","Kothagudam","Hyderabad","Vikarabad","Shamshabad","Malkajgiri"}));
         if(state.getSelectedItem()=="Tripura")
        district.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Dhalai","South Tripura","Gomati","North Tripura","Sipahijala","Khowai","Khowai","Unakoti"}));
         
         //location=district.getSelectedItem().toString();
        }   
       
    }
    
}

