public abstract class Goods 
{
    private String name;    
    private double noDPHPrice;
    private final double DPH = 1.21;

    public Goods (String NewName, double newPrice){
        this.name = NewName;
        this.noDPHPrice = newPrice;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getPrice(){
        return noDPHPrice * DPH;
    }

    public void setPrice(double newPrice){
        this.noDPHPrice = newPrice;
    }

    public abstract String getJednotka();
}
