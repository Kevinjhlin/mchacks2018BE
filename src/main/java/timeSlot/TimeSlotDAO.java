package timeSlot;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import main.java.Configuration;
import org.apache.tomcat.jni.Local;

import javax.xml.transform.Result;


public class TimeSlotDAO {
    private String database;
    private String username;
    private String password;

    public TimeSlotDAO() {
        Configuration config = Configuration.getInstance();
        this.database = config.getProperties().getProperty("database");
        this.username = config.getProperties().getProperty("databaseUsername");
        this.password = config.getProperties().getProperty("databasePassword");
    }

    public TimeSlotModel createTimeSlot(int ownerId, LocalDateTime startDate, LocalDateTime endDate) throws Exception {

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = TimeSlotSQL.createTimeSlot(ownerId, startDate, endDate); //query
            rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                int owner = rs.getInt("owner");

                Timestamp startDateStamp = rs.getTimestamp("start_date");
                Timestamp endDateStamp = rs.getTimestamp("end_date");

                TimeSlotModel timeSlot = new TimeSlotModel(id, owner, startDateStamp, endDateStamp);
                return timeSlot;
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
    return null;
    }

    public String deleteTimeSlot(int id) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;


        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = TimeSlotSQL.deleteTimeSlot(id); //query
            stmt.execute(query);
            return "TimeSlot has been deleted!";

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

    }

    public TimeSlotModel[] getTimeSlots(int ownerid) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = TimeSlotSQL.getTimeSlots(ownerid); //query
            rs = stmt.executeQuery(query);
            ArrayList<TimeSlotModel> timeSlotArrayList = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                int owner = rs.getInt("owner");

                Timestamp startDate = rs.getTimestamp("start_date");

                Timestamp endDate = rs.getTimestamp("end_date");

                TimeSlotModel timeSlot = new TimeSlotModel(id, owner, startDate, endDate);
                timeSlotArrayList.add(timeSlot);
            }
            TimeSlotModel[] timeSlotArray = timeSlotArrayList.toArray(new TimeSlotModel[timeSlotArrayList.size()]);
            return timeSlotArray;
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
    }

    public TimeSlotModel updateTimeSlot(int timeslotid, LocalDateTime startDate, LocalDateTime endDate) throws Exception{
        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = TimeSlotSQL.updateTimeSlot(timeslotid, startDate, endDate); //query
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int owner = rs.getInt("owner");

                Timestamp startDateStamp = rs.getTimestamp("start_date");
                Timestamp endDateStamp = rs.getTimestamp("end_date");

                TimeSlotModel timeSlot = new TimeSlotModel(id, owner, startDateStamp, endDateStamp);
                return timeSlot;
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
            if(rs != null){
                rs.close();
            }
        }
        return null;
    }
}
