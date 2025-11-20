package org.example;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Logger;


public class CodeAnalysis {
    private static final String RESULT_MESSAGE = "The result is: ";

    public static void main(String[] args){
        Logger log = Logger.getLogger("CodeAnalysis");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        log.info("Enter the first number: ");
        final double num1 = sc.nextInt();
        log.info("Enter the second number: ");
        final double num2 = sc.nextInt();
        log.info("Select an operation by choosing one of the following numbers: (1-Add, 2-Subtract, 3-Multiply, 4-Divide): ");
        int operation = sc.nextInt();

        switch (operation) {
            case 1:
                log.info(() -> String.format("%s%s", RESULT_MESSAGE, addValues(num1, num2)));
                break;
            case 2:
                log.info(() -> String.format("%s%s", RESULT_MESSAGE, subtractValues(num1, num2)));
                break;
            case 3:
                log.info(() -> String.format("%s%s", RESULT_MESSAGE, multiplyValues(num1, num2)));
                break;
            case 4:
                log.info(() -> String.format("%s%s", RESULT_MESSAGE, divideValues(num1, num2)));
                break;
            default:
                log.info("Invalid operation");
        }
    }
    public static double addValues (double num1, double num2){
        return num1 + num2;
    }
    public static double subtractValues (double num1, double num2){
        return num1 - num2;
    }
    public static double multiplyValues (double num1, double num2){
        return num1 * num2;
    }
    public static double divideValues (double num1, double num2){
        return num1 / num2;
    }
}