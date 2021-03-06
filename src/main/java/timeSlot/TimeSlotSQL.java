package timeSlot;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeSlotSQL {

    public static String createTimeSlot(int ownerid, Timestamp startDate, Timestamp endDate){
        return "insert into \"timetable\" (owner, start_date, end_date) values ('" + ownerid + "','" +
                startDate + "','" + endDate + "') returning *";
    }

    public static String deleteTimeSlot(int id){
        return "delete from \"timetable\" where id =" + id;
    }

    public static String getTimeSlots(int id){
        return "select * from \"timetable\" where owner = " + id;
    }

    public static String updateTimeSlot(int id, Timestamp startDate, Timestamp endDate) {
        return "update \"timetable\" SET start_date = '" + startDate + "', end_date = '" + endDate + "' where id = " + id + " returning *";
    }
}
