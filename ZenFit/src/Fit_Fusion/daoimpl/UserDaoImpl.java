package Fit_Fusion.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Fit_Fusion.classes.User;
import Fit_Fusion.dao.UserDAO;
import Fit_Fusion.util.DbConnection;

public class UserDaoImpl implements UserDAO {
    private static final String INSERT_QUERY = "INSERT INTO user (username, password) VALUES (?, ?)";
    private static final String VERIFY_QUERY = "SELECT * FROM user WHERE username = ?";
    private static final String DELETE_QUERY = "DELETE FROM user WHERE userId = ?";
    
    @Override
    public boolean addUser(User user) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS);
        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        int rowsAffected = st.executeUpdate();
        if (rowsAffected > 0) {
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                    return true; // User added successfully
                }
            }
        }
        return false;
 }

    @Override
    public int verifyUser(String username, String password) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(VERIFY_QUERY);
        st.setString(1, username);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            String storedPassword = rs.getString("password");
            if(storedPassword.equals(password))
            	return rs.getInt("userId");
        }
        
        return 0;
    }
    
    @Override
    public boolean deleteUser(int userId) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(DELETE_QUERY);
        st.setInt(1, userId);
        int rowsAffected = st.executeUpdate();
        return rowsAffected > 0;
    }
}
