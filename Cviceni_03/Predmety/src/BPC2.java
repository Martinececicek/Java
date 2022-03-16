public class BPC2 implements Predmet {
    private static final double maxProjekt = 30.0;
    private static final double maxPulSemZkouska = 20.0;
    private static final double maxZaverZkouska = 50.0;

    private static double projekt;
    private static double pulsemZkouska;
    private static double zaverZkouska;
    


    @Override
    public String getName(){
        return "BPC2";
    }

    @Override
    public double getPoints(){
        return (projekt + pulsemZkouska + zaverZkouska);
    }
    
    @Override
    public String getPass(){
        if ((projekt + pulsemZkouska + zaverZkouska) > minZapocet) {
            return "Zapocet udelen";
        }else{
            return "Zapocet neudelen";
        }

    }


    public static void setProjekt(int Projekt){
        if ( (Projekt <= maxProjekt) || Projekt < 0 ) {
            projekt = Projekt;
        }else{
            System.out.println("Points out of interval");
        }
    }

    public static void setZaverZkouska(int ZaverZkouska){
        if ( (ZaverZkouska <= maxZaverZkouska) || ZaverZkouska < 0 ) {
            zaverZkouska = ZaverZkouska;
        }else{
            System.out.println("Points out of interval");
        }
    }

    public static void setPulSemZkouska(int PulSemZkouska){
        if (PulSemZkouska <= maxPulSemZkouska) {
            pulsemZkouska = PulSemZkouska;
        }else{
            System.out.println("Points out of interval");
        }
    }

}
