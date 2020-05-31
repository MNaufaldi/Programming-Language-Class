public class Account{
    private
    String id;
    String name;
    int balance = 0;
    
    public
    Account(String id, String name){
        this.id = id;
        this.name = name;
    }
    Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    String getID(){
        return id;
    }
    String getName(){
        return name;
    }
    int getBalance(){
        return balance;
    }
    int debit(int amount){
        if(amount <= this.balance){
            this.balance = this.balance - amount;
        }
        else{
            System.out.println("Amount Exceeded Balance");
        }
        return this.balance;
    }
    int credit(int amount){
        this.balance = this.balance + amount;
        return this.balance;
    }
    int transferTo(Account another, int amount){
        if(amount <= this.balance){
            debit(amount);
            another.credit(amount);
        }
        else{
            System.out.println("Amount Exceeded Balance");
        }
        return this.balance;
    }
    @Override
    public String toString(){
        return "Acoount[id="+this.id+",balance="+balance+"]";
    }
}