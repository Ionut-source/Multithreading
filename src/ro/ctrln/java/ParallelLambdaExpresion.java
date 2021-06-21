package ro.ctrln.java;

import ro.ctrln.java.concurrency.model.ListingTaskLambdaExpresion;
import ro.ctrln.java.concurrency.model.Student;
import ro.ctrln.java.concurrency.model.Teacher;
import ro.ctrln.java.utils.PersonRepository;

import java.util.List;

public class ParallelLambdaExpresion {

    public static void main(String[] args) {

        List<Teacher> teachers = PersonRepository.getAllTeachers();
        List<Student> student = PersonRepository.getAllStudents();

        ListingTaskLambdaExpresion<Teacher> teacherListingTask = new ListingTaskLambdaExpresion<>();
        ListingTaskLambdaExpresion<Student> studentListingTask = new ListingTaskLambdaExpresion<>();

        new Thread(() -> {
            teacherListingTask.processEntities(teachers, Thread.currentThread().getName());
        }).start();

        new Thread(() -> {
          studentListingTask.processEntities(student, Thread.currentThread().getName());

        }).start();
    }
}
