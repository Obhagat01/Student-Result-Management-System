package dao;
import db.DBConnection;
import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s) throws SQLException {
        String query = "INSERT INTO students (name, branch, semester) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getBranch());
            ps.setInt(3, s.getSemester());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        }
    }

    public Student getStudent(int rollNo) throws SQLException {
        String query = "SELECT * FROM students WHERE roll_no = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("roll_no"),
                    rs.getString("name"),
                    rs.getString("branch"),
                    rs.getInt("semester")
                );
            }
        }
        return null;
    }

    public void deleteStudent(int rollNo) throws SQLException {
        String query = "DELETE FROM students WHERE roll_no = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, rollNo);
            ps.executeUpdate();
            System.out.println("Student deleted.");
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("roll_no"),
                    rs.getString("name"),
                    rs.getString("branch"),
                    rs.getInt("semester")
                ));
            }
        }
        return list;
    }
}