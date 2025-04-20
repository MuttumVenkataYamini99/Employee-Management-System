import java.util.Scanner;

public class Employee {
    String EmpID;
    String Right = "✅";
    String wrong = "❌";
    Scanner scanner = new Scanner(System.in);

    void enterEmpID() {
        System.out.println("Please Enter your Employee ID: ");
        EmpID = scanner.nextLine();

        DatabaseManager db = new DatabaseManager();
        if (db.checkEmployee(EmpID)) {
            if (EmpID.length() < 8 && EmpID.matches("[a-zA-Z0-9]+")) {
                System.out.println("Login Successful " + Right);
            } else {
                System.out.println(wrong + " Employee ID must be below 8 characters. Try Again.");
            }
        } else {
            System.out.println(wrong + " Your Employee ID is not created. Please contact HR or Admin.");
        }
    }

    void enterPassword() {
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();
        //checking password from database//
        DatabaseManager db = new DatabaseManager();
        if (db.checkPassword(password)) {
            if (password.length() < 9 && password.matches("[a-zA-Z0-9]+")) {
                System.out.println("Login Successful " + Right);
            } else {
                System.out.println(wrong + " password  must be below 8 characters. Try Again.");
            }
        } else {
            System.out.println(wrong + " Your password is incorrect. Please contact HR or Admin.");
        }

    }
}