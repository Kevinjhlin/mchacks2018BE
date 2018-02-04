package timeSlot;

import java.time.LocalDateTime;
import java.util.Date;

public class TimeSlotSQL {

    public static String createTimeSlot(int ownerid, LocalDateTime startDate, LocalDateTime endDate){
        return "insert into \"timetable\" (owner, start_date, end_date) values ('" + ownerid + "','" +
                startDate + "','" + endDate + "')";
    }
}
