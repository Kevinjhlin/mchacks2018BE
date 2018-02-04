package main.java.timeSlot;


import org.springframework.web.bind.annotation.*;
import timeSlot.TimeSlotDAO;
import timeSlot.TimeSlotModel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;


@RestController
public class TimeSlotController {


    @PostMapping("user/{userid}/timeslot")
    public String createTimeSlot(@PathVariable int userid, @RequestParam Long startDate, @RequestParam Long endDate){
        TimeSlotDAO timeSlotDAO = new TimeSlotDAO();

        //parse to LocalDateTime. This is assuming a long input
        LocalDateTime startDateParsed =
                LocalDateTime.ofInstant(Instant.ofEpochSecond(startDate),
                        TimeZone.getDefault().toZoneId());

        LocalDateTime endDateParsed =
                LocalDateTime.ofInstant(Instant.ofEpochSecond(endDate),
                        TimeZone.getDefault().toZoneId());

        try{
            String response = timeSlotDAO.createTimeSlot(userid, startDateParsed, endDateParsed);
            return response;
        }
        catch(Exception ex) {
            return "TimeSlot has failed to be created!";
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
    public TimeSlotModel[] updateTimeSlot(@PathVariable int userid, @PathVariable int timeslotid, @RequestParam long startDate, @RequestParam long endDate){
        TimeSlotDAO room = new TimeSlotDAO();
        try{

            //parse to LocalDateTime. This is assuming a long input
            LocalDateTime startDateParsed =
                    LocalDateTime.ofInstant(Instant.ofEpochSecond(startDate),
                            TimeZone.getDefault().toZoneId());

            LocalDateTime endDateParsed =
                    LocalDateTime.ofInstant(Instant.ofEpochSecond(endDate),
                            TimeZone.getDefault().toZoneId());

            TimeSlotModel[] response = room.updateTimeSlot(userid, timeslotid, startDateParsed, endDateParsed);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }



}