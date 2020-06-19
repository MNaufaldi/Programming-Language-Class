import java.util.ArrayList;
import java.util.List;

public class Book{
    // Book data
    private String bookTitle;
    private String subject;
    private int ID;
    private int numOfPages;
    private ArrayList<String> authors;
    // 

    // for library features
    private int currentHolder;
    private int issue;

    Book(){
        authors = new ArrayList<String>();

    }
    Book(String bookTitle){
        this.bookTitle = bookTitle;
        authors = new ArrayList<String>();
    }
    Book(String bookTitle, String subject, int ID, int numOfPages, String author){
        authors = new ArrayList<String>();
        this.bookTitle = bookTitle;
        this.subject = subject;
        this.ID = ID;
        this.numOfPages = numOfPages;
        this.authors.add(author);
    }
    Book(String bookTitle, String subject, int ID, int numOfPages, List<String> authors,int holder){
        this.bookTitle = bookTitle;
        this.subject = subject;
        this.ID = ID;
        this.numOfPages = numOfPages;
        this.authors = (ArrayList<String>) authors;
        this.currentHolder = holder;
    }
    // Book Features
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }


    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String author){
        this.authors.add(author);
    }
    //

    // Library features
    public int getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(int visitor) {
        this.currentHolder = visitor;
    }
    
    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

   
    //
}