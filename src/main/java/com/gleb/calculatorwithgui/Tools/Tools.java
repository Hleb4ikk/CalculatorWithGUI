package com.gleb.calculatorwithgui.Tools;

import java.util.Objects;

public class Tools {

    public static boolean isOperation(String s){

        return Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/");

    }
    public static boolean isLeftScope(String s){

        return Objects.equals(s, "(");

    }

    public static boolean isRightScope(String s){

        return Objects.equals(s, ")");

    }
}
