public class Subject{
    private
    String prefix = "SB";
    String id;
    String name;
    String category;
    int index;

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
    void setCategory(String category){
        this.category = category;
    }
    void setIndex(int index){
        this.index = index;
    }

    String getID(){
        return id;
    }
    String getName(){
        return name;
    }
    String getCategory(){
        return category;
    }
    String getPrefix(){
        return prefix;
    }

}