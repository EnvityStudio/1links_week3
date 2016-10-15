package Entity;

/**
 * Created by Thuan Nguyen on 9/27/2016.
 */
public class Student {
    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    private String School;
    private  String name;
    private String address;
    private String Id,sex;
    private double chemistryPoint;
    private  double physicalPoint;
    private double mathPoint;
    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name = name;
    }
    public String getSex()
    {
        return sex;
    }
    public void setSex()
    {
        this.sex = sex;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress()
    {
        this.address = address;
    }
    public String getId()
    {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setChemistryPoint(double chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public void setPhysicalPoint(double physicalPoint) {
        this.physicalPoint = physicalPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public void setId()
    {
        this.Id = Id;
    }
    public double getChemistryPoint()
    {
        return chemistryPoint;
    }
    public void setChemistryPoint()
    {
        this.chemistryPoint= chemistryPoint;
    }
    public double getPhysicalPoint()
    {
        return physicalPoint;
    }
    public void setPhysicalPoint()
    {
        this.physicalPoint= physicalPoint;
    }
    public double getMathPoint()
    {
        return mathPoint;
    }
    public void setMathPoint()
    {
        this.mathPoint= mathPoint;
    }
    public  Student()
    {
        this("","","","","",0,0,0);
    }
    public Student(String school,String Id,String name,String sex,String address,double mathPoint,double physicalPoint, double chemistryPoint)

    {
        this.School = school;
        this.sex = sex;
        this.name = name;
        this.address = address;
        this.Id = Id;
        this.chemistryPoint = chemistryPoint;
        this.physicalPoint= physicalPoint;
        this.mathPoint = mathPoint;
    }


}
