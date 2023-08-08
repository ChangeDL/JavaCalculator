package JavaCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean shouldRestart = true;

        while (shouldRestart) {
            System.out.println("Enter 1st Number: ");
            int firstNum = getIntInput(input);
            System.out.println("Enter 2nd Number: ");
            int secondNum = getIntInput(input);
            System.out.println("What Operation would you like to do?");
            System.out.println("Type the number next to the operation to select it");
            System.out.println("1: Add 2: Subtract 3: Multiply 4: Divide ");
            int operation = getIntInput(input);

            if (operation > 0 && operation < 5) {
                double result = result(firstNum, secondNum, operation);
                System.out.println("Result: " + result);
                System.out.print("Would you like to do another problem? (y/n): ");
                shouldRestart = getYesOrNoInput(input);
            } else {
                System.out.println("That is not a valid option for this calculator");
                System.out.print("Would you like try again? (y/n): ");
                shouldRestart = getYesOrNoInput(input);
            }
        }
        System.out.println("Program ended. Goodbye!");
        input.close();
    }

    public static int getIntInput(Scanner scanner) {
        int number;
        while (true) {
            try {
                number = scanner.nextInt();
                break; // Exit the loop if input is a valid integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        return number;
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

    public static double result(int num1, int num2, int operation) {
        if (operation == 1)
            return num1 + num2;
        else if (operation == 2)
            return num1 - num2;
        else if (operation == 3)
            return num1 * num2;
        else if (operation == 4)
            return (double) num1 / num2;
        else {
            return -1;
        }
    }
}
