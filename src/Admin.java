import java.util.Scanner;

public class Admin {

    public void adminPanel() {
        String empID = "";
        String empName;
        String empPassword = "";
        String empEmail;
        long empPhno;
        int gae =0;
        int upe =0;
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
                        db.addEmployee(empID, empName, empPassword, empEmail, (int)empPhno);

                        System.out.println("Do want to Exit ? (Yes or No)");
                        String userChoice1 = sc.next();
                        if(sc.nextLine().equalsIgnoreCase("Yes")){
                            System.out.println("Closed");
                        }
                        else if(sc.nextLine().equalsIgnoreCase("No")){
                            System.out.println("Operation cancelled.");
                        } else {
                            System.out.println("Invalid choice. Please try again.");

                        }
                        break;
                    case 2:
                        if(upe==0) {
                            upe += 1;
                            System.out.println("Updating Employee details Please wait for Server connection..."+"⏳");
                            System.out.println("Enter your old Employee ID: ");
                            empID = sc.next();

                            System.out.println("Enter Your Old Password: ");
                            empPassword = sc.next();

                            if( db.checkEmployee(empID)) {
                             System.out.println("Enter your new Employee ID : ");
                             empID = sc.next();

                             System.out.println("Enter new Employee Name: ");
                                empName = sc.next();

                             System.out.println("Enter new Employee Password: ");
                                empPassword = sc.next();

                                System.out.println("Enter new Employee Email: ");
                                empEmail = sc.next();

                                System.out.println("Enter new Employee Phone Number: ");
                                empPhno = sc.nextLong();

                                // Call the updateEmployee method from DatabaseManager
                                db.updateEmployee(empID, empName, empPassword, empEmail, (int)empPhno);
                            } else {
                                System.out.println("Invalid Employee ID or Password. Please try again.");
                            }
                            System.out.println("Do want to Exit ? (Yes or No)");
                            String userChoice2 = sc.next();
                            if(sc.nextLine().equalsIgnoreCase("Yes")){
                                System.out.println("Closed");
                            }
                            else if(sc.nextLine().equalsIgnoreCase("No")){
                                System.out.println("Operation cancelled.");
                            } else {
                                System.out.println("Invalid choice. Please try again.");

                            }
                        }
                        break;
                    case 3:
                        System.out.println("Employee Details Deleted From Server...");
                        System.out.println("Enter Employee ID: ");
                        empID = sc.next();
                        db.deleteEmployee(empID);
                        break;
                    case 4:
                        if(gae ==0) {
                            gae += 1;
                            System.out.println("Getting Employee Details...");
                            System.out.println("Please wait for Server connection..."+"⏳");
                            System.out.println();
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