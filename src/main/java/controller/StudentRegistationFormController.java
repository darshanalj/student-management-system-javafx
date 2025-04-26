package controller;

import db.DBConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class StudentRegistationFormController implements Initializable {
    public TextField txtId;
    public TextField txtName;
    public TextField txtPassword;
    public TextField txtEmail;
    public DatePicker dpDateOfBirth;
    public TextField txtConfirmPassword;
    public RadioButton rbMale;
    public RadioButton rbFemale;

    private String gender = "";

    private boolean isValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(emailRegex);

        return email != null && p.matcher(email).matches();

    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        if(!txtPassword.getText().equals(txtConfirmPassword.getText())){
            new Alert(Alert.AlertType.CONFIRMATION,"invalid confirm password !!").show();
            return;
        }

        if(!isValid(txtEmail.getText())){
            new Alert(Alert.AlertType.CONFIRMATION,"invalid email !!").show();
            return;
        }

        Student student = new Student(txtId.getText(),txtName.getText(),txtEmail.getText(),txtPassword.getText(),dpDateOfBirth.getValue(),gender);

        int id = Integer.parseInt(txtId.getText());
        id++;
        txtId.setText(id+"");

        List<Student> studentList = DBConnection.getInstance().getStudentList();
        studentList.add(student);

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"))));
        stage.show();
    }

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"))));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(DBConnection.getInstance().getStudentList().size()!=0){
            Student student =  DBConnection.getInstance().getStudentList().get(DBConnection.getInstance().getStudentList().size() - 1);
            txtId.setText((Integer.parseInt(student.getId())+1)+"");

        }else{
            txtId.setText("1");
        }

    }

    public void rbMaleOnAction(ActionEvent actionEvent) {
        if(rbMale.isSelected()){
            gender="male";
            rbFemale.setSelected(false);
        }
    }

    public void rbFemaleOnAction(ActionEvent actionEvent) {
        if(rbFemale.isSelected()){
            gender="female";
            rbMale.setSelected(false);
        }
    }
}
