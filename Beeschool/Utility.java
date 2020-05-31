import java.util.Scanner;
import java.util.ArrayList;

public class Utility{
    Scanner ask = new Scanner(System.in);
    //String format
    String column1Format = "%-8.8s";  // fixed size 5+3 characters, left aligned
    String column2Format = "%-28.28s";  // fixed size 25+3 characters, left aligned
    String column3Format = "%-16.16s";   // fixed size 6 characters, right aligned
    String formatInfo = column1Format + " " + column2Format + " " + column3Format;

    public void menu(){
        System.out.println("Bee School");
        System.out.println("===================================================");
        System.out.println("1. Insert New Subject");
        System.out.println("2. View All Subject");
        System.out.println("3. Insert New Student");
        System.out.println("4. View All Student");
        System.out.println("5. Insert Student Score");
        System.out.println("6. View All Student Score");
        System.out.println("7. Exit");
        System.out.print("Choose Menu: ");
    }

    //Insert new Subject
    public void insertSubject(ArrayList<Subject> list){
        Subject subject = new Subject();
        String name = "a";
        String category = "a";
        int id;
        System.out.print("Input subject name [3-25 characters | ends with 'Subject']: ");
        name = ask.nextLine();
        if(name.length() > 2 && name.length() < 26 && name.contains(" Subject") == true){
            //Check if already exist
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getName() == name){
                    System.out.println("Subject already exist!");
                    insertSubject(list);
                }
                else{
                    continue;
                }
            }
        }
        else{
            insertSubject(list);
        }
            System.out.println();
            while(true){
                System.out.print("Input subject category [Main | elective]: ");
                
                category = ask.nextLine();
                if(category.equals("Main") == true || category.equals("Elective") == true){
                    id = list.size() + 1;
                    //Creating the class
                    
                    subject.setName(name);
                    subject.setCategory(category);
                    subject.setID(id);
                    subject.setIndex(list.size());
                    list.add(subject);
                    System.out.println("Subject added!");
                    break;
                }
                else{
                    System.out.println(category);
                    continue;
                }
            }
            
            

    }

    public void viewSubject(ArrayList<Subject> list){
        if(list.size() == 0){
            System.out.println("No Data!");
        }
        else{
            //System.out.println("Subject ID\tSubject Name\t\t\tSubject Category");
            System.out.format(formatInfo,"Subject ID","Subject Name","Subject Category");
            System.out.println();
            System.out.println("===================================================");

            for(int i = 0; i < list.size(); i++){
                //System.out.println("SB001\t\ttestSubject\t\tMain");
               // System.out.println(list.get(i).getPrefix()+list.get(i).getID()+"\t\t"+list.get(i).getName()+"\t\t\t"+list.get(i).getCategory());
                System.out.format(formatInfo,list.get(i).getPrefix()+list.get(i).getID() ,list.get(i).getName(),list.get(i).getCategory());
                System.out.println();
        }
            }
            
    }

    public void insertStudent(ArrayList<Student> list){
        Student student = new Student();
        String name = "a";
        String gender = "a";
        int id;
        System.out.print("Input student name [3-25 characters]: ");
        name = ask.nextLine();
        if(name.length() > 2 && name.length() < 26){
            //Check if already exist
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getName() == name){
                    System.out.println("Student already exist!");
                    insertStudent(list);
                }
                else{
                    continue;
                }
            }
        }
        else{
            insertStudent(list);
        }
            System.out.println();
            while(true){
                System.out.print("Input student gender [Male | Female]: ");
                System.out.println();
                gender = ask.next();
                if(gender.equals("Male") == true || gender.equals("Female") == false){
                    id = list.size() + 1;
                    //Creating the class
                    
                    student.setName(name);
                    student.setGender(gender);
                    student.setID(id);

                    list.add(student);
                    System.out.println("Student added!");
                    break;
                }
                else{
                 
                    break;
                }
            }
            
    }

    public void viewStudent(ArrayList<Student>list){
        if(list.size() == 0){
            System.out.println("No Data!");
        }
        else{
           
            System.out.format(formatInfo,"Student ID","Student Name","Student Gender");
            System.out.println();
            System.out.println("===================================================");

            for(int i = 0; i < list.size(); i++){
                System.out.format(formatInfo,list.get(i).getPrefix()+list.get(i).getID() ,list.get(i).getName(),list.get(i).getGender());
                System.out.println();
            }
            
        }

    }

    public void insertScore(ArrayList<Student>St,ArrayList<Subject>Su){
        String stID;
        String suID;
        Student student = null;
        Subject subject = null;
        boolean s = true;
        int num = -1;
       
        //Check
        System.out.print("Input student id: ");
        stID = ask.nextLine();
        System.out.println();
        for(int i = 0; i < St.size();i++){
            if(St.get(i).getID().equals(stID) == true){
                student = St.get(i);
                break;
            }
            else if(i == St.size()-1){
                insertScore(St, Su);
            }
            else{
                continue;
            }
        }
        
        while(s == true){
            System.out.print("Input subject id: ");
            suID = ask.nextLine();
            System.out.println();
            for(int j = 0; j < Su.size(); j++){
                if((Su.get(j).getPrefix()+Su.get(j).getID()).equals(suID) == true){
                    for(int k = 0; k < student.getScore().size(); k++){
                        if((student.getScore().get(k).getSubject().getPrefix()+student.getScore().get(k).getSubject().getPrefix()).equals(suID)==true){
                            break;
                        }
                        else if(k == student.getScore().size() - 1){
                            subject = Su.get(j);
                            s = false;
                        }
                        else{
                            continue;
                        }
                    }
                    
                }
                else if(j == Su.size()-1){
                    break;
                }
            }

        }
        //Finished check
        //Create instance
        Score score = new Score();
        //Input score
        while(s == false){
            System.out.print("Input score [0-100]: ");
            num = ask.nextInt();
            if(num < 101 && num >= 0){
               //Assign
                score.setScore(num);
                score.setSubject(subject);
                score.setID(student.getScore().size()+1);
                student.setScore(score);
                System.out.println("Success insert student score!");
            }
            else{
                continue;
            }
        }
        
        
    }

    public void viewScore(ArrayList<Student>St,ArrayList<Subject>Su){
        if(Su.size() == 0 && St.size() == 0){
            System.out.println("No Data!");
        }
        else{
            
            for(int i = 0; i < St.size(); i++){
                if(St.size() == 0){
                    System.out.println("No Data!");
                    break;
                }
                else{
                    System.out.format(formatInfo,"Student ID","Student Name","Student Gender");
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.format(formatInfo,St.get(i).getPrefix()+St.get(i).getID() ,St.get(i).getName(),St.get(i).getGender());
                    System.out.println();
                    
                }
                if(St.get(i).getScore().size() == 0){
                    System.out.println("---------------------------------------------------");
                    System.out.println("No Data!");
                    break;
                }
                else{
                    System.out.println("---------------------------------------------------");
                    System.out.format(formatInfo,"Subject ID","Subject Name","Subject Score");
                    System.out.println();
                    System.out.println("---------------------------------------------------");
                    for(int k = 0; k < St.get(i).getScore().size(); k++){
                        System.out.format(formatInfo,St.get(i).getScore().get(k).getPrefix()+Su.get(k).getID() ,
                                            St.get(i).getScore().get(k).getSubject().getName(),
                                            St.get(i).getScore().get(k).getScore());
                        System.out.println();
                    }
                    System.out.println("===================================================");
                }
            }
            
        }
    }

}