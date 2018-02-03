package main.java.controllers;


import org.springframework.web.bind.annotation.*;
import user.UserModel;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public UserModel greeting(@PathVariable int id) {

        main.java.persistence.dao.UserDAO user = new main.java.persistence.dao.UserDAO();
        try{
            UserModel response = user.getUser(id);
            return response;
        }
        catch(Exception ex) {
            return null;
        }

    }
}