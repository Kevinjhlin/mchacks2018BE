package roomConfig;

import java.sql.Timestamp;

public class RoomConfigModel {
    private int id;
    private int roomId;
    private double length;
    private Timestamp timeFrameStart;
    private Timestamp timeFrameEnd;
    private int minNumOfPeople;

    public RoomConfigModel(){
        super();
    }

    public RoomConfigModel (int id, int roomId, double length, Timestamp timeFrameStart, Timestamp timeFrameEnd, int minNumOfPeople){
        setId(id);
        setRoomId(roomId);
        setLength(length);
        setTimeFrameStart(timeFrameStart);
        setTimeFrameEnd(timeFrameEnd);
        setMinNumOfPeople(minNumOfPeople);
    }

    public double getLength() {
        return length;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getMinNumOfPeople() {
        return minNumOfPeople;
    }

    public Timestamp getTimeFrameEnd() {
        return timeFrameEnd;
    }

    public Timestamp getTimeFrameStart() {
        return timeFrameStart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setMinNumOfPeople(int minNumOfPeople) {
        this.minNumOfPeople = minNumOfPeople;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setTimeFrameEnd(Timestamp timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
    }

    public void setTimeFrameStart(Timestamp timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

}
