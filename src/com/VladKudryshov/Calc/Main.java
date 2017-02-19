package com.VladKudryshov.Calc;

import com.VladKudryshov.Calc.algorithm.PolishNotation;
import com.VladKudryshov.Calc.algorithm.ShuntingYard;
import com.VladKudryshov.Calc.model.Expression;
import com.VladKudryshov.Calc.parse.Parser;
import com.VladKudryshov.Calc.reader.Reader;
import com.VladKudryshov.Calc.validator.Validator;
import com.VladKudryshov.Calc.writer.Writer;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter math expression(example:(2+3)^2)");
	System.out.println();
        System.out.println("You can use these symbols: '+' '-' '/' '*' '^' '(' ')'");
        System.out.println("Enter Q to quit the application");
        while (true) {
            Expression exp = new Expression();
            Validator validator = new Validator();
            boolean flag = true;
            while (flag) {
                String line = Reader.readFromConsole();
                if (Objects.equals(line, "Q")) {
                    System.exit(0);
                }
                if (!validator.checkErrorsExp(line)) {
                    line = Parser.splitExpression(line);
                    exp.setStrExp(line);
                    flag = false;
                }
            }
            exp.setPostfixExp(ShuntingYard.infixToPostfix(exp.getStrExp()));
            Writer.printAnswer(PolishNotation.calculateExp(exp.getPostfixExp()));
        }
    }
}
