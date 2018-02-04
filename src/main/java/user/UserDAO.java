//package main.java.user;
package user;

import java.sql.*;

import main.java.Configuration;

public class UserDAO {
    private String database;
    private String username;
    private String password;

    public UserDAO() {
        Configuration config = Configuration.getInstance();
        this.database = config.getProperties().getProperty("database");
        this.username = config.getProperties().getProperty("databaseUsername");
        this.password = config.getProperties().getProperty("databasePassword");

    }

    public UserModel getUser(int userId) throws Exception{

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = UserSQL.getUser(userId); //query
            rs = stmt.executeQuery(query); //execute
            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                //String password = rs.getString("password");
                UserModel user = new UserModel(id, username, null, firstname, lastname, email);



                return user;
            }
            //retrieve values from the dataSet. Hardcoded.

        } catch (Exception ex) {
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
        return null;
    }

    public boolean insertNewUser(String username, String password,
                                 String firstname, String lastname, String email) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        boolean queryExec = false;

        try{
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = UserSQL.insertUser(username, password, firstname, lastname, email); //query
            int count = stmt.executeUpdate(query); //'count' is number of rows affected
            if(count > 0){
                queryExec = true;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return queryExec;
    }

    public boolean updateUser(int id, String firstname, String lastname, String email) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        boolean queryExec = false;

        try{
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = UserSQL.updateUser(id, firstname, lastname, email); //query
            int count = stmt.executeUpdate(query); //'count' is number of rows affected
            if(count > 0){
                queryExec = true;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return queryExec;
    }

    public boolean isValidPassword(String username, String password) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = UserSQL.getUserAndPassword(username, password); //query
            rs = stmt.executeQuery(query); //execute
            if(rs.next()) { //this means user + pass combo were found in the user table
                return true;
            }
        } catch (Exception ex) {
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
        return false;
    }

    public boolean usernameExists(String username) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = UserSQL.getUsername(username); //query
            rs = stmt.executeQuery(query); //execute
            if(rs.next()) { //this means username was found in the user table
                return true;
            }
        } catch (Exception ex) {
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
        return false;
    }

    public boolean emailExists(String email) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = UserSQL.getEmail(email); //query
            rs = stmt.executeQuery(query); //execute
            if(rs.next()) { //this means email was found in the user table
                return true;
            }
        } catch (Exception ex) {
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
        return false;
    }

}
