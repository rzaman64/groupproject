package com.example.groupproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Random;

public class HelloController {
    String username;
    String password;

    @FXML
    private Label bottomlogindisplay;

    @FXML
    private Button loginButton;

    @FXML
    private Button passwordButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField userNameTextField;
    @FXML
    public void btnExitHandler(MouseEvent event) {
        Button selectedUIDesigner = (Button) event.getSource();
        selectedUIDesigner.setEffect(null);

    }

    @FXML
    void btnHoverHandler(MouseEvent event) {
        Button selectedUIDesigner = (Button) event.getSource();
        selectedUIDesigner.setEffect(new Glow());
    }


    @FXML
    void loginButtonHandler(ActionEvent event) {
        username = userNameTextField.getText().replace(" ", ""); //removes spaces from username
        password = passwordTextField.getText();
        bottomlogindisplay.setVisible(true);

        //Validates user input (checks if input is empty)
        if (username.isBlank() || password.isBlank()){
            bottomlogindisplay.setVisible(true);
            bottomlogindisplay.setText("Invalid request");
            System.out.println("Invalid request");
        }
        //Validates user input (checks if length is at an appropriate length)
        else if(username.length() <=3 || username.length() >=30 || password.length() <=6){
            if(username.length() <=3){
                bottomlogindisplay.setText("Username must be more than 3 characters");
                System.out.println("Username must be more than 3 characters");
            }
            if(username.length() >= 30) {
                bottomlogindisplay.setText("Username must be less than 30 characters");
            }
            if(password.length() <=6){
                bottomlogindisplay.setText("Password must be more than 6 characters");
                System.out.println("Password must be more than 6 characters");
            }
        }

            //This runs if input is validated and correct
        else {
            System.out.println("Username: " + username + "\nPassword: " + password);

            try {
                username = userNameTextField.getText().replace(" ", "");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcome-user.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 602, 451);
                Stage currStge = (Stage) (loginButton.getScene().getWindow());
                currStge.setTitle("Welcome");
                currStge.setScene(scene);
                currStge.centerOnScreen();
                currStge.show();

                //Displays names to the second view
                WelcomeUserController welcomeUserController = fxmlLoader.getController();
                welcomeUserController.displayUsername(username); //displays name

            } catch (IOException e) {
                System.out.println(e);
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void passwordButtonHandler(ActionEvent event) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String specialChars = "<>,.?/}]{[+_-)(*&^%$#@!=";
        String combination = upper + lower + specialChars + num;
        int len = 16;

        char[] password = new char[len];
        Random r = new Random();

        for(int i = 0; i<len; i++){
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        System.out.println("generated password: " + new String(password));
        passwordTextField.setText(String.valueOf(password));
    }

}
