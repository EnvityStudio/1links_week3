

package Model;
import Entity.Student;
import javafx.geometry.Point3D;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.util.*;
import java.lang.String;

/**
 * Created by Thuan Nguyen on 9/27/2016.
 */
public class StudentModel {
   // Student student = new Student();

    public double CheckPoint() throws Exception {
        Scanner input = new Scanner(System.in);
        double n = 0;
        boolean checkInput = true;
        do {
            try {
                n = input.nextDouble();
                checkInput = false;
                if (n < 0 || n > 10) {
                    checkInput = true;
                    System.out.println("Nhập lại");

                }

            } catch (InputMismatchException ex) {
                System.out.printf("Nhập lại");
                input.nextDouble();
            }
        } while (checkInput);
        return n;
    }
    public String CheckID()
    {
        Scanner input = new Scanner(System.in);
        String id = "";
        ArrayList<Student> listStudent = new ArrayList<Student>();
        boolean checkInput = true;
        do
        { try {
            id = input.nextLine();
            checkInput = false;;
            for (Student st:listStudent)
            {
                if (id != st.getId())
                {
                    checkInput = true;
                    System.out.println("Bạn đã nhập trùng mã sinh viên--> nhập lại");
                }
            }

        }catch (InputMismatchException ex)
        {
            System.out.println("Bạn đã nhập trùng mã sinh viên-->Nhập lại");
            input.nextLine();
        }

        }while(checkInput);
        return id;
    }

    public int AddNumberStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số sinh viên cần thêm: ");
        int n = 0;
        boolean checkInput = true;
        do
        {
            try {
                n = input.nextInt();
                checkInput = false;
                if (n<0)
                {
                    checkInput =true;
                    System.out.println("Nhập lại");
                }
            }
            catch(InputMismatchException ex)
            {
                System.out.println(" Nhập lại");
                input.nextLine();
            }
        }while (checkInput);
        return n;
    }

    public void AddStudentByHand() throws Exception {
        Scanner input1 = new Scanner(System.in);
        String name, address, sex, ID, school;
        System.out.println("Nhập tên trường");
        school = input1.nextLine();

        String fileName="C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON\\" + school.toLowerCase() + ".json";
        ArrayList<Student> listStudent = ListStudent_JSon(fileName);

            int n = AddNumberStudent();
            double mathPoint, physicalPoint, chemistryPoint;
            for (int i = 0; i < n; i++) {
                Scanner input = new Scanner(System.in);
                System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");
                System.out.print("Nhập mã sinh viên: ");
                ID = CheckID();
                System.out.print("Nhập tên: ");
                name = input.nextLine();
                System.out.print("Nhập giới tính: ");
                sex = input.nextLine();
                System.out.print("Nhập địa chỉ: ");
                address = input.nextLine();

                System.out.print("Điểm toán: ");
                mathPoint = CheckPoint();
                System.out.print("Điểm lý: ");
                physicalPoint = CheckPoint();
                System.out.print("Điểm hóa: ");
                chemistryPoint = CheckPoint();
                Student student = new Student(school.toLowerCase(), ID, Standardized(name), sex, Standardized(address), mathPoint, physicalPoint, chemistryPoint);
                listStudent.add(student);

            }

        File file = new File(fileName);
        ObjectMapper objectMapper =  new ObjectMapper();
         objectMapper.writeValue(file, listStudent);

        }
    public ArrayList<Student> ListStudent_JSon(String name) throws IOException {
        ArrayList<Student> listStudent = new ArrayList<Student>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(name);
        if(file.exists()) {
            listStudent = objectMapper.readValue(file, new TypeReference<ArrayList<Student>>() {
            });
        }
        else   {
            File file1 = new File(name);
            ObjectMapper objectMapper1 =  new ObjectMapper();
            objectMapper1.writeValue(file1, listStudent);

        }
        return listStudent;
    }

   public ArrayList<Student> ListStudent () throws Exception
    {
        ArrayList<Student> input = new ArrayList<Student>();
        ReadFile readFile = new ReadFile();
        readFile.ReadFile_Thread();
        FileInputStream fin = new FileInputStream("TotalStudent");
        BufferedReader in = new BufferedReader(new InputStreamReader(fin));
        String str = " ";
        while((str = in.readLine())!=null)
        {
            String [] st = str.split("/");
            Student student = new Student(st[0],st[1],st[2],st[3],st[4],Double.parseDouble(st[5]),
                    Double.parseDouble(st[6]),Double.parseDouble(st[7]));
            input.add(student);
        }
        in.close();
        return input;
    }
    public String Standardized(String str) {
        str = str.trim();
        str = str.replace("\\s+", " ");
        String temp[] = str.split(" ");
        str = "";
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                str += " ";
        }
        return str;
    }

    public boolean CompareStudent(Student st1, Student st2)
    {

        if((st1.getId().equals(st2.getId())==true)&&(st1.getName().equals(st2.getName())==true) &&( st1.getAddress().equals(st2.getAddress())==true) && (st1.getSex().equals(st2.getSex()) == true))
            return true;
       else return false;
    }
    public void CompareStudent(int index) throws Exception {
        Student student = ListStudent().get(index-1);
        String school = ListStudent().get(index-1).getSchool();
        String fileName="C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON\\" + school.toLowerCase() + ".json";
        ArrayList<Student> listStudent = ListStudent_JSon(fileName);
      /*  for(Student st:listStudent)
        {
           if((CompareStudent(student,st))==true)
           {

               EditStudent(listStudent,school,fileName,student);
           }
        }*/
        Iterator<Student> lir = listStudent.iterator();

        while (lir.hasNext()) {
            if((CompareStudent(student,lir.next()))==true)
            {
               EditStudent(listStudent,school,fileName,student);
            }
        }
    }
    public void EditStudent(ArrayList<Student> listStudent,String school,String fileName,Student student) throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.println("Nhập ID: ");
        String id = new String();
        id = input.nextLine();
        student.setId(id);
        System.out.println("Nhập tên: ");
        String name = new String();
         name =input.nextLine();
        student.setName(name);
        System.out.println("Nhập giới tính: ");
        String sex = new String();
        sex = input.nextLine();
        student.setSex(sex);

        System.out.println("Nhập địa chỉ: ");
        String address = new String();
        address=input.nextLine();
        student.setAddress(address);
        System.out.println("Nhập điểm toán: ");
        double math;
        math=CheckPoint();
        student.setMathPoint(math);
        System.out.println("Nhập điểm lý: ");
        double physical = CheckPoint();
        student.setPhysicalPoint(physical);
        System.out.println("Nhập điểm hóa: ");
        double chemistry = CheckPoint();
        student.setPhysicalPoint(chemistry);
        System.out.println("Đã chỉnh sửa");
        listStudent.add(student);
        File file = new File(fileName);
        ObjectMapper objectMapper =  new ObjectMapper();
        objectMapper.writeValue(file,listStudent);

    }

    public static Comparator<Student> StudentName =new Comparator<Student>() {
        public int compare(Student st1, Student st2) {
            String str1 = String.valueOf(st1.getName());
            String str2 = String.valueOf((st2.getName()));
            return str1.compareTo(str2);
        }
    };
    public static Comparator <Student> StudentID = new Comparator<Student>() {
        public int compare(Student st1, Student st2) {
            String str1 = String.valueOf(st1.getId());
            String str2 = String.valueOf(st2.getId());
            return str1.compareTo(str2);
        }
    };
    public static Comparator<Student> StudentCore = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String str1 = String.valueOf(o1.getMathPoint()+o1.getPhysicalPoint()+o1.getChemistryPoint());
            String str2 = String.valueOf(o2.getMathPoint()+o2.getPhysicalPoint()+o2.getChemistryPoint());
            return str1.compareTo(str2);
        }
    };
    public ArrayList SortByID() throws Exception
    {

        ArrayList<Student> listStudent = ListStudent();
        ArrayList<Student> result =new ArrayList<Student>();
        Collections.sort(listStudent,StudentID);
        for (int i = 0;i<listStudent.size();i++)
        {
            result.add(listStudent.get(i));
        }
        return  result;
    }
    public ArrayList SortByName()throws Exception
    {
        ArrayList<Student> listStudent = ListStudent();
        ArrayList<Student> result = new ArrayList<Student>();
        Collections.sort(listStudent,StudentName);
        for (Student st:listStudent)
        {
            result.add(st);
        }
        return  result;
    }
    public ArrayList SortByToTalPoint()throws Exception
    {   ArrayList<Student> result = ListStudent();
        ArrayList<Student> listStudent = new ArrayList<Student>();
        Collections.sort(listStudent,StudentCore);
        for (Student st:listStudent)
        {
            result.add(st);
        }
        return result;
    }
    public ArrayList SearchByID(String id)throws Exception
    {
        ArrayList<Student>listStudent = ListStudent();
        ArrayList<Student> result = new ArrayList<Student>();
        for (int i =0;i<listStudent.size();i++)
        {
            if(id.equals(listStudent.get(i).getId())==true)
            {
               result.add(listStudent.get(i));
            }
        }
        return result;
    }
    public ArrayList SearchByName(String name)throws Exception
    {
        ArrayList<Student> ListStudent= ListStudent();
        ArrayList<Student> result = new ArrayList<Student>();
        for (int k =0;k<ListStudent.size();k++)
        {
            int i =0;
            int j=0;

            while ((i<ListStudent.get(k).getName().length()&&j<name.length()))
            {
                if (ListStudent.get(k).getName().charAt(i)==name.charAt(j))
                {
                    i++;
                    j++;

                }else{
                    j =0;
                    i++;
                }
            }
            if (i == name.length())
            {
                result.add(ListStudent.get(i));
            }
        }
        return  result;
    }

    public ArrayList SearchByToTalPoint(double totalPoint) throws Exception {
        ArrayList<Student> ls = ListStudent();
        ArrayList<Student>result = new ArrayList<Student>();
        for (int i =0;i<ls.size();i++)
        {
            if (totalPoint == (ls.get(i).getMathPoint()+ls.get(i).getChemistryPoint()+ls.get(i).getPhysicalPoint()))
            {
                result.add(ListStudent().get(i));
            }
        }
        return  result;
    }
    public ArrayList DeleteStudent(int index) throws Exception {
        Student student = ListStudent().get(index-1);
        String school = ListStudent().get(index-1).getSchool();
        String fileName="C:\\Users\\Thuan Nguyen\\IdeaProjects\\ManagerStudent_week3_1links\\src\\test\\FileJSON\\" + school.toLowerCase() + ".json";
        ArrayList<Student> listStudent = ListStudent_JSon(fileName);
    // phải sử dụng Iterator
        Iterator<Student> lir = listStudent.iterator();

        while (lir.hasNext()) {
            if((CompareStudent(student,lir.next()))==true)
            {
                lir.remove();
            }
        }
        File file = new File(fileName);
        ObjectMapper objectMapper =  new ObjectMapper();
        objectMapper.writeValue(file, listStudent);
        return listStudent;
    }



    public int StatisticalPoint( int first,int end) throws Exception {  int count = 0;
        ArrayList <Student>listStudent = ListStudent();
        for (Student st: listStudent)
        {

            if ((st.getMathPoint()+st.getChemistryPoint()+st.getPhysicalPoint())>=first
                    && (st.getPhysicalPoint()+st.getChemistryPoint()+st.getMathPoint()<=end))
            count ++;
        }
        return count;

    }



}
