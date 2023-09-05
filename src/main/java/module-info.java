module com.example.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;


    opens com.example.hellofx to javafx.fxml;
    exports com.example.hellofx;
}