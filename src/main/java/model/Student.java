package model;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDate date;
    private String gender;

    public Student(String id, String name, String email, String password, LocalDate date, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                '}';
    }
}
