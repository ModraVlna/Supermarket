import java.util.Timer;

/*
Tato trida slouzi pro vytvareni produktu.
Produkt ma atributy carovyKod a cas.
Pokud obsahuje carovy kod, tak cas k zpracovani
produktu jsou dve sekundy, v druhem pripade to je pet sekund
*/

public class Produkt {

    boolean carovyKod;
    Integer cas;


    public Produkt(boolean carovyKod) {
        this.carovyKod = carovyKod;

      //Urci cas podle toho, jestli produkt ma carovy kod
      if (carovyKod == true){
        this.cas = 2; }

        else  {

          this.cas = 5;
      }
    }

    //vraci cas produktu
    public Integer getCas() {
        return cas;
    }
}
