package Model;

import Entity.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thuan Nguyen on 10/7/2016.
 */
public class ThreadProcess extends  Thread {

    ArrayList<Student> listStudent = new ArrayList<Student>();

    public void run() {
        File folder = new File("C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON");
        for(int i=0;i<folder.listFiles().length;i++)
        {

        }
    }


}
