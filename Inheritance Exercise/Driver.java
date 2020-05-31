public class Driver {
    public static void main(String[] args){
        Shape sh = new Shape("Green",false);
        System.out.println(sh.toString());
        Circle ci = new Circle(7,"Green",false);
        System.out.println(ci.getArea());
        System.out.println(ci.toString());
        Rectangle rec = new Rectangle(10,20,"Red",true);
        System.out.println(rec.getArea());
        System.out.println(rec.toString());
        Square sq = new Square(10,"Blue",true);
        System.out.println(sq.toString());
        sq.setLength(20);
        System.out.println(sq.toString());
        System.out.println(sq.getPerimeter());
        System.out.println(sq.getArea());

    }
}