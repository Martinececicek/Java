import java.util.Scanner;
import java.io.Console;

public class DatabaseOperation {
    
    public static void main(String[] args){
        int pocetosob = 3;
		Database database[] = new Database[pocetosob];
		
		String Jmeno;
		int rok;
		Scanner sc = new Scanner(System.in);
		double NOvyUvazek = 0;
		//Console c = new Console(System.);
		//VypisMenu();

		for (int i = 0; i < pocetosob; i++) {
			System.out.print("Zadej jmeno osoby c." + (i+1) + ": ");
			sc=new Scanner(System.in);
			Jmeno = sc.next();
			
			System.out.print("Zadej rok narozeni: ");
			sc=new Scanner(System.in);
			rok = sc.nextInt();
			
			database[i]=new Database(Jmeno,rok);
			
		}
		System.out.println(); //Odradkovani aby to vypadalo trochu k svetu
			
		
		int choice = 1;
		
		while (choice!=0) {
		System.out.println();
		System.out.println("MENU");
		System.out.println("1: Zadani nove vyse maximalniho uvazku");
		System.out.println("2: Zmena uvazku konkretni osoby");
		System.out.println("3: Vypis vsech dat");
		System.out.println("0: Konec programu");
		System.out.print("Vas vyber: ");
		if (sc.hasNextInt()) {
			choice = sc.nextInt();	
		}

		switch (choice) {
			case 1:
			while (true) {
				System.out.print("Zadejte novou vysi maximalniho uvazku: ");
				if (sc.hasNextDouble()) {
					NOvyUvazek = sc.nextDouble();	
					Database.SetMaxObligation(NOvyUvazek);
					break;
				}else{
					System.out.print("Chyba: Nebylo zadano cislo");
				}
				
			}
			break;

			case 2:
			int osoba = 0;
			double nextuvazek = 0.0;
			System.out.println();
			System.out.print("Zadejte cislo konkretni osoby: ");
			if (sc.hasNextInt()) {
				osoba = sc.nextInt();	
			}else{
				System.out.print("Nezadali jste cislo");	
			}
			System.out.print("Zadejte novou vysi uvazku osoby: " + database[osoba-1].GetName());
			if (sc.hasNextDouble()) {
				nextuvazek = sc.nextDouble();
				if (database[osoba-1].AddObligation(nextuvazek)) {
					database[osoba-1].AddObligation(nextuvazek);
					System.out.print("Nova vyse uspesne zadana");
					break;
				}else{
					System.out.print("Zadana nespravna vyse uvazku ( vetsi nez povolena )");
					break;
				}
				
			}else{
				System.out.print("Nezadali jste cislo");
			}
			break;

			case 3:
			System.out.println("Vypisuji vsechny data, potom stiskni enter");
			for (int i = 0; i < database.length; i++) {									//Vypis celeho pole pro kontrolu ze se vse zaplsalo jak melo
				System.out.println(database[i].GetName() + "  vek: " + database[i].GetAge() + "  uvazek: " + database[i].GetObligation());
				//sc = new Scanner(System.in);
			}	
			System.out.print("Maximalni uvazek: " + Database.GetMaxObligation());
			sc.nextLine();
			break;	

			case 0:
			System.out.print("Konec");
			break;
			default:
				break;
		}
		}
		sc.close();
		
		/*
			for (int i = 0; i < database.length; i++) {
				System.out.println();
				System.out.println(database[i].GetName() + " " + database[i].GetAge());
				//sc = new Scanner(System.in);
			}	
		*/
			
	}
}


