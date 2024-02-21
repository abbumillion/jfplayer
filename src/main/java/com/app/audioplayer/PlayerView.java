package com.app.audioplayer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerView implements Initializable {
    @FXML
    public ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.itemsProperty().set(AudioRepository.getInstance().getAudioList());
        listView.setCellFactory(stringListView -> new AudioCell());
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if (t1 != null)
            {
                PlayerQueue.getInstance().getPlayerQueue().add(t1);
                AudioPlayer.getInstance().play();
            }
        });
    }
}