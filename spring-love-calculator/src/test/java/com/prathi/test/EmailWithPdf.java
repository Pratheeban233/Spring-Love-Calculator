package com.prathi.test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
 
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * Email with PDF example.
 * <br><br>
 * Email sending code adapted from http://www.java-tips.org/other-api-tips/javamail/how-to-send-an-email-with-a-file-attachment.html.
 * @author Jee Vang
 *
 */
public class EmailWithPdf {
     
    /**
     * Sends an email with a PDF attachment.
     */
    public void email() {
        String smtpHost = "smtp.gmail.com"; //replace this with a valid host
        int smtpPort = 587; //replace this with a valid port
                 
        String sender = "msnasa11@gmail.com"; //replace this with a valid sender email address
        final String username = "msnasa11@gmail.com";//change accordingly
        final String password = "9566022371";//change accordingly
        
        String recipient = "mnprathi233@gmail.com"; //replace this with a valid recipient email address
        String content = "Please use Your customer id and last 4 digits of your mobile number for view the Pdf content "; //this will be the text of the email
        String subject = "Protected Pdf Test"; //this will be the subject of the email
         
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);  
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.user", username);
        properties.put("mail.smtp.password", password);
   
        Session session = Session.getDefaultInstance(properties,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });
         
        ByteArrayOutputStream outputStream = null;
         
        try {           
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(content);
             
            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(outputStream);
            byte[] bytes = outputStream.toByteArray();
             
            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("test_1.pdf");
                         
            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
             
            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(sender);
            InternetAddress iaRecipient = new InternetAddress(recipient);
             
            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);
             
            
            
            //send off the email
            Transport.send(mimeMessage);
            
            System.out.println("sent from " + sender + 
                    ", to " + recipient + 
                    "; server = " + smtpHost + ", port = " + smtpPort);   
            
            System.out.println("Mail sent successfully!!!!");
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }
    }
     
    /**
     * Writes the content of a PDF file (using iText API)
     * to the {@link OutputStream}.
     * @param outputStream {@link OutputStream}.
     * @throws Exception
     */
    public void writePdf(OutputStream outputStream) throws Exception {
    	
    	 String USER_PASSWORD = "password";
    	 String OWNER_PASSWORD = "pratheeban";
        Document document = new Document();
        //Encrypted PdfFile Password
        PdfWriter.getInstance(document, outputStream).setEncryption(USER_PASSWORD.getBytes(),
                OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
                PdfWriter.ENCRYPTION_AES_128);
         
        document.open();
        
        /* Create Connection objects */
        Class.forName ("oracle.jdbc.OracleDriver"); 
     //   Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.144.17.81:1527/ordcmsut", "cmsemrfiid", "emrfiidcms321#");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "Prathi#123");
        Statement stmt = conn.createStatement();
        /* Define the SQL query */
        
        ResultSet query_set= stmt.executeQuery("select ID,FIRST_NAME ,LAST_NAME ,SALARY from employee");
        
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(4);
        //create a cell object
        PdfPCell table_cell;
        
     // Defiles the relative width of the columns
        float[] columnWidths = new float[]{10f, 20f, 30f, 20f};
        my_report_table.setWidths(columnWidths);
        
        table_cell= new PdfPCell(new Paragraph("ID", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Paragraph("First Name", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Paragraph("Last Name", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Paragraph("Salary", FontFactory.getFont(FontFactory.COURIER_BOLD, 8)));
        my_report_table.addCell(table_cell);
       
       
        while (query_set.next()) {                
                            String rowNo = query_set.getString("id");
                            table_cell = new PdfPCell(new Paragraph(rowNo,FontFactory.getFont(FontFactory.COURIER, 8)));
                            my_report_table.addCell(table_cell);
                            String txnDttm = query_set.getString("FIRST_NAME");
                            table_cell = new PdfPCell(new Paragraph(txnDttm,FontFactory.getFont(FontFactory.COURIER, 8)));
                            my_report_table.addCell(table_cell);
                            String acctNo = query_set.getString("LAST_NAME");
                            table_cell = new PdfPCell(new Paragraph(acctNo,FontFactory.getFont(FontFactory.COURIER, 8)));
                            my_report_table.addCell(table_cell);
                            String txnAmt = query_set.getString("SALARY");
                            table_cell = new PdfPCell(new Paragraph(txnAmt,FontFactory.getFont(FontFactory.COURIER, 8)));
                            my_report_table.addCell(table_cell);
                         
                        }
         
        document.addTitle("Test PDF");
        document.addSubject("Testing email PDF");
        document.addKeywords("iText, email");
        document.addAuthor("Pratheeban");
        document.addCreator("Pratheeban");
         
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Chunk("hello!"));
        document.add(paragraph);
        document.add(my_report_table);
         
        document.close();
        
        /* Close all DB related objects */
        query_set.close();
        stmt.close(); 
        conn.close(); 
    }
     
    /**
     * Main method.
     * @param args No args required.
     */
    public static void main(String[] args) {
        EmailWithPdf demo = new EmailWithPdf();
        demo.email();
    }
}

