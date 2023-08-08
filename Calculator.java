package JavaCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean shouldRestart = true;
        boolean shouldClear = false;
        double sum = 0;
        double firstNum = 0;

        while (shouldRestart) {
            if (sum != 0) {
                System.out.println("Would you like to clear the calculator?");
                System.out.print("CLEAR: " + sum + "? (y/n): ");
                shouldClear = getYesOrNoInput(input);
                if (shouldClear) {
                    sum = 0;
                }
            }
            if (sum == 0) {
                System.out.print("Enter 1st Number: ");
                firstNum = getIntInput(input);
            } else {
                firstNum = sum;
            }
            System.out.print("Enter 2nd Number: ");
            double secondNum = getIntInput(input);
            input.nextLine();
            System.out.println("What Operation would you like to do?");
            System.out.println("type the symbol that best represents it.");
            System.out.print("[ + | - | * | / ]:  ");
            String operation = getOperatorInput(input);
            sum = result(firstNum, secondNum, operation);
            System.out.println("Result: " + sum);
            System.out.print("Would you like to do another problem? (y/n): ");
            shouldRestart = getYesOrNoInput(input);
        }
        System.out.println("Program ended. Goodbye!");
        input.close();
    }

    public static double getIntInput(Scanner scanner) {
        double number;
        while (true) {
            try {
                number = scanner.nextDouble();
                break; // Exit the loop if input is a valid integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        return number;
    }

    public static String getOperatorInput(Scanner scanner) {
        String operator;
        while (true) {
            operator = scanner.next().trim(); // Trim any leading/trailing spaces
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                break; // Exit the loop if input is a valid operator
            } else {
                System.out.println("Invalid input. Please enter +, -, *, or /:");
            }
        }
        return operator;
    }

    public static boolean getYesOrNoInput(Scanner scanner) {
        while (true) {
            String choice = scanner.next().trim().toLowerCase();
            if (choice.equals("y")) {
                return true;
            } else if (choice.equals("n")) {
                return false;
            } else {
                System.out.print("Invalid input. Please enter 'y' or 'n': ");
            }
        }
    }

    public static double result(double num1, double num2, String operation) {
        if (operation.equals("+"))
            return num1 + num2;
        else if (operation.equals("-"))
            return num1 - num2;
        else if (operation.equals("*"))
            return num1 * num2;
        else if (operation.equals("/"))
            return (double) num1 / num2;
        else {
            return -1;
        }
    }
}
