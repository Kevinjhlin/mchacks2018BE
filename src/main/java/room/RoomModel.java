package room;

public class RoomModel {
    private int id;
    private String name;
    private int owner;
    private String url;
    private String description;


    public RoomModel(){
        super();
    }

    public RoomModel(int id, String url, String name, int owner, String description){
        setId(id);
        setUrl(url);
        setName(name);
        setOwner(owner);
        setDescription(description);
    }

    private void setId(int id){
        this.id = id;
    }
    private void setUrl(String url){
        this.url = url;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setOwner(int owner){
        this.owner = owner;
    }
    private void setDescription(String description) {
        this.description = description;
    }
    public int getId(){
        return this.id;
    }
    public String getUrl(){
        return this.url;
    }
    public String getName(){
        return this.name;
    }
    public int getOwner(){
        return this.owner;
    }
    public String getDescription(){
        return this.description;
    }


}
