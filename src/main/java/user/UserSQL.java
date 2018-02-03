package user;

public class UserSQL {

    public static String getUser(int id) {
        return "select * from \"user\" where id = " + id;
    }
}
