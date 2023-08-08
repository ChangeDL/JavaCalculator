package JavaCalculator;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean shouldRestart = true;

        while (shouldRestart) {
            System.out.println("Enter 1st Number: ");
            int firstNum = input.nextInt();
            System.out.println("Enter 2st Number: ");
            int secondNum = input.nextInt();
            System.out.println("What Operation would you like to do?");
            System.out.println("Type the number next to the operation to select it");
            System.out.println("1: Add 2: Subtract 3: Multiply 4: Divide ");
            int operation = input.nextInt();

            if (operation > 0 && operation < 5) {
                double result = result(firstNum, secondNum, operation);
                System.out.println("Result: " + result);
                System.out.print("Would you like to do another problem? (y/n): ");
                String restartChoice = input.next();
                shouldRestart = restartChoice.equalsIgnoreCase("y");
            } else {
                System.out.println("That is not a valid option for this calculator");
                System.out.print("Would you like try again? (y/n): ");
                String restartChoice = input.next();
                shouldRestart = restartChoice.equalsIgnoreCase("y");
            }
        }
        System.out.println("Program ended. Goodbye!");
        input.close();
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
