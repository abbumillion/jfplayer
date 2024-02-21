package com.app.audioplayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerQueue {
    private static PlayerQueue instance = null;
    private ObservableList<String> playerQueue = FXCollections.observableArrayList();
    private PlayerQueue(){}
    public static synchronized PlayerQueue getInstance()
    {
        if (instance == null)
        {
            instance = new PlayerQueue();
        }
        return instance;
    }

    public ObservableList<String> getPlayerQueue() {
        return playerQueue;
    }
}
