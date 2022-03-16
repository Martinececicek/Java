import javax.tools.Tool;

public class Test {
    public static void main(String[] args) throws Exception {
       
        Goods[] goods = new Goods[6]; // Array zboží

        goods[0] = new Food("Rohlík",1.5, 1); // Deklarace hodnot arraye
        goods[1] = new Tools("Kleště",278,24);
        goods[2] = new Food("Chleba",20.8,6);
        goods[3] = new Food("Jablko",51,20);
        goods[4] = new Food("Merunka",51,-20);
        goods[5] = new Tools("Lopata", 100, -9);

        
        
        for(int i = 0; goods.length > i ;i++ ) // For který běží od 0 po velikost Arraye zboží - Future proofing pokud se změní velikost zboží
        {
            System.out.print(goods[i].getName() + ", price " + goods[i].getPrice()); // První print který najde jméno a cenu ítého zboží

            if(goods[i] instanceof Food ) // Jednoduché if else - které zjistí jestli array zboží má instanci Potravina pokud ano zapiš expiraci pokud má instanci Nářadí zapis záruku - mimo zadání ale chtěl jsem to udělat
            {
                Food expiration = (Food) goods[i];
                System.out.println(", Expiration: " + expiration.getExpiration_date() + " " + expiration.getJednotka());
            }
            else
            {
                Tools warranty = (Tools) goods[i];
                System.out.println(", Waranty " + warranty.getWarranty() + " " + warranty.getJednotka());
            }
        }
    }

}
