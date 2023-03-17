/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResumeGeneratorPackage;

import static java.awt.Font.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class SignUP extends JFrame {
  Connection con = null;

  JLabel FName = new JLabel("First name *: ");
  JLabel MName = new JLabel("Middle name: ");
  JLabel LName = new JLabel("Last name *: ");
  JLabel EmailLabel = new JLabel("Email: ");
  JLabel PhoneN = new JLabel("Phone number: ");
  JLabel user = new JLabel("Username: ");
  JLabel Pass = new JLabel("Password: ");
  JLabel CoPass = new JLabel("Confirme password: ");

  //ERROE MESSEGE

  JLabel FnameM = new JLabel("invalid name, must contain only characters");
  JLabel FnameM2 = new JLabel("Enter your first name");

  JLabel MnameM = new JLabel("invalid name, must contain only characters");
  JLabel MnameM2 = new JLabel("Enter your middle name");

  JLabel LnameM = new JLabel("invalid name, must contain only characters");
  JLabel LnameM2 = new JLabel("Enter your last name");

  JLabel NumberM1 = new JLabel(
    "Your phone number must  start with 05 and contain 10 numbers"
  );
  JLabel NumberM2 = new JLabel("Enter your phone number!");
  JLabel NumberM3 = new JLabel("Your phone number must start with 05 ");

  JLabel EmailE = new JLabel("Invalid email");

  JLabel UserNameM = new JLabel("This username is already used");
  JLabel UserNameM2 = new JLabel("Enter your username");

  JLabel PassM = new JLabel(" Enter your password ");
  JLabel PassM2 = new JLabel(" Confrim your password ");
  JLabel PassM3 = new JLabel("No matching with password ");

  TextField FnameField = new TextField();
  TextField MiddleNameF = new TextField(10);
  TextField LnameField = new TextField(10);
  TextField EmailField = new TextField(10);
  TextField PNumberField = new TextField(10);

  TextField userf = new TextField(10);
  JPasswordField passf = new JPasswordField(10);
  JPasswordField ConfPassWordField = new JPasswordField(10);

  String FirstName = "";
  String MiddleName = "";
  String LastName = "";
  String Email = "";

  JButton bt = new JButton("Sign up");

  JButton bt2 = new JButton("Cansel");

  static String PNumber = "";
  // public static  String Username = "";
  static String PassWord = " 1";
  static String ConfPassWord = "2";
  static char ch;
  static char ch2;

  static boolean isNumber(String s) {
    for (int i = 0; i < s.length(); i++) if (
      Character.isDigit(s.charAt(i))
    ) return false;

    return true;
  }

  static boolean isValidPhone(String s) {
    return (
      s.charAt(0) == '0' &&
      s.charAt(1) == '5' &&
      s.length() == 10 &&
      s.matches("[0-9]+")
    );
  }

  static boolean isValidEmail(String s) {
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[com]{3,3}$";
    Pattern emailpatt = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailpatt.matcher(s);
    return matcher.find();
  }

  public SignUP() {
    super("Sign up Page");
    setLayout(null);

    FName.setBounds(500, 190, 80, 20);
    FnameField.setBounds(640, 190, 200, 20);
    add(FName);
    add(FnameField);

    FnameM.setFont(new Font("SANSSERIF", ITALIC, 12));
    FnameM.setForeground(Color.red);
    FnameM.setBounds(640, 210, 500, 20);
    add(FnameM);
    FnameM.setVisible(false);

    FnameM2.setFont(new Font("SANSSERIF", ITALIC, 12));
    FnameM2.setForeground(Color.red);
    FnameM2.setBounds(640, 210, 500, 20);
    add(FnameM2);
    FnameM2.setVisible(false);

    MName.setBounds(500, 240, 80, 20);
    MiddleNameF.setBounds(640, 240, 200, 20);
    add(MName);
    add(MiddleNameF);

    MnameM.setFont(new Font("SANSSERIF", ITALIC, 12));
    MnameM.setForeground(Color.red);
    MnameM.setBounds(640, 260, 500, 20);
    add(MnameM);
    MnameM.setVisible(false);

    MnameM2.setFont(new Font("SANSSERIF", ITALIC, 12));
    MnameM2.setForeground(Color.red);
    MnameM2.setBounds(640, 260, 500, 20);
    add(MnameM2);
    MnameM2.setVisible(false);

    LName.setBounds(500, 290, 80, 20);
    LnameField.setBounds(640, 290, 200, 20);
    add(LName);
    add(LnameField);

    LnameM.setFont(new Font("SANSSERIF", ITALIC, 12));
    LnameM.setForeground(Color.red);
    LnameM.setBounds(640, 310, 500, 20);
    add(LnameM);
    LnameM.setVisible(false);

    LnameM2.setFont(new Font("SANSSERIF", ITALIC, 12));
    LnameM2.setForeground(Color.red);
    LnameM2.setBounds(640, 310, 500, 20);
    add(LnameM2);
    LnameM2.setVisible(false);

    EmailLabel.setBounds(500, 340, 80, 20);
    EmailField.setBounds(640, 340, 200, 20);
    add(EmailLabel);
    add(EmailField);
    EmailE.setFont(new Font("SANSSERIF", ITALIC, 12));
    EmailE.setForeground(Color.red);
    EmailE.setBounds(640, 360, 500, 20);
    add(EmailE);
    EmailE.setVisible(false);

    PhoneN.setBounds(500, 390, 100, 20);
    PNumberField.setBounds(640, 390, 200, 20);
    add(PhoneN);
    add(PNumberField);

    NumberM1.setFont(new Font("SANSSERIF", ITALIC, 12));
    NumberM1.setForeground(Color.red);
    NumberM1.setBounds(640, 410, 500, 20);
    add(NumberM1);
    NumberM1.setVisible(false);
    NumberM2.setFont(new Font("SANSSERIF", ITALIC, 12));

    NumberM2.setForeground(Color.red);
    NumberM2.setBounds(640, 410, 500, 20);
    add(NumberM2);
    NumberM2.setVisible(false);
    NumberM3.setFont(new Font("SANSSERIF", ITALIC, 12));

    NumberM3.setForeground(Color.red);
    NumberM3.setBounds(640, 410, 500, 20);
    add(NumberM3);
    NumberM3.setVisible(false);
    user.setBounds(500, 440, 80, 20);
    userf.setBounds(640, 440, 200, 20);

    add(user);
    add(userf);
    UserNameM.setFont(new Font("SANSSERIF", ITALIC, 12));
    UserNameM.setForeground(Color.red);

    UserNameM.setBounds(640, 460, 500, 20);
    add(UserNameM);
    UserNameM.setVisible(false);
    UserNameM2.setFont(new Font("SANSSERIF", ITALIC, 12));
    UserNameM2.setForeground(Color.red);

    UserNameM2.setBounds(640, 460, 500, 20);
    add(UserNameM2);
    UserNameM2.setVisible(false);
    Pass.setBounds(500, 490, 200, 20);
    passf.setBounds(640, 490, 200, 20);

    add(Pass);
    add(passf);
    PassM.setFont(new Font("SANSSERIF", ITALIC, 12));
    PassM.setForeground(Color.red);

    PassM.setBounds(640, 510, 500, 20);
    add(PassM);
    PassM.setVisible(false);
    CoPass.setBounds(500, 540, 200, 20);
    ConfPassWordField.setBounds(640, 540, 200, 20);

    add(CoPass);
    add(ConfPassWordField);
    PassM2.setFont(new Font("SANSSERIF", ITALIC, 12));
    PassM2.setForeground(Color.red);

    PassM2.setBounds(640, 560, 500, 20);
    add(PassM2);
    PassM2.setVisible(false);
    PassM3.setFont(new Font("SANSSERIF", ITALIC, 12));
    PassM3.setForeground(Color.red);

    PassM3.setBounds(640, 560, 500, 20);
    add(PassM3);
    PassM3.setVisible(false);
    bt.setBounds(680, 600, 100, 30);
    add(bt);

    bt2.setBounds(680, 650, 100, 30);
    add(bt2);

    try {
      String db_url =
        "jdbc:mysql://localhost:3307/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
      String db_username = "root";
      String db_password = "";

      con = DriverManager.getConnection(db_url, db_username, db_password);
    } catch (SQLException sqlException) {
      System.out.println(sqlException.getMessage());
    }
    FnameField.addTextListener(
      new TextListener() {

        @Override
        public void textValueChanged(TextEvent e) {
          FirstName = FnameField.getText();
          if (!isNumber(FirstName) && !FnameField.getText().equals("")) {
            FnameM2.setVisible(false);
            FnameM.setVisible(true);
          } else {
            FnameM2.setVisible(false);
            FnameM.setVisible(false);
          }
        }
      }
    );

    MiddleNameF.addTextListener(
      new TextListener() {

        @Override
        public void textValueChanged(TextEvent e) {
          MiddleName = MiddleNameF.getText();
          if (!isNumber(MiddleName) && !MiddleNameF.getText().equals("")) {
            MnameM2.setVisible(false);
            MnameM.setVisible(true);
          } else {
            MnameM2.setVisible(false);
            MnameM.setVisible(false);
          }
        }
      }
    );

    LnameField.addTextListener(
      new TextListener() {

        @Override
        public void textValueChanged(TextEvent e) {
          LastName = LnameField.getText();
          if (!isNumber(LastName) && !LnameField.getText().equals("")) {
            LnameM2.setVisible(false);
            LnameM.setVisible(true);
          } else {
            LnameM2.setVisible(false);
            LnameM.setVisible(false);
          }
        }
      }
    );

    bt.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          FirstName = FnameField.getText();
          MiddleName = MiddleNameF.getText();
          LastName = LnameField.getText();
          //   Username = userf.getText();
          Email = EmailField.getText();
          PNumber = PNumberField.getText();
          // ch = PNumber.charAt(0);
          // ch2 = PNumber.charAt(1);
          PassWord = passf.getText();
          ConfPassWord = ConfPassWordField.getText();

          if (FnameField.getText().equals("")) {
            FnameM.setVisible(false);
            FnameM2.setVisible(true);
          } else {
            FnameM2.setVisible(false);
          }

          if (MiddleNameF.getText().equals("")) {
            MnameM.setVisible(false);
            MnameM2.setVisible(true);
          }

          if (LnameField.getText().equals("")) {
            LnameM.setVisible(false);
            LnameM2.setVisible(true);
          }

          if (PNumber.equals("")) {
            NumberM1.setVisible(false);
            NumberM2.setVisible(true);
          } else {
            NumberM2.setVisible(false);
          }
          if (!PNumber.equals("") && !isValidPhone(PNumber)) {
            NumberM2.setVisible(false);
            NumberM1.setVisible(true);
          } else {
            NumberM1.setVisible(false);
          }

          if (!isValidEmail(Email)) {
            EmailE.setVisible(true);
          } else {
            EmailE.setVisible(false);
          }

          try {
            String Username = userf.getText();

            Statement s = con.createStatement();
            String sql =
              "SELECT * FROM userinformation WHERE UserName='" + Username + "'";
            ResultSet res = s.executeQuery(sql);

            if (res.next()) {
              UserNameM2.setVisible(false);
              UserNameM.setVisible(true);
            } else {
              UserNameM.setVisible(false);
            }
          } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
          }
          if (userf.getText().equals("")) {
            UserNameM.setVisible(false);
            UserNameM2.setVisible(true);
          } else {
            UserNameM2.setVisible(false);
          }

          if (passf.getText().equals("")) {
            PassM.setVisible(true);
          } else {
            PassM.setVisible(false);
          }

          if (ConfPassWordField.getText().equals("")) {
            PassM2.setVisible(true);
          } else {
            PassM2.setVisible(false);
          }

          if (!ConfPassWordField.getText().equals(passf.getText())) {
            PassM2.setVisible(false);
            PassM3.setVisible(true);
          } else {
            PassM3.setVisible(false);
          }

          if (
            isNumber(FirstName) &&
            isNumber(MiddleName) &&
            isNumber(LastName) &&
            isValidEmail(Email) &&
            passf.getText().equals(ConfPassWordField.getText()) &&
            isValidPhone(PNumber)
          ) {
            try {
              String Username = userf.getText();
              FirstName = FnameField.getText();
              MiddleName = MiddleNameF.getText();
              LastName = LnameField.getText();
              //   Username = userf.getText();
              Email = EmailField.getText();
              PNumber = PNumberField.getText();

              PassWord = passf.getText();
              ConfPassWord = ConfPassWordField.getText();
              Statement s = con.createStatement();
              String sql =
                "SELECT * FROM userinformation WHERE UserName='" +
                Username +
                "'";
              ResultSet res = s.executeQuery(sql);

              if (res.next()) {
                UserNameM2.setVisible(false);
                UserNameM.setVisible(true);
              } else {
                MyFrame frm = new MyFrame();

                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
                frm.setVisible(true);

                String sql2 = String.format(
                  "INSERT INTO userinformation(FirstName,MiddleName,LastName,Email" +
                  " , PhoneNumber,UserName,PassWord)\n" +
                  "Values ('%s','%s','%s','%s','%s','%s','%s');",
                  FirstName,
                  MiddleName,
                  LastName,
                  Email,
                  PNumber,
                  Username,
                  PassWord
                );
                s.executeUpdate(sql2);
                JOptionPane.showMessageDialog(null, "welcom");
                setVisible(false);
              }
            } catch (SQLException sqlException) {
              System.out.println(sqlException.getMessage());
            }
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
          f.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
          f.setVisible(true);
        }
      }
    );
  }
}
