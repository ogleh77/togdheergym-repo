module com.example.togdheergym {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
    requires AnimateFX;
    opens com.example.togdheergym to javafx.fxml;
    opens com.example.togdheergym.controllers to javafx.fxml;
    exports com.example.togdheergym;
    exports com.example.togdheergym.objects;
}