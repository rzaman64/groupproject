package com.example.groupproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloController {
    String username;
    String password;

    @FXML
    private Button loginButton;

    @FXML
    private Button passwordButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField userNameTextField;

    @FXML
    void loginButtonHandler(ActionEvent event) {
        username = userNameTextField.getText();
        password = passwordTextField.getText();
        System.out.println("Username: " + username + "\nPassword: " + password);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("welcome-user.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 597, 400);

            Stage currStge = (Stage)(loginButton.getScene().getWindow());
            currStge.setTitle("Welcome");
            currStge.setScene(scene);
            currStge.centerOnScreen();
            currStge.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
