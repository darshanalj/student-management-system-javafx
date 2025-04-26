package controller;

import db.DBConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


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

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        Student student = new Student(txtId.getText(),txtName.getText(),txtEmail.getText(),txtPassword.getText(),dpDateOfBirth.getValue(),gender);

        int id = Integer.parseInt(txtId.getText());
        id++;
        txtId.setText(id+"");

        List<Student> studentList = DBConnection.getInstance().getStudentList();
        studentList.add(student);

    }

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"))));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtId.setText("1");
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
