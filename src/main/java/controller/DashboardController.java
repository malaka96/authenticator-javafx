package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.dto.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class DashboardController {


    @FXML
    private TextField CreateEmailTf;

    @FXML
    private TextField CreateFirstNameTf;

    @FXML
    private TextField CreateLastNameTf;

    @FXML
    private PasswordField CreatePasswordTf;

    @FXML
    private PasswordField CreateReEnterPasswordTf;

    @FXML
    private AnchorPane createAccPane;

    @FXML
    private AnchorPane dashboardPane;

    @FXML
    private TextField loginEmailTf;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private PasswordField loginPsTf;

    final UserService userService = new UserServiceImpl();

    @FXML
    void CreateBtnAction(ActionEvent event) {
        try {
            String firstName = CreateFirstNameTf.getText();
            String lastName = CreateLastNameTf.getText();
            String email = CreateEmailTf.getText();
            String password = CreatePasswordTf.getText();

            User user = new User(firstName,lastName,email,password);

            userService.createUser(user);

            showTargetScreen(dashboardPane);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error creating account");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void createLoginBtnAction(MouseEvent event) {
        showTargetScreen(loginPane);
    }

    @FXML
    void dashboradLogoutBtnAction(ActionEvent event) {
        showTargetScreen(loginPane);
    }

    @FXML
    void loginAccCreateBtnAction(MouseEvent event) {
        showTargetScreen(createAccPane);
    }

    @FXML
    void loginBtnAction(ActionEvent event) {
        showTargetScreen(dashboardPane);
    }

    private void showTargetScreen(AnchorPane targetAnchorPane){
        loginPane.setVisible(false);
        createAccPane.setVisible(false);
        dashboardPane.setVisible(false);

        targetAnchorPane.setVisible(true);
    }

}
