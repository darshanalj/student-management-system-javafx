package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentLogInFormController {
    public TextField txtPassword;
    public TextField txtEmailOrId;

    public void linkRegisterFormOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_registation_form.fxml"))));
        stage.show();
    }

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
        if(DBConnection.getInstance().logIn(txtEmailOrId.getText(),txtPassword.getText())){
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_dashboard_form.fxml"))));
            stage.show();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"login failed !!").show();
        }
    }
}
