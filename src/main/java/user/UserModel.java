package user;

public class UserModel {
    private int userId;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    public UserModel(){
        super();
    }
    public UserModel(int id, String username, String password, String firstname, String lastname, String email){
        setUserId(id);
        setUsername(username);
        setPassword(password);
        setFirstName(firstname);
        setLastName(lastname);
        setEmail(email);
    }
    public UserModel(String username, String password){
        setUsername(username);
        setPassword(password);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName(){
        return firstname;
    }

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public String getLastName(){
        return lastname;
    }

    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
