package com.prathi.test;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.swing.text.StyleConstants.FontConstants;
 
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
 
 
public class PdfFileGenerate {  
        public static void main(String[] args) throws Exception{
                
                /* Create Connection objects */
                Class.forName ("oracle.jdbc.OracleDriver"); 
             //   Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.144.17.81:1527/ordcmsut", "cmsemrfiid", "emrfiidcms321#");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "Prathi#123");
                Statement stmt = conn.createStatement();
                Statement stmt1 = conn.createStatement();
                String custId=null;
                /* Define the SQL query */
                
                ResultSet query_set= stmt.executeQuery("select ID,FIRST_NAME ,LAST_NAME ,SALARY from employee");
                
				 
        /* Step-2: Initialize PDF documents - logical objects */
             
                
                
                Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
                Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
                Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
                Document my_pdf_report = new Document();
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("D://PdfGenerateTest//test_1.pdf"));
                
              
                my_pdf_report.open();          
                
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
                
               
                
                /* Attach report table to PDF */
                my_pdf_report.add(my_report_table);                       
                my_pdf_report.close();
                
                /* Close all DB related objects */
                query_set.close();
                stmt.close(); 
                conn.close();               
                
        }
}

