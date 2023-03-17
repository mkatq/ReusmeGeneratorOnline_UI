/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResumeGeneratorPackage;

import javax.swing.*;
import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class MyFrame extends JFrame {
    
    JLabel lb = new JLabel("Welcome to Resume Generator");
    JButton bt1 = new JButton ("Login");
    JButton bt2 = new JButton ("Sign up");
    JButton bt3 = new JButton ("Exit");
    
        public void close()
    {
     WindowEvent c = new WindowEvent(this , WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(c);
    }
        
    public MyFrame()
    {
         super("Welcome");
        setLayout(null);
        
       lb.setFont(new Font("SANSSERIF",BOLD, 30));
         lb.setBounds(517, 150, 600 ,100);
      add(lb);
      
          bt1.setBounds(680, 300, 100 ,30);
      add(bt1);
      
       bt2.setBounds(680, 350, 100 ,30);
      add(bt2);
      
       bt3.setBounds(680, 400, 100 ,30);
      add(bt3);
        
        bt1.addActionListener(
        
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               LogIn log = new LogIn();
               log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               log.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
               log.setVisible(true);
            }
        }
                
        );
        
        
        bt2.addActionListener(
        
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 setVisible(false);
                 
              SignUP si = new SignUP();
              si.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               si.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
               si.setVisible(true);
             
            }
        }
                
        );
        
          bt3.addActionListener(
        
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                close();
                
            }
        }
                
        );
        
    }
    
}
