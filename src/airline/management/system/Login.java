package airline.management.system;


import com.mysql.cj.Query;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{

    TextField txt_user_name;
    JPasswordField txt_password;
    Label l1,l2;
    Button b2,b3,b4,b5;
    GridBagLayout gbl;  
    GridBagConstraints gbc; 
    Font f1,f2;


    public Login(){
        super("Login");



        getContentPane().setBackground(Color.BLUE);

        f1 = new Font("TimesRoman",Font.BOLD,20);
        f2 = new Font("TimesRoman",Font.BOLD,15);
		
        gbl=new GridBagLayout(); 
	    gbc=new GridBagConstraints();
        setLayout(gbl);

	
        l1 = new Label("Username: ");
        l1.setForeground(Color.red);
        l1.setFont(f1);
	
        l2 = new Label("Password: ");
        l2.setForeground(Color.red);
        l2.setFont(f1);

	
        txt_user_name = new TextField(14);
	    txt_password = new JPasswordField(13);

       // txt_password.setEchoChar('*');
	
	    b2 = new Button("Reset");
        b2.setForeground(Color.blue);
        b2.setFont(f2);
		
        b3 = new Button("Submit");
        b3.setForeground(Color.blue);
        b3.setFont(f2);
		
        b4 = new Button("Close");
        b4.setForeground(Color.blue);
	    b4.setFont(f2);

        b5 = new Button("SIGNUP");
        b5.setForeground(Color.blue);
        b5.setFont(f2);

		
        gbc.gridx=0;
	    gbc.gridy=0;
        gbl.setConstraints(l1,gbc);
	    add(l1);
        
	    gbc.gridx=2;
        gbc.gridy=0;
	    gbl.setConstraints(txt_user_name,gbc);
        add(txt_user_name);
		
	    gbc.gridx=0;
        gbc.gridy=2;
	    gbl.setConstraints(l2,gbc);
        add(l2);

	    gbc.gridx=2;
        gbc.gridy=2;
        gbl.setConstraints(txt_password,gbc);
	    add(txt_password);
				
	
	    gbc.gridx=0;
        gbc.gridy=8;
	    gbl.setConstraints(b2,gbc);
        add(b2);

        gbc.gridx=2;
	    gbc.gridy=8;
        gbl.setConstraints(b3,gbc);
	    add(b3);
	
        gbc.gridx=4;
	    gbc.gridy=8;
        gbl.setConstraints(b4,gbc);
	    add(b4);

        gbc.gridx=4;
        gbc.gridy=11;
        gbl.setConstraints(b5,gbc);
        add(b5);
        

        b2.addActionListener(this);
        b3.addActionListener(this);
	    b4.addActionListener(this);
        b5.addActionListener(this);
                
        setVisible(true);   
        setSize(400,250); 
        setLocation(400,200);   
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b5){
            new Register();
        }

        if(ae.getSource()==b2){
          
            txt_user_name.setText("");
            txt_password.setText("");
	}
        if(ae.getSource()==b4){
            System.exit(0); 
	}


        if(ae.getSource()==b3){
            try{
                Conn c1 = new Conn() {

                };
                
                String username= txt_user_name.getText();
                String password = txt_password.getText();
            
                String query = "select * from login1 where user_name = '"+username+"' and password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c1.select(query);



                if(rs.next()){
                    //JOptionPane.showMessageDialog(gbl,"login sucessfull");

                    new Mainframe();
                    new Dashboard(  username  );
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
                setVisible(false);

            }catch(Exception e){}
            
	}

    }




    public static void main(String[] args){
            new Login();
    }
}
