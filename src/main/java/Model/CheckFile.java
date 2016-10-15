package Model;

import java.io.File;

/**
 * Created by Thuan Nguyen on 10/13/2016.
 */
public class CheckFile {
    public long CheckLastModify()
    {


        File file1 = new File("C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON");
        File [] listFile= file1.listFiles();
        long name = listFile[0].lastModified();
        return name;
    }

    public int CheckFile()
    {
        File file1 = new File("C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON");
        int a = file1.listFiles().length;
        return a;
    }

}
