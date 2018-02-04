package roomConfig;

import org.springframework.web.bind.annotation.*;

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
        try{
            RoomConfigModel response = roomConfig.getRoomConfig(id); //retrieve the room based on id
            return response; //return it
        }
        catch(Exception ex) {
            return null;
        }
    }

    @PutMapping("/{id}/{roomId}")
    public RoomConfigModel updateRoomConfig(@PathVariable int id, @PathVariable int roomId, @RequestParam double length, @RequestParam long timeFrameStart, @RequestParam long timeFrameEnd, @RequestParam int minNumOfPeople){
        RoomConfigDAO roomConfig = new RoomConfigDAO();
        try{
            LocalDateTime timeFrameStartParsed =
                    LocalDateTime.ofInstant(Instant.ofEpochSecond(timeFrameStart),
                            TimeZone.getDefault().toZoneId());

            LocalDateTime timeFrameEndParsed =
                    LocalDateTime.ofInstant(Instant.ofEpochSecond(timeFrameEnd),
                            TimeZone.getDefault().toZoneId());
            RoomConfigModel response = roomConfig.updateRoomConfig(id, roomId, length, timeFrameStartParsed, timeFrameEndParsed , minNumOfPeople);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }