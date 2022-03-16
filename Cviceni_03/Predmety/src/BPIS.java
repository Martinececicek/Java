
public class BPIS implements Predmet{
    
    private static int points;
    

    @Override
    public String getName(){
        return "BPIS";
    }

    @Override
    public double getPoints(){
        return points;
    }
    
    @Override
    public String getPass(){
        
        if (points > minZapocet) {
            return "Zapocet udelen";
        }else{
            return "Zapocet neudelen";
        }

    }

    public static void setZapocet(String Zapocet){
        if (Zapocet == "Ano") {
            points = 100;
        }else if (Zapocet == "Ne")
        {
            points = 0;
        }else{
            System.out.println("No correct entry");
        }
    }
}
