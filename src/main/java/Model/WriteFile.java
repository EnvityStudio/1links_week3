package Model;

import Entity.Student;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thuan Nguyen on 10/3/2016.
 */
public class WriteFile {

    public void WriteFile1(ArrayList<Student> listStudent) throws IOException{


        FileWriter fw = new FileWriter("TotalStudent");
        for (int i =0;i<listStudent.size();i++)
        {
            Student student = listStudent.get(i);
            String str = student.getId() + "/" + student.getName()+ "/" + student.getSex() + "/" + student.getAddress() + "/"
                    + student.getMathPoint() + "/" + student.getPhysicalPoint() + "/" + student.getChemistryPoint() + "/";
            fw.write(str);
        }
        fw.close();
    }
}


