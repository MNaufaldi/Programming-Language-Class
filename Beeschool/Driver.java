import java.util.ArrayList;
import java.util.Scanner;

public class Driver{

    public static void main(String[] args) {
        Scanner ask = new Scanner (System.in);
        ArrayList<Subject> subjectData = new ArrayList<Subject>();
        ArrayList<Student> studentData = new ArrayList<Student>();
        Utility test = new Utility();
        int choice = 0;

        test.menu();
        while(choice != 7){
            choice = ask.nextInt();

            if(choice == 1){
                test.insertSubject(subjectData);
                test.menu();
            }
            else if(choice == 2){
                test.viewSubject(subjectData);
                test.menu();
            }
            else if(choice == 3){
                test.insertStudent(studentData);
                test.menu();
            }
            else if(choice == 4){
                test.viewStudent(studentData);
                test.menu();
            }
            else if(choice == 5){
                test.insertScore(studentData, subjectData);
                test.menu();
            }
            else if(choice == 6){
                test.viewScore(studentData, subjectData);
                test.menu();
            }
            else if(choice == 7){
                break;
            }
            else{
                System.out.print("Choose Menu: ");
                continue;
            }
        }
    }
}