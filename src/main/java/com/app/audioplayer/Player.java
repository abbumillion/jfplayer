package com.app.audioplayer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Player extends Application {
    double W = Screen.getPrimary().getVisualBounds().getWidth() * .8;
    double H = Screen.getPrimary().getVisualBounds().getHeight() * .7;

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        FXMLLoader fxmlLoader = new FXMLLoader(Player.class.getResource("player-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), W, H);
        scene.getStylesheets().add(String.valueOf(Objects.requireNonNull(Player.class.getResource("style.css")).toString()));
        stage.setTitle("Player");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.setFullScreen(true);
        new Thread(new AudioCollector()).start();
    }

    public static void main(String[] args) {
        launch();
    }
}