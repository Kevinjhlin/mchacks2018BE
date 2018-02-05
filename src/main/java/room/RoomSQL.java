package room;

public class RoomSQL {
    public static String getRoom(int id) {
        return "select * from \"room\" where id = " + id;
    }
    public static String createRoom(String name, int owner, String description, String url){
        return "insert into \"room\" (name, owner, description, url) values ( '" + name + "','" + owner + "','" + description +
                "','" + url + "') returning *";
    }
    public static String deleteRoom(int id){
        return "delete from \"room\" where id = " + id;
    }
    public static String updateRoom(int id, String name, String description) {
        return "update \"room\" SET name = '" + name + "', description = '" + description + "' where id = " + id + "returning *";
    }
}
