package com.gleb.calculatorwithgui.SyntacticalAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class SyntacticalAnalazer {

    public static List<Lexeme> lexAnalyze(String expression){

        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while(pos < expression.length()){

            char c = expression.charAt(pos);
            switch (c){

                case '(':
                    lexemes.add(new Lexeme(Lexeme.LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(Lexeme.LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(Lexeme.LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(Lexeme.LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(Lexeme.LexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(Lexeme.LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                default:
                    if(c <= '9' && c >= '0'){

                        StringBuilder sb = new StringBuilder();
                        do{

                            sb.append(c);
                            pos++;
                            if(pos >= expression.length()){

                                break;

                            }
                            c = expression.charAt(pos);
                        }while(c <= '9' && c >='0' || c =='.');
                        lexemes.add(new Lexeme(Lexeme.LexemeType.NUMBER, sb.toString()));
                    } else {

                        if(c != ' '){

                            throw new RuntimeException("Unexcepted character: " + c);

                        }
                        pos++;
                    }
            }

        }
        lexemes.add(new Lexeme(Lexeme.LexemeType.EOF, ""));
        return lexemes;
    }
    public static double expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == Lexeme.LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }

    public static double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.Value
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public static double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.Value
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public static double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Double.parseDouble(lexeme.Value);
            case LEFT_BRACKET:
                double value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != Lexeme.LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.Value
                            + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.Value
                        + " at position: " + lexemes.getPos());
        }
    }

}
