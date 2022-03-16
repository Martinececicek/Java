public class BPC1 implements Predmet{

    private static double aktivita;
    private static double zkouska;

    private static final double maximalniAtivita = 20;
    private static final double maximalniZkouska = 80;


    @Override
    public String getName(){
        return "BPC1";
    }

    @Override
    public double getPoints(){
        return (aktivita + zkouska);
    }
    
    @Override
    public String getPass(){
        if (aktivita >= minZapocet) {
            return "Zapocet udelen";
        }else{
            return "Zapocet neudelen";
        }

    }

    public static void setAktivita(int Aktivita){
        if ( (Aktivita <= maximalniAtivita) || Aktivita < 0) {
            aktivita = Aktivita;
        }else
        System.out.println("Points out of interval");
    }

    public static void setZkouska(int Zkouska){
        if ( (Zkouska <= maximalniZkouska) || Zkouska < 0 ) {
            zkouska = Zkouska;
        }else
        System.out.println("Points out of interval");
    }


}
