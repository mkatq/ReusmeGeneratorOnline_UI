package ResumeGeneratorPackage;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import java.io.IOException;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.BaseDirection;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TabAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.layout.element.Image;



public class CV {
    
    static String src = null;


    public CV(String Email, String Phone, String Address, String LinkedIn, String First_Name, String Second_Name, String SMA1, String EDT1, String EDT2, String EDT3, String EDT4, String EDT5, String EDT6, String EDT7, String EDT8, String SKT1, String SKT2, String SKT3, String SKT4, String SKT5, String SKT6, String SKT7, String SKT8, String lg1, String lg2, String QualficationsA, String expr, String p) throws IOException {
        Document document = null;
        String Srcpath = null;
        //	      ---------------------------------------------------------------------------------------------------------
        if (!First_Name.isEmpty() && !Second_Name.isEmpty()) {
            String PDFname = First_Name + "_" + Second_Name + "_Resume.pdf"; 
            Srcpath = PDFname; 
            
            PdfWriter pdfwriter = new PdfWriter(Srcpath);
            PdfDocument pdfDocument = new PdfDocument(pdfwriter);
            document = new Document(pdfDocument);
          src =  Srcpath;
            
            
        }
        
          

        com.itextpdf.kernel.colors.Color Primiry_color = new DeviceRgb(47, 79, 79);
        com.itextpdf.kernel.colors.Color Secondy_color = new DeviceRgb(0, 128, 128);
        com.itextpdf.kernel.colors.Color WHITE = new DeviceRgb(255, 255, 255);

        Style MainHeading = new Style();
        MainHeading.setFontColor(Primiry_color).setBold().setFontSize(10).setTextAlignment(TextAlignment.LEFT);

        Style SubHeading = new Style();
        SubHeading.setFontSize(10).setFontColor(Secondy_color).setBold();

        Style MainText = new Style();
        MainText.setFontSize(8);
if(document != null)
{
        if (p != "") {
            String imageFile = p;
            ImageData data = ImageDataFactory.create(imageFile);
            Image img = new Image(data);
            img.scaleAbsolute(100f, 100f);
            img.setFixedPosition(20f, 730f);
            document.add(img);
        }


        Paragraph Address_Para = new Paragraph().setTextAlignment(TextAlignment.RIGHT);

        Text Email_Head = new Text(Email + " :Email").addStyle(MainText);;
        Text Address1 = new Text("\n" + Address + " :Address").addStyle(MainText);;
        Text Phone1 = new Text("\n" + Phone + " :Phone").addStyle(MainText);;
        Text LinkedIn1 = new Text("\n" + LinkedIn + " :LinkedIn").addStyle(MainText);;


        Address_Para.add(Email_Head)
            .add(Address1)
            .add(Phone1)
            .add(LinkedIn1)
            .add(new Text("\n"))
            .add(new Text("\n"))
            .add(new Text("\n "));

        document.add(Address_Para);


        Paragraph Full_Name = new Paragraph()
            .setBackgroundColor(Primiry_color, 1000)
            .setHeight(30)
            .setPadding(3)
            .setPaddingLeft(6)
            .setMarginBottom(10);

        Text Name = new Text(" " + First_Name + " " + Second_Name).setFontColor(WHITE)
            .setFontSize(20f);

        Full_Name.add(Name);
        document.add(Full_Name);


        float columnWidth[] = {
            20f,
            200f,
            200f,
            200f
        };
        Table table = new Table(columnWidth);
        table.setPaddingTop(7f);
        table.setBorder(new SolidBorder(WHITE, 1));

        if (!SMA1.isEmpty()) {
            Paragraph Suumary = new Paragraph()
                .setTextAlignment(TextAlignment.JUSTIFIED)
                .setPaddingLeft(15f).setMaxWidth(300);
            Text summarytext = new Text("\n" + SMA1)
                .addStyle(MainText);
            Suumary.add(summarytext);

            Paragraph su = new Paragraph();
            Text summarylabel = new Text("Professional Summary").setRelativePosition(0, 0, 0, 0)
                .addStyle(MainText);
            su.add(summarylabel);



            table.addCell(new Cell(0, 1)
                .setBorder(new SolidBorder(WHITE, 1))
                .setBorderBottom(new SolidBorder(Primiry_color, 1))
                .add(su)
                .setPadding(7f)
                .addStyle(MainHeading)
                .setTextAlignment(TextAlignment.RIGHT)
            );
            table.addCell(new Cell(0, 3)
                .setPadding(7f)
                .add(Suumary)
                .setBorder(new SolidBorder(WHITE, 1))
                .setBorderBottom(new SolidBorder(Primiry_color, 1)));

        }



        Paragraph edc = new Paragraph()
            .setTextAlignment(TextAlignment.JUSTIFIED)
            .setPaddingLeft(15f).setMaxWidth(300);


        Text edctext1 = new Text("\n" + EDT1)
            .addStyle(MainText);

        Text edctext2 = new Text("\n" + EDT2)
            .addStyle(MainText);

        Text edctext3 = new Text("\n" + EDT3)
            .addStyle(MainText);



        Text edctext4 = new Text("\n" + EDT4)
            .addStyle(MainText);


        Text edctext5 = new Text("\n" + EDT5)
            .addStyle(MainText);


        Text edctext6 = new Text("\n" + EDT6)
            .addStyle(MainText);

        Text edctext7 = new Text("\n" + EDT7)
            .addStyle(MainText);
        Text edctext8 = new Text("\n" + EDT8)
            .addStyle(MainText);


        edc.add(edctext1).add(edctext2).add(edctext3).add(edctext4).add(edctext5).add(edctext6).add(edctext7).add(edctext8);



        Paragraph edc1 = new Paragraph();
        Text edclabel = new Text("Educations").setRelativePosition(0, 0, 4, 0)
            .addStyle(MainText);
        edc1.add(edclabel);



        table.addCell(new Cell(0, 1)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1))
            .add(edc1)
            .setPadding(7f)
            .addStyle(MainHeading)
            .setTextAlignment(TextAlignment.RIGHT)
        );
        table.addCell(new Cell(0, 3)
            .setPadding(7f)
            .add(edc)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1)));



        Paragraph skilss1 = new Paragraph()
            .setTextAlignment(TextAlignment.JUSTIFIED)
            .setPaddingLeft(5f).setMaxWidth(150);

        Paragraph skilss2 = new Paragraph()
            .setTextAlignment(TextAlignment.JUSTIFIED)
            .setPaddingLeft(5f).setMaxWidth(150);


        Text skilst1 = new Text("\n" + SKT1)
            .addStyle(MainText);

        Text skilst2 = new Text("\n" + SKT2)
            .addStyle(MainText);

        Text skilst3 = new Text("\n" + SKT3)
            .addStyle(MainText);



        Text skilst4 = new Text("\n" + SKT4)
            .addStyle(MainText);


        Text skilst5 = new Text("\n" + SKT5)
            .addStyle(MainText);


        Text skilst6 = new Text("\n" + SKT6)
            .addStyle(MainText);

        Text skilst7 = new Text("\n" + SKT7)
            .addStyle(MainText);
        Text skilst8 = new Text("\n" + SKT8)
            .addStyle(MainText);


        skilss1.add(skilst1).add(skilst2).add(skilst3).add(skilst4);
        skilss2.add(skilst5).add(skilst6).add(skilst7).add(skilst8);


        Paragraph skils1 = new Paragraph();
        Text skilslabel = new Text("Skills").setRelativePosition(0, 0, 16, 0)
            .addStyle(MainText);
        skils1.add(skilslabel);






        table.addCell(new Cell(0, 0)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1))
            .add(skils1)
            .setPadding(7f)
            .addStyle(MainHeading)
            .setTextAlignment(TextAlignment.RIGHT)
        );
        table.addCell(new Cell(0, 1)
            .setPadding(7f)
            .add(skilss1)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1)));


        table.addCell(new Cell(0, 2)
            .setPadding(7f)
            .add(skilss2)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1)));


        Paragraph Lnaguage = new Paragraph()
            .setTextAlignment(TextAlignment.JUSTIFIED)
            .setPaddingLeft(15f).setMaxWidth(300);
        Text Lnaguagetext1 = new Text("\n" + lg1)
            .addStyle(MainText);
        Text Lnaguagetext2 = new Text("\n" + lg2)
            .addStyle(MainText);
        Lnaguage.add(Lnaguagetext1).add(Lnaguagetext2);

        Paragraph lg = new Paragraph();
        Text lglabel = new Text("Languages").setRelativePosition(0, 0, 4, 0)
            .addStyle(MainText);
        lg.add(lglabel);


        table.addCell(new Cell(0, 1)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1))
            .add(lg)
            .setPadding(7f)
            .addStyle(MainHeading)
            .setTextAlignment(TextAlignment.RIGHT)
        );
        table.addCell(new Cell(0, 3)
            .setPadding(7f)
            .add(Lnaguage)
            .setBorder(new SolidBorder(WHITE, 1))
            .setBorderBottom(new SolidBorder(Primiry_color, 1)));


        if (!QualficationsA.isEmpty()) {
            Paragraph QualficationsAp = new Paragraph()
                .setTextAlignment(TextAlignment.JUSTIFIED)
                .setPaddingLeft(15f).setMaxWidth(300);
            Text QualficationsApt = new Text("\n" + QualficationsA)
                .addStyle(MainText);
            QualficationsAp.add(QualficationsApt);

            Paragraph QualficationsAo = new Paragraph();
            Text Qualficationslabel = new Text("Qualfications")
                .addStyle(MainText);
            QualficationsAo.add(Qualficationslabel);



            table.addCell(new Cell(0, 1)
                .setBorder(new SolidBorder(WHITE, 1))
                .setBorderBottom(new SolidBorder(Primiry_color, 1))
                .add(QualficationsAo)
                .setPadding(7f)
                .addStyle(MainHeading)
                .setTextAlignment(TextAlignment.RIGHT)
            );
            table.addCell(new Cell(0, 3)
                .setPadding(7f)
                .add(QualficationsAp)
                .setBorder(new SolidBorder(WHITE, 1))
                .setBorderBottom(new SolidBorder(Primiry_color, 1)));
        }

        if (!expr.isEmpty()) {
            Paragraph exAp = new Paragraph()
                .setTextAlignment(TextAlignment.JUSTIFIED)
                .setPaddingLeft(15f).setMaxWidth(300);
            Text expt = new Text("\n" + expr)
                .addStyle(MainText);
            exAp.add(expt);

            Paragraph exo = new Paragraph();
            Text exlabel = new Text("Experiences")
                .addStyle(MainText);
            exo.add(exlabel);


            table.addCell(new Cell(0, 1)
                .setBorder(new SolidBorder(WHITE, 1))
                .setBorderBottom(new SolidBorder(Primiry_color, 1))
                .add(exo)
                .setPadding(7f)
                .addStyle(MainHeading)
                .setTextAlignment(TextAlignment.RIGHT)
            );
            table.addCell(new Cell(0, 3)
                .setPadding(7f)
                .add(exAp)
                .setBorder(new SolidBorder(WHITE, 1))
                .setBorderBottom(new SolidBorder(Primiry_color, 1)));

        }
        document.add(table);
        document.close();
        
        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + Srcpath );
    }
    }

}