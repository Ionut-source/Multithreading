package ro.ctrln.java.priority;

public class PriorityThreadUsage {

    public static void main(String[] args) {

        PriorityThread threadOne  = new PriorityThread();
        threadOne.setPriorityThreadName("threadOne");
        PriorityThread threadTwo = new PriorityThread();
        threadTwo.setPriorityThreadName("threadTwo");
        PriorityThread threadThree = new PriorityThread();
        threadThree.setPriorityThreadName("threadThree");

        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadTwo.setPriority(Thread.MIN_PRIORITY);
        threadThree.setPriority(Thread.NORM_PRIORITY);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
