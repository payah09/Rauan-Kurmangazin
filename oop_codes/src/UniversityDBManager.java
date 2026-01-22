import java.sql.*;

public class UniversityDBManager {

    public void saveCourse(Course c, int profId) {
        String sql = "INSERT INTO courses (course_code, title, credits, department, professor_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, c.getCourseCode());
            pstmt.setString(2, c.getTitle());
            pstmt.setInt(3, c.getCredits());
            pstmt.setString(4, c.getDepartment());
            pstmt.setInt(5, profId);
            pstmt.executeUpdate();
            System.out.println(">> Course saved to database successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving course: " + e.getMessage());
        }
    }

    public void listAllCourses() {
        String sql = "SELECT c.*, p.name, p.surname FROM courses c " +
                "JOIN professors p ON c.professor_id = p.id";
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nUNIVERSITY COURSE CATALOG");
            while (rs.next()) {
                System.out.printf("%-8s | %-20s | Credits: %d | Prof: %s %s\n",
                        rs.getString("course_code"), rs.getString("title"),
                        rs.getInt("credits"), rs.getString("name"), rs.getString("surname"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void removeCourse(String code) {
        String sql = "DELETE FROM courses WHERE course_code = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println(">> Course deleted.");
            else System.out.println(">> Course not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void saveProfessor(Professor p) {
        String sql = "INSERT INTO professors (name, surname, email, department) VALUES (?, ?, ?, ?)";
        try(Connection conn = DBConfig.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getSurname());
            pstmt.setString(3, p.getEmail());
            pstmt.setString(4, p.getDepartment());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int newId = rs.getInt(1);
                System.out.println(">> Professor added successfully! Assigned ID: " + newId);
            }
        } catch (SQLException e) {System.out.println("Error saving professor: " + e.getMessage());}
    }

    public void listAllProfessors() {
        String sql = "SELECT * FROM professors ORDER BY id ASC";
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nFACULTY LIST");
            System.out.printf("%-5s | %-20s | %-15s | %s\n", "ID", "Name", "Dept", "Email");
            while (rs.next()) {
                System.out.printf("%-5d | %-20s | %-15s | %s\n",
                        rs.getInt("id"),
                        rs.getString("name") + " " + rs.getString("surname"),
                        rs.getString("department"),
                        rs.getString("email"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void filterCoursesByDept(String deptName) {
        String sql = "SELECT c.*, p.name, p.surname FROM courses c " +
                "JOIN professors p ON c.professor_id = p.id " +
                "WHERE LOWER(c.department) = LOWER(?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, deptName);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n COURSES IN DEPARTMENT: " + deptName.toUpperCase());
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("%-8s | %-20s | Credits: %d | Prof: %s %s\n",
                        rs.getString("course_code"), rs.getString("title"),
                        rs.getInt("credits"), rs.getString("name"), rs.getString("surname"));
            }
            if (!found) System.out.println("No courses found for this department.");

        } catch (SQLException e) { e.printStackTrace(); }
    }
}