import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        BankAccount account = new BankAccount(name);

        while (true) {

            System.out.println("\n===== Banking System =====");
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
