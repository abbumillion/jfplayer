package com.app.audioplayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class AudioPlayer {
    private static AudioPlayer instance = null;
    private MediaPlayer mediaPlayer;
    private AudioPlayer(){}
    public static synchronized AudioPlayer getInstance()
    {
        if (instance == null)
        {
            instance = new AudioPlayer();
        }
        return instance;
    }
    public void play()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.dispose();
        }
            mediaPlayer = new MediaPlayer(new Media(new File(PlayerQueue.getInstance().getPlayerQueue().get(
                    PlayerQueue.getInstance().getPlayerQueue().size() - 1)).toURI().toString()));
            mediaPlayer.play();
            mediaPlayer.setVolume(1.0);
    }
}
