package main.java.persistence.dao;

import java.sql.*;

import main.java.Configuration;

public class userDAO {

    private String sqlFile = "/sql_oper/user.psql";
    private String database;
    private String username;
    private String password;

    public userDAO() {
        Configuration config = Configuration.getInstance();
        this.database = config.getProperties().getProperty("database");
        this.username = config.getProperties().getProperty("databaseUsername");
        this.password = config.getProperties().getProperty("databasePassword");

    }

    public getUser(int userId) {

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(database, username, password); //get connection
            stmt = conn.createStatement();
            String query = "select * from user where id = " + userId; //query
            rs = stmt.executeQuery(query); //execute

            //retrieve values from the dataSet. Hardcoded.
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String password = rs.getFloat("password");
            Date created = rs.getDate("created");
            Date updated = rs.getDate("updated");

            

        } catch (Exception ex) {
            System.out.println(ex.toString());
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }


}
