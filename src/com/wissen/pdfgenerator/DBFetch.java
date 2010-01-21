package com.wissen.pdfgenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Ritu Raj  on 5:14:25 PM
 */

/**
 * @author Ritu Raj
 *
 * Create Date : 18-Jan-2010
 */

public class DBFetch {
    

    private static final String dbClassName = "com.mysql.jdbc.Driver";

    private static final String CONNECTION  = "jdbc:mysql://127.0.0.1/test";
    public static void main(String args[])
    {
        DBFetch d=new DBFetch();
        try {
            String s[][]=d.check("Paul Graham");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String[][] check(String nm) throws ClassNotFoundException, SQLException {
        System.out.println(dbClassName);
        Class.forName(dbClassName);
        Properties p = new Properties();
        p.put("user", "root");
        p.put("password", "wissen");
        String attrib[][] = new String[12][12];
        try {
            Connection c = DriverManager.getConnection(CONNECTION, p);
            Statement stmt = c.createStatement();
            ResultSet rs;
            String sql = " select * from invoice as i, cust as c where c.cust_id=i.cust_id && cust_nm='"+nm+"' ";
            rs = stmt.executeQuery(sql);

           while(rs.next()) {
               int rows=0;
                for(int i=0;i<12;i++)
                {
                    int a=i+1;
                    attrib[rows][i] = rs.getString(a);
                }
                rows++;
              }
            c.close();
            stmt.close();
            return attrib;
        } catch (Exception ex) {
            System.err.println("SQLException: " + ex.getMessage());
            return attrib;
        }

    }


}
