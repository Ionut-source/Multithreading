package ro.ctrln.java.volatile_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class BittnetVolatileAtomicInteger {

    private final AtomicInteger counterOne = new AtomicInteger(0);
    private final AtomicInteger counterTwo = new AtomicInteger(0);
    private final AtomicInteger counterThree = new AtomicInteger(0);

    public synchronized void incrementCounters() {
        counterOne.set(counterOne.get()+1);
        counterTwo.set(counterTwo.get()+1);
        counterThree.set(counterThree.get()+1);
    }

    public synchronized void showCounters() {
        System.out.println("counterOne: " + counterOne + "; counterTwo: " + counterOne + "; counterThree: " + counterThree);
    }

    public static void main(String[] args) {

        BittnetVolatileAtomicInteger bittnetVolatile = new BittnetVolatileAtomicInteger();

        Thread threadOne = new Thread(getTask(bittnetVolatile));
        Thread threadTwo = new Thread(getTask(bittnetVolatile));
        Thread threadThree = new Thread(getTask(bittnetVolatile));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

    private static Runnable getTask(BittnetVolatileAtomicInteger bittnetVolatile) {
        return () -> {
            for (int i = 0; i < 100000; i++) {
                bittnetVolatile.incrementCounters();
                bittnetVolatile.showCounters();
            }
        };
    }
}
