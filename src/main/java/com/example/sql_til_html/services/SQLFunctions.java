package com.example.sql_til_html.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLFunctions {

    static Connection con;
    static Statement stmt;
    static String sqlString;
    public static void main(String[] args) {


    }


    public static void connectDB(){
        System.out.println("Connecting to DB SQL");

        try
        {

            String url = "jdbc:mysql://localhost:3306/opgaver";


            con = DriverManager.getConnection(url,"root","Tim10ses");


            System.out.println("URL: " + url);
            System.out.println("Connection: " + con);

        }catch (Exception e){
            System.out.println("ERROR");
        }


    }
    public static void addToTable(String brugerNavn, String brugerMail){




        String insertSQL = "INSERT INTO free_money " +
                "(`brugerNavn`,`brugerMail`) " +
                "VALUES('"+brugerNavn+"','"+brugerMail+"');";

        try
        {
            stmt = con.createStatement();
            stmt.executeUpdate(insertSQL);

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
    }

