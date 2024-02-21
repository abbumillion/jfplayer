package com.app.audioplayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class AudioRepository {
    private static AudioRepository instance = null;
    private  ObservableList<String> audioList = FXCollections.observableArrayList();
    private AudioRepository()
    {}
    public static synchronized AudioRepository getInstance()
    {
        if (instance == null)
        {
            instance = new AudioRepository();
        }
        return instance;
    }
    public void addAudio(String path)
    {
        try {
            audioList.add(path);
        }catch (Exception e){System.out.println(e);}
    }
    public ObservableList<String> getAudioList() {
        return audioList;
    }
}
