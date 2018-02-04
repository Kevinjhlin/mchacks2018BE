package main.java.user;

import user.*;
import org.springframework.web.bind.annotation.*;



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
}