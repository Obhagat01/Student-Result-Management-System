package dao;
import db.DBConnection;
import model.Result;
import java.sql.*;
import java.util.*;

public class ResultDAO {

    public void addResult(Result r) throws SQLException {
        String query = "INSERT INTO results (roll_no, subject, marks) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, r.getRollNo());
            ps.setString(2, r.getSubject());
            ps.setInt(3, r.getMarks());
            ps.executeUpdate();
            System.out.println("Result added!");
        }
    }

    public List<Result> getResults(int rollNo) throws SQLException {
        List<Result> list = new ArrayList<>();
        String query = "SELECT * FROM results WHERE roll_no = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Result(
                    rs.getInt("roll_no"),
                    rs.getString("subject"),
                    rs.getInt("marks")
                ));
            }
        }
        return list;
    }
}