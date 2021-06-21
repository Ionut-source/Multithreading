package ro.ctrln.java.volatile_variables;

public class VolatilePerformance {

    private volatile int counterOne = 0;
    private volatile int counterTwo = 0;

    private static volatile int numberOfCounts = 0;

    private static long timeForCounterOne;
    private static long tmeForCounterTwo;

    public static void main(String[] args) {

        VolatilePerformance volatilePerformance = new VolatilePerformance();

        new Thread (() -> {
            timeForCounterOne = System.currentTimeMillis();
            while (numberOfCounts < 10) {
                volatilePerformance.counterOne++;
                if (volatilePerformance.counterOne % 100_000_000 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-Am ajuns la 100_000_000 in : " + (System.currentTimeMillis() - timeForCounterOne) + " ms");
                    timeForCounterOne = System.currentTimeMillis();
                    volatilePerformance.counterOne = 0;
                    numberOfCounts++;
                }
            }
        }).start();

        new Thread (() -> {
            tmeForCounterTwo = System.currentTimeMillis();
            while (numberOfCounts < 10) {
                volatilePerformance.counterTwo++;
                if (volatilePerformance.counterTwo % 100_000_000 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-Am ajuns la 100_000_000 in : " + (System.currentTimeMillis() - tmeForCounterTwo) + " ms");
                    tmeForCounterTwo = System.currentTimeMillis();
                    volatilePerformance.counterTwo = 0;
                    numberOfCounts++;
                }
            }
        }).start();
    }
}
