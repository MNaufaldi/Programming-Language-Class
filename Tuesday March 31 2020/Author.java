public class Author{
    private
    String name;
    String email;
    char gender;

    public
    Author(){}

    Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    void setName(String name){
        this.name = name;
    }
    void setEmail(String email){
        this.email = email;
    }
    void setGender(char gender){
        this.gender = gender;
    }

    String getName(){
        return name;
    }
    String getEmail(){
        return email;
    }
    char getGender(){
        return gender;
    }

    @Override
    public String toString(){
        return "Author[name="+this.name+",email="+this.email+",gender="+this.gender+"]";
    }
}