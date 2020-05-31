public class Rectangle{
    private float length;
    private float width;
    
    public Rectangle(){
        this.length = 1.0f;
        this.width = 1.0f;
    }
    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }
    //getter
    public float getLength(){
        return this.length;
    }
    public float getWidth(){
        return this.width;
    }

    //setter
    public void setLength(float length){
        this.length = length;
    }
    public void setWidth(float width){
        this.width = width;
    }

    //stuff
    public float getArea(){
        return length*width;
    }
    public float getPerimeter(){
        return (length*2) + (width*2);
    }

    @Override
    public String toString(){
        return "Rectangle[length = "+this.length+" width = "+this.width+"]";
    }

}