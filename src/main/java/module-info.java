module com.gleb.calculatorwithgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gleb.calculatorwithgui to javafx.fxml;
    exports com.gleb.calculatorwithgui;
    exports com.gleb.calculatorwithgui.MainPane.ButtonPanel;
    opens com.gleb.calculatorwithgui.MainPane.ButtonPanel to javafx.fxml;
}