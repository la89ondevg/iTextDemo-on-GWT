package com.wissen.pdfgenerator;

/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Ritu Raj  on 11:13:41 AM
 */
import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Ritu Raj
 * 
 *         Create Date : 16-Jan-2010
 */
public class Demo {

    /**
     * @param args
     */
    Document document;

    Chunk    space   = new Chunk("   ");

    Chunk    newline = new Chunk("\n");

    Font     f1      = new Font(Font.COURIER, 26, Font.BOLD);

    Font     f2      = new Font(Font.COURIER, 14, Font.BOLD);

    public void head1() {
        //heading1
        Paragraph paragraph = new Paragraph("Sheet1");
        paragraph.setAlignment(Element.ALIGN_CENTER);
        try {
            document.add(paragraph);
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        //heading1
    }

    public void subHead() {
        //subheadings
        PdfPTable t3 = new PdfPTable(2);
        PdfPCell c1, c2;
        c1 = new PdfPCell();
        c2 = new PdfPCell();
        Chunk h1, h2;
        h1 = new Chunk("Wissen Labs", new Font(Font.TIMES_ROMAN, 14, Font.BOLD));
        f1.setColor(BaseColor.BLUE);
        h2 = new Chunk("INVOICE", f1);
        float l[] = { 80, 30 };
        try {
            t3.setWidths(l);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        c1.addElement(h1);
        c2.addElement(h2);
        c1.setBorder(0);
        c2.setBorder(0);
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        t3.addCell(c1);
        t3.addCell(c2);
        t3.setHorizontalAlignment(Element.ALIGN_CENTER);
        try {
            document.add(t3);
        } catch (DocumentException e) {
            e.getMessage();
        }
        //subheadings
    }

    public void firstTable(String dt, String inv_no, String cust_id) {
        //first table
        PdfPTable t3 = new PdfPTable(2);
        float l[] = { 60, 40 };
        PdfPCell c1, c2;
        c1 = new PdfPCell();
        c2 = new PdfPCell();
        c1.setBorder(0);
        c2.setBorder(0);
        c1.addElement(space);
        PdfPTable t2 = new PdfPTable(2);
        PdfPTable t1 = new PdfPTable(2);
        t1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        PdfPCell dateCellh, dateCelld, invoiceCellh, invoiceCelld, custidCellh, custidCelld;
        dateCellh = new PdfPCell(new Phrase("Date"));
        dateCellh.setBorder(0);
        invoiceCellh = new PdfPCell(new Phrase("INVOICE#"));
        invoiceCellh.setBorder(0);
        custidCellh = new PdfPCell(new Phrase("Customer ID"));
        custidCellh.setBorder(0);
        dateCelld = new PdfPCell(new Phrase(dt));
        dateCelld.setBorder(0);
        dateCelld.setBackgroundColor(BaseColor.LIGHT_GRAY);
        invoiceCelld = new PdfPCell(new Phrase(inv_no));
        custidCelld = new PdfPCell(new Phrase(cust_id));
        t1.addCell(dateCellh);
        t1.addCell(dateCelld);
        t1.addCell(invoiceCellh);
        t1.addCell(invoiceCelld);
        t1.addCell(custidCellh);
        t1.addCell(custidCelld);
        c2.addElement(t1);
        t3.addCell(c1);
        t3.addCell(c2);
        try {
            document.add(t3);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        //first table
    }

    public void addHead() {
        //address header
        PdfPTable t = new PdfPTable(1);
        PdfPCell c1, c2, c3;
        Paragraph addH = new Paragraph();
        addH.setAlignment(Element.ALIGN_LEFT);
        c1 = new PdfPCell();
        c1.setBorder(0);
        c1.addElement(new Phrase("4th Floor, Rajvi Enclave"));
        c2 = new PdfPCell();
        c2.setBorder(0);
        c2.addElement(new Phrase("New Pandit Colony, Nasik, Maharashtra, India"));
        c3 = new PdfPCell();
        c3.setBorder(0);
        c3.addElement(new Phrase("Phone: 91 253 301 2029/91 253 301 2038"));
        t.addCell(c1);
        t.addCell(c2);
        t.addCell(c3);
        Phrase addP = new Phrase("4th Floor, Rajvi Enclave" + "\nNew Pandit Colony, Nasik, Maharashtra, India"
                + "\nPhone: 91 253 301 2029/91 253 301 2038\n\n");
        addH.add(addP);
        try {
            document.add(t);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        //address header
    }

    public void billToHead(String cust_nm, String cust_add, String city) {
        //bill to header
        PdfPTable t = new PdfPTable(2);
        PdfPCell con = new PdfPCell();
        con.setBorder(0);
        PdfPTable t2 = new PdfPTable(1);
        t2.setHorizontalAlignment(Element.ALIGN_LEFT);
        t2.setWidthPercentage(40);
        PdfPCell billtoH, billtonm, billtoadd, billtocity, c;
        f2.setColor(BaseColor.WHITE);
        billtoH = new PdfPCell(new Phrase("Bill to ", f2));
        billtoH.setBackgroundColor(BaseColor.BLUE);
        billtoH.setBorder(0);
        billtonm = new PdfPCell(new Phrase(cust_nm));
        billtonm.setBorder(0);
        billtoadd = new PdfPCell(new Phrase(cust_add));
        billtoadd.setBorder(0);
        billtocity = new PdfPCell(new Phrase(city + "\n"));
        billtocity.setBorder(0);
        t2.addCell(billtoH);
        t2.addCell(billtonm);
        t2.addCell(billtoadd);
        t2.addCell(billtocity);
        PdfPTable er = new PdfPTable(2);
        c = new PdfPCell(t2);
        c.setBorder(0);
        er.addCell(c);
        con.addElement(space);
        er.addCell(con);
        try {
            document.add(er);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        //bill to header
    }

    public void descTable(String attrib[][]) {
        //description table
        f2.setColor(BaseColor.WHITE);
        StringBuffer alldesc, allamt;
        alldesc = new StringBuffer();
        allamt = new StringBuffer();
        PdfPTable t4 = new PdfPTable(1);
        PdfPTable t3 = new PdfPTable(2);
        t3.setHorizontalAlignment(Element.ALIGN_CENTER);
        float wide[] = { 85, 15 };
        try {
            t3.setWidths(wide);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        PdfPCell descH, amtH, descd, amtd;
        descH = new PdfPCell(new Phrase("\t\tdescription\t\t", f2));
        descH.setBackgroundColor(BaseColor.BLUE);
        amtH = new PdfPCell(new Phrase("amount", f2));
        amtH.setBackgroundColor(BaseColor.BLUE);
        for (int i = 0; i < (attrib.length) / 12; i++) {
            alldesc.append(attrib[i][3]);
            alldesc.append(newline);
            allamt.append(attrib[i][4]);
            allamt.append(newline);
        }
        descd = new PdfPCell(new Phrase(alldesc.toString()));
        descd.setExtraParagraphSpace(200);
        amtd = new PdfPCell(new Phrase(allamt.toString()));
        amtd.setHorizontalAlignment(Element.ALIGN_RIGHT);
        t3.addCell(descH);
        t3.addCell(amtH);
        t3.addCell(descd);
        t3.addCell(amtd);
        try {
            document.add(t3);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        //description table
    }

    public void descFoot(String subtot, String rate, String tax, String other, String total, PdfWriter writer) {
        //description footer
        PdfPTable t4, t41, t42;
        t4 = new PdfPTable(2);
        t4.setTotalWidth(50);
        t41 = new PdfPTable(1);
        PdfPCell c2; //for footer comments
        {
            PdfPCell commh, commd;
            commh = new PdfPCell(new Phrase("OTHER COMMENTS"));
            commh.setBackgroundColor(BaseColor.GRAY);
            commd = new PdfPCell(new Phrase("1. Total payment due in 30 days" + "\n2. Please include the invoice number on your check"));
            t41.addCell(commh);
            t41.addCell(commd);
            c2 = new PdfPCell(t41);
            c2.setBorder(0);
        }
        t42 = new PdfPTable(2);
        t42.setWidthPercentage(50);
        t42.setHorizontalAlignment(Element.ALIGN_RIGHT);
        PdfPCell c1; //for footer description
        {
            t42.setTotalWidth(180f);
            PdfPCell subtoth, subtotd, taxrateh, taxrated, taxh, taxd, otherh, otherd, totalh, totald, notify1, notify2;
            subtoth = new PdfPCell(new Phrase("SUBTOTAL"));
            subtoth.setBorder(0);
            taxrateh = new PdfPCell(new Phrase("TAX RATE"));
            taxrateh.setBorder(0);
            otherh = new PdfPCell(new Phrase("OTHER"));
            otherh.setBorder(Rectangle.BOTTOM);
            totalh = new PdfPCell(new Phrase("TOTAL", new Font(Font.COURIER, 12, Font.BOLD)));
            totalh.setBorder(Rectangle.TOP);
            subtotd = new PdfPCell(new Phrase("$" + subtot));
            subtotd.setBorder(0);
            subtotd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            taxrated = new PdfPCell(new Phrase(rate + "%"));
            taxrated.setBorder(0);
            taxh = new PdfPCell(new Phrase("TAX"));
            taxh.setBorder(0);
            taxd = new PdfPCell(new Phrase("$" + tax));
            taxd.setBorder(0);
            taxd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            otherd = new PdfPCell(new Phrase("$" + other));
            otherd.setBorder(Rectangle.BOTTOM);
            totald = new PdfPCell(new Phrase("$" + total));
            totald.setBorder(Rectangle.TOP);
            totald.setBackgroundColor(BaseColor.LIGHT_GRAY);
            notify1 = new PdfPCell(new Phrase("Make checks available to"));
            notify1.setBorder(0);
            notify1.setColspan(2);
            notify1 = new PdfPCell(new Phrase("Make checks available to", new Font(Font.COURIER, 12)));
            notify1.setBorder(0);
            notify1.setColspan(2);
            notify2 = new PdfPCell(new Phrase("Wissen Labs"));
            notify2.setBorder(0);
            notify2.setColspan(2);
            t42.addCell(subtoth);
            t42.addCell(subtotd);
            t42.addCell(taxrateh);
            t42.addCell(taxrated);
            t42.addCell(taxh);
            t42.addCell(taxd);
            t42.addCell(otherh);
            t42.addCell(otherd);
            t42.addCell(totalh);
            t42.addCell(totald);
            t42.addCell(notify1);
            t42.addCell(notify2);
            float currHeight = writer.getVerticalPosition(true);
            PdfContentByte b = writer.getDirectContent();
            t42.writeSelectedRows(0, -1, 354, currHeight, writer.getDirectContent());
        }
        c2.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1 = new PdfPCell(new Phrase(""));
        c1.setBorder(0);
        t4.addCell(c2);
        t4.addCell(c1);
        t4.setHorizontalAlignment(Element.ALIGN_CENTER);
        try {
            document.add(newline);
            document.add(newline);
            document.add(t4);
            document.add(newline);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        //description footer
    }

    public void paraFoot() {
        //footer para
        Paragraph p4 = new Paragraph();
        {
            p4.setAlignment(Element.ALIGN_MIDDLE);
            Phrase p5 = new Phrase(Element.ALIGN_CENTER, "If you have any questions about this invoice, please contact\n" + "Sushrut Bidwai,");
            Phrase p6 = new Phrase(Element.ALIGN_CENTER, ",\n +91 986 023 8124");
            Font f3 = new Font(Font.COURIER, 12, Font.BOLD);
            f3.setColor(BaseColor.BLUE);
            Anchor anchor = new Anchor("sushrut@wissen.co.in", f3);
            anchor.setReference("mailto:sushrut@wissen.co.in");
            Phrase p7 = new Phrase("\n\nThank You For Your Business!", new Font(Font.COURIER, 16, Font.BOLDITALIC));
            p4.add(p5);
            p4.add(anchor);
            p4.add(p6);
            p4.add(p7);
        }
        p4.setAlignment(Element.ALIGN_CENTER);
        try {
            document.add(p4);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        // footer para
    }

    public void createPdf(String nm) {
        {
            // TODO Auto-generated method stub
            this.document = new Document(PageSize.A4, 2, 2, 2, 2);/*new Document(PageSize.LETTER);*/
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
                DBFetch d = new DBFetch();
                String attrib[][] = d.check(nm);
                this.document.open();
                document.setMarginMirroring(true);

                this.head1();
                this.subHead();
                this.firstTable(attrib[0][2], attrib[0][0], attrib[0][1]);
                this.addHead();
                this.billToHead(attrib[0][9], attrib[0][10], attrib[0][11]);
                this.descTable(attrib);
                Double subtot = 0.0;
                try {
                    for (int v = 0; v < 12; v++)
                        subtot = subtot + Integer.parseInt(attrib[v][4]);
                } catch (Exception e) {
                }
                Double tax, other, tot, tax_rate = 11.0;//tax rate for now constant
                tax = (subtot * (11.0 / 100.0));
                System.out.println("total calculated " + tax);
                other = 500.0;
                tot = tax + subtot + other;
                this.descFoot(subtot.toString(), tax_rate.toString(), tax.toString(), other.toString(), tot.toString(), writer);
                this.paraFoot();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            this.document.close();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Demo d = new Demo();
            d.createPdf("Paul Graham");//passing user name
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
