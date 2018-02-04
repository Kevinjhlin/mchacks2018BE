package room;

import java.sql.*;
import main.java.Configuration;


public class RoomDAO {
    private String database;
    private String username;
    private String password;

    public RoomDAO() {
        Configuration config = Configuration.getInstance();
        this.database = config.getProperties().getProperty("database");
        this.username = config.getProperties().getProperty("databaseUsername");
        this.password = config.getProperties().getProperty("databasePassword");
    }

    public RoomModel getRoom(int roomId) throws Exception{

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomSQL.getRoom(roomId); //query
            rs = stmt.executeQuery(query); //execute
            while(rs.next()) { //
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int owner = rs.getInt("owner");
                String url = rs.getString("url");
                String description = rs.getString("description");
                RoomModel room = new RoomModel(id, url, name, owner, description);

                return room;
            }
            //retrieve values from the dataSet. Hardcoded.

        } catch (Exception ex) {
            //uh

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

    public String createRoom(String name, int owner, String description, String url) throws Exception {

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomSQL.createRoom(name, owner, description, url); //query
            stmt.execute(query);
            return "Room has been created!";
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

    }

    public String deleteRoom(int roomId) throws Exception {
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomSQL.deleteRoom(roomId); //query
            stmt.execute(query); //execute
            return "Room has been deleted!";
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
    }

    public RoomModel updateRoom(int roomId, String name, String description) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomSQL.updateRoom(roomId, name, description); //query
            stmt.execute(query); //execute
            stmt.close();
            RoomModel room = getRoom(roomId);
            return room;
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

    }
}
