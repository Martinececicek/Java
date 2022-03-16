import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
		
		while (choice!=0) {
		    System.out.println();
		    System.out.println("MENU");
		    System.out.println("1: BPC1");
		    System.out.println("2: BPC2");
		    System.out.println("3: BPIS");
            System.out.println("4: Vypsat vsechny predmety");
		    System.out.println("0: Konec programu");
		    System.out.print("Vas vyber: ");
		        if (sc.hasNextInt()) {
			        choice = sc.nextInt();	
		        }else{
                    System.out.println("Nebylo zadano cislo");
                }

            switch (choice) {
                case 1:
                    Predmet predmitek_1 = new BPC1(); //navazujeme spojeni s objektem
                    System.out.println("\n" + predmitek_1.getName()); // zavolání ukázání jména skrz Předmět do BPC1.Java


                    System.out.print("Zadejte body za aktivitu na cvičení: ");
                    BPC1.setAktivita(sc.nextInt());

                    System.out.print("Zadejte body za zkoušku: ");
                    BPC1.setZkouska(sc.nextInt());

                    break;
            
                case 2:
                    Predmet predmitek_2 = new BPC2();
                    System.out.println("\n" + predmitek_2.getName());


                    System.out.print("Zadejte body za Projekt: ");
                    BPC2.setProjekt(sc.nextInt());

                    System.out.print("Zadejte body za Půlsemestrální zkoušku: ");
                    BPC2.setPulSemZkouska(sc.nextInt());

                    System.out.print("Zadejte body za zkoušku: ");
                    BPC2.setZaverZkouska(sc.nextInt());
                
                break;

                case 3:
                    Predmet predmitek_3 = new BPIS();
                    System.out.println("\n" + predmitek_3.getName());
   
                    System.out.print("Udělit zápočet? (Zadat 'Ano' / 'Ne'): ");
                    BPIS.setZapocet(sc.nextLine()); 
                    System.out.println(predmitek_3.getPass());
                    break;
                case 4:
                    Predmet vypisPredmitek_1 = new BPC1();
                    System.out.println();
                    System.out.println(vypisPredmitek_1.getName());
                    System.out.println("Dosazene body: " + vypisPredmitek_1.getPoints() + " ==> " + vypisPredmitek_1.getPass());
                    System.out.println();
                    Predmet vypisPredmitek_2 = new BPC2();
                    System.out.println(vypisPredmitek_2.getName());
                    System.out.println("Dosazene body: " + vypisPredmitek_2.getPoints() + " ==> " + vypisPredmitek_2.getPass());
                    System.out.println();
                    Predmet vypisPredmitek_3 = new BPIS();
                    System.out.println(vypisPredmitek_3.getName());
                    System.out.println("Dosazene body: " + vypisPredmitek_3.getPoints() + " ==> " + vypisPredmitek_3.getPass());
                default:
                    break;
            }
                
        }
    }
}
