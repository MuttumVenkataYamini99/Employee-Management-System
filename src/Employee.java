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
        if (EmpID.length() < 8 && EmpID.matches("[a-zA-Z0-9]+")) {
            System.out.println("Login Successful " + Right);
        } else {
            System.out.println(wrong + "\uD83D\uDC49 Employee ID must be below 8 characters., Try Again");
        }
    }


    void enterpassword() {
        System.out.println("Please Enter your password: "+enterpassword);
        password = scanner.nextLine();

        if (password.length() <8 && password.matches("[a-zA-Z]+")) {
            System.out.println("Login Successful " + Right);
        } else {
            System.out.println(wrong + "\uD83D\uDC49 Password must be below 8 characters., Try Again");
        }


    }

    void updatePassword() {
        System.out.println("Do you want to update your Password: Yes Or No? ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println("Enter your New password: ");
            String newpassword= scanner.nextLine();
            if (newpassword.length() <8 && newpassword.matches("[a-zA-Z]+")) {
                System.out.println("Password Updated Successfully " + Right);
                System.out.println("Your employee ID is: " + EmpID);
                System.out.println("Your new password is: " + newpassword);
            } else {
                System.out.println(wrong +  "\uD83D\uDC49 Please enter fewer than 8 characters, Try Again"+wrong);
            }
        } else if (choice.equalsIgnoreCase("No")) {
            System.out.println("Old password continues to be used"+Right);
        } else {
            System.out.println(wrong + " Invalid Details, Try Again");
        }
    }
}



