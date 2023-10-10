package com.example.groupproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MusicLibraryController implements Initializable{

    @FXML
    private Button addSongBtn;
    @FXML
    private Button allSongBtn;
    @FXML
    private Label artistNameLabel;
    @FXML
    private Button backBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button favoriteSongBtn;
    @FXML
    private Button pauseBtn;
    @FXML
    private Button personalBtn;
    @FXML
    private Button playBtn;
    @FXML
    private Button skipBtn;
    @FXML
    private ImageView songIconImg;
    @FXML
    private Label songNameLabel;
    @FXML
    private VBox vItems;

    @FXML
    public void btnHoverHandler(MouseEvent event) {
        Button selectedUIDesigner = (Button) event.getSource();
        selectedUIDesigner.setEffect(new Glow());
    }

    @FXML
    public void btnExitHandler(MouseEvent event) {
        Button selectedUIDesigner = (Button) event.getSource();
        selectedUIDesigner.setEffect(null);
    }

    @FXML
    void addSongBtnHandler(ActionEvent event) {

    }

    @FXML
    void allSongBtnHandler(ActionEvent event) {

    }

    @FXML
    void backBtnHandler(ActionEvent event) {

    }

    @FXML
    void closeBtnHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void editBtnHandler(ActionEvent event) {

    }

    @FXML
    void favoriteSongBtnHandler(ActionEvent event) {

    }

    @FXML
    void pauseBtnHandler(ActionEvent event) {

    }

    @FXML
    void personalBtnHandler(ActionEvent event) {

    }

    @FXML
    void playBtnHandler(ActionEvent event) {

    }

    @FXML
    void skipBtnHandler(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("song-module.fxml"));
            Node fxml1 = fxmlLoader.load();

            // Set initial style when loading FXML1 content
            fxml1.setStyle("-fx-background-color: #1E1E1E");

            // Add mouse event handlers for FXML1 content
            fxml1.setOnMouseEntered(event -> {
                fxml1.setStyle("-fx-background-color: #165DDB");
            });

            fxml1.setOnMouseExited(event -> {
                fxml1.setStyle("-fx-background-color: #1E1E1E");
            });

            fxml1.setOnMousePressed(event -> {
                fxml1.setStyle("-fx-background-color: #165DDB");
                // Handle mouse press action, e.g., navigate or perform some action.
            });

            vItems.getChildren().add(fxml1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
