package com.app.audioplayer;

import javafx.beans.InvalidationListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.text.Font;

import java.io.File;
import java.util.Map;

public class AudioCell extends ListCell {
    @Override
    protected void updateItem(Object o, boolean b) {
        super.updateItem(o, b);
        HBox hBox = new HBox(30);
        Label title = new Label("title");
        Label artist = new Label("artist");
        Label album = new Label("album");
        Label year = new Label("year");
        ImageView imageView = new ImageView();
        if (o != null)
        {
            Media media = new Media(new File(o.toString()).toURI().toString());
            media.getMetadata().addListener((InvalidationListener) observable -> {
                Map map = (Map) observable;
                if (map.get("title") != null)
                {
                    title.setText(map.get("title").toString());
                }
                if (map.get("artist") != null)
                {
                    artist.setText(map.get("artist").toString());
                }
                if (map.get("album") != null)
                {
                    album.setText(map.get("album").toString());
                }
                if (map.get("year") != null)
                {
                    year.setText(map.get("year").toString());
                }
                if (map.get("image") != null)
                {
                    imageView.setImage((Image) map.get("image"));
                }
            });
        }
        imageView.setFitWidth(40);
        imageView.setFitHeight(30);
        //
        hBox.getChildren().addAll(imageView,title,artist,album,year);
        title.setAlignment(Pos.CENTER_LEFT);
        artist.setAlignment(Pos.CENTER_LEFT);
        album.setAlignment(Pos.CENTER_LEFT);
        year.setAlignment(Pos.CENTER_LEFT);
        //
        title.setFont(Font.font(11.5));
        album.setFont(Font.font(11.5));
        artist.setFont(Font.font(11.5));
        year.setFont(Font.font(11.5));
        //
        title.prefWidthProperty().bind(widthProperty().multiply(.2));
        album.prefWidthProperty().bind(widthProperty().multiply(.2));
        artist.prefWidthProperty().bind(widthProperty().multiply(.2));
        year.prefWidthProperty().bind(widthProperty().multiply(.2));
        //
        hBox.setPadding(new Insets(3.6,3.6,3.6,3.6));
        //
        setGraphic(hBox);
    }
}
