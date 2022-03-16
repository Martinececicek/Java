import java.util.Scanner;




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

	


	public static void main(String[] args) {	
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
		System.out.println("5 .. vypis cele databaze");
		System.out.println("6 .. ulozeni databaze do souboru");
		System.out.println("7 .. nacteni databaze ze souboru");
		System.out.println("8 .. ukonceni aplikace");
		System.out.println("9 .. rychle naplneni databaze");
		volba=pouzeCelaCisla(sc);



		
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
					System.out.println("Zadejte jmeno studenta, rok narozeni");
					//sc.nextLine();
					String jmeno=sc.next();
					int rok=sc.nextInt();
					mojeDatabaze.setStudent(jmeno,rok);
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
					mojeDatabaze.printDatabase();
					break;	
				case 6: 
					sc.nextLine(); 
					System.out.println("Zadejte jmeno souboru pro ulozeni: ");
					String name = sc.nextLine(); 
					//name += ".txt";
					mojeDatabaze.printToFile(name); 
					break;
				case 7:
					sc.nextLine(); // vyprazdneni scanneru
					System.out.println("Zadejte jmeno souboru pro nacteni: ");
					name = sc.nextLine();
					//name += ".txt";
					mojeDatabaze.loadFromFile(name, mojeDatabaze); 
				break;
				case 9: 
					mojeDatabaze=new Databaze(5);
					mojeDatabaze.setStudent("Martin",2000);
					mojeDatabaze.setStudent("David", 2145);
					mojeDatabaze.setStudent("Petr",2000);
					mojeDatabaze.setStudent("Jakub", 2145);
					mojeDatabaze.setStudent("Ondra",2000);
					mojeDatabaze.setPrumer(0, 1);
					mojeDatabaze.setPrumer(1, 4);
					mojeDatabaze.setPrumer(2, 5);
					mojeDatabaze.setPrumer(3, 1);
					mojeDatabaze.setPrumer(4, 2);
					break;
				case 8:
					run=false;
					break;
				}
					
			zkus = false;
				

		}
		if (zkus == false && volba!=8) {
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. vypis cele databaze");
			System.out.println("6 .. ulozeni databaze do souboru");
			System.out.println("7 .. nacteni databaze ze souboru");
			System.out.println("8 .. ukonceni aplikace");
			System.out.println("9 .. rychle naplneni databaze");
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
