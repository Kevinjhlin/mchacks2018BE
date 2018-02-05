package main.java.user;
import user.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable int id) {

        UserDAO user = new UserDAO();
        try{
            UserModel response = user.getUser(id);
            return response;
        }
        catch(Exception ex) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable int id, @RequestBody UserModel userRequest) {

        String firstname = userRequest.getFirstName();
        String lastname = userRequest.getLastName();
        String email = userRequest.getEmail();
        UserDAO user = new UserDAO();
        try {
            UserModel response = user.updateUser(id, firstname, lastname, email);
            return response;
        } catch (Exception ex) {
            return null;
        }

    }
}