
import java.util.Scanner;

public class EmployeePayrollSystemInteractive{

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            PayrollProcessor processor = new PayrollProcessor();

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter details for Employee " + (i + 1));

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("ID: ");
                int id = sc.nextInt();

                System.out.print("Type (1 = Full-Time, 2 = Part-Time): ");
                int type = sc.nextInt();

                switch (type) {
                    case 1 -> {
                        System.out.print("Base Salary: ");
                        double base = sc.nextDouble();

                        System.out.print("Bonus: ");
                        double bonus = sc.nextDouble();

                        System.out.print("Allowances: ");
                        double allowance = sc.nextDouble();

                        processor.addEmployee(
                            new FullTimeEmployee(name, id, base, bonus, allowance)
                        );
                    }
                    case 2 -> {
                        System.out.print("Hours Worked: ");
                        int hours = sc.nextInt();

                        System.out.print("Hourly Rate: ");
                        double rate = sc.nextDouble();

                        processor.addEmployee(
                            new PartTimeEmployee(name, id, 0, hours, rate)
                        );
                    }
                    default -> System.out.println("Invalid type! Skipping employee...");
                }

                sc.nextLine(); // consume newline
            }

            // Print payroll
            processor.printPayroll();
        }
    }
}