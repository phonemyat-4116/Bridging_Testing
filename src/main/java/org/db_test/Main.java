package org.db_test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is testing Main Class
 * Created by Lin MyaT Thu
 * Created data 13/5/2025
 */

public class Main {

    private String ip = "localhost";
    private String port = "3306";
    private String dbname = "test_db";
    private String username = "root";
    private String password = "";

    protected Connection get_db_connection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbname, username, password);
            System.out.println("Successful Connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Connection con = main.get_db_connection();

        try {
            if (con != null)
                con.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}