package ro.ctrln.java.volatile_variables;

public class BittnetVolatile {

    private volatile int counterOne = 0;
    private volatile int counterTwo = 0;

    public synchronized void incrementCounters() {
        counterOne++;
        counterTwo++;
    }

    public synchronized void showCounters() {
        System.out.println("counterOne: " + counterOne + "; counterTwo: " + counterOne);
    }

    public static void main(String[] args) {

        BittnetVolatile bittnetVolatile = new BittnetVolatile();

        Thread threadOne = new Thread(getTask(bittnetVolatile));
        Thread threadTwo = new Thread(getTask(bittnetVolatile));

        threadOne.start();
        threadTwo.start();
    }

    private static Runnable getTask(BittnetVolatile bittnetVolatile) {
        return () -> {
            for (int i = 0; i < 1000000; i++) {
                bittnetVolatile.incrementCounters();
                bittnetVolatile.showCounters();
            }
        };
    }
}
