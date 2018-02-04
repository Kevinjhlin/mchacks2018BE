package timeSlot;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeSlotModel {
    private int id;
    private int ownerid;
    private Timestamp startDate;
    private Timestamp endDate;

    public TimeSlotModel (int id, int ownerid, Timestamp startDate, Timestamp endDate){
        setId(id);
        setOwnerId(ownerid);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public int getId(){
        return this.id;
    }
    public int getOwnerId(){
        return this.ownerid;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setOwnerId(int ownerid){
        this.ownerid = ownerid;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
