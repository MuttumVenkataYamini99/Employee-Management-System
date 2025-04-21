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
        double lpa = 0;
        int salary = 0;
        double Hike = 0.0; // Example initialization
        int _Leaves = 0; // Example initialization
        double LossOfPay = 0.0; // Example initialization
        double Tax_insurance = 0.0;
       //******************************************************************//
        System.out.println("====================================");
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
                        System.out.println("Adding Employee Details on Database..."+ "⏳");

                        System.out.println("Generate Employee ID: ");
                        empID = sc.next();

                        System.out.println("Enter Employee Name: ");
                        empName = sc.next();

                        System.out.println("Generate Employee Password: ");
                        empPassword = sc.next();
                        // Check if the password is less than 8 characters

                        if(empPassword.length()>=10 || empPassword.matches("[A-Za-z0-9]+")){
                            System.out.println("Password Generated Successfully"+"✅");
                        }
                        else{
                            System.out.println("Password must be below 10 characters. Try Again.");
                            System.out.println("Please Avoid !@#$%^&*()_+|~`... this symbols"+"❌");
                        }

                        // Check if the password is valid
                        System.out.println("Enter Employee Email: ");
                        empEmail = sc.next();
                        // Check if the email is valid
                        if (!empEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                            System.err.println("Please enter a valid email address."); 
                        }
                        // checking mobile number validation
                        System.out.println("Enter Employee Mobile Number: ");
                        empPhno = sc.nextLong();

                        if(String.valueOf(empPhno).length()==10){
                            System.out.println("Mobile Number Is verified"+"✅");
                        }
                        else{
                            System.err.println("Please enter a valid mobile number.");
                            break;
                        }


                        System.out.println("Enter the Project Name: ");
                        String project = sc.next();

                        // Check if the project name is valid
                        if(project == null || project.isEmpty()) {
                            project =" No Project Assigned";
                        }

                        System.out.println("Assign Employee Designation: ");
                        String designation = sc.next();

                       System.out.println("Enter Employee Salary: ");
                       while (!sc.hasNextInt()) {

                           sc.next(); // Clear the invalid input
                       }
                       salary = sc.nextInt();

                        System.out.println("Enter Employee Hike: ");
                        Hike = sc.nextDouble();

                        System.out.println("Enter Employee Leaves: ");
                        _Leaves = sc.nextInt();

                        System.out.println("Enter Employee Loss of Pay: ");
                        LossOfPay = sc.nextDouble();

                        System.out.println("Enter Employee Tax and Insurance: ");
                        Tax_insurance = sc.nextDouble();

                        System.out.println("Enter Employee LPA: ");
                        lpa = sc.nextDouble();


                        // Call the addEmployee method from DatabaseManager
                        db.addEmployee(empID, empName, empPassword, empEmail, (int)empPhno);
                        db.employeedetails(project, designation, lpa, salary ,Hike , _Leaves, LossOfPay , Tax_insurance);
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
                                empPhno = sc.nextInt();

                                // Call the updateEmployee method from DatabaseManager
                                db.updateEmployee(empID, empName, empPassword, empEmail, (int)empPhno);
                            } else {
                                System.out.println("Invalid Employee ID or Password. Please try again.");
                            }

                        }
                        break;
                    case 3:
                        System.out.println("Employee Details Deleted From Server..."+ "⏳");
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