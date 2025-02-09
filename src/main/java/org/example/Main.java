package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Main {


        public static void main(String[] args) {
            System.out.println("Hello, World!");

            String url="jdbc:mysql://localhost:3306/students";
            String username="root";
            String password="2121912";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Drivers loaded successfully");
            }catch(ClassNotFoundException e)
            {
                System.out.println(e.getMessage());
            }


            try{
                Connection connection= DriverManager.getConnection(url,username,password);
                System.out.println("Connection established");
            }catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
}