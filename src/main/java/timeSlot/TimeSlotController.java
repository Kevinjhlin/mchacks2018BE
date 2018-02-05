package main.java.timeSlot;


import org.springframework.web.bind.annotation.*;
import timeSlot.TimeSlotDAO;
import timeSlot.TimeSlotModel;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TimeSlotController {


    @PostMapping("user/{userid}/timeslot")
    public TimeSlotModel createTimeSlot(@PathVariable int userid, @RequestBody TimeSlotModel timeSlotRequest){
        TimeSlotDAO timeSlotDAO = new TimeSlotDAO();
        Timestamp startDate = timeSlotRequest.getStartDate();
        Timestamp endDate = timeSlotRequest.getEndDate();

        try{
            TimeSlotModel response = timeSlotDAO.createTimeSlot(userid, startDate, endDate);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }

    @DeleteMapping("schedule/{id}")
    public String deleteTimeSlot(@PathVariable int id){
        TimeSlotDAO timeSlotDAO = new TimeSlotDAO(); //create a DAO object
        try{
            String response = timeSlotDAO.deleteTimeSlot(id);
            return response; //return it
        }
        catch(Exception ex) {
            return "TimeSlot failed to be deleted";
        }
    }

    @GetMapping("/user/{userid}/timeslot")
    public TimeSlotModel[] getUsersTimeSlot(@PathVariable int userid){
        TimeSlotDAO timeSlotDAO = new TimeSlotDAO();
        try{
            TimeSlotModel[] response = timeSlotDAO.getTimeSlots(userid);
            return response;
        }
        catch(Exception ex){
            return null;
        }
    }

    @PutMapping("/user/{userid}//timeslot/{timeslotid}")
    public TimeSlotModel updateTimeSlot(@PathVariable int userid, @PathVariable int timeslotid, @RequestBody TimeSlotModel timeSlotRequest){
        TimeSlotDAO room = new TimeSlotDAO();
        try{
            Timestamp startDate = timeSlotRequest.getStartDate();
            Timestamp endDate = timeSlotRequest.getEndDate();


            TimeSlotModel response = room.updateTimeSlot(timeslotid, startDate, endDate);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }



}