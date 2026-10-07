package com.skillswap;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {

            System.out.println("JDBC connection successful!");

            try {
                connection.close();
                System.out.println("Connection closed.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}