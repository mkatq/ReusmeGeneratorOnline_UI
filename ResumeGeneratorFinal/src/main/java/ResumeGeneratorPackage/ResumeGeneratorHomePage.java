package ResumeGeneratorPackage;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ResumeGeneratorHomePage extends JFrame {
  JButton select;
  JPanel PersonInformations = new JPanel();
  JPanel ContactInformations = new JPanel();
  JPanel Summary = new JPanel();
  JPanel exper = new JPanel();
  JPanel Educations = new JPanel();
  JPanel Skills = new JPanel();
  JPanel Languages = new JPanel();
  JPanel Qualfications = new JPanel();

  //    #PersonInformations
  JLabel PersonInformationslabel = new JLabel("Personal Information");
  JLabel PIL1 = new JLabel("Frist Name");
  JTextField PTT1 = new JTextField(10);
  JLabel PIL2 = new JLabel("Last Name");
  JTextField PTT2 = new JTextField(10);
  JLabel PIL3 = new JLabel("Gender");
  ButtonGroup bg = new ButtonGroup();
  JLabel PIGL1 = new JLabel("Male");
  JRadioButton PIGB1 = new JRadioButton();
  JLabel PIGL2 = new JLabel("Female");
  JRadioButton PIGB2 = new JRadioButton();
  JLabel PIL4 = new JLabel("Date of Birth");
  JTextField PTT4 = new JTextField(10);
  JLabel PIL5 = new JLabel("Country");
  String list[] = { "Sauid Arabia", "Egypt", "United State" };
  JComboBox PTT5 = new JComboBox(list);

  //    #ContactInformations
  JLabel ContactInformationsLabel = new JLabel("Contact Information");
  JLabel CIL1 = new JLabel("Email");
  JTextField CIT1 = new JTextField(10);
  JLabel CIL2 = new JLabel("Phone");
  JTextField CIT2 = new JTextField(10);
  JLabel CIL3 = new JLabel("Address");
  JTextField CIT3 = new JTextField(10);
  JLabel CIL4 = new JLabel("Linkedin");
  JTextField CIT4 = new JTextField(10);

  //    #Summary
  JLabel SummaryLabel = new JLabel("Professional Summary");
  JTextArea SMA1 = new JTextArea(7, 24);

  //    #exp
  JLabel expLabel = new JLabel("Experiences");
  JTextArea exp = new JTextArea(7, 24);

  //    #Educations
  JLabel EducationsLabel = new JLabel("Educations");
  JTextField EDT1 = new JTextField(20);
  JTextField EDT2 = new JTextField(20);
  JTextField EDT3 = new JTextField(20);
  JTextField EDT4 = new JTextField(20);
  JTextField EDT5 = new JTextField(20);
  JTextField EDT6 = new JTextField(20);
  JTextField EDT7 = new JTextField(20);
  JTextField EDT8 = new JTextField(20);

  JLabel SkillsLabel = new JLabel("Skills");

  JTextField SKT1 = new JTextField(7);
  JTextField SKT2 = new JTextField(7);
  JTextField SKT3 = new JTextField(7);
  JTextField SKT4 = new JTextField(7);
  JTextField SKT5 = new JTextField(7);
  JTextField SKT6 = new JTextField(7);
  JTextField SKT7 = new JTextField(7);
  JTextField SKT8 = new JTextField(7);

  JLabel LanguagesLabel = new JLabel("Languages");
  JLabel LEL1 = new JLabel("First language");
  JLabel LEL2 = new JLabel("Second language");

  String list1[] = { "English", "Arabic", "Spanish" };
  JComboBox LE1 = new JComboBox(list1);
  JComboBox LE2 = new JComboBox(list1);

  JButton Generate = new JButton("Generate and open");
  JButton Save = new JButton("Save");

  JLabel QualficationsLabel = new JLabel("Qualfications");
  JTextArea QualficationsA = new JTextArea(13, 24);
  String lg1 = "";
  String lg2 = "";

  JLabel jimage = new JLabel();
  byte[] image;
  String imagepath;
  ImageIcon im1;
  String p = "";

  public ImageIcon seticon(String m, byte[] image) {
    if (m != null) {
      im1 = new ImageIcon(m);
    } else {
      im1 = new ImageIcon(image);
    }
    return im1;
  }

  public ResumeGeneratorHomePage() {
    super("Resume Generator");
    setLayout(null);

    JMenuBar jb = new JMenuBar();
    setJMenuBar(jb);
    JMenu jm1 = new JMenu("File");
    jb.add(jm1);

    JMenu jm2 = new JMenu("Format");
    jb.add(jm2);
    JMenu jm3 = new JMenu("Tool");
    jb.add(jm3);

    JMenu jm4 = new JMenu("View");
    jb.add(jm4);
    JMenu jm = new JMenu("Log out");
    JMenuItem jl1 = new JMenuItem("Logout");

    jb.add(Box.createHorizontalGlue());
    jb.add(jm);

    jm.add(jl1);

    jl1.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          MyFrame frm = new MyFrame();
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frm.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
          frm.setVisible(true);
          setVisible(false);
        }
      }
    );

    PersonInformations.setBounds(100, 50, 300, 200);
    PersonInformationslabel.setFont(new Font("", Font.BOLD, 15));
    add(PersonInformationslabel);
    PersonInformationslabel.setBounds(110, 53, 300, 30);
    add(PIL1);
    PIL1.setBounds(115, 90, 100, 10);
    add(PTT1);
    PTT1.setBounds(200, 90, 100, 20);
    add(PIL2);
    PIL2.setBounds(115, 120, 100, 10);
    add(PTT2);
    PTT2.setBounds(200, 120, 100, 20);

    add(PIL3);
    PIL3.setBounds(115, 150, 50, 20);
    bg.add(PIGB1);
    bg.add(PIGB2);

    add(PIGL1);
    PIGL1.setBounds(200, 150, 50, 20);

    add(PIGB1);
    PIGB1.setBounds(230, 150, 20, 20);

    add(PIGL2);
    PIGL2.setBounds(260, 150, 100, 20);

    add(PIGB2);
    PIGB2.setBounds(310, 150, 50, 20);

    add(PIL4);
    PIL4.setBounds(115, 180, 100, 20);
    add(PTT4);
    PTT4.setBounds(200, 180, 100, 20);
    add(PIL5);
    PIL5.setBounds(115, 210, 50, 20);
    add(PTT5);
    PTT5.setBounds(200, 210, 100, 20);

    //#
    ContactInformations.setBounds(100, 290, 300, 170);
    ContactInformationsLabel.setFont(new Font("", Font.BOLD, 15));
    add(ContactInformationsLabel);
    ContactInformationsLabel.setBounds(110, 293, 300, 30);
    add(CIL1);
    CIL1.setBounds(115, 330, 60, 10);
    add(CIT1);
    CIT1.setBounds(200, 330, 100, 20);
    add(CIL2);
    CIL2.setBounds(115, 360, 60, 10);
    add(CIT2);
    CIT2.setBounds(200, 360, 100, 20);
    add(CIL3);
    CIL3.setBounds(115, 390, 50, 20);
    add(CIT3);
    CIT3.setBounds(200, 390, 100, 20);
    add(CIL4);
    CIL4.setBounds(115, 420, 50, 20);
    add(CIT4);
    CIT4.setBounds(200, 420, 100, 20);

    //#
    Summary.setBounds(100, 500, 300, 180);
    SummaryLabel.setFont(new Font("", Font.BOLD, 15));
    add(SummaryLabel);
    SummaryLabel.setBounds(110, 503, 300, 30);
    add(SMA1);
    SMA1.setBounds(110, 535, 270, 130);

    SMA1.setLineWrap(true);

    exper.setBounds(1060, 290, 270, 180);
    expLabel.setFont(new Font("", Font.BOLD, 15));
    add(expLabel);
    expLabel.setBounds(1070, 280, 300, 50);
    add(exp);
    exp.setBounds(1075, 319, 240, 140);
    exp.setLineWrap(true);

    Educations.setBounds(500, 53, 500, 200);

    EducationsLabel.setFont(new Font("", Font.BOLD, 15));
    add(EducationsLabel);
    EducationsLabel.setBounds(510, 53, 300, 50);
    add(EDT1);
    EDT1.setBounds(600, 90, 150, 20);
    add(EDT2);
    EDT2.setBounds(600, 120, 150, 20);
    add(EDT3);
    EDT3.setBounds(600, 150, 150, 20);
    add(EDT4);
    EDT4.setBounds(600, 180, 150, 20);
    add(EDT5);
    EDT5.setBounds(800, 90, 150, 20);
    add(EDT6);
    EDT6.setBounds(800, 120, 150, 20);
    add(EDT7);
    EDT7.setBounds(800, 150, 150, 20);
    add(EDT8);
    EDT8.setBounds(800, 180, 150, 20);
    JTextField Serach = new JTextField(10);

    JLabel Serachl = new JLabel("Serach");
    add(Serach);

    add(Serachl);
    Serach.setBounds(1160, 7, 200, 20);
    Serachl.setBounds(1090, 7, 200, 20);
    Skills.setBounds(500, 290, 200, 180);

    SkillsLabel.setFont(new Font("", Font.BOLD, 15));
    add(SkillsLabel);
    SkillsLabel.setBounds(510, 285, 300, 50);
    add(SKT1);
    SKT1.setBounds(540, 330, 50, 20);
    add(SKT2);
    SKT2.setBounds(540, 360, 50, 20);
    add(SKT3);
    SKT3.setBounds(540, 390, 50, 20);
    add(SKT4);
    SKT4.setBounds(540, 420, 50, 20);
    add(SKT5);
    SKT5.setBounds(620, 330, 50, 20);
    add(SKT6);
    SKT6.setBounds(620, 360, 50, 20);
    add(SKT7);
    SKT7.setBounds(620, 390, 50, 20);
    add(SKT8);
    SKT8.setBounds(620, 420, 50, 20);
    Languages.setBounds(770, 290, 250, 180);

    LanguagesLabel.setFont(new Font("", Font.BOLD, 15));
    add(LanguagesLabel);
    LanguagesLabel.setBounds(780, 285, 300, 50);
    add(LEL1);

    LEL1.setBounds(785, 340, 100, 20);
    add(LE1);
    LE1.setBounds(890, 340, 100, 20);
    LE1.setSelectedIndex(1);
    add(LEL2);

    LEL2.setBounds(785, 380, 100, 20);
    add(LE2);
    LE2.setBounds(890, 380, 100, 20);
    lg1 = "Arabic";

    LE1.addItemListener(
      new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
          lg1 = list1[LE1.getSelectedIndex()];
        }
      }
    );

    lg2 = "English";
    LE2.addItemListener(
      new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
          lg2 = list1[LE2.getSelectedIndex()];
        }
      }
    );

    select =
      new JButton(
        new ImageIcon("C:\\Users\\mzyon\\Downloads\\icons8-add-image-30.png")
      );

    select.setBounds(1100, 100, 200, 150);
    select.setBackground(Color.white);
    JPanel imagepanel = new JPanel();

    imagepanel.setBounds(1100, 100, 200, 150);
    select.addActionListener(
      new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
          JFileChooser fi = new JFileChooser();
          fi.setCurrentDirectory(new File("Pictures"));
          FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "All picture",
            "png",
            "jpeg",
            "jpg"
          );
          fi.showOpenDialog(null);
          fi.addChoosableFileFilter(filter);
          File f = fi.getSelectedFile();
          if (f != null) {
            p = f.getAbsolutePath();
            select.setIcon(seticon(p, image));
          }
        }
      }
    );

    Generate.setBounds(1050, 600, 150, 30);

    Save.setBounds(1230, 600, 90, 30);
    Generate.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            CV jq = new CV(
              CIT1.getText(),
              CIT2.getText(),
              CIT3.getText(),
              CIT4.getText(),
              PTT1.getText(),
              PTT2.getText(),
              SMA1.getText(),
              EDT1.getText(),
              EDT2.getText(),
              EDT3.getText(),
              EDT4.getText(),
              EDT5.getText(),
              EDT6.getText(),
              EDT7.getText(),
              EDT8.getText(),
              SKT1.getText(),
              SKT2.getText(),
              SKT3.getText(),
              SKT4.getText(),
              SKT5.getText(),
              SKT6.getText(),
              SKT7.getText(),
              SKT8.getText(),
              lg1,
              lg2,
              QualficationsA.getText(),
              exp.getText(),
              p
            );
          } catch (IOException ex) {
            Logger
              .getLogger(ResumeGeneratorHomePage.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        }
      }
    );

    Save.addActionListener(
      new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            if (CV.src != null && LogIn.user != null) {
              File f = new File(CV.src);
              FileInputStream ff = new FileInputStream(f);
              String sql1 = String.format(
                "Insert into filepdf(username ,file" +
                ")\n" +
                "Values ('%s','%s');",
                LogIn.user,
                ff
              );

              String db_url =
                "jdbc:mysql://localhost:3307/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
              String db_username = "root";
              String db_password = "";
              Connection con = DriverManager.getConnection(
                db_url,
                db_username,
                db_password
              );
              Statement s = con.createStatement();
              s.executeUpdate(sql1);
            }
          } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
          } catch (FileNotFoundException ex) {
            Logger
              .getLogger(ResumeGeneratorHomePage.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        }
      }
    );
    Qualfications.setBounds(530, 500, 450, 180);

    QualficationsLabel.setFont(new Font("", Font.BOLD, 15));
    add(QualficationsLabel);
    QualficationsLabel.setBounds(538, 503, 300, 30);
    add(QualficationsA);
    QualficationsA.setBounds(543, 535, 420, 130);
    QualficationsA.setLineWrap(true);
    getContentPane().setBackground(Color.WHITE);

    add(PersonInformations);
    add(ContactInformations);
    add(Summary);
    add(Educations);
    add(Skills);
    add(Languages);
    add(Generate);
    add(Save);
    add(Qualfications);
    add(exper);
    add(select);
    imagepanel.add(jimage);
    add(imagepanel);
  }
}
//
//
