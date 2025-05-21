package org.db_test;

import java.sql.*;
import java.util.ArrayList;

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

    private ArrayList<Office> report1(Connection con){
        ArrayList<Office> al = new ArrayList<>();

        // error handling must
        try{
            PreparedStatement ps = con.prepareStatement("SELECT officeCode, city, state FROM offices");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                int officeCode = rs.getInt("officeCode"); // if use colum index, first column index is 1. not 0
                String city = rs.getString("city");
                String state = rs.getString("state");

                Office of = new Office(officeCode, city, state);
                al.add(of);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return al;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Connection con = main.get_db_connection();

        ArrayList<Office> al = main.report1(con);
        System.out.println(al);

        try {
            if (con != null)
                con.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}