public class Date{
    private
    int day;
    int month;
    int year;

    public 
    Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    //getter
    int getDay(){
        return this.day;
    }
    int getMonth(){
        return this.month;
    }
    int getYear(){
        return this.year;
    }

    //setter
    void setDay(int day){
        this.day = day;
    }
    void setMonth(int month){
        this.month = month;
    }
    void setYear(int year){
        this.year = year;
    }
    void setDate(int day,int month,int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString(){
        if(this.day>=10 && this.month >= 10){
            return this.day+"/"+this.month+"/"+this.year;
        }
        else if(this.day>=10){
            return this.day+"/0"+this.month+"/"+this.year;
        }
        else {
            return "0"+this.day+"/"+this.month+"/"+this.year;
        }
    }

}