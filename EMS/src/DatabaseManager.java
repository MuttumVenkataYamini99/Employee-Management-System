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

    public void addEmployee(String empID, String password) {
        String sql = "INSERT INTO employees (empID, password) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empID);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateEmployee(String empID, String newPassword) {
        String sql = "UPDATE employees SET password = ? WHERE empID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, empID);
            pstmt.executeUpdate();
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

    public void getEmployee(String empID) {
        String sql = "SELECT * FROM employees WHERE empID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getString("empID"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.addEmployee("E1234567", "password123");
        dbManager.updateEmployee("E1234567", "newpassword123");
        dbManager.getEmployee("E1234567");
        dbManager.deleteEmployee("E1234567");
    }
}

