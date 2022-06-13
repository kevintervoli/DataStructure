module com.example.datastructure {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datastructure to javafx.fxml;
    exports com.example.datastructure;
}