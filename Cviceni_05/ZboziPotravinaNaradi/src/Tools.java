public class Tools extends Goods {

    private int Warranty;

    public Tools(String newName, double price, int newWarr){
        super(newName, price);
        this.Warranty = newWarr;
    }

    public int getWarranty(){
        return Warranty;
    }

    public void setWarranty(int newWarr){
        this.Warranty = newWarr;
    }

    @Override
    public String getJednotka(){
        if (Warranty > 1) {
            return "Months";
        }
        if (Warranty < 1) {
            return "After warranty";
        }else{
            return "Month";
        }
    }
    
}
