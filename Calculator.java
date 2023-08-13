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
        double secondNum = 0;
        String operation = "";

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
                System.out.print("Are you trying to find the square root of a number? (y/n): ");
            } else {
                System.out.print("Do you want to find the square root of " + sum + " (y/n): ");
            }
            boolean squareRootCheck = getYesOrNoInput(input);
            if (squareRootCheck) {
                operation = "sqrt";
                if (sum == 0) {
                    System.out.print("What number are you looking for the square root for?: ");
                    firstNum = getSqrtIntInput(input);
                } else if (sum < 0) {
                    System.out.print("Negative numbers can be square rooted, please type in a new number: ");
                    firstNum = getSqrtIntInput(input);
                } else {
                    firstNum = sum;
                }
            }

            if (!squareRootCheck) {

                if (sum == 0) {
                    System.out.print("Enter 1st Number: ");
                    firstNum = getIntInput(input);
                } else {
                    firstNum = sum;
                }

                input.nextLine();
                System.out.println("What Operation would you like to do?");
                System.out.println("type the symbol that best represents it.");
                System.out.print("[ + | - | * | / | ^ | % ]:  ");
                operation = getOperatorInput(input);
                if (!squareRootCheck) {
                    System.out.print("Enter 2nd Number: ");
                    secondNum = getIntInput(input);
                }

            }
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
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        return number;
    }

    public static double getSqrtIntInput(Scanner scanner) {
        double number;
        while (true) {
            try {
                number = scanner.nextDouble();
                if (number >= 0) {
                    break; // Exit the loop if input is a valid integer
                } else {
                    System.out.print("Invalid input. Please enter a non-negative number: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        return number;
    }

    public static String getOperatorInput(Scanner scanner) {
        String operator;
        while (true) {
            operator = scanner.next().trim(); // Trim any leading/trailing spaces
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")
                    || operator.equals("^") || operator.equals("sqrt") || operator.equals("%")) {
                break; // Exit the loop if input is a valid operator
            } else {
                System.out.println("Invalid input. Please enter +, -, *, /, ^, or %:");
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
        else if (operation.equals("^"))
            return (double) Math.pow(num1, num2);
        else if (operation.equals("sqrt"))
            return (double) Math.sqrt(num1);
        else if (operation.equals("%"))
            return (double) num1 * (num2 * .01);
        else {
            return -1;
        }
    }
}
