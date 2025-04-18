import java.util.Scanner;

public class Admin {

    public void adminPanel() {
        String empID = "";
        String empName;
        String empPassword = "";
        String empEmail;
        int empPhno;
        int c=0;
        System.out.println("Welcome to the Admin Panel");
        System.out.println("Please Enter your Admin Username: ");
        DatabaseManager db = new DatabaseManager();
        Scanner sc = new Scanner(System.in);
        String AdminUsername = sc.nextLine();
        System.out.println("Please Enter your Admin Password: ");
        String password = sc.nextLine();
        if (AdminUsername.equals("Admin") && password.equals("Admin123")) {
            System.out.println("Login Successful ");
            System.out.println("Welcome to the Admin Panel");
            System.out.println("Please Enter your choice: ");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Get Employee");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            do{
                switch(choice) {
                    case 1:
                        System.out.println("Adding Employee...");

                        System.out.println("Enter Employee ID: ");
                        empID = sc.next();
                        System.out.println("Enter Employee Name: ");
                        empName = sc.next();
                        System.out.println("Enter Employee Password: ");
                        empPassword = sc.next();
                        System.out.println("Enter Employee Email: ");
                        empEmail = sc.next();
                        System.out.println("Enter Employee Phone Number: ");
                        empPhno = sc.nextInt();

                        // Call the addEmployee method from DatabaseManager
                        db.addEmployee(empID, empName, empPassword, empEmail, empPhno);
                        break;
                    case 2:
                        System.out.println("Updating Employee...");
                        DatabaseManager db1 = new DatabaseManager();
                        db1.updateEmployee(empID, empPassword);
                        break;
                    case 3:
                        System.out.println("Deleting Employee...");
                        System.out.println("Enter Employee ID: ");
                        empID = sc.next();
                        db.deleteEmployee(empID);
                        break;
                    case 4:
                        if(c==0) {
                            c += 1;
                            System.out.println("Getting Employee...");
                            db.getAllEmployees();
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the Admin Panel...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }while (choice != 5);
        } else {
            System.out.println("Invalid Details, Try Again");
        }

    } // end of adminPanel method


}