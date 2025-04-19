import java.util.Scanner;

public class Employee {
    String EmpID;
    String password;
    String enterpassword;
    String Right = "✅";
    String wrong = "❌";
    Scanner scanner = new Scanner(System.in);



    void enterEmpID() {
        System.out.println("Please Enter your Employee ID: ");
        EmpID = scanner.nextLine();

        DatabaseManager db = new DatabaseManager();
        String empPassword = "";
        if (db.checkEmployee(EmpID)) { // Fixed method call and variable name
            if (EmpID.length() < 8 && EmpID.matches("[a-zA-Z0-9]+")) {
                System.out.println("Login Successful " + Right);
            } else {
                System.out.println(wrong + "\uD83D\uDC49 Employee ID must be below 8 characters., Try Again");
            }
        } else {
            System.out.println(wrong + " Your Employee ID is not created. Please contact HR or Admin.");
        }
    }

    void enterPassword() {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        // Check if the password is valid format
        if (password.length() >= 8 || !password.matches("[a-zA-Z]+")) {
            System.err.println("\u274C Password is incorrect. It must be less than 8 characters and contain only letters.");
            System.err.println("Character count: " + password.length());
            System.err.println("\uD83D\uDC49 Special characters and numbers are not allowed.");
            return; // exit early
        }

        // If password format is valid, check if it exists in the database
        if (db.checkEmployee(password)) {
            System.out.println("\u2705 Password verified successfully.");
        } else {
            System.out.println("\u274C Password not found in records. Please try again.");
        }
    }


    void updatePassword() {
        System.out.println("Do you want to update your Password: Yes Or No? ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println("Enter your New password: ");
            String newpassword = scanner.nextLine();
            if (newpassword.length() < 8 && newpassword.matches("[a-zA-Z0-9 ]+")) {
                System.out.println("Password Updated Successfully " + Right);
                System.out.println("Your employee ID is: " + EmpID);
                System.out.println("Your new password is: " + newpassword);
            } else {
                System.out.println(wrong + "\uD83D\uDC49 Please enter fewer than 8 characters, Try Again" + wrong);
            }
        } else if (choice.equalsIgnoreCase("No")) {
            System.out.println("Process Terminated" + Right);
        } else {
            System.out.println(wrong + " Invalid Details, Try Again");
        }
    }
}