import java.util.Scanner;

public class BasicCalculator {

    // Method for Addition
    double addition(double a, double b) {
        return a + b;
    }

    // Method for Subtraction
    double subtraction(double a, double b) {
        return a - b;
    }

    // Method for Multiplication
    double multiplication(double a, double b) {
        return a * b;
    }

    // Method for Division
    double division(double a, double b) {
        if (b == 0) {
            System.out.println("Error! Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BasicCalculator cal = new BasicCalculator();

        int choice;

        System.out.println("===============================");
        System.out.println("      BASIC CALCULATOR");
        System.out.println("===============================");

        do {

            System.out.println("\nMenu");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                switch (choice) {

                    case 1:
                        System.out.println("Result = " + cal.addition(num1, num2));
                        break;

                    case 2:
                        System.out.println("Result = " + cal.subtraction(num1, num2));
                        break;

                    case 3:
                        System.out.println("Result = " + cal.multiplication(num1, num2));
                        break;

                    case 4:
                        System.out.println("Result = " + cal.division(num1, num2));
                        break;
                }

            } else if (choice == 5) {

                System.out.println("\nThank you for using Basic Calculator!");

            } else {

                System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}