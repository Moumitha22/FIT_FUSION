package Fit_Fusion.dao;

import java.sql.Date;
import java.sql.SQLException;

import Fit_Fusion.classes.Goals;

public interface GoalsDAO {
	boolean addGoal(Goals g) throws SQLException;
	Goals viewGoal(int userId) throws SQLException;
	boolean updateGoal(Goals g) throws SQLException;
	boolean updateWeight(double weight,int userId) throws SQLException;
	int viewNetCalories(Date date,int userId) throws SQLException;
}
