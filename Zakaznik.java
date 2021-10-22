import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
Tato trida slouzi pro vytvoreni zakaznika, ktery ma v kosiku produkty.
Zakaznikovi jsou do kosiku pridavany nahodne produkty.
*/


public class Zakaznik {

    //List, ktery obsahuje produkty zakaznika
    ArrayList<Produkt> kosik =new ArrayList<Produkt>();
   // ArrayList kosik =new ArrayList();
    boolean velkyNakup;



    public Zakaznik(boolean velkyNakup) {

        this.velkyNakup = velkyNakup;



    }

    //prida produkty s carovym kodem a bez caroveho kodu

    public  void pridatPrudukt(){

        int randomNum;

   if(velkyNakup==true){
       randomNum = ThreadLocalRandom.current().nextInt(8, 50);


   } else  {

       randomNum = ThreadLocalRandom.current().nextInt(1, 7);

   }

        for(int i = 0; i <randomNum; i++){

            Random random = new Random();
            int game = random.nextInt(100);

            if (game < 70) {    // 70
                Produkt produkt= new Produkt(true);
                kosik.add(produkt);

            } else {
                Produkt produkt= new Produkt(false);
                kosik.add(produkt);

            }






        }


    }

    //vraci produkty zakaznika
    public ArrayList<Produkt> getKosik() {
        return kosik;
    }


    //vraci pocet produktu
    public Integer getPocetProduktuZakaznika(){

        return kosik.size();
    }




    //vraci celkovy cas potrebny k odbaveni jednoho zakaznika
    public Integer getCelkovyCasNakupu(){

        int dvesukundy = 0;
        int petsekund = 0;

        for(int i = 0; i<kosik.size(); i++) {
            if(kosik.get(i).getCas() == 5) {
                petsekund++;
            } else {
                dvesukundy++;
            }

        }
        return (petsekund*5) + (dvesukundy*4) + 20 ;
    }

    //vraci hodnotu, jestli je nakup velky nebo maly
    public boolean isVelkyNakup() {
        return velkyNakup;
    }

    //vypis informaci pro testovani
    public void printInfo(){
   int dvesukundy = 0;
   int petsekund = 0;
        System.out.println("Pocet produktu: " + kosik.size());

        for(int i = 0; i<kosik.size(); i++) {

            if(kosik.get(i).getCas() == 5) {
                petsekund++;

            } else {

                dvesukundy++;
            }



        }

    System.out.println("S carovym kodem:  " + dvesukundy + "  bez caroveho: " + petsekund);

}

}
