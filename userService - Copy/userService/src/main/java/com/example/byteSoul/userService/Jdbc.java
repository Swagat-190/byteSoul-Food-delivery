package com.example.byteSoul.userService;

import java.sql.*;

public class Jdbc {
    public static void main(String args[]) throws SQLException {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "root", "123456");
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") +
                        " | " + " | " + rs.getString("email"));
            }
        }
        catch (Exception e) {
            System.out.println("Hey");

        }
    }
}
