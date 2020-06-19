import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class userQuery {
    //String format
    DateFormat dateFormat = new SimpleDateFormat("E,dd/MM/yyyy");
    String column1Format = "%-5.5s";  // fixed size 5+3 characters, left aligned
    String column2Format = "%-20.20s";  // fixed size 25+3 characters, left aligned
    String column3Format = "%-10.10s";   // fixed size 6 characters, right aligned
    //String column4Format = "%-20.20s"; 
    String formatInfoUser = column1Format + " " + column2Format + " " + column2Format + " " + column2Format;
    String formatInfoBooks = column1Format + " " + column2Format + " " + column2Format + " " + column3Format + " " + column2Format + " " + column3Format;
    String formatInfoIssue = column1Format + " " + column2Format + " " + column2Format + " " + column3Format + " " + column3Format;
    Scanner scan = new Scanner(System.in);
    // INTERFACE FUNCTIONS // 
    public int displayStart(){
        System.out.println("Welcome to the Library Page");
        System.out.println("=====================================");
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Please enter your choice: ");
        int choice = scan.nextInt();
        System.out.println();
        return choice;
    }

    public int displayVisitorHome(Person user){
        String name = user.getName();
        System.out.println("Welcome "+name+" !");
        System.out.println("===========================");
        System.out.println("1. Search a book");
        System.out.println("2. Check Borrowed book");
        System.out.println("3. Exit");
        System.out.print("Please input your choice: ");
        int choice = scan.nextInt();
        return choice;
    }

    public int displayLibrarianHome(Person user){
        String name = user.getName();
        System.out.println("Welcome "+name+" !");
        System.out.println("===========================");
        System.out.println("1. Issue a book");
        System.out.println("2. Add a book");
        System.out.println("3. Search a book");
        System.out.println("4. Search an issue");
        System.out.println("5. Get returned book");
        System.out.println("6. Check issue today");
        System.out.println("7. Search user");
        System.out.println("8. Exit");
        System.out.print("Please input your choice: ");
        int choice = scan.nextInt();
        return choice;
    }

    public void displaySearchBook(){
        String title = "";
        int id = -1;
        System.out.println("Search Book");
        System.out.println("1. Search by title");
        System.out.println("2. Search by id");
        System.out.print("Please input your choice: ");
        int choice = scan.nextInt();
        System.out.println();
        Book book = new Book();
        if(choice == 1){
            while(title.isEmpty()){
                System.out.print("Title: ");
                title = scan.nextLine();
                System.out.println();
            }
            ResultSet rs = searchBook(title);
            printRs(rs);
            while(id == -1){
                System.out.print("ID: ");
                id = scan.nextInt();
                System.out.println();
            }
            
            book = getBookById(id);
            
        }
        else if(choice == 2){
            while(id == -1){
                System.out.print("ID: ");
                id = scan.nextInt();
                System.out.println();
            }
            
            book = getBookById(id);
        }
        System.out.format(formatInfoBooks,"ID","Title","Subject","Pages","Author","Holder");
        System.out.println();
        System.out.format(formatInfoBooks,book.getID(),book.getBookTitle(),book.getSubject(),book.getNumOfPages(),book.getAuthors(),book.getCurrentHolder());
        System.out.println();
    }

    public void displayGiveIssue(){
        int user = -1;
        int id = -1;
        while(true){
            while(id == -1){
                System.out.print("Book ID: ");
                id = scan.nextInt();
                System.out.println();
            }
            
            Book book = getBookById(id);

            while(user == -1){
                System.out.print("User ID: ");
                user = scan.nextInt();
                System.out.println();
            }
           

            if(book.getCurrentHolder() > 0){
                System.out.print("For how many days? ");
                int days = scan.nextInt();
                System.out.println();

                System.out.println("Would you like to issue "+book.getBookTitle()+" ?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Please input your choice: ");
                int choice = scan.nextInt();
                System.out.println();

                if(choice == 1){
                    Issue issue = new Issue(user, days, book.getID());
                    addIssue(issue);
                    addBookIssue(issue, book.getID());
                    addBorrowedBook(book, user);
                }
                else{
                    System.out.println("Issue canceled");
                    break;
                }
            }
            else{
                System.out.println("This book is not available at the moment.");
                break;
            }
        }
        
    }

    public void displayAddBook(){
        String title = "";
        String subject = "";
        int numberOfPages = -1;
        String author = "";

        while(title.isEmpty()){
            System.out.print("Book title: ");
            title = scan.nextLine();
            System.out.println();
        }
        
        while(subject.isEmpty()){
            System.out.print("Book subject: ");
            subject = scan.nextLine();
            System.out.println();
        }
        
        while(numberOfPages == -1){
            System.out.print("Number of pages: ");
            numberOfPages = scan.nextInt();
            System.out.println();
        }
       
        while(author.isEmpty()){
            System.out.print("Author: ");
            author = scan.nextLine();
            System.out.println();
        }
        

        Book book = new Book(title, subject, -1, numberOfPages, author);
        addBook(book);
    }

    public void displaySearchIssue(){
        while(true){
            System.out.println("Search an issue");
            System.out.println("1. Search by book id");
            System.out.println("2. Search by user id");
            System.out.println("3. Search by return date");
            System.out.println("4. Exit");
            System.out.print("Please input your choice: ");
            int choice = scan.nextInt();
            System.out.println();

            if(choice == 1){
                System.out.print("Please input book id: ");
                int id = scan.nextInt();
                System.out.println();
                ResultSet rs = searchIssueByBook(id);
                if(rs != null){
                    printRs(rs);
                }
                else{
                    continue;
                }
            }
            else if(choice == 2){
                System.out.print("Please input user id: ");
                int id = scan.nextInt();
                System.out.println();
                ResultSet rs = searchIssueByUser(id);
                if(rs != null){
                    printRs(rs);
                }
                else{
                    continue;
                }
            }
            else if(choice == 3){
                String date = "";
                int id = -1;
                while(date.isEmpty()){
                    System.out.print("Please input the date [day,dd/mm/yyyy]: ");
                    date = scan.nextLine();
                }
                
                try {
                    Date returnDate = dateFormat.parse(date);
                    ResultSet rs = searchIssueByReturnDate(date);
                    printRs(rs);

                } catch (ParseException e) {
                    System.out.println("Invalid date");
                    continue;
                }
                
            }
            else if(choice == 4){
                break;
            }
            else{
                System.out.println("Invalid input");
                continue;
            }
        }
    }

    public void displayReturnBook(){
        System.out.println();
        System.out.println("Return Book");
        System.out.print("Please input book id: ");
        int id = scan.nextInt();
        System.out.println();

        System.out.print("Please input holder id: ");
        int user = scan.nextInt();
        System.out.println();

        removeBookIssue(id);
        removeBorrowedBook(id, user);
    }

    public void displaySearchUser(){
        System.out.println();
        System.out.println("Search User");
        System.out.print("Please input a name: ");
        String name = scan.nextLine();
        System.out.println();
        searchUser(name);
    }
    // INTERFACE FUNCTIONS END // 

    public Connection getConnection() {
        try { // get connection to db
            //Class.forName("com.mysql.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "admin",
                    "QiUXCpyXs3YHxlCm");
            return conn;
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    public Person makeAccount(){
        String name = "";
        String address = "";
        String username = "";
        String password = "";
        try{
            System.out.println("Please enter the information required");
            
            while(name.isEmpty()){
                System.out.print("Name: ");
                name = scan.nextLine();
                System.out.println();
            }
            
            while(address.isEmpty()){
                System.out.print("Address: ");
                address = scan.nextLine();
                System.out.println();
            }
            
            while(username.isEmpty()){
                System.out.print("Username: ");
                username = scan.nextLine();
                System.out.println();
            }
           
            
            Connection conn = getConnection();
            String search = "SELECT * FROM `user` WHERE `username`= ?";
            PreparedStatement prpstmt = conn.prepareStatement(search);
            prpstmt.setString(1, username);
            ResultSet rs = prpstmt.executeQuery();

            if(!rs.isBeforeFirst()){
                while(password.isEmpty()){
                    System.out.print("Password: ");
                    password = scan.nextLine();
                    System.out.println();
                }
                
                Visitor user = new Visitor(name, 0, address, username, password);
                addUser(user);
                int id = getUserId(user);
                user.setID(id);
                System.out.println("Success");
                return user;
            }
            else{
                System.out.println("Username is already taken.");
                
                return null;
            }

        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public void printRs(ResultSet rs){
        
        try{
            ResultSetMetaData rsMetaData = rs.getMetaData();
            String tableName = rsMetaData.getTableName(1);
            System.out.println(tableName);
            if(tableName.equalsIgnoreCase("user")){
                System.out.format(formatInfoUser,"ID","Name","Address","Borrowed Books");
                System.out.println();
                while(rs.next()){
                    System.out.format(formatInfoUser,rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("borrowed books"));
                    System.out.println();
                }
                rs.beforeFirst();

            }
            else if(tableName.equalsIgnoreCase("books")){
                System.out.format(formatInfoBooks,"ID","Title","Subject","Pages","Author","Holder");
                System.out.println();
                while(rs.next()){
                    System.out.format(formatInfoBooks,rs.getInt("id"),rs.getString("book title"),rs.getString("subject"),rs.getInt("number of pages"),rs.getString("author"),rs.getInt("current holder"));
                    System.out.println();
                }
                rs.beforeFirst();
            }
            else if(tableName.equalsIgnoreCase("issue")){
                System.out.format(formatInfoIssue,"ID","Issue Date", "Return Date","Book","Holder");
                System.out.println();
                while(rs.next()){
                    System.out.format(formatInfoIssue,rs.getInt("id"),rs.getString("issue date"),rs.getString("return date"),rs.getInt("book"),rs.getInt("holder"));
                    System.out.println();
                }
                rs.beforeFirst();
            }
           
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }

    // BOOK FUNCTIONS //
    
    public ResultSet searchBook(String title){
        
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `books` where `book title` like ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setString(1,"%"+title+"%");
            ResultSet rs = prepstmt.executeQuery();

            if(rs.next()){
                rs.beforeFirst();
                return rs;
            }
            else{
                System.out.println("Not Found");
                return null;
            }
            
        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    // Get book by title
    public void getBookByHolder(int id){
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `books` where `current holder` = ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setInt(1,id);
            ResultSet rs = prepstmt.executeQuery();
            printRs(rs);
            prepstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Get book by id
    public Book getBookById(int id){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS");
            // while result set has next book
            while(rs.next()){
                int dbId = rs.getInt("id");
                // if title is the same 
                if(dbId == id){
                    // Getting the list of authors as a list without the comma
                    List<String> authors = new ArrayList<String>(Arrays.asList(rs.getString("author").split("\\s*,\\s*")));
                    // Make the book class
                    Book result = new Book(rs.getString("book title"), rs.getString("subject"), dbId, rs.getInt("number of pages"),authors,rs.getInt("current holder"));
                    stmt.close();
                    return result;
                }
            }
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    // Add book into db
    public void addBook(Book book){
        ArrayList<String> author = book.getAuthors();
        // To concat string and put ',' as seperator
        String authors = String.join(",",author);
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // insert format
            String insert = "INSERT INTO `books` (`book title`, `subject`, `number of pages`, `author`,`current holder`)" + 
                            "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prepstmt = conn.prepareStatement(insert);
            prepstmt.setString(1, book.getBookTitle());
            prepstmt.setString(2, book.getSubject());
            prepstmt.setInt(3,book.getNumOfPages());
            prepstmt.setString(4, authors);
            prepstmt.setInt(5,-1);
            prepstmt.execute();
            stmt.close();
            System.out.println("Book added succesfully");
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }

    // Add issue id into book
    public void addBookIssue(Issue issue, int bookId){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // insert format
            String update = "UPDATE books SET issue = ?, `current holder` = ? where `id` = ?";
            PreparedStatement prepstmt = conn.prepareStatement(update);
            prepstmt.setInt(1, issue.getId());
            prepstmt.setInt(2, issue.getHolder());
            prepstmt.setInt(3, bookId);
            prepstmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }

    // set book issue into null
    public void removeBookIssue(int bookId){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // insert format
            String update = "UPDATE books SET `issue` = ?, `current holder` = ? where `id` = ?";
            PreparedStatement prepstmt = conn.prepareStatement(update);
            prepstmt.setNull(1, Types.INTEGER);
            prepstmt.setNull(2, Types.INTEGER);
            prepstmt.setInt(3, bookId);
            prepstmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }
    
    // BOOK FUNCTIONS END //

    // ISSUE FUNCTIONS //

    // Get issue by id
    public Issue getIssueById(int id){
        DateFormat dateFormat = new SimpleDateFormat("E,dd/MM/yyyy");
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM issue");
            // while result set has next book
            while(rs.next()){
                int dbId = rs.getInt("id");
                // if title is the same 
                if(dbId == id){
                    Calendar issueDate = Calendar.getInstance();
                    Calendar returnDate = Calendar.getInstance();
                    issueDate.setTime(dateFormat.parse(rs.getString("issue date")));
                    returnDate.setTime(dateFormat.parse(rs.getString("return date")));

                    Issue result = new Issue(rs.getInt("current holder"), issueDate, returnDate, id, rs.getInt("book"));
                    stmt.close();
                    return result;
                }
            }
            stmt.close();
        }
        catch(SQLException | ParseException e ){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    // ISSUE FUNCTIONS END //

    // USER FUNCTIONS // 

    public void addUser(Person person){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String role = "";

            if(person instanceof Visitor){
                role = "Visitor";
            }
            else if(person instanceof Librarian){
                role = "Librarian";
            }
            // insert format
            String insert = "INSERT INTO `user` (`name`, `address`, `username`, `password`, `role`)" + 
                            "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prepstmt = conn.prepareStatement(insert);
            prepstmt.setString(1, person.getName());
            prepstmt.setString(2, person.getAddress());
            prepstmt.setString(3,person.getUsername());
            prepstmt.setString(4, person.getPassword());
            prepstmt.setString(5,role);
            prepstmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }

    public int getUserId(Person user){
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `user` WHERE `username` = ?";
            PreparedStatement prpstmt = conn.prepareStatement(search); 
            prpstmt.setString(1,user.getUsername());
            ResultSet rs = prpstmt.executeQuery();
            int id = rs.getInt("id");
            prpstmt.close();
            return id;
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public Person getUserById(int id){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            // while result set has next book
            while(rs.next()){
                int dbId = rs.getInt("id");
                // if title is the same 
                if(dbId == id){
                    // Check the role
                    String role = rs.getString("role");
                    if(role.equalsIgnoreCase("Visitor")){
                        Visitor user = new Visitor(rs.getString("name"), dbId, rs.getString("address"), rs.getString("username"), rs.getString("password"));
                        stmt.close();
                        return user;
                    }
                    else if(role.equalsIgnoreCase("Librarian")){
                        Librarian user = new Librarian(rs.getString("name"), dbId, rs.getString("address"), rs.getString("username"), rs.getString("password"));
                        stmt.close();
                        return user;
                    }
                }
            }
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void addBorrowedBook(Book book, int id){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // insert format
            String update = "UPDATE `user` SET `borrowed books` = ? where `id` = ?";
            PreparedStatement prepstmt = conn.prepareStatement(update);
            prepstmt.setInt(1, book.getID());
            prepstmt.setInt(2, id);
            prepstmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }

    public void removeBorrowedBook(int bookId, int id){
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            // insert format
            String update = "UPDATE user SET `borrowed books` = ? where `id` = ?";
            PreparedStatement prepstmt = conn.prepareStatement(update);
            prepstmt.setNull(1, Types.INTEGER);
            prepstmt.setInt(2, bookId);
            prepstmt.executeUpdate();
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }

    public Person login(){
        String username = "";
        String password = "";
        while(username.isEmpty()){
            System.out.print("Username: ");
            username = scan.nextLine();
            System.out.println();
        }
        while(password.isEmpty()){
            System.out.print("Password: ");
            password = scan.nextLine();
            System.out.println();
        }
        try{
            Connection conn = getConnection();
            String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
            PreparedStatement prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1,username);
            prepStmt.setString(2,password);
            ResultSet rs = prepStmt.executeQuery();

            

            if(!rs.isBeforeFirst()){
                System.out.println("Wrong username or password");
                return null;
            }
            rs.next();
            String role = rs.getString("role");

            if(role.equalsIgnoreCase("Visitor")){
                Visitor user = new Visitor(rs.getString("name"), rs.getInt("id"), rs.getString("address"), username, password);
                prepStmt.close();
                return user;
            }
            else if(role.equalsIgnoreCase("Librarian")){
                Librarian user = new Librarian(rs.getString("name"), rs.getInt("id"), rs.getString("address"), username, password);
                prepStmt.close();
                return user;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet searchUser(String name){
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `user` where `name` like ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setString(1,"%"+name+"%");
            ResultSet rs = prepstmt.executeQuery();

            if(rs.next()){
                // reset pointer
                rs.beforeFirst();
                return rs;
            }
            else{
                System.out.println("Not Found");
                return null;
            }
            
        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    // USER FUNCTIONS END //

    // ISSUE FUNCTIONS //

    public ResultSet searchIssueByReturnDate(String date){
        // date has to be properly formatted
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `issue` WHERE `return date` LIKE ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setString(1,"%"+date+"%");
            ResultSet rs = prepstmt.executeQuery();
            if(rs.next()){
                // reset pointer
                rs.beforeFirst();
                return rs;
            }
            else{
                System.out.println("Not Found");
                return null;
            }

        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public void searchIssueByToday(){
        // date has to be properly formatted
        Calendar calendar = Calendar.getInstance();
        String today = dateFormat.format(calendar.getTime());
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `issue` WHERE `return date` LIKE ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setString(1,"%"+today+"%");
            ResultSet rs = prepstmt.executeQuery();
            if(rs.next()){
                // reset pointer
                rs.beforeFirst();
                printRs(rs);
            }
            else{
                System.out.println("Not Found");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addIssue(Issue issue){
        
        String issueDate = dateFormat.format(issue.getIssueDate().getTime());
        String returnDate = dateFormat.format(issue.getReturnDate().getTime());
        try{
            Connection conn = getConnection();
            // insert format
            String insert = "INSERT INTO `issue` (`issue date`, `return date`, `holder`, `book`)" + 
                            "VALUES(?, ?, ?, ?)";
            PreparedStatement prepstmt = conn.prepareStatement(insert);
            prepstmt.setString(1, issueDate);
            prepstmt.setString(2, returnDate);
            prepstmt.setInt(3,issue.getHolder());
            prepstmt.setInt(4, issue.getBook());
            prepstmt.execute();
            prepstmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();   
        }
    }

    public ResultSet searchIssueByBook(int id){
        // date has to be properly formatted
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `issue` WHERE `book` LIKE ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setString(1,"%"+id+"%");
            ResultSet rs = prepstmt.executeQuery();
            if(rs.next()){
                // reset pointer
                rs.beforeFirst();
                return rs;
            }
            else{
                System.out.println("Not Found");
                return null;
            }

        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public ResultSet searchIssueByUser(int id){
        // date has to be properly formatted
        try{
            Connection conn = getConnection();
            String search = "SELECT * FROM `issue` WHERE `holder` LIKE ?";
            PreparedStatement prepstmt = conn.prepareStatement(search);
            prepstmt.setString(1,"%"+id+"%");
            ResultSet rs = prepstmt.executeQuery();
            if(rs.next()){
                // reset pointer
                rs.beforeFirst();
                return rs;
            }
            else{
                System.out.println("Not Found");
                return null;
            }

        }
        catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    // ISSUE FUNCTIONS END // 
}