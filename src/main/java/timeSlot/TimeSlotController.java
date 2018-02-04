package main.java.timeSlot;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import timeSlot.TimeSlotDAO;
import java.time.LocalDateTime;


@RestController
public class TimeSlotController {


    @PostMapping("user/{userid}/timeSlot")
    public String createTimeSlot(@PathVariable int userid, @RequestParam @DateTimeFormat(pattern="yyyyMMDD") LocalDateTime startDate, @RequestParam @DateTimeFormat(pattern="yyyyMMDD") LocalDateTime endDate){
        TimeSlotDAO timeSlotDAO = new TimeSlotDAO();
        try{
            String response = timeSlotDAO.createTimeSlot(userid, startDate, endDate);
            return response;
        }
        catch(Exception ex) {
            return "TimeSlot has failed to be created!";
        }
    }
//
//    @DeleteMapping("schedule/{id}")
//    public String deleteRoom(@PathVariable int id){
//        RoomDAO room = new RoomDAO(); //create a DAO object
//        try{
//            String response = room.deleteRoom(id);
//            return response; //return it
//        }
//        catch(Exception ex) {
//            return "Room cannot be deleted";
//        }
//    }
//
//    @PutMapping("/{id}")
//    public RoomModel updateRoom(@PathVariable int id, @RequestParam String name, @RequestParam String description){
//        RoomDAO room = new RoomDAO();
//        try{
//            RoomModel response = room.updateRoom(id, name, description);
//            return response;
//        }
//        catch(Exception ex) {
//            return null;
//        }
//    }



}