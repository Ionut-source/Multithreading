package ro.ctrln.java.volatile_variables;

import ro.ctrln.java.imutable.BittnetImutableInteger;

public class BittnetVolatileImutable {

    private BittnetImutableInteger counterOne = new BittnetImutableInteger(0);
    private BittnetImutableInteger counterTwo = new BittnetImutableInteger(0);

    public synchronized void incrementCounters() {
        counterOne = counterOne.increment();
        counterTwo = counterTwo.increment();
    }

    public synchronized void showCounters() {
        System.out.println("counterOne: " + counterOne.getValue() + "; counterTwo: " + counterTwo.getValue());
    }

    public static void main(String[] args) {

        BittnetVolatileImutable bittnetVolatile = new BittnetVolatileImutable();

        Thread threadOne = new Thread(getTask(bittnetVolatile));
        Thread threadTwo = new Thread(getTask(bittnetVolatile));

        threadOne.start();
        threadTwo.start();
    }

    private static Runnable getTask(BittnetVolatileImutable bittnetVolatile) {
        return () -> {
            for (int i = 0; i < 100000; i++) {
                bittnetVolatile.incrementCounters();
                bittnetVolatile.showCounters();
            }
        };
    }
}
