package android.example.com.prayas;

public class Student {
    private String name;
    private String roll;
    private int gender;
    private int set;
    private int batch;
    public Student(String name,String roll,int gender,int set,int batch){
        this.batch = batch;
        this.gender = gender;
        this.name = name;
        this.roll = roll;
        this.set = set;
    }
    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public int getGender() {
        return gender;
    }

    public int getSet() {
        return set;
    }

    public int getBatch() {
        return batch;
    }
}
