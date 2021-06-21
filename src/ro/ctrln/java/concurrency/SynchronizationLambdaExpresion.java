package ro.ctrln.java.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class SynchronizationLambdaExpresion {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>(Arrays.asList("One", "Two", "Three"));

        Thread threadOne = new Thread(() -> {
            strings.stream().filter(stringPredicate()).forEach(System.out::println);
        });

        Thread threadTwo = new Thread(() -> {
            strings.stream().filter(stringPredicate()).forEach(System.out::println);
        });

        threadOne.start();
        threadTwo.start();

    }

    public static Predicate<String> stringPredicate() {
        return (string) -> {
            synchronized (SynchronizationLambdaExpresion.class) {
                return string.length() > 3 || string.equalsIgnoreCase("One");
            }
        } ;
    }
}
