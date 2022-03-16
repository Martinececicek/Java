import java.util.Scanner;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.rowset.spi.SyncProvider;
import javax.xml.crypto.Data;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}

	public static float JeCeleNeboDesetinne(Scanner sc){
		float number = 0;

		try {
			number = sc.nextFloat();
		} catch (Exception e) {
		System.out.println("Nastala vyjimka typu "+e.toString());
		System.out.print("Zadejte prosim cislo (desetinne nebo cele cislo): ");	
		sc.nextLine();
		number = JeCeleNeboDesetinne(sc);
		}
		return number;
	}

	public static int JeVPoli(Scanner sc, Databaze MyDatabase){

		int number = 0;
		try {
			number = sc.nextInt();					//Zkousime zda jsme v poli na spravnem indexu
			MyDatabase.getStudent(number);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nastala vyjimka typu: "+e.toString());
			System.out.println("Zadejte prosim index v rozsahu databaze");
			sc.nextLine();
			number = JeVPoli(sc, MyDatabase);
		} catch (NullPointerException e){
			System.out.println("Nastala vyjimka typu: "+e.toString());
			System.out.print("Zadejte prosim spravny index studenta: ");
			sc.nextLine();
			number = JeVPoli(sc, MyDatabase);
		}
		return number;
	}

	public static float ZkusPrumer(Scanner sc, Databaze MyDatabase){
			int number = 0;
			float avg = 0;

			try {
				number = JeVPoli(sc, MyDatabase);
				avg = JeCeleNeboDesetinne(sc);
				MyDatabase.setPrumer(number, avg);
			} catch (Exception e) {
				System.out.println("Nastala vyjimka typu: " + e.toString());
				sc.nextLine();
				avg = ZkusPrumer(sc, MyDatabase);
			}
			return number;
	}
	


	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx;
		float prumer;
		int volba;
		boolean run=true;
		boolean zkus= true;
		
		System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);



		//try {
			while(run)
			try{
		{
			if (zkus) {
				switch(volba)
			{
				case 1:
					System.out.println("Zadejte pocet studentu");
					sc.nextLine();
					mojeDatabaze=new Databaze(sc.nextInt());
					break;
				case 2:
					mojeDatabaze.setStudent();
					break;
				case 3:
					System.out.println("Zadejte index a prumer studenta");
					sc.nextLine();
					idx=sc.nextInt();
					prumer =sc.nextFloat();
					mojeDatabaze.setPrumer(idx,prumer);
					break;
				case 4:
					System.out.println("Zadejte index studenta");
					idx=sc.nextInt();
					Student info=mojeDatabaze.getStudent(idx);
					System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
					
					break;
				case 5:
					run=false;
					break;
				
					
				}
					
			zkus = false;
				

		}
		if (zkus == false && volba!=5) {
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			zkus = true;
			
		}

			}

			
			
		} catch (Exception e) {
			System.out.println("Nastala chyba typu: " + e.toString());
			System.out.println("Zadejte spravnou pozadovanou hodnotu");
		}



		
	}

}
