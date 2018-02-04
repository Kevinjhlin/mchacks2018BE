package main.java.room;
import org.springframework.web.bind.annotation.*;
import room.*;
import java.util.Random;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/room")
public class RoomController {

    @GetMapping("/{id}")
    public RoomModel getRoom(@PathVariable int id) {

        RoomDAO room = new RoomDAO(); //create a DAO object
        try{
            RoomModel response = room.getRoom(id); //retrieve the room based on id
            return response; //return it
        }
        catch(Exception ex) {
            return null;
        }
    }

    @PostMapping("/")
    public RoomModel createRoom(@RequestBody RoomModel roomRequest){
        RoomDAO room = new RoomDAO();
        try{
            String url = getSaltString();
            int owner = roomRequest.getOwner();
            String description = roomRequest.getDescription();
            String name = roomRequest.getName();
            RoomModel response = room.createRoom(name, owner, description, url);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable int id){
        RoomDAO room = new RoomDAO(); //create a DAO object
        try{
            String response = room.deleteRoom(id);
            return response; //return it
        }
        catch(Exception ex) {
            return "Room cannot be deleted";
        }
    }

    @PutMapping("/{id}")
    public RoomModel updateRoom(@PathVariable int id, @RequestBody RoomModel roomRequest){
        RoomDAO room = new RoomDAO();
        try{
            String name = roomRequest.getName();
            String description = roomRequest.getDescription();
            RoomModel response = room.updateRoom(id, name, description);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }



}