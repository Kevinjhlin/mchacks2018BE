package roomConfig;

import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@CrossOrigin
@RestController
@RequestMapping("/roomconfig")
public class RoomConfigController {

    @GetMapping("/{id}")
    public RoomConfigModel getRoomConfig(@PathVariable int id) {

        RoomConfigDAO roomConfig = new RoomConfigDAO(); //create a DAO object
        try {
            RoomConfigModel response = roomConfig.getRoomConfig(id); //retrieve the room based on id
            return response; //return it
        } catch (Exception ex) {
            return null;
        }
    }

    @PutMapping("/{roomId}")
    public RoomConfigModel updateRoomConfig(@PathVariable int id, @PathVariable int roomId, @RequestBody RoomConfigModel roomConfigRequest) {
        RoomConfigDAO roomConfig = new RoomConfigDAO();
        try {
            double length = roomConfigRequest.getLength();
            Timestamp timeFrameStart = roomConfigRequest.getTimeFrameStart();
            Timestamp timeFrameEnd = roomConfigRequest.getTimeFrameEnd();
            int minNumOfPeople = roomConfigRequest.getMinNumOfPeople();
            RoomConfigModel response = roomConfig.updateRoomConfig(roomId, length, timeFrameStart, timeFrameEnd, minNumOfPeople);
            return response;
        } catch (Exception ex) {
            return null;
        }
    }
}