package org.example;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Logger;


public class CodeAnalysis {
    public static void main(String[] args){
        Logger log = Logger.getLogger("CodeAnalysis");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        log.info("Enter the first number: ");
        final double num1 = sc.nextInt();
        log.info("Enter the second number: ");
        final double num2 = sc.nextInt();
        int operation = (int) Math.ceil(num1 / num2);
        double value = 0;
            switch (operation) {
                case 1:
                    value = addValues(num1, num2);
                    break;
                case 2:
                    value = subtractValues(num1, num2);
                    break;
                case 3:
                    value = multiplyValues(num1, num2);
                    break;
                case 4:
                    value = divideValues(num1, num2);
                    break;
                default:
                    log.info("Invalid operation");
            }
        log.info("The result is: "+ addValues(num1, num2));
        log.info("The result is: "+ subtractValues(num1, num2));
        log.info("The result is: "+ multiplyValues(num1, num2));
        log.info("The result is: "+ divideValues(num1, num2));
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
