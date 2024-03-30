package com.gleb.calculatorwithgui;

import com.gleb.calculatorwithgui.MainPane.ButtonPanel.ButtonPanel;
import com.gleb.calculatorwithgui.MainPane.IOStream.StreamLine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        StreamLine IOLine = new StreamLine();
        ButtonPanel Panel = new ButtonPanel(IOLine.get());
        VBox window = new VBox(IOLine.get(), Panel.get());
        window.getStyleClass().setAll("window");
        Scene scene = new Scene(window,320, 450);

        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Калькулятор");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}