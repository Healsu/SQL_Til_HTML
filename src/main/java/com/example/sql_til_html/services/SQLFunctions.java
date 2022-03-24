package com.example.sql_til_html.services;

import com.example.sql_til_html.model.userInfo;
import com.example.sql_til_html.respository.EmailRepository;

import java.sql.*;
import java.util.ArrayList;

public class SQLFunctions {

    static Connection con;
    static Statement stmt;
    static String sqlString;
    static ResultSet rs;

    public static void main(String[] args) {


    }


    public static Connection connectDB() {
        System.out.println("Connecting to DB SQL");

        try {

            String url = "jdbc:mysql://localhost:3306/opgaver";


            con = DriverManager.getConnection(url, "root", "Tim10ses");


            System.out.println("URL: " + url);
            System.out.println("Connection: " + con);

        } catch (Exception e) {
            System.out.println("ERROR");
        }

        return con;
    }

    public static void addToTable(String brugerNavn, String brugerMail) {


        String insertSQL = "INSERT INTO free_money " +
                "(`brugerNavn`,`brugerMail`) " +
                "VALUES('" + brugerNavn + "','" + brugerMail + "');";

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(insertSQL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<userInfo> returnUsers() throws SQLException {
        ArrayList<userInfo> allUsers = new ArrayList<>();

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        sqlString = "SELECT * from free_money";
        rs = stmt.executeQuery(sqlString);

        while (rs.next()) {
            userInfo mail = new userInfo(rs.getString("brugerNavn"),rs.getString("brugerMail"));
            allUsers.add(mail);

        }
        EmailRepository.fetchAllUsers(allUsers);
        return allUsers;
    }
}