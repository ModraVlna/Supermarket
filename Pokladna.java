import java.util.*;

/*
Tato trida generuje zakazniky, ktere pridava do listu.
Zakaznik je generovan podle velikosti nakupu a podle aktualniho casu
*/

public class Pokladna  {


    //list zakazniku
    ArrayList<Zakaznik> zakaznici = new ArrayList<Zakaznik>();

    ArrayList<ArrayList<Zakaznik>> pokladna = new ArrayList<ArrayList<Zakaznik>>();


    int casPokladny0 = 0;
    int casPokladny1 = 0;
    int casPokladny2 = 0;
    int casPokladny3 = 0;
    int casPokladny4 = 0;
    int casPokladny5 = 0;
    int casPokladny6 = 0;
    int casPokladny7 = 0;
    int casPokladny8 = 0;
    int casPokladny9 = 0;




    public Pokladna() {

        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
    /*    pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());
        pokladna.add(new ArrayList<Zakaznik>());*/
        generujZakaznikaPodleCasu(6);

       // vratCelkovyNakupZakaznika();

    }



    public void vratCelkovyNakupZakaznika(){
        int suma = 0;

        for(int i=0; i<zakaznici.size() ;i++){
            suma = suma + zakaznici.get(i).getCelkovyCasNakupu();
        }

        System.out.println("Celkovy cas, ktery je skutecny: " + suma);
    }




    //zatim docasne, potom to prevezme z Tridy cas
    public int vratAktualniCas() {
        int cas = 2;
        return cas;
    }




    //Generuje zakaznika s velkym nebo malym nakupem podle pravdepodobnosti z tabulky
    public void generujZakaznikaPodleNakupu(int pocetZakazniku, int pravdepodobnostVelkehoNakupu) {

        for(int i = 0; i <pocetZakazniku; i++) {


            Random random = new Random();
            int game = random.nextInt(100);


            if (game < pravdepodobnostVelkehoNakupu) {
                Zakaznik novyZakaznik = new Zakaznik(true);
                novyZakaznik.pridatPrudukt();
                zakaznici.add(novyZakaznik);



            } else {
                Zakaznik novyZakaznik = new Zakaznik(false);
                novyZakaznik.pridatPrudukt();
                zakaznici.add(novyZakaznik);

            }

        }

    }

    //Tato metoda generuje zakaznika podle casu
    //Pro generovani je pouzita metoda generujZakaznikaPodleNakupu
    public void generujZakaznikaPodleCasu(int cas) {

        switch (cas) {
            case 6:
                generujZakaznikaPodleNakupu(445, 27);
                break;
            case 8:
                generujZakaznikaPodleNakupu(300, 30);
                break;
            case 10:
                generujZakaznikaPodleNakupu(175, 34);
                break;
            case 12:
                generujZakaznikaPodleNakupu(335, 31);
                break;
            case 14:
                generujZakaznikaPodleNakupu(725, 59);
                break;
            case 16:
                generujZakaznikaPodleNakupu(930, 73);
                break;
            case 18:
                generujZakaznikaPodleNakupu(760, 62);
                break;
            case 20:
                generujZakaznikaPodleNakupu(350, 26);
                break;
        }

    }



    //vrati pocet zakazniku
    public int getPocetZakazniku(int cas){
        generujZakaznikaPodleCasu(cas);
        return zakaznici.size();
    }

    //vypis informaci pro testovani
    public void printInfo() {
        int malyNakup = 0;
        int velkyNakup = 0;
        System.out.println("Pocet zakazniku: " + getPocetZakazniku(10));
        for (int i=1; i<445;i++){
            if (zakaznici.get(i).isVelkyNakup() == true){
                velkyNakup++;
            } else {
                malyNakup++;
            }

          // System.out.println(zakaznici.get(i).isVelkyNakup());
        }
        System.out.println("Pocet maleho nakupu:" + malyNakup);
        System.out.println("Pocet velkho nakupu:" + velkyNakup);

    }


    //Pridava zakazniky do pokladny a odstrani ze seznamu zakazniku (ne z pokladny)
    public void zpracovaniZakazniku(){

        if(zakaznici.size()>0){
            pokladna.get(vratNejmensiRadu()).add(zakaznici.get(0));
            zakaznici.remove(0);
        }

    }


    //prida zakaznika do nejmensi rady u pokladny
    public int vratNejmensiRadu(){
        int pocetRada = 0;
        int minRada = 1000;
        int aktualniRada = 0;

        for(int i=0;i<pokladna.size();i++){
            aktualniRada = pokladna.get(i).size(); //pocet zakazniku
            if (minRada > aktualniRada){
                minRada = aktualniRada;
                pocetRada = i; //index pokladny s nejmensi radou
            }
        }
        return pocetRada;
    }


    //prida pokladnu
    public void vytvoritPokladnu(){

        if (pocetZakaznikuNaPokladne() == true && pokladna.size()<10){
            pokladna.add(new ArrayList<Zakaznik>()); //jedna pokladna
        }
    }

    //zjisti nejmensi pocet zakazniku na pokladne
    public boolean pocetZakaznikuNaPokladne(){

        int min = 1000;
        int aktualni = 0;

        for(int i=0;i<pokladna.size();i++){
            aktualni = pokladna.get(i).size(); //pocet zakazniku
            if (min > aktualni){
                min = aktualni;

            }
        }

        return min>=4; //pokud true, tak otevre novou
    }



    //odstrani pokladnu
    public void odstranitPokladnu(int cislo) {

        if(pokladna.isEmpty() == true){
            pokladna.remove(cislo);
        }

    }

    public int indexPrazdnePokladny(){
        for(int i=0; i<pokladna.size();i++){
            if(pokladna.get(i).isEmpty()){
                return i;
            }
        }
        return -1;
    }


    public void printPokladny(){

        System.out.println("Pocet pokladen: " + pokladna.size());
        System.out.println(" ");

        for(int i=0; i<pokladna.size();i++){
            System.out.println("Pocet zakazniku ve fronte pro " + i + ". pokladnu " + pokladna.get(i).size());
        }

        System.out.println("Celkovy cas vsech pokladen  " + (casPokladny0+casPokladny1+casPokladny2+casPokladny3+casPokladny4+casPokladny5+casPokladny6+casPokladny7+casPokladny8+casPokladny9));


    }


    public void initTasks() {
        MyTimerTaskZakaznik taskZakaznik = new MyTimerTaskZakaznik();
        MyTimerTask0 task0 = new MyTimerTask0();
        MyTimerTask1 task1 = new MyTimerTask1();
        MyTimerTask2 task2 = new MyTimerTask2();
        MyTimerTask3 task3 = new MyTimerTask3();
        MyTimerTask4 task4 = new MyTimerTask4();
        MyTimerTask5 task5 = new MyTimerTask5();
        MyTimerTask6 task6 = new MyTimerTask6();
        MyTimerTask7 task7 = new MyTimerTask7();
        MyTimerTask8 task8 = new MyTimerTask8();
        MyTimerTask9 task9 = new MyTimerTask9();

        taskZakaznik.start();
        task0.start();
        task1.start();
        task2.start();
        task3.start();
        task4.start();
        task5.start();
        task6.start();
        task7.start();
        task8.start();
        task9.start();




    }


    public Integer vratNakupCas(int i){
            if (pokladna.size() >= i +1) {
                if (!pokladna.get(i).isEmpty()) {
                    return pokladna.get(i).get(0).getCelkovyCasNakupu();
                } else {
                    return 1000;
                }
            } else {
                return 1000;
            }

    }

    class MyTimerTaskZakaznik extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {
        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {

                    vytvoritPokladnu();
                    zpracovaniZakazniku();
                    // dobaOtevrenePokladny(); TODO: Chybi tam cas
                    printPokladny();

               /*     if(zakaznici.isEmpty()) {
                      timer.cancel();

                    }*/

                }
            }, 0, 7200/zakaznici.size());
        }
    }

    class MyTimerTask0 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                   if(pokladna.size()>=1){
                    if(!pokladna.get(0).isEmpty()){
                    if (i==1) {

                            casPokladny0 = casPokladny0 + ((pokladna.get(0).get(0).getCelkovyCasNakupu()) * (pokladna.get(0).size()-1));
                            pokladna.get(0).remove(0);
                            MyTimerTask0 task0 = new MyTimerTask0();
                            task0.start();
                            task0.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(0));
        }
    }


    class MyTimerTask1 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=2){
                    if(!pokladna.get(1).isEmpty()){
                    if (i==1) {

                        casPokladny1 = casPokladny1 + ((pokladna.get(1).get(0).getCelkovyCasNakupu()) * (pokladna.get(1).size()-1));

                            pokladna.get(1).remove(0);
                            printPokladny();
                            MyTimerTask1 task1 = new MyTimerTask1();
                            task1.start();
                            task1.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(1));
        }
    }


    class MyTimerTask2 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=3){
                    if(!pokladna.get(2).isEmpty()){
                    if (i==1) {

                        casPokladny2 = casPokladny2 + ((pokladna.get(2).get(0).getCelkovyCasNakupu()) * (pokladna.get(2).size()-1));

                            pokladna.get(2).remove(0);
                            printPokladny();
                            MyTimerTask2 task2 = new MyTimerTask2();
                            task2.start();
                            task2.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } }}
                }
            }, 0, vratNakupCas(2));
        }
    }


    class MyTimerTask3 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=4){
                    if(!pokladna.get(3).isEmpty()){
                    if (i==1) {

                        casPokladny3 = casPokladny3 + ((pokladna.get(3).get(0).getCelkovyCasNakupu()) * (pokladna.get(3).size()-1));

                            pokladna.get(3).remove(0);
                            printPokladny();
                            MyTimerTask3 task3 = new MyTimerTask3();
                            task3.start();
                            task3.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(3));
        }
    }


    class MyTimerTask4 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }
        public void start() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {

                    if(pokladna.size()>=5){
                    if(!pokladna.get(4).isEmpty()){
                    if (i==1) {

                        casPokladny4 = casPokladny4 + ((pokladna.get(4).get(0).getCelkovyCasNakupu()) * (pokladna.get(4).size()-1));

                            pokladna.get(4).remove(0);
                            MyTimerTask4 task4 = new MyTimerTask4();
                            task4.start();
                            task4.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(4));
        }
    }


    class MyTimerTask5 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=6){
                    if(!pokladna.get(5).isEmpty()){
                    if (i==1) {

                        casPokladny5 = casPokladny5 + ((pokladna.get(5).get(0).getCelkovyCasNakupu()) * (pokladna.get(5).size()-1));

                            pokladna.get(5).remove(0);
                            printPokladny();
                            MyTimerTask5 task5 = new MyTimerTask5();
                            task5.start();
                            task5.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(5));
        }
    }


    class MyTimerTask6 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=7){
                    if(!pokladna.get(6).isEmpty()){
                    if (i==1) {

                        casPokladny6 = casPokladny6 + ((pokladna.get(6).get(0).getCelkovyCasNakupu()) * (pokladna.get(6).size()-1));

                            pokladna.get(6).remove(0);
                            printPokladny();
                            MyTimerTask6 task6 = new MyTimerTask6();
                            task6.start();
                            task6.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(6));
        }
    }


    class MyTimerTask7 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=9){
                    if(pokladna.size()>=8){
                    if(!pokladna.get(7).isEmpty()){
                    if (i==1) {

                        casPokladny7 = casPokladny7 + ((pokladna.get(7).get(0).getCelkovyCasNakupu()) * (pokladna.get(7).size()-1));
                            pokladna.get(7).remove(0);
                            printPokladny();
                            MyTimerTask7 task7 = new MyTimerTask7();
                            task7.start();
                            task7.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    }} }
                } }
            }, 0, vratNakupCas(7));
        }
    }


    class MyTimerTask8 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {

                    if(pokladna.size()>=9){
                    if(!pokladna.get(8).isEmpty()){
                    if (i==1) {

                        casPokladny8 = casPokladny8 + ((pokladna.get(8).get(0).getCelkovyCasNakupu()) * (pokladna.get(8).size()-1));

                            pokladna.get(8).remove(0);
                            printPokladny();
                            MyTimerTask8 task8 = new MyTimerTask8();
                            task8.start();
                            task8.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(8));
        }
    }

    class MyTimerTask9 extends TimerTask {
        int i =0;
        private NovyCas timer;

        public void run() {

        }

        public void start() {

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    if(pokladna.size()>=10){
                    if(!pokladna.get(9).isEmpty()){
                    if (i==1) {

                        casPokladny9 = casPokladny9 + ((pokladna.get(9).get(0).getCelkovyCasNakupu()) * (pokladna.get(9).size()-1));

                            pokladna.get(9).remove(0);
                            printPokladny();
                            MyTimerTask9 task9 = new MyTimerTask9();
                            task9.start();
                            task9.cancel();
                            timer.cancel();

                    }
                    else {
                        i++;
                    } } }
                }
            }, 0, vratNakupCas(9));
        }
    }



}





