package roomConfig;

import java.time.LocalDateTime;

public class RoomConfigSQL {
    public static String createRoomConfig(int roomid) {
        return "insert into \"room_config\" (room_id) values ("+ roomid + ")";
    }

    public static String deleteRoomConfig(int id) {
        return "delete from \"room_config\" where id = " + id;
    }
    public static String getRoomConfig(int roomid) {
        return "select * from \"room_config\" where room_id = " + roomid;
    }
    public static String updateRoomConfig(int id, double length, LocalDateTime timeFrameStart, LocalDateTime timeFrameEnd, int minNumberOfPeople){
        return "update \"room_config\" SET length = '" + length + "', time_frame_start = '" + timeFrameStart + "', time_frame_end = '" +
        timeFrameEnd + "', min_num_of_people='" + minNumberOfPeople + "' where id = " + id;
    }


}
