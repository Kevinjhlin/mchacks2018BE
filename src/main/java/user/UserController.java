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

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestParam String firstname,
                             @RequestParam String lastname, @RequestParam String email) {
        UserDAO user = new UserDAO();
        try {
            boolean updateUserSuccess = user.updateUser(id, firstname, lastname, email);
            if(updateUserSuccess) {
                return "Update User success";
            }
        } catch (Exception ex) {
            return null;
        }
        return "Update User fail";
    }
}