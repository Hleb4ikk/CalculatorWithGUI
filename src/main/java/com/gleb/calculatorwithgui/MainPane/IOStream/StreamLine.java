package com.gleb.calculatorwithgui.MainPane.IOStream;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;

public class StreamLine {
    private TextField IOStream;

    public StreamLine(){

        this.IOStream = new TextField();
        this.IOStream.getStyleClass().add("StreamLine");
        this.IOStream.setEditable(false);
    }
    public TextField get(){

        return this.IOStream;

    }
}
