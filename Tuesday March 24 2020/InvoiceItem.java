public class InvoiceItem{
    private
    String id;
    String desc;
    int qty;
    double unitPrice;

    public
    InvoiceItem(String id,String desc,int qty,double unitPrice){
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    //getter
    String getID(){
        return this.id;
    }
    String getDesc(){
        return this.desc;
    }
    int getQty(){
        return this.qty;
    }
    double unitPrice(){
        return this.unitPrice;
    }
    //setter
    void setQty(int qty){
        this.qty = qty;
    }
    void setUnitPrice(int unitPrice){
        this.unitPrice = unitPrice;
    }
    //stuff
    double getTotal(){
        return this.unitPrice * this.qty;
    }
    @Override
    public String toString(){
        return "InvoiceItem[id="+this.id+",desc="+this.desc+",qty="+this.qty+",unitPrice="+this.unitPrice+"]";
    }

}