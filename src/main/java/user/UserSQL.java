package user;

public class UserSQL {

    public static String getUser(int id) {
        return "select * from \"user\" where id = " + id;
    }

    public static String insertUser(String username, String password,
                                    String firstname, String lastname, String email){
        return "INSERT INTO \"user\" (username, password, firstname, lastname, email) "+
                "VALUES('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+email+"')";
    }

    //can be used to check if Username & Password combo exists
    public static String getUserAndPassword(String username, String password)  {
        return "SELECT username,password FROM \"user\" " +
                "WHERE username = '" + username +"' " +
                "AND password = '" + password + "'";
    }

    //can used to check if Username exists
    public static String getUsername(String username)  {
        return "SELECT username FROM \"user\" WHERE username = '" + username + "'";
    }

    //can be used to check if email Exists
    public static String getEmail(String email)  {
        return "SELECT email FROM \"user\" WHERE username = '" + email + "'";
    }

    public static String updateUser(int id, String firstname, String lastname, String email){
        return "UPDATE \"user\""+
                "SET firstname = '" + firstname + "', " +
                "lastname = '" + lastname + "', " +
                "email = '" + email + "'" +
                "WHERE id = " + id + "returning *";
    }

//    public static String getUserPasswordFromID(int id)  {
//        return "SELECT password FROM \"user\" WHERE id = " + id;
//    }
//
//    public static String getPasswordFromUsername(String username)  {
//        return "SELECT password FROM \"user\" WHERE username = '" + username + "'";
//    }
}
