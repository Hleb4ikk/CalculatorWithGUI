package com.gleb.calculatorwithgui.MainPane.ButtonPanel;

import com.gleb.calculatorwithgui.ActionHandler.ActionHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ButtonPanel {
    private final VBox buttonpanel;

    public ButtonPanel(TextField field) {
        Button LeftScope = new Button("(");
        LeftScope.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        LeftScope.getStyleClass().addAll("button");
        ActionHandler.ClickedOperation(LeftScope, field);

        Button RightScope = new Button(")");
        RightScope.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        RightScope.getStyleClass().addAll("button");
        ActionHandler.ClickedOperation(RightScope, field);

        Button AC = new Button("AC");
        AC.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        AC.getStyleClass().addAll("button");
        ActionHandler.ClickedOperation(AC, field);

        Button del = new Button("del");
        del.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        del.getStyleClass().addAll("button");
        ActionHandler.ClickedOperation(del, field);

        final HBox edit = new HBox(LeftScope, RightScope, AC, del);
        edit.setSpacing(12);
        edit.setPadding(new Insets(6));
        final GridPane gridpane = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {


                Button number = new Button("" + (7 + k - 3 * i));
                number.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
                number.getStyleClass().addAll("button");
                GridPane.setMargin(number, new Insets(6));

                //здесь нужна обработка событий
                ActionHandler.ClickedNumber(number, field);
                gridpane.add(number, k, i);

            }

        }
        Button divide = new Button("/"); //деление
        divide.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        divide.getStyleClass().addAll("button");
        GridPane.setMargin(divide, new Insets(6));
        ActionHandler.ClickedOperation(divide, field);
        gridpane.add(divide, 3, 0);

        Button multi = new Button("*"); //умножение
        multi.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        multi.getStyleClass().addAll("button");
        GridPane.setMargin(multi, new Insets(6));
        ActionHandler.ClickedOperation(multi, field);
        gridpane.add(multi, 3, 1);

        Button minus = new Button("-"); //минус
        minus.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        minus.getStyleClass().addAll("button");
        GridPane.setMargin(minus, new Insets(6));
        ActionHandler.ClickedOperation(minus, field);
        gridpane.add(minus, 3, 2);

        Button plus = new Button("+"); //плюс
        plus.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        plus.getStyleClass().addAll("button");
        GridPane.setMargin(plus, new Insets(6));
        ActionHandler.ClickedOperation(plus, field);
        gridpane.add(plus, 3, 3);

        Button equ = new Button("="); //равно
        equ.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        equ.getStyleClass().addAll("button");
        GridPane.setMargin(equ, new Insets(6));
        ActionHandler.ClickedEquals(equ, field);
        gridpane.add(equ, 2, 3);

        Button zero = new Button("0"); //ноль
        zero.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        zero.getStyleClass().addAll("button");
        GridPane.setMargin(zero, new Insets(6));
        ActionHandler.ClickedNumber(zero, field);
        gridpane.add(zero, 1, 3);

        Button comma = new Button("."); //точка
        comma.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        comma.getStyleClass().addAll("button");
        GridPane.setMargin(comma, new Insets(6));
        ActionHandler.ClickedNumber(comma, field);
        gridpane.add(comma, 0, 3);

        buttonpanel = new VBox(edit, gridpane);

    }

    public VBox get(){

        return this.buttonpanel;

    }
}