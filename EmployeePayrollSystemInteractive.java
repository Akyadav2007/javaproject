
import java.util.Scanner;

// Parent Class
class Employee {

    protected String name;
    protected int id;
    protected double baseSalary;

    // Parameterized Constructor
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    // Method to be overridden
    public double calculateSalary() {
        return baseSalary;
    }

    public void displayDetails() {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID   : " + id);
    }
}

// Full-Time Employee Class
class FullTimeEmployee extends Employee {

    private double bonus;
    private double allowance;

    public FullTimeEmployee(String name, int id,
            double baseSalary,
            double bonus,
            double allowance) {

        super(name, id, baseSalary);
        this.bonus = bonus;
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus + allowance;
    }
}

// Part-Time Employee Class
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,
            int id,
            int hoursWorked,
            double hourlyRate) {

        super(name, id, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main Class
public class EmployeePayrollSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Employee Payroll Management System =====");

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.println("\nSelect Employee Type");
        System.out.println("1. Full-Time Employee");
        System.out.println("2. Part-Time Employee");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        Employee emp;

        if (choice == 1) {

            System.out.print("Enter Base Salary: ");
            double baseSalary = sc.nextDouble();

            System.out.print("Enter Bonus: ");
            double bonus = sc.nextDouble();

            System.out.print("Enter Allowance: ");
            double allowance = sc.nextDouble();

            emp = new FullTimeEmployee(
                    name, id, baseSalary, bonus, allowance);

        } else if (choice == 2) {

            System.out.print("Enter Hours Worked: ");
            int hoursWorked = sc.nextInt();

            System.out.print("Enter Hourly Rate: ");
            double hourlyRate = sc.nextDouble();

            emp = new PartTimeEmployee(
                    name, id, hoursWorked, hourlyRate);

        } else {
            System.out.println("Invalid Choice!");
            sc.close();
            return;
        }

        System.out.println("\n===== Payroll Report =====");
        emp.displayDetails();
        System.out.println("Salary : Rs. " + emp.calculateSalary());

        sc.close();
    }
}
