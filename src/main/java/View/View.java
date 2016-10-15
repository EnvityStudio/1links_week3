package View;

import Controller.StudentController;
import Entity.Student;
import Model.ReadFile;
import Model.StudentModel;

import Model.ThreadUpdate;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Thuan Nguyen on 9/27/2016.
 */
public class View {

    public static void MenuMain()
    {
        System.out.println("QUẢN LÝ SINH VIÊN");
        System.out.println("1.Thêm mới sinh viên");
        System.out.println("2.Xem danh sách");
        System.out.println("3.Sắp xếp ");
        System.out.println("4.Tìm kiếm");
        System.out.println("5.Thống kê");
        System.out.println("6.Thoát");
    }
    public void MenuAddNewStudent()
    {
        System.out.println("1.Nhập từ bàn phím");
        System.out.println("2.Nhập từ file");
        System.out.println("3.Quay lại");
    }
    public void MenuViewStudent()
    {
        System.out.println("1.Sửa thông tin sinh viên");
        System.out.println("2.Xóa sinh viên");
        System.out.println("3.Quay lại");
    }
    public void MenuSearch()
    {
        System.out.println("1.Tìm kiếm theo tên");
        System.out.println("2.Tìm kiếm theo ID");
        System.out.println("3.Tìm kiếm theo tổng điểm");
        System.out.println("4.Quay lại");
    }
    public void MenuSort()
    {
        System.out.println("1.Sắp xếp theo tên");
        System.out.println("2.Sắp xếp theo ID");
        System.out.println("3.Sắp xếp theo tổng điểm");
        System.out.println("4.Quay lại");
    }
    public void AddStudent() throws Exception {
        StudentModel studentModel = new StudentModel();
        studentModel.AddStudentByHand();
        MenuMain();
    }
    public void SelectMenuMain() throws Exception {
        MenuMain();
        System.out.print("Bạn chọn: ");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        //choice=input.nextInt();
        do {
            choice = input.nextInt();
            switch (choice)
            {
                case 1: AddStudent(); break;
                case 2: ViewStudent(); break;
                case 3: SortStudent();break;
                case 4: SearchStudent();break;
                case 5: StatisticalStudent();break;
                case 6: break;
                //default:
                   // System.out.println("Bạn phải nhập số từ 1-->7"); break;
            }
        }while(choice !=6);
    }
    public void SelectMenuViewStudent() throws Exception {
        MenuViewStudent();
        System.out.print("Bạn chọn: ");
        Scanner input = new Scanner(System.in);
        int choice;
        do {
             choice = input.nextInt();
            switch (choice)
            {
                case 1: EditStudent(); break;
                case 2: DeleteStudent(); break;
                case 3: break;
              //  default:
                //    System.out.println("Nhập lại");
            }
        }while (choice !=3 );
    }
    public void ViewStudent() throws Exception {
        StudentModel studentModel = new StudentModel();
        ThreadUpdate threadUpdate = new ThreadUpdate();
        threadUpdate.start();
        ArrayList<Student> listStudent = studentModel.ListStudent();

        int i =1;
        for (Student st : listStudent) {

           System.out.printf(" %-5s |%-30s | %-10s  | %-35s  | %-10s | %-14s  | %-10.2f  | %-10.2f  | %10.2f ",i,st.getSchool(), st.getId(), st.getName(),
                    st.getSex(), st.getAddress(), st.getMathPoint(),
                    st.getPhysicalPoint(), st.getPhysicalPoint());
            System.out.println();
            i++;


        }
        SelectMenuViewStudent();
        
    }
    public void SortStudent() throws Exception {
        MenuSort();
        System.out.print("Bạn chọn: ");
        Scanner input = new Scanner(System.in);
        int choice;
        do {
             choice = input.nextInt();
            switch (choice )
            {
                case 1: SortByName(); break;
                case 2: SortByID(); break;
                case 3: SortByToTalPoint(); break;
                case 4: break;
             //   default:
               //     System.out.println("Nhập lại");
            }
        }while (choice !=4);
    }

    public void SearchStudent() throws Exception {
        MenuSearch();
        System.out.print("Bạn chọn: ");
        Scanner input = new Scanner(System.in);
        int choice;
        do {

                choice = input.nextInt();
                switch (choice)
                {
                    case 1: SearchByName(); break;
                    case 2: SearchByid(); break;
                    case 3: SearchByPoint(); break;
                    case 4: break;
                    default:
                        System.out.println("Nhập lại");
                }
            }while (choice!=4);
    }
    public void EditStudent() throws Exception {
        StudentModel studentModel = new StudentModel();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vị trí: ");
        int index = input.nextInt();
        studentModel.CompareStudent(index);

    }
    public void SearchByid() throws Exception {
        System.out.println("Nhập Id : ");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        StudentController studentController = new StudentController();
        showList(studentController.SearchById(id));
        MenuMain();
    }
    public void SearchByName() throws Exception
    {
        System.out.println("Nhập tên sinh viên: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        StudentController studentController = new StudentController();
        showList(studentController.SearchByName(name));
        MenuMain();
    }

    public void SearchByPoint() throws Exception
    {
        System.out.print("Nhập tổng điểm: ");
        Scanner input = new Scanner(System.in);
        double totalPoint = input.nextDouble();
        StudentController studentController = new StudentController();
        showList(studentController.SearchByToTalPoint(totalPoint));
        MenuMain();
    }
    public void SortByName() throws Exception {
   //     System.out.print("Nhập tên: ");
     //   Scanner input = new Scanner(System.in);
       // String name = input.nextLine();
        StudentController studentController = new StudentController();
        showList(studentController.SortByName());
        MenuMain();
    }
    public void SortByID() throws Exception {
     //   System.out.print("Nhập ID: ");
       // Scanner input = new Scanner(System.in);
       // String ID = input.nextLine();
        StudentController studentController = new StudentController();
        showList(studentController.SortByID());
        MenuMain();
    }
    public void SortByToTalPoint() throws Exception {
        //System.out.print("Nhập tổng điểm: ");
        //Scanner input = new Scanner(System.in);
        //double totalPoint = input.nextDouble();
        StudentController studentController = new StudentController();
        showList(studentController.SortByToTalPoint());
        MenuMain();
    }
    public void DeleteStudent() throws Exception {
        System.out.print("Nhập stt mà bạn muốn xóa: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        StudentModel studentModel = new StudentModel();
        studentModel.DeleteStudent(index);
        //StudentController studentController = new StudentController();
        //showList(studentController.DeleteStudent(index));
        MenuMain();
    }
    public void StatisticalStudent() throws Exception {
     //   ArrayList<Student> ListStudent = new ArrayList<Student>();
        StudentController studentController = new StudentController();
        System.out.println("Thống kê");
        System.out.println("Tổng sinh viên có điểm dưới 15 "+ studentController.StatisticalPoint(0,15));
        System.out.println("Tổng sinh viên có điểm từ 15 tới 20 " +studentController.StatisticalPoint(15,20));
        System.out.println("Tổng sinh viên có điểm từ 20 tới 25 "+studentController.StatisticalPoint(20,25));
        System.out.println("Tổng sinh viên có điểm trên 25: "+studentController.StatisticalPoint(25,30));
        MenuMain();

    }

    public void showList(ArrayList<Student> listStudent)
    {
        System.out.println("List student ");
        for (Student st : listStudent) {
            System.out.printf(" %-10s  | %-35s  | %-10s | %-14s  | %-10.2f  | %-10.2f  | %10.2f ",st.getId(),st.getName(),
                    st.getSex(),st.getAddress(),st.getMathPoint(),
                    st.getPhysicalPoint(),st.getPhysicalPoint());
            System.out.println();
        }
    }

    // bên view chỉ hiện thị còn bên controller chỉ gọi hành động từ bên Model không có hiển thị, bên Model chỉ thiết kế
}

