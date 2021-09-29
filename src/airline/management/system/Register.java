package airline.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 class Register implements ActionListener {
     JFrame fr;
     JLabel lbl_heading, lbl_full_name, lbl_user_name,lbl_Email,lbl_password,lbl_conform_password;
     JTextField txt_full_name,txt_user_name,txt_Email;
     JPasswordField txt_password, txt_conform_password;
     JButton btn_Register,btn_cancel;
     Font f1,f2;
     public Register() {
         fr = new JFrame("USER REGISTRATION PAGE");
         fr.getContentPane().setBackground(Color.red);

         f1 = new Font("arial", Font.BOLD, 22);
         f2 = new Font("arial", Font.BOLD, 18);

         lbl_heading = new JLabel("USER REGISTRATION ");
         lbl_heading.setFont(f1);
         lbl_heading.setForeground(Color.BLUE);
         lbl_heading.setBounds(80, 10, 250, 40);
         fr.add(lbl_heading);

         lbl_full_name = new JLabel("FIRST NAME:");
         lbl_full_name.setFont(f1);
         lbl_full_name.setForeground(Color.BLUE);
         lbl_full_name.setBounds(20,50,150,40);
         fr.add(lbl_full_name);

         lbl_user_name = new JLabel("USER NAME:");
         lbl_user_name.setFont(f1);
         lbl_user_name.setForeground(Color.BLUE);
         lbl_user_name.setBounds(20,80,150,40);
         fr.add(lbl_user_name);

         lbl_Email = new JLabel("EMAIL:");
         lbl_Email.setFont(f1);
         lbl_Email.setForeground(Color.BLUE);
         lbl_Email.setBounds(20,110,150,40);
         fr.add(lbl_Email);

         lbl_password=new JLabel("PASSWORD:");
         lbl_password.setForeground(Color.blue);
         lbl_password.setFont(f1);
         lbl_password.setBounds(20,140,150,40);
         fr.add(lbl_password);

         lbl_conform_password=new JLabel("CON PASSWORD:");
         lbl_conform_password.setForeground(Color.blue);
         lbl_conform_password.setFont(f1);
         lbl_conform_password.setBounds(20,170,200,40);
         fr.add(lbl_conform_password);

         txt_full_name=new JTextField();
         txt_full_name.setFont(f2);
         txt_full_name.setBounds(220,50,220,30);
         fr.add(txt_full_name);

         txt_user_name=new JTextField();
         txt_user_name.setFont(f2);
         txt_user_name.setBounds(220,80,220,30);
         fr.add(txt_user_name);

         txt_Email=new JTextField();
         txt_Email.setFont(f2);
         txt_Email.setBounds(220,110,220,30);
         fr.add(txt_Email);

         txt_password=new JPasswordField();
         txt_password.setFont(f2);
         txt_password.setBounds(220,140,220,30);
         fr.add(txt_password);

         txt_conform_password=new JPasswordField();
         txt_conform_password.setFont(f2);
         txt_conform_password.setBounds(220,170,220,30);
         fr.add(txt_conform_password);

         btn_Register=new JButton("REGISTER");
         btn_Register.setFont(f2);
         btn_Register.setBounds(180,210,130,40);
         btn_Register.addActionListener(this);
         fr.add(btn_Register);

         btn_cancel=new JButton("Cancel");
         btn_cancel.setFont(f2);
         btn_cancel.setBounds(180,260,130,40);
         fr.add(btn_cancel);

        fr.setSize(600, 500);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String[]args){
        new Register();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String full_name = txt_full_name.getText();
        String user_name = txt_user_name.getText();
        String email = txt_Email.getText();
        String password = txt_password.getText();
        String conform_password = txt_conform_password.getText();

        User u = new User(full_name,user_name,email,password,conform_password);
        if (e.getSource()==btn_Register) {
           Conn o = new Conn();
            String query = "insert into login1 (full_name, user_name, email, password, conform_password) values ('" + u.getFull_name() + "', '"+u.getUser_name()+"','" + u.getEmail() + "','" +u.getPassword() + "','"+u.getConform_password()+"')";
            int ans = o.insert(query);
            if (ans > 0) ;
            JOptionPane.showMessageDialog(fr, "Account created successfully");
            fr.dispose();
        }
        else{
            JOptionPane.showMessageDialog(fr,"Something Wrong");
        }
    }


}
