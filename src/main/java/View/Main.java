package View;

import Model.ReadFile;
import Model.StudentModel;
import Model.ThreadProcess;
import Model.ThreadUpdate;

/**
 * Created by Thuan Nguyen on 9/28/2016.
 */

public class Main {

    public static void main(String args[]) throws Exception {
           View view = new View();
         view.SelectMenuMain();
       // StudentModel studentModel = new StudentModel();
      //  studentModel.AddStudentByHand();
        //Thread thread = new Thread();
        /*ReadFile readFile = new ReadFile();
        eadFile.ReadFile_Thread();
*/

    }
}


class TestThread {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String args[]) {

        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
           synchronized ( Lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
           // State.BLOCKED
            synchronized (Lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (Lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}