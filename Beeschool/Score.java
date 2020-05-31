public class Score{
    private
    String prefix = "SC";
    String id;
    Subject subject;
    int score;

    public
    void setID(int id){
        if(id < 10){
            this.id = "00" + id;
        }
        else{
            this.id = "0" + id;
        }
    }
    void setSubject(Subject subject){
        this.subject = subject;
    }
    void setScore(int score){
        this.score = score;
    }

    String getID(){
        return id;
    }
    Subject getSubject(){
        return subject;
    }
    int getScore(){
        return score;
    }
    String getPrefix(){
        return prefix;
    }

}