package com.VladKudryshov.Calc.reader;

import java.util.Scanner;

public class Reader {
    public static String readFromConsole(){
        System.out.println("Expression: ");
        return new Scanner(System.in).nextLine();
    }
}
