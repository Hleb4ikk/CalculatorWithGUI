package com.gleb.calculatorwithgui.ActionHandler;

import com.gleb.calculatorwithgui.SyntacticalAnalyzer.Lexeme;
import com.gleb.calculatorwithgui.SyntacticalAnalyzer.LexemeBuffer;
import com.gleb.calculatorwithgui.SyntacticalAnalyzer.SyntacticalAnalazer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Objects;

public class ActionHandler {

    private final static int limit = 30;

    public static void ClickedNumber(Button button, TextField stream) {

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(stream.getText().length() <= limit && !Objects.equals(stream.getText(), "Ошибка!")) {
                    if(Objects.equals(stream.getText(), "0")) stream.setText("" + button.getText());
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
                    }else if(Objects.equals(stream.getText(), "Ошибка!")) {

                        stream.setText("0");

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
                } else if(stream.getText().length() <= limit && !Objects.equals(stream.getText(), "Ошибка!")) {
                    if(stream.getText().equals("0")) stream.setText(stream.getText() + " " + button.getText() + " ");
                    else stream.setText(stream.getText() + " " + button.getText() + " ");
                }
            }
        });

    }
    public static void ClickedEquals(Button button, TextField stream){

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    List<Lexeme> lexemes = SyntacticalAnalazer.lexAnalyze(stream.getText());
                    LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
                    stream.setText("" + SyntacticalAnalazer.expr(lexemeBuffer));
                } catch (Exception e) {

                    stream.setText("Ошибка!");

                }
            }
        });

    }

}
