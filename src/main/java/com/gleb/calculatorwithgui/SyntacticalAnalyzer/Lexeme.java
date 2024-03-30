package com.gleb.calculatorwithgui.SyntacticalAnalyzer;

import java.util.List;

public class Lexeme {
    public enum LexemeType{
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        EOF;
    }

    LexemeType type;
    String Value;

    public Lexeme(LexemeType type, String Value) {
        this.type = type;
        this.Value = Value;
    }
    public Lexeme(LexemeType type, Character Value) {
        this.type = type;
        this.Value = Value.toString();
    }

}
