package db;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<Student> studentList;
    private int index;

    private DBConnection(){
        studentList = new ArrayList<>();
    }
    public static DBConnection getInstance(){
        return instance == null ? instance = new DBConnection() : instance;
    }
    public List<Student> getStudentList(){
        return studentList;
    }
    public boolean logIn(String nameOrId,String password){
        int  i = 0;
        for(Student student : studentList){
            if(student.getName().equals(nameOrId) || student.getId().equals(nameOrId)){
                if(student.getPassword().equals(password)){
                    index=i;
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public int getIndex() {
        return index;
    }
}
