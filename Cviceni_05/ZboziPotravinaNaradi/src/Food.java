import java.rmi.server.ExportException;
import javax.lang.model.util.ElementScanner6;

public class Food extends Goods
{
    private int expiration_date;

    public Food(String name,double price, int newExp){
        super(name, price);
        this.expiration_date = newExp;
    }

    public int getExpiration_date(){
        return expiration_date;
    }

    public void setExpiration_date(int newExp){
        this.expiration_date = newExp;
    }

    @Override
    public String getJednotka(){
        if (expiration_date > 1) {
            return "days";
        }
        if (expiration_date < 0) {
            return "After expiration";
        }
        else{
            return "day";
        }
    }
}
