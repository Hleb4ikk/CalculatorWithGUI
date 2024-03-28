package com.gleb.calculatorwithgui.ActionHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ActionHandler {

    public static void ClickedNumber(Button button, TextField stream) {

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(stream.getText().length() <= 20) {
                    if(stream.getText().equals("0")) stream.setText("" + button.getText());
                    else stream.setText(stream.getText() + button.getText());
                }
            }
        });

    }
    public static void ClickedOperation(Button button, TextField stream){

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(button.getText() == "AC") {

                    stream.setText("0");

                } else if(button.getText() == "del"){

                    String nStr = "";

                    if(stream.getText().charAt(stream.getText().length() - 1) == ' ') {
                        for (int i = 0; i < stream.getText().length() - 3; i++) {

                            nStr = nStr + stream.getText().charAt(i);

                        }
                    } else {

                        for (int i = 0; i < stream.getText().length() - 1; i++) {

                            nStr = nStr + stream.getText().charAt(i);

                        }

                    }
                    if(nStr.isEmpty()){

                        stream.setText("0");

                    } else {
                        stream.setText(nStr);
                    }
                } else if(stream.getText().length() <= 20) {
                    if(stream.getText().equals("0")) stream.setText("" + button.getText());
                    else stream.setText(stream.getText() + " " + button.getText() + " ");
                }
            }
        });

    }
}
