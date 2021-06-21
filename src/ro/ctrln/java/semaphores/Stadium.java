package ro.ctrln.java.semaphores;

import java.util.concurrent.Semaphore;

public class Stadium {

    private Semaphore semaphore;

    public Stadium(int maximumPlaces) {
        semaphore = new Semaphore(maximumPlaces);
    }

    public boolean tryToAcces() {
        return semaphore.tryAcquire();
    }

    public void exitStadium() {
        semaphore.release();
    }

    public int avaiblePlaces() {
        return semaphore.availablePermits();
    }
}
