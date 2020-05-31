public class Driver{
    public static void main(String [] args){
        Rectangle r = new Rectangle(5.0f,10.0f);
        Employee e = new Employee(1,"nop","al",100);
        InvoiceItem ie = new InvoiceItem("1", "Stuff", 10, 1000.0);
        Account a1 = new Account("1", "a1", 10);
        Account a2 = new Account("2","a2",100);
        Date d = new Date(1,10,2020);
        Time t = new Time(1,20,59);

        System.out.println(r.toString());
        System.out.println(e.toString());
        System.out.println(ie.toString());
        System.out.println(a1.toString());
        a2.transferTo(a1, 50);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(d.toString());
        System.out.println(t.toString());
        t.nextSecond();
        System.out.println(t.toString());
        }
}