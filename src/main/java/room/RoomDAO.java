package room;

import java.sql.*;
import main.java.Configuration;
import roomConfig.RoomConfigDAO;


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

    public RoomModel createRoom(String name, int owner, String description, String url) throws Exception {

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomSQL.createRoom(name, owner, description, url); //query
            rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                RoomConfigDAO roomConfig = new RoomConfigDAO();
                roomConfig.createRoomConfig(id);
                String nameRecord = rs.getString("name");
                int ownerRecord = rs.getInt("owner");
                String urlRecord = rs.getString("url");
                String descriptionRecord = rs.getString("description");
                RoomModel room = new RoomModel(id, urlRecord, nameRecord, ownerRecord, descriptionRecord);

                return room;
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
        return null;

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
            RoomConfigDAO roomConfigDAO = new RoomConfigDAO();
            roomConfigDAO.deleteRoomConfig(roomId);
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
