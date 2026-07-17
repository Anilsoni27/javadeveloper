import java.util.Scanner;

public class FactorialRecursion {

    static long fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        
        try {
            int num = in.nextInt();
            
            if (num < 0) {
                System.out.println("Cannot calculate factorial of a negative number.");
            } else {
                System.out.println("Factorial: " + fact(num));
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid integer.");
        } finally {
            in.close();
        }
    }
}
