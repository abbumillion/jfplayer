module com.app.audioplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.app.audioplayer to javafx.fxml;
    exports com.app.audioplayer;
}