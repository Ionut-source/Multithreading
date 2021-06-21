package ro.ctrln.java.atomic_variables;

import java.util.concurrent.atomic.AtomicReference;

public class BittnetAtomicReference {

    public static void main(String[] args) {

        AtomicReference <String> atomicReference = new AtomicReference<>("initial");

        String value = atomicReference.get();
        System.out.println("Valoarea initiala este: " + value);

        atomicReference.set("one");
        System.out.println("Valoarea setata este: " + atomicReference.get());

        value = atomicReference.getAndSet("two");
        System.out.println("Valoarea veche de dinaintea apelului getAndSet: " + value);
        System.out.println("Valoarea noua de dupa apelul getAndSet: " + atomicReference.get());

        boolean compareAndSet = atomicReference.compareAndSet("four","three");
        System.out.println("compareAndSet: " + compareAndSet);
        System.out.println("Valoarea de dupa apelul compareAndSet:" + atomicReference.get());

        atomicReference.lazySet("six");
        System.out.println("Valoarea dupa lazySet: " + atomicReference.get());

    }
}
