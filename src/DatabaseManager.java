import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/EMS";
    private static final String USER = "root";
    private static final String PASSWORD = "WJ28@krhps";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addEmployee(String empID, String Name, String Password, String Email, int Phno) {
        String sql = "INSERT INTO employees (empID,Name, Password,Email,Phno) VALUES (?, ?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empID);
            pstmt.setString(2, Name);
            pstmt.setString(3, Password);
            pstmt.setString(4, Email);
            pstmt.setInt(5, Phno);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Inside DatabaseManager.java
    public void updateEmployee(String empID, String empName, String empPassword, String empEmail, int phno) {
        String sql = "UPDATE employees SET name = ?, password = ?, email = ?, phno = ? WHERE empID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empName);
            pstmt.setString(2, empPassword);
            pstmt.setString(3, empEmail);
            pstmt.setInt(4, phno);
            pstmt.setString(5, empID);

            int rowsAffected = pstmt.executeUpdate();  // Check if update happened
            if (rowsAffected > 0) {
                System.out.println("✅ Employee details updated successfully!");
            } else {
                System.out.println("❌ No matching Employee ID found. Update failed.");
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Error updating employee details: " + e.getMessage());
        }
    }


    public void deleteEmployee(String empID) {
        String sql = "DELETE FROM employees WHERE empID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empID);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void getAllEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { // Properly iterates through the ResultSet
                System.out.println("-----------------------------------");
                System.out.println("Employee ID: " + rs.getString("empID"));
                System.out.println("Employee Name: " + rs.getString("Name"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("Phone Number: " + rs.getInt("Phno"));
                System.out.println("Password: " + rs.getString("Password"));
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving all employees: " + e.getMessage());
        }
    }

    public boolean checkEmployee(String empID) {
        String sql = "SELECT * FROM employees WHERE empID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empID);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if the employee exists
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkPassword(String password) {
        String sql = "SELECT * FROM employees WHERE password = ? ";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if the password matches
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void employeedetails(String project, String designation, double lap, double salary, double Hike, int _Leaves, double LossOfPay, double Tax_insurance) {
        String sql = "INSERT INTO employeedetails (project, designation, lap, salary, Hike, _Leaves, LossOfPay, Tax_insurance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, project);
            pstmt.setString(2, designation);
            pstmt.setInt(3, (int) lap); // Cast lap to int
            pstmt.setDouble(4, salary);
            pstmt.setDouble(5, Hike);
            pstmt.setInt(6, _Leaves);
            pstmt.setDouble(7, LossOfPay);
            pstmt.setDouble(8, Tax_insurance);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee details added successfully.");
            } else {
                System.out.println("Failed to add employee details.");
            }
        } catch (SQLException e) {
            System.out.println("Error while inserting employee details: " + e.getMessage());
        }
    }
}




