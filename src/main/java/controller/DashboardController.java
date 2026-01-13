package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class DashboardController {

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

    @FXML
    void CreateBtnAction(ActionEvent event) {
        showTargetScreen(dashboardPane);
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
