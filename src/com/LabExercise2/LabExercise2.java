/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LabExercise2;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Jinno
 */
public class LabExercise2 {
    public static void main(String[] args)throws Exception {
        
        /*FILE READING START*/
        FileReader fl = new FileReader("info.txt");
        Properties prop = new Properties();
        prop.load(fl);
        BufferedReader br = new BufferedReader(fl);
        /*FILE READING END*/
        
        /*INPUT FILE INFO START*/
        String dname = prop.readLine();
        Class.forName(dname);
        String url, name, pass;
        url = br.readLine();
        name = br.readLine();
        pass = br.readLine();
        Connection conn = DriverManager.getConnection(url, name, pass);
        String query = br.readLine();
        Statement stmt = conn.createStatement();
        
        /*EXECUTE SQL START*/
        if(stmt.execute(query)==true){
            ResultSet rst = stmt.getResultSet();
            /*DISPLAY INFO START*/
        System.out.println("OUTPUT");
        while (rst.next()) {
        System.out.println(" STUDENT_NAME: " + rst.getString("STUDENT_NAME").trim());       
        System.out.println(" STUDENT_NUMBER: " + rst.getString("STUDENT_NUMBER").trim());
        System.out.println(" COURSE: " + rst.getString("COURSE").trim());
        System.out.println("");
        rst.close();
      }
            /*DISPLAY INFO END*/
        }
        else {
            ResultSet rst = stmt.getResultSet();
            /*DISPLAY INFO START*/
        System.out.println("OUTPUT");
        System.out.println("Number of Rows Affected: ");
        System.out.println(stmt.getUpdateCount());
            /*DISPLAY INFO END*/
        }
        /*EXECUTE SQL END*/
        
        /*INPUT FILE INFO END*/
        
        
      stmt.close();
      conn.close();
        /*System.out.println(br.readLine());
        
        
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());*/
    }
}
