import java.sql.*;
import java.util.*;

public class StudentDAO {
    private final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
    private final String USER = "root";
    private final String PASSWORD = "your_password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertStudent(Student s) {
        String sql = "INSERT INTO Students (first_name, email) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getEmail());
            stmt.executeUpdate();
            System.out.println("Student added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        String sql = "SELECT student_id, first_name, email FROM Students";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + " | " +
                                   rs.getString("first_name") + " | " +
                                   rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted.");
            else System.out.println("Student not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
