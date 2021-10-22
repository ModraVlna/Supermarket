import java.util.Timer;
import java.util.TimerTask;


public class CasSystemu extends TimerTask {
    int i = 0;
    public void run() {

      // System.out.println("Hello World!");
      //  System.out.println(i++);

    }

    public void printInfo(){

        Timer timer = new Timer();
        timer.schedule(new CasSystemu(), 0, 100);

    }


}
