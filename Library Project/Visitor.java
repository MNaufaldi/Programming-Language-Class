import java.util.ArrayList;

public class Visitor extends Person{
    private transient ArrayList<Book>borrowedBook;

    public Visitor(){
        borrowedBook = new ArrayList<Book>();
    }
    public Visitor(String name, int ID, String address){
        super(name,ID,address);
        borrowedBook = new ArrayList<Book>();
    }
    public Visitor(String name, int ID, String address, String username, String password){
        super(name,ID,address,username,password);
        borrowedBook = new ArrayList<Book>();
    }

    public ArrayList<Book> getBorrowedBook() {
        return borrowedBook;//edit this
    }

    public void addBorrowedBook(Book book) {
        borrowedBook.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBook.remove(book);
    }

    

}