package main.java.controllers;


import org.springframework.web.bind.annotation.*;
import user.UserDAO;
import user.UserModel;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public UserModel greeting(@PathVariable int id) {

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