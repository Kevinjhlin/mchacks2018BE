package roomConfig;

import java.sql.*;
import java.time.LocalDateTime;

import main.java.Configuration;


public class RoomConfigDAO {
    private String database;
    private String username;
    private String password;

    public RoomConfigDAO() {
        Configuration config = Configuration.getInstance();
        this.database = config.getProperties().getProperty("database");
        this.username = config.getProperties().getProperty("databaseUsername");
        this.password = config.getProperties().getProperty("databasePassword");
    }

    public RoomConfigModel getRoomConfig(int roomId) throws Exception{

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomConfigSQL.getRoomConfig(roomId); //query
            rs = stmt.executeQuery(query); //execute
            while(rs.next()) { //
                int id = rs.getInt("id");
                int room_id = rs.getInt("room_id");
                double length = rs.getDouble("length");
                Timestamp timeFrameStart = rs.getTimestamp("time_frame_start");
                Timestamp timeFrameEnd = rs.getTimestamp("time_frame_end");
                int minNumOfPeople = rs.getInt("min_num_of_ppl");
                RoomConfigModel roomConfig = new RoomConfigModel(id, room_id, length, timeFrameStart, timeFrameEnd, minNumOfPeople);
                return roomConfig;
            }

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

    public String createRoomConfig(int owner) throws Exception {

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomConfigSQL.createRoomConfig(owner); //query
            stmt.execute(query);
            return "Room Config has been created!";


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

    public String deleteRoomConfig(int roomId) throws Exception {
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomConfigSQL.deleteRoomConfig(roomId); //query
            stmt.execute(query); //execute
            return "Room config has been deleted!";

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

    public RoomConfigModel updateRoomConfig(int roomId, double length, LocalDateTime timeFrameStart, LocalDateTime timeFrameEnd, int minNumOfPeople) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = RoomConfigSQL.updateRoomConfig(roomId, length, timeFrameStart, timeFrameEnd, minNumOfPeople); //query
            rs = stmt.executeQuery(query); //execute
            while(rs.next()) {
                int id = rs.getInt("id");
                int room_id = rs.getInt("room_id");
                double lengthRecord = rs.getDouble("length");
                Timestamp timeFrameStartRecord = rs.getTimestamp("time_frame_start");
                Timestamp timeFrameEndRecord = rs.getTimestamp("time_frame_end");
                int minNumOfPeopleRecord = rs.getInt("min_num_of_ppl");
                RoomConfigModel roomConfig = new RoomConfigModel(id, room_id, lengthRecord, timeFrameStartRecord, timeFrameEndRecord, minNumOfPeopleRecord);
                return roomConfig;
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
