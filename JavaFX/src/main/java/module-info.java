module MotorcyclesCatalog {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires jdk.jfr;
    exports pl.polsl.lab to javafx.graphics, javafx.fxml;
    exports pl.polsl.lab.controller to javafx.fxml;

    opens pl.polsl.lab;
    opens pl.polsl.lab.model;
    opens pl.polsl.lab.controller;
}