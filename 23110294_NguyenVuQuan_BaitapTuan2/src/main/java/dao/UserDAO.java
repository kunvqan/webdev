package dao;

import java.sql.*;
import model.User;
import util.DBConn;

public class UserDAO {
	public boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(User u) {
        String sql = "INSERT INTO Users(username,password,email) VALUES(?,?,?)";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
