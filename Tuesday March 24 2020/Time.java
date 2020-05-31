public class Time{
    private
    int hour;
    int minute;
    int second;

    public
    Time(int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    //getter
    int getHour(){
        return hour;
    }
    int getMinute(){
        return minute;
    }
    int getSecond(){
        return second;
    }
    //setter
    void setHour(int hour){
        this.hour = hour;
    }
    void setMinute(int minute){
        this.minute = minute;
    }
    void setSecond(int second){
        this.second = second;
    }
    void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    Time nextSecond(){
        if(this.second < 59){
            this.second = this.second + 1;
        }
        else{
            this.second = 0;
            this.minute = this.minute + 1;
            if(this.minute == 60){
                this.minute = 0;
                this.hour = this.hour +1;
                if(this.hour == 24){
                    this.hour = 0;
                }
            }
        }
        return this;
    }
    Time previousSecond(){
        if(this.second < 1){
            this.second = 59;
            this.minute = this.minute-1;
            if(this.minute < 0){
                this.minute = 59;
                this.hour = this.hour - 1;
                if(this.hour < 1){
                    this.hour = 24; 
                }
            }
        }
        else{
            this.second = this.second - 1;
        }
        return this;
    }

    @Override
    public String toString(){
        String temp;
        if(hour >=10){
            temp = hour+":";
        }
        else{
            temp = "0"+hour+":";
        }

        if(minute >= 10){
            temp = temp+minute+":";
        }
        else{
            temp = temp+"0"+minute+":";
        }

        if(second >= 10){
            temp = temp+second;
        }
        else{
            temp = temp+"0"+second;
        }
        return temp;
    }
}