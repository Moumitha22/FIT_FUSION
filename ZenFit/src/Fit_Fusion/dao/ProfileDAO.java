package Fit_Fusion.dao;

import java.sql.SQLException;

import Fit_Fusion.classes.Profile;

public interface ProfileDAO {
	Profile getProfileById(int id) throws SQLException;
	boolean addProfile(Profile p) throws SQLException;
	boolean updateProfile(Profile profile) throws SQLException;

}
