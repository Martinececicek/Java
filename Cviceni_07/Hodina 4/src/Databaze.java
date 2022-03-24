import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	


	public void setStudent(String name, int year)
	{
		prvkyDatabaze[posledniStudent++]=new Student(name,year);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer)
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	public void printDatabase(){
		try {
				for (Student studentik : prvkyDatabaze) {
					System.out.println("Jmeno: " + studentik.getJmeno() + " , rok narozeni: " + studentik.getRocnik() + " , studijni prumer: " + studentik.getStudijniPrumer()); 		
			}
	 	} catch (NullPointerException e) {
				System.out.println(e);
		}
	}
	

	public void printToFile(String soubor)throws Exception
	{
		//File fout = new File(soubor);
			FileWriter writer = new FileWriter(soubor);
			for (int i = 0; i < prvkyDatabaze.length; i++) {
				writer.write("Jmeno: " + prvkyDatabaze[i].getJmeno() + " , rok narozeni: " + prvkyDatabaze[i].getRocnik() + " , studijni prumer: " + prvkyDatabaze[i].getStudijniPrumer() + "\n");
			}
			writer.close();
	}

	public void loadFromFile(String soubor, Databaze mojeDatabaze)throws Exception
	{
		//Jmeno: Martin , rok narozeni: 2000 , studijni prumer: 1.0
			Scanner load = new Scanner(new FileReader(soubor));
			//List<String> commWords = new ArrayList<String>();
			int lines = 0;
			int i = 0;
			String pomocna = "";
			
			while (load.hasNextLine()) {
				lines++;
				pomocna = load.nextLine();
				//System.out.println(lines);
			}

			load.close();
			Scanner load_2 = new Scanner(new FileReader(soubor));
			prvkyDatabaze= new Student[lines];
			while (load_2.hasNextLine()) {
			String radek = load_2.nextLine();
			String wordiky[] = radek.split(" ");
			
			mojeDatabaze.setStudent(wordiky[1], Integer.parseInt(wordiky[5]));
			mojeDatabaze.setPrumer(i, Float.parseFloat(wordiky[9]));
			i++;
			}
			load_2.close();
	}

            
            
            

			
			
	

	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}