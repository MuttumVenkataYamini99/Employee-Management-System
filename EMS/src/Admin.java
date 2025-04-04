import java.util.Scanner;

public class Admin {

    public void adminPanel() {
        System.out.println("Welcome to the Admin Panel");
        System.out.println("Please Enter your Admin Username: ");

        Scanner sc = new Scanner(System.in);
        String AdminUsername = sc.nextLine();
        System.out.println("Please Enter your Admin Password: ");
        String password = sc.nextLine();
        if (AdminUsername.equals("Admin") && password.equals("Admin123")) {
            System.out.println("Login Successful ");
            System.out.println("Welcome to the Admin Panel");
            int choice;
            do {
                System.out.println("Please Enter your choice: ");
                System.out.println("1. Add Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Get Employee");
                System.out.println("5. Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Adding Employee...");
                        // Call method to add employee
                        break;
                    case 2:
                        System.out.println("Updating Employee...");
                        // Call method to update employee
                        break;
                    case 3:
                        System.out.println("Deleting Employee...");
                        // Call method to delete employee
                        break;
                    case 4:
                        System.out.println("Getting Employee...");
                        // Call method to get employee
                        break;
                    case 5:
                        System.out.println("Exiting the Admin Panel...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid Details, Try Again");
        }
    }
}