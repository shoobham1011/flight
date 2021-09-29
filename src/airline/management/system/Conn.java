package airline.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    int val;
    ResultSet rows;

    public Conn() {
        // register the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connection object
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project4", "root", "root");
            if (c != null) {
                System.out.println("Database is connected successful");
            }
            //creating statement object
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public int insert(String query) {
        // execute query
        try {
            val= s.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }
    public  ResultSet select(String query){
        try {
            rows = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public static void main (String[]args){
        new Conn();
    }
}


