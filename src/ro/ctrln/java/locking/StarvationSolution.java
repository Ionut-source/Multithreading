package ro.ctrln.java.locking;

public class StarvationSolution {

    public synchronized void starve() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " scrie pe consola!");
        while (true) {
            try{
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            System.out.println(threadName + " lucreaza de zor!");
        }
    }
}
