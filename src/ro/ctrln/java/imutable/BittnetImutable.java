package ro.ctrln.java.imutable;

public class BittnetImutable {

    private String name;

    public BittnetImutable(String nama) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BittnetImutable append(String extraName) {
        return new BittnetImutable(this.name.concat(extraName));
    }
}
