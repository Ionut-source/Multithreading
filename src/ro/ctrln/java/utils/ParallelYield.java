package ro.ctrln.java.utils;

import ro.ctrln.java.concurrency.model.ListingTaskWithYield;
import ro.ctrln.java.concurrency.model.Teacher;

import java.util.List;

public class ParallelYield {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        ListingTaskWithYield<Teacher> listingTaskWithYield = new ListingTaskWithYield<>("TeacherTask", teachers);

        Thread threadOne = new Thread(listingTaskWithYield);
        Thread threadTwo = new Thread(listingTaskWithYield);


        threadOne.start();
        threadTwo.start();
    }
}
