module CalcInJava {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;

exports pl.gerkeprojects.calcinjava.main to javafx.graphics;
opens pl.gerkeprojects.calcinjava.controller to javafx.fxml;
}