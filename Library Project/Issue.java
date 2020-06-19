
import java.util.Calendar;


public class Issue {
    private int id;
    private int book;
    private Calendar issueDate;
    private Calendar returnDate;
    private int holder;
    boolean isReturned;
    Issue(){

    }

    Issue(int holder,int days,int book){
        this.issueDate = Calendar.getInstance();
        this.returnDate = Calendar.getInstance();
        this.returnDate.add(Calendar.DATE,days);
        this.book = book;
        this.holder = holder;
        this.isReturned = false;
    }

    // for mysql instances
    Issue(int holder,Calendar issueDate, Calendar returnDate,int id){
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.holder = holder;
        this.id = id;
        this.isReturned = false;
    }
    Issue(int holder,Calendar issueDate, Calendar returnDate,int id,int book){
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.holder = holder;
        this.id = id;
        this.isReturned = false;
        this.book = book;
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Calendar issueDate) {
        this.issueDate = issueDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    public int getHolder() {
        return holder;
    }

    public void setHolder(int holder) {
        this.holder = holder;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }
    public int compareDate(){
        return this.issueDate.compareTo(this.returnDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

}