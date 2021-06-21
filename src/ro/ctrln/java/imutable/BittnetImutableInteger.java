package ro.ctrln.java.imutable;

public class BittnetImutableInteger {

    private int value;

    public BittnetImutableInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BittnetImutableInteger increment() {
        return new BittnetImutableInteger(this.value + 1);
    }
}
