import java.lang.reflect.Array;
import java.util.Arrays;

public class MyPoint{
    private
    int x = 0;
    int y = 0;

    
    public
    MyPoint(){}
    MyPoint(int x,int y){
        this.x = x;
        this.y = y;
    }
	int getX() {
		return x;
	}
	void setX(int x) {
		this.x = x;
	}
	int getY() {
		return y;
	}
	void setY(int y) {
		this.y = y;
	}
    int[] getXY(){
        int[] temp = {this.x,this.y};
        return temp;
    }
    void setXY(int x,int y){
        this.x = x;
        this.y = y;
    }
    double distance(int x, int y){
        return Math.sqrt(Math.pow((Math.abs(this.x - x)),2)+Math.pow((Math.abs(this.y - y)),2));
    }
    double distance(MyPoint another){
        return Math.sqrt(Math.pow((Math.abs(this.x - another.getX())),2)+Math.pow((Math.abs(this.y - another.getY())),2));
    }
    double distance(){
        return Math.sqrt(Math.pow(Math.abs(this.x),2)+Math.pow(Math.abs(this.y),2));    
    }

    @Override
    public String toString() {
        return "MyPoint [x=" + x + ", y=" + y + "]";
    }

    
}