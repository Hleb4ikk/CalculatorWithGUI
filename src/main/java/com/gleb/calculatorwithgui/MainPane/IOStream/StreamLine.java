package com.gleb.calculatorwithgui.MainPane.IOStream;

import javafx.scene.control.TextField;

public class StreamLine {
    private final TextField IOStream;

    public StreamLine(){

        this.IOStream = new TextField();
        this.IOStream.getStyleClass().add("StreamLine");
        this.IOStream.setEditable(false);
    }
    public TextField get(){

        return this.IOStream;

    }
}
