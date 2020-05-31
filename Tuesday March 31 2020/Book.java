import java.util.ArrayList;
public class Book{
    private
    String name;
    ArrayList<Author> authors = new ArrayList<Author>();
    double price;
    int qty;

    public
    Book(String name,Author author,double price){
        this.name = name;
        this.authors.add(author);
        this.price = price;
        this.qty = 0;
    }
    Book(String name,ArrayList<Author>authors,double price){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = 0;
    }
    Book(String name,ArrayList<Author>authors,double price,int qty){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    void setName(String name){
        this.name = name;
    }
    void setAuthors(ArrayList<Author>authors){
        this.authors = authors;
    }
    void setPrice(double price){
        this.price = price;
    }
    void setQty(int qty){
        this.qty = qty;
    }
    void addAuthor(Author author){
        this.authors.add(author);
    }

    String getName(){
        return this.name;
    }
    ArrayList<Author> getAuthor(){
        return this.authors;
    }
    String getAuthorNames(){
        String temp = "";
        for(int i=0;i<this.authors.size();i++){
            temp = temp +  this.authors.get(i).getName();
            temp = temp + ", ";
        }
        return temp;
    }
    double getPrice(){
        return this.price;
    }
    int getQty(){
        return this.qty;
    }

    @Override
    public String toString(){
        String temp = "";
        for(int i=0;i<this.authors.size();i++){
            temp = temp + this.authors.get(i).toString()+" ";
            
        }

        return "Book[name=" + this.name + ",authors={" + temp + "},price=" + this.price + ",qty=" + this.qty + "]";
    }
    

}