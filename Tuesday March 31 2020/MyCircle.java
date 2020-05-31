public class MyCircle{
    private
    MyPoint center;
    int radius = 1;

    public
    MyCircle(){}
    MyCircle(int x, int y, int radius){
        this.center = new MyPoint(x, y);
        this.radius = radius;
    }
    MyCircle(MyPoint center, int radius){
        this.center = center;
        this.radius = radius;
    }
    int getRadius(){
        return this.radius;
    }
    MyPoint getCenter(){
        return this.center;
    }
    void setRadius(int radius){
        this.radius = radius;
    }
    int getCenterX(){
        return this.center.getX();
    }
    int getCenterY(){
        return this.center.getY();
    }
    void setCenterX(int x){
        this.center.setX(x);
    }
    void setCenterY(int y){
        this.center.setY(y);
    }
    void setCenterXY(int x, int y){
        this.center.setXY(x, y);
    }
    int[] getCenterXY(){
        return this.center.getXY();
    }
    double getArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }
    double getCircumference(){
        return 2 * Math.PI * this.radius;
    }
    double distance(MyCircle another){
        return this.center.distance(another.getCenter());
    }

    @Override
    public String toString() {
        return "MyCircle [center=(" + getCenter().toString() + "), radius=" + this.radius + "]";
    }
    
}