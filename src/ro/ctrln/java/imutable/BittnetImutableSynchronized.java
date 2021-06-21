package ro.ctrln.java.imutable;

public class BittnetImutableSynchronized {

    private BittnetImutable bittnetImutable;

    public synchronized void setBittnetImutable(BittnetImutable bittnetImutable) {
        this.bittnetImutable = bittnetImutable;
    }

    public synchronized BittnetImutable getBittnetImutable() {
        return bittnetImutable;
    }

    public synchronized void append(String extraName) {
        this.bittnetImutable = this.bittnetImutable.append(extraName);
    }
}
