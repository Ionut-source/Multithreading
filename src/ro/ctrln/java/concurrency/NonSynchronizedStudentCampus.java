package ro.ctrln.java.concurrency;

import ro.ctrln.java.concurrency.model.StudentCampus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NonSynchronizedStudentCampus {

    public static void main(String[] args) throws InterruptedException, IOException {

        StudentCampus studentCampus = new StudentCampus();

        for (int i = 0; i < 9000; i++) {
            studentCampus.addStudent();
        }

       // System.out.println("Studenti in campus (secvential) " + studentCampus.getStudents());
        Files.write(Paths.get("student_campus_secvential.txt" ), studentCampus.getStudents().getBytes());

        StudentCampus concurentStudentCampus = new StudentCampus();
        Thread threadOne = new Thread(getTask(concurentStudentCampus, "Task1", 0,3000));
        Thread threadTwo = new Thread(getTask(concurentStudentCampus, "Task2",3000,6000));
        Thread threadThree = new Thread(getTask(concurentStudentCampus, "Task3", 6000,9000));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        Thread.sleep(2000);
       // System.out.println("Studenti in campus (concurent) " + concurentStudentCampus.getStudents());
        Files.write(Paths.get("student_campus_concurent.txt" ), concurentStudentCampus.getStudents().getBytes());
    }

    private static Runnable getTask(StudentCampus concurentStudentCampus, String task, int start, int stop) {
        return () -> {
            for (int i = start; i < stop; i++) {
                concurentStudentCampus.addStudentIntrinsicLock();
                System.out.println("Studentul adaugat este: Student" + i + " - Task: " + task);

            }
        };
    }
}
