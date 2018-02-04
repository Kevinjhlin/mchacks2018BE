package main.java.user;

import org.springframework.web.bind.annotation.*;
import user.UserModel;


@RestController
public class UserAuthController {

    @PostMapping("/login")
    public UserModel login(@RequestParam String username, @RequestParam String password) {
        return null;
    }
}