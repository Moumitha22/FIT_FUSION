package Fit_Fusion.dao;

import java.sql.SQLException;

import Fit_Fusion.classes.User;

public interface UserDAO {
	boolean addUser(User u) throws SQLException;
	int verifyUser(String username,String password) throws SQLException;
	boolean deleteUser(int userId) throws SQLException;
}
