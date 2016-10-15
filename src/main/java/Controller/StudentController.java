package Controller;

import Entity.Student;
import Model.StudentModel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thuan Nguyen on 9/27/2016.
 */
public class StudentController {
    StudentModel studentModel = new StudentModel();

    public ArrayList SearchById(String id) throws Exception {

        return  studentModel.SearchByID(id);

    }
    public ArrayList SearchByToTalPoint(double totalPoint) throws Exception {

        return studentModel.SearchByToTalPoint(totalPoint);
    }
    public ArrayList SearchByName(String name)  throws Exception
    {

        return studentModel.SearchByName(name);
    }
    public ArrayList SortByName()throws Exception
    {

        return studentModel.SortByName();
    }
    public ArrayList SortByID () throws Exception
    {

        return studentModel.SortByID();
    }
    public ArrayList SortByToTalPoint() throws Exception {

        return studentModel.SortByToTalPoint();
    }
 /*   public ArrayList DeleteStudent(int index) throws Exception {

        return studentModel.DeleteStudent(index);
    }*/
    public int StatisticalPoint(int first,int end) throws Exception {
        return studentModel.StatisticalPoint(first,end);
    }
   // public ArrayList NewID(Student )
}
