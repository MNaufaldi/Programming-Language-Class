import java.util.ArrayList;
public class Driver{
    public static void main(String[] args){
        ArrayList<Author> authors = new ArrayList<Author>();
        Author a1 = new Author("n1", "e1", 'm');
        Author a2 = new Author("n2", "e2", 'f');
        authors.add(a1);
        authors.add(a2);
        Book b1 = new Book("b1", authors, 100, 1);
        System.out.println(b1.toString());
        System.out.println(b1.getAuthorNames());

        System.out.println();

        MyPoint mp1 = new MyPoint(2,4);
        MyPoint mp2 = new MyPoint(4,2);
        System.out.println(mp1.distance(mp2));
        System.out.println(mp1.distance(4,2));

        System.out.println();

        MyCircle c1 = new MyCircle(mp1, 7);
        MyCircle c2 = new MyCircle(mp2,14);
        System.out.println(c1.getArea());
        System.out.println(c1.toString());
        System.out.println(c1.distance(c2));

        System.out.println();

        MyPoint mp3 = new MyPoint(2,2);
        //Isosceles
        MyTriangle t1 = new MyTriangle(mp1, mp2, mp3);
        System.out.println(t1.getType());
        System.out.println(t1.toString());
    }
}