package ro.ctrln.java.atomic_variables;

import java.util.concurrent.atomic.AtomicLong;

public class BittnetAtomicLong {

    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong(10);

        long value = atomicLong.get();
        System.out.println("Valoarea initiala este: " + value);

        atomicLong.set(1);
        System.out.println("Valoarea setata este: " + atomicLong.get());

        value = atomicLong.getAndSet(2);
        System.out.println("Valoarea veche de dinaintea apelului getAndSet: " + value);
        System.out.println("Valoarea noua de dupa apelul getAndSet: " + atomicLong.get());

        boolean compareAndSet = atomicLong.compareAndSet(2,3);
        System.out.println("compareAndSet: " + compareAndSet);
        System.out.println("Valoarea de dupa apelul compareAndSet:" + atomicLong.get());


    }
}
