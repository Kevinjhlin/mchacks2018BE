package timeSlot;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import main.java.Configuration;
import org.apache.tomcat.jni.Local;


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

    public String createTimeSlot(int ownerId, LocalDateTime startDate, LocalDateTime endDate) throws Exception {

        //instantiate the database connection variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(this.database, this.username, this.password); //get connection
            stmt = conn.createStatement();
            String query = TimeSlotSQL.createTimeSlot(ownerId, startDate, endDate); //query
            stmt.execute(query);
            return "TimeSlot has been created!";

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
