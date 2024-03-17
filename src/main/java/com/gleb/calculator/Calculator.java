package com.gleb.calculator;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application {

    public String del(String str){

        String nStr = "";

        for(int i = 0; i < str.length()-1; i++) nStr = nStr + str.charAt(i);

        return nStr;
    }

    @Override
    public void start(Stage stage) throws IOException {

        TextField IOStream = new TextField();
        IOStream.getStyleClass().add("StreamLine");
        IOStream.setEditable(false);

        GridPane ButtonPanel = new GridPane();
        ButtonPanel.getStyleClass().add("ButtonPanel");
        Button[][] buttons = new Button[3][3];
        for(int i = 0; i < 3; i++) for(int k = 0; k < 3; k++){


            buttons[i][k] = new Button("" + (7+k-3*i));
            buttons[i][k].setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
            GridPane.setMargin(buttons[i][k], new Insets(2));
            Button b = buttons[i][k];
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(IOStream.getText().length() <= 20) {
                        if(IOStream.getText().equals("0")) IOStream.setText("" + b.getText());
                        else IOStream.setText(IOStream.getText() + b.getText());
                    }
                }
            });
            ButtonPanel.add(buttons[i][k], k, i);

        }
        Button button = new Button("0");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 0, 3);
        button = new Button(",");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 1, 3);
        button = new Button("=");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 2, 3);
        button.getStyleClass().add("equals");
        button = new Button("+");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 3, 3);
        button = new Button("/");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 3, 0);
        button = new Button("*");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 3, 1);
        button = new Button("-");
        button.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        GridPane.setMargin(button, new Insets(2));
        ButtonPanel.add(button, 3, 2);

        Button Delete = new Button("Delete");
        Delete.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);

        Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                IOStream.setText(del(IOStream.getText()));
                if(IOStream.getText().isEmpty()){

                    IOStream.setText("" + 0);
                    IOStream.requestFocus();
                    IOStream.positionCaret(0);
                }
            }
        });

        Button AC = new Button("AC");
        AC.setPrefSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        AC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                IOStream.setText("0");
            }
        });

        HBox DestroyButtons = new HBox(Delete,AC);
        DestroyButtons.setSpacing(4);
        VBox window = new VBox(IOStream, DestroyButtons, ButtonPanel);

        window.setSpacing(4);
        window.getStyleClass().add("window");

        Scene scene = new Scene(window, 320, 450);
        if(IOStream.getText().isEmpty()){

            IOStream.setText("" + 0);
            IOStream.requestFocus();
            IOStream.positionCaret(0);
        }

        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Калькулятор");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}