public class Employee{
    private
    int id;
    String firstName;
    String lastName;
    int salary;

    public
    Employee(int id,String firstName,String lastName,int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    //getter
    int getID(){
        return this.id;
    }
    String getFirstName(){
        return this.firstName;
    }
    String getLastName(){
        return this.lastName;
    }
    String getName(){
        return this.firstName + " " +this.lastName;
    }
    int getSalary(){
        return salary;
    }

    //stuff
    int getAnnualSalary(){
        return this.salary * 12;
    }
    int raiseSalary(int percent){
        this.salary = this.salary * (percent/100);
        return this.salary;
    }
    
    //setter
    void setSalary(int salary){
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee[id= " + id + ",first name= " + firstName + ",last name= " + lastName + ",salary= " + salary
                + "]";
    }
    
}