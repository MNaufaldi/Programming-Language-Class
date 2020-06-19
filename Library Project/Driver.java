import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Driver {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        
        userQuery query = new userQuery();
        DateFormat dateFormat = new SimpleDateFormat("E,dd/MM/yyyy");
        
        while(true){
            choice = query.displayStart();
            if(choice == 1){// login
                choice = 0;
                Person user = query.login();
                if(user == null){
                    user = query.login();
                }
                // if user = visitor
                if(user instanceof Visitor){
                    while(true){
                        choice = query.displayVisitorHome(user);
                        if(choice == 1){// Search book
                            query.displaySearchBook();
                            choice = 0;
                        }
                        else if(choice == 2){// Check borrowed book
                            query.getBookByHolder(user.getID());
                            choice = 0;
                        }
                        else if(choice == 3){// Exit
                            choice = 0;
                            user = null;
                            break;
                        }
                    }
                }
                // if user = librarian
                else if(user instanceof Librarian){
                    while(true){
                        choice = query.displayLibrarianHome(user);
                        if(choice == 1){ // Issue book
                            query.displayGiveIssue();
                            choice = 0;
                        }
                        else if(choice == 2){ // Add book
                            query.displayAddBook();
                            choice = 0;
                        }
                        else if(choice == 3){ // Search book
                            query.displaySearchBook();
                            choice = 0;
                        }
                        else if(choice == 4){// Search an issue
                            query.displaySearchIssue();
                            choice = 0;
                        }
                        else if(choice == 5){// Return book
                            query.displayReturnBook();
                            choice = 0;
                        }
                        else if(choice == 6){// Issue today
                            query.searchIssueByToday();
                            choice = 0;
                        }
                        else if(choice == 7){// Search user
                            query.displaySearchUser();
                        }
                        else if(choice == 8){
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Error");
                }
            } // login end

            else if(choice == 2){//Register
                choice = 0;
                Person user = query.makeAccount();
                if(user == null){
                    user = query.makeAccount();
                }
                user = null;
            }// Register end

            else if(choice == 3){// Exit
                break;
            } // Exit end

            else{ // na input
                continue;
            } // na input end
        }

        
    }
}