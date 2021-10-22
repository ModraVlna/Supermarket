import java.util.Timer;
import java.util.TimerTask;

public class NovyCas {
    public void initTasks() {
        MyTimerTask1 task1 = new MyTimerTask1();
        MyTimerTask2 task2 = new MyTimerTask2();
        MyTimerTask3 task3 = new MyTimerTask3();
        task1.start();
        task2.start();
        task3.start();
    }

    class MyTimerTask1 extends TimerTask {
        private NovyCas timer;

        public void run() {
            System.out.println("Hello Time 1");
        }

        public void start() {
            Timer timer = new Timer();
            timer.schedule(new MyTimerTask1(), 0, 1000);
        }
    }

    class MyTimerTask2 extends TimerTask {
        private NovyCas timer;

        public void run() {
            System.out.println("Hello Time 2");
        }

        public void start() {
            Timer timer = new Timer();
            timer.schedule(new MyTimerTask2(), 0, 2000);
        }
    }

    class MyTimerTask3 extends TimerTask {
        private NovyCas timer;

        public void run() {
            System.out.println("Hello Time 3");
        }

        public void start() {
            Timer timer = new Timer();
            timer.schedule(new MyTimerTask3(), 0, 3000);
        }
    }
}
