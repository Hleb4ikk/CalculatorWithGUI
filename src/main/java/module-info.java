module com.gleb.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gleb.calculator to javafx.fxml;
    exports com.gleb.calculator;
}