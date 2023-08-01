package Fit_Fusion.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Fit_Fusion.classes.Profile;
import Fit_Fusion.dao.ProfileDAO;
import Fit_Fusion.util.DbConnection;

public class ProfileDaoImpl implements ProfileDAO {
	private static final String INSERT_QUERY = "INSERT INTO profile (userId, firstName,lastName,age, height, gender) VALUES (?, ?, ?, ?,?,?)";
	private static final String SELECT_QUERY= "SELECT * FROM profile WHERE userId = ?";
	private static final String UPDATE_QUERY = "UPDATE profile SET firstName=?, lastName=?, age=?, height=?, gender=? WHERE userId=?";

	 @Override
	public Profile getProfileById(int id) throws SQLException {
		
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(SELECT_QUERY);
		st.setInt(1,id);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			 Profile profile = new Profile();
	         profile.setUserId(rs.getInt("userId"));
	         profile.setAge(rs.getInt("age"));
	         profile.setFirstName(rs.getString("firstName"));
	         profile.setLastName(rs.getString("lastName"));
	         profile.setHeight(rs.getDouble("height"));
	         profile.setGender(rs.getString("gender"));
			return profile;
		}
		return null;
	}

	@Override
	public boolean addProfile(Profile profile) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getConnection();
		PreparedStatement st = con.prepareStatement(INSERT_QUERY);

        st.setInt(1, profile.getUserId());
        st.setString(2, profile.getFirstName());
        st.setString(3, profile.getLastName());
        st.setInt(4, profile.getAge());
        st.setDouble(5, profile.getHeight());
        st.setString(6, profile.getGender());
        return st.executeUpdate()>0;
	}
	
	 @Override
	    public boolean updateProfile(Profile updatedProfile) throws SQLException {
	        Connection con = DbConnection.getConnection();
	        PreparedStatement st = con.prepareStatement(UPDATE_QUERY);

	        st.setString(1, updatedProfile.getFirstName());
	        st.setString(2, updatedProfile.getLastName());
	        st.setInt(3, updatedProfile.getAge());
	        st.setDouble(4, updatedProfile.getHeight());
	        st.setString(5, updatedProfile.getGender());
	        st.setInt(6, updatedProfile.getUserId());

	        return st.executeUpdate() > 0;
	    }

}
