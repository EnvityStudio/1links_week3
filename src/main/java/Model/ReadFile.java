package Model;

import Entity.Student;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Thuan Nguyen on 10/3/2016.
 */
public class ReadFile {


    public void ReadFile_Thread() throws IOException {
        File file = new File ("TotalStudent");
        if (file.exists())
        {
            file.delete();
        }
        File folder = new File("C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON");

        File file1 = new File("C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON");
        File [] listFile= file1.listFiles();


        for (int i =0;i<folder.listFiles().length;i++)
        {
            // lấy đường dẫn của file

           String name = listFile[i].getAbsolutePath();
            listFile[i].lastModified();
           ReadFile(name);
        }

    }
    // Kiểm tra xem file đó có trong danh sách chưa nếu chưa có thì thêm mới


    // Ghi ra 1 file tổng khác
    public void WriteFile(Student student) throws IOException{

        FileWriter fw = new FileWriter("TotalStudent",true);
        String str =student.getSchool()+"/"+ student.getId() + "/" +student.getName()+"/" + student.getSex()+"/"
                +student.getAddress()+"/"+student.getMathPoint()+"/"
                +student.getPhysicalPoint()+"/"+student.getChemistryPoint()+"/"+"\n";
        fw.write(str);
        fw.close();
    }
    // đọc file JSON
    public void ReadFile(String name) throws IOException {

        ArrayList<Student> listStudent = new ArrayList<Student>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(name);
        try {
            listStudent = objectMapper.readValue(file, new TypeReference<ArrayList<Student>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (Student st : listStudent) {
            WriteFile(st);
          /* System.out.printf(" %-5s  | %-10s  | %-35s  | %-10s | %-14s  | %-10.2f  | %-10.2f  | %10.2f ",i, st.getId(), st.getName(),
                    st.getSex(), st.getAddress(), st.getMathPoint(),
                    st.getPhysicalPoint(), st.getPhysicalPoint());
            System.out.println();
            i++;
*/

        }
    }
}



