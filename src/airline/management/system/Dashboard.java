package airline.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard {
    JFrame fr;
    JLabel lbl_heading;
    String user_name;
   // ImageIcon image;

    public Dashboard(String user){
        this.user_name= user;
        fr = new JFrame("Dashboard");
        fr.getContentPane().setBackground(Color.lightGray);
       // image = new ImageIcon(this.getClass().getResource("Nepal.jpg"));

        lbl_heading = new JLabel("WELCOME TO NEPAL AIRLINES"+ user);
        lbl_heading.setFont(new Font("arial",Font.BOLD,24));
        lbl_heading.setForeground(Color.blue);
        lbl_heading.setBounds(550,350,800,100);
        fr.add(lbl_heading);


        fr.setSize(1980,1020);
        fr.setLayout(null);
        fr.setVisible(true);

    }
    public static void main(String[]args){
        new Dashboard("   "  );
    }
}
