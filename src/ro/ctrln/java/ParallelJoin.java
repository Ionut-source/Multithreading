package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.ListingTaskWithSleepTime;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.Date;
import java.util.List;

public class ParallelJoin {

    public static void main(String[] args) {

        System.out.println("Threadul principal a inceput " + new Date());

        List<Teacher> teachers = PersonRepository.getAllTeachers();

        Thread threadOne = new Thread(new ListingTaskWithSleepTime<>("Teacher-Task-1", teachers, 1000));
        Thread threadTwo = new Thread(new ListingTaskWithSleepTime<>("Teacher-Task-2", teachers, 2000));
        Thread threadThree = new Thread(new ListingTaskWithSleepTime<>("Teacher-Task-3", teachers, 3000));

        threadOne.start();
        joinThread(threadOne);
        threadTwo.start();
        joinThread(threadTwo);
        threadThree.start();
        joinThread(threadThree);

        System.out.println("Threadul principal s-a incheiat la: " + new Date());
    }

    private static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
