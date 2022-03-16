public class Database {
    private String Jmeno;
	private int RokNarozeni;
	private double Uvazek = 0;
	private static double MaxUvazek = 1;

	public Database(String Jmeno, int RokNarozeni) { //konstruktor tridy
		this.Jmeno = Jmeno;
		this.RokNarozeni = RokNarozeni;
	}
	
	public String GetName() { //gettery pro jednotlive promenne
		return Jmeno;
	}
	
	public int GetAge() {
		return RokNarozeni;
	}
	
	public double GetObligation() {
		return Uvazek;
	}

	public static double GetMaxObligation(){
		return MaxUvazek;
	}
	
	public static void SetMaxObligation(double MaxObligation){ //Nastavi maximalni zavazek
		MaxUvazek=MaxObligation;
	}
	
	
	public boolean AddObligation(double Uvazek) { //Nova hodnota uvazku, NESMI byt vetsi nez hodnota maximalniho uvazku
		if((this.Uvazek + Uvazek)>MaxUvazek) {
			return false;
		}else {
			this.Uvazek += Uvazek;
			return true;
		}
			
	}

    
}
