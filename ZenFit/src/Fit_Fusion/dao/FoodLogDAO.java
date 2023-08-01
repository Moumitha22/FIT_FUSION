package Fit_Fusion.dao;

import java.sql.SQLException;
import java.util.List;

import Fit_Fusion.classes.FoodLog;

public interface FoodLogDAO {
	
	List<FoodLog> viewFoodLog(int id) throws SQLException;
	boolean addFoodLog(FoodLog food) throws SQLException;

}
