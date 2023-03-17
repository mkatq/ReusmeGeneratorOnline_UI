/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResumeGeneratorPackage;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class LogIn extends JFrame {

    static String user = null;
    JLabel User = new JLabel("Username :");
    JLabel Pass = new JLabel("Password :");
    JTextField text = new JTextField(10);
    JPasswordField pass = new JPasswordField(10);
   JButton bt = new JButton("Login");
    JButton bt2 = new JButton ("Cancel");

    Connection con = null;

    public LogIn() {
        super("Login Page");
        setLayout(null);
        User.setBounds(40, 40, 200, 20);
        text.setBounds(120, 40, 200, 20);
        add(User);
        add(text);

        Pass.setBounds(40, 80, 200, 20);
        pass.setBounds(120, 80, 200, 20);
        add(Pass);
        add(pass);

       bt.setBounds(690, 430, 100 ,25);
        add(bt);
        
         bt2.setBounds(690, 480, 100 ,25);
        add(bt2);

        try {
            String db_url = "jdbc:mysql://localhost:3307/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String db_username = "root";
            String db_password = "ME@mkatq1";
            con = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        bt.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String un = text.getText();
                    String pw = pass.getText();
                    String sql = "SELECT UserName , PassWord FROM userinformation where username = '" + un + "'and Password = '" + pw + "'";

                    try {
                        Statement s = con.createStatement();
                        ResultSet res = s.executeQuery(sql);

                        if (res.next()) {
                            if (un.equals(res.getObject(1)) && pw.equals(res.getObject(2))) {
                                JOptionPane.showMessageDialog(null, "welcome");
                                user = un;
                                ResumeGeneratorHomePage RGM = new ResumeGeneratorHomePage();
                                RGM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                RGM.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
                                RGM.setVisible(true);
                                setVisible(false);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "wrong");

                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

                    }

                }
            }

        );
        
           bt2.addActionListener(

new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
                MyFrame f = new MyFrame();
                 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(Integer.MAX_VALUE , Integer.MAX_VALUE);
    f.setVisible(true);
               
           }
       }

);

    }
}