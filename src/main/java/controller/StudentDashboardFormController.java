package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentDashboardFormController implements Initializable {

    public Label lblStudentId;
    public Label lblName;
    public Label lblEmail;
    public Label lblDateOfBirth;
    public Label lblGender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student student = DBConnection.getInstance().getStudentList().get(DBConnection.getInstance().getIndex());

        lblStudentId.setText(student.getId());
        lblName.setText(student.getName());
        lblEmail.setText(student.getEmail());
        lblDateOfBirth.setText(student.getDate()+"");
        lblGender.setText(student.getGender());

    }

    public void btnLogOutOnAction(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"))));
        stage.show();

    }
}
