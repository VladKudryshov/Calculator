package com.VladKudryshov.Calc.validator;

import java.util.Stack;
import java.util.regex.Pattern;

public class Validator {
    public static boolean checkErrorsExp(String exp){
        if (divideByZeroValidator(exp)) {
            System.out.println("Divide by zero!");
            return true;
        }
        if (parenthesesValidator(exp)) {
            System.out.println("In expression parentheses unpaired!");
            return true;
        }
        if (unCorrectExpValidator(exp)){
            System.out.println("Expression isn't correct!");
            return true;
        }
        return false;
    }

    private static boolean divideByZeroValidator(String exp){
        return Pattern.matches(".+\\/\\s*0[\\+\\-\\*/^()]*([^\\.]*)", exp);
    }

    private static boolean parenthesesValidator(String exp){
        String tmp = exp.replaceAll("[^()]*","");
        if(tmp.length()==0)return false;
        Stack<Character> parenthesisStack = new Stack<>();
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '(') {
                parenthesisStack.push('(');
            }
            if (tmp.charAt(i) == ')') {
                if (parenthesisStack.isEmpty()) {
                    return true;
                }
                parenthesisStack.pop();
            }
        }
        return !parenthesisStack.isEmpty();
    }
    private static boolean unCorrectExpValidator(String exp){
        return !Pattern.matches("\\s*\\(*\\s*(-?\\d+|-?\\d+\\.\\d+)(\\s*[-+ */^]\\(*\\s*-?(\\d+|-?\\d+\\.\\d+)\\s*\\)*)*\\s*", exp);
    }


}
