package ro.ctrln.java.concurrency.model;

// read-modify-write
public class StudentCampus {

    private String students = "";
    private long studentId = 0;

    public synchronized long addStudent() {
        // AICI ESTE UN PCT CRITIC
        students +=("Student" + studentId);
        studentId++;
        return studentId;
    }

    public synchronized String getStudents() {
        // AICI ESTE UN PCT CRITIC
        return students;
    }

    public long addStudentIntrinsicLock() {
        synchronized (this) {  //INTRINSIC LOCK
            students +=("Student" + studentId);
            studentId++;
            return studentId;
        }
    }
}
