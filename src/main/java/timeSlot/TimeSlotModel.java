package timeSlot;

import java.util.Date;

public class TimeSlotModel {
    private int id;
    private int ownerid;
    private Date startDate;
    private Date endDate;

    public TimeSlotModel (int id, int ownerid, Date startDate, Date endDate){
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setOwnerId(int ownerid){
        this.ownerid = ownerid;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
