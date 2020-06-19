public class Person {
    private String name;
    private int ID;
    private String address;
    private String password;
    private String username;

    public Person(){}
    public Person(String name, int ID, String address){
        this.name = name;
        this.ID = ID;
        this.address = address;
    }
    public Person(String name, int ID, String address, String username, String password){
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }    

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userame) {
        this.username = userame;
    }

    
    
}