package Model;

import Entity.Student;

import java.io.File;

/**
 * Created by Thuan Nguyen on 10/13/2016.
 */
public class ThreadUpdate extends Thread {
    private Thread T;

    public void run() {


        while (true) {
            CheckFile checkFile = new CheckFile();
            int lengthFile = checkFile.CheckFile();
            long status = checkFile.CheckLastModify();
            try {


                T.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StudentModel studentModel = new StudentModel();
            try {

                if((status!=checkFile.CheckLastModify()|| lengthFile!=checkFile.CheckFile()))
                {
                    studentModel.ListStudent();
                    System.out.println("updated");
                }
            } catch (Exception e) {
                e.printStackTrace();

            }

        }


    }
}

