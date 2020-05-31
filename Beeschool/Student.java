import java.util.ArrayList;

public class Student{
    private
    String prefix = "ST";
    String id;
    String name;
    String gender;
    ArrayList<Score> score = new ArrayList<Score>();

    public
    void setID(int id){
        if(id < 10){
            this.id = "00" + id;
        }
        else{
            this.id = "0" + id;
        }
    }
    void setName(String name){
        this.name = name;
    }
    void setGender(String gender){
        this.gender = gender;
    }
    void setScore(Score score) {
        this.score.add(score);
    }

    String getID(){
        return id;
    }
    String getName(){
        return name;
    }
    String getGender(){
        return gender;
    }
    String getPrefix(){
        return prefix;
    }
    ArrayList<Score> getScore(){
        return score;
    }

}
