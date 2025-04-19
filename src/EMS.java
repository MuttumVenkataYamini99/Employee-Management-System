import java.util.Scanner;
public class EMS {
    public static void main(String[] args) {
        System.out.println("Employee Management System");
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Admin");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                   Admin admin = new Admin();
                   admin.adminPanel();
                    break;
                case 2:
                    Employee employee = new Employee();
                    employee.enterEmpID();
                    employee.enterPassword();
                    employee.updatePassword();
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }while (choice != 3);
        System.out.println("Thank you for using the Employee Management System!");
        sc.close();
    }
}

