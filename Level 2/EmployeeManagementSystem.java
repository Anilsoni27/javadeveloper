import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementSystem {

    private static final HashMap<Integer, Employee> employees = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (employees.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.put(id, new Employee(id, name, salary));
        System.out.println("Employee Added Successfully!");
    }

    public static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
            return;
        }

        System.out.println("\nEmployee Records:");
        for (Employee emp : employees.values()) {
            System.out.println(emp);
        }
    }

    public static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = employees.get(id);

        if (emp == null) {
            System.out.println("Employee Not Found!");
        } else {
            System.out.println(emp);
        }
    }

    public static void updateEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = employees.get(id);

        if (emp == null) {
            System.out.println("Employee Not Found!");
            return;
        }

        System.out.print("Enter New Name: ");
        emp.setName(sc.nextLine());

        System.out.print("Enter New Salary: ");
        emp.setSalary(sc.nextDouble());

        System.out.println("Employee Updated Successfully!");
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        if (employees.remove(id) != null) {
            System.out.println("Employee Deleted Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}