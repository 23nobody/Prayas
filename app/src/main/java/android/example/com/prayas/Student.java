package android.example.com.prayas;

public class Student {
    private String name;
    private String roll;
    private String studentId;
    //private int gender;
    private String set;
    //private int batch;
    public Student(String studentId,String name,String roll,String set){
       // this.batch = batch;
       // this.gender = gender;
        this.studentId=studentId;
        this.name = name;
        this.roll = roll;
        this.set = set;
    }
    public String getStudentId()
    {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }
    public String getSet() {
        return set;
    }

   /* public int getGender() {
        return gender;
    }



    public int getBatch() {
        return batch;
    }*/
}
