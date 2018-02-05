//package user;
package main.java.user;
import user.*;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserAuthController {


    @PostMapping("/login")
    public boolean login(@RequestBody UserModel credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        UserDAO dao = new UserDAO();
        try{
            if(dao.isValidPassword(username, password)) {
                return true;
            }
        }
        catch(Exception ex) {
            return false;
        }
        return false;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserModel userRequest) {

        String username = userRequest.getUsername();
        String password = userRequest.getPassword();
        String firstname = userRequest.getFirstName();
        String lastname = userRequest.getFirstName();
        String email = userRequest.getEmail();

        UserDAO dao = new UserDAO();
        try{
            boolean userExists = dao.usernameExists(username);
            boolean emailExists = dao.emailExists(email);

            if(!userExists && !emailExists){
                //do insert
                boolean insertUserSuccess = dao.insertNewUser(username, password, firstname, lastname, email);
                return "Registration success";
            }
        }
        catch (Exception ex){
            return null;
        }
        return "Registration fail";
    }
}
