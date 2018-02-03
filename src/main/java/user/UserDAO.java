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
                String password = rs.getString("password");
                Date created = rs.getDate("created");
                Date updated = rs.getDate("updated");
                UserModel user = new UserModel(id, username, password, firstname, lastname, email);

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


}
