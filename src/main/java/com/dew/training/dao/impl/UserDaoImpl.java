package com.dew.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dew.training.dao.JDBCDaoSupport;
import com.dew.training.dao.UserDao;
import com.dew.training.dto.JobInfo;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.dto.Work;
import com.dew.training.enums.EducationType;
import com.dew.training.enums.Gender;
import com.dew.training.util.GeneralUtils;

@Repository
public class UserDaoImpl extends JDBCDaoSupport implements UserDao {

	
	
	private class UserRowMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs,int rowNum)throws SQLException{
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setEmail(rs.getString("email"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			return user;
			
		}
	}
	
	@Override
	public User addUser(final User user) throws Exception {
		final String sql = "INSERT INTO users (email,first_name,last_name,password,created_on,created_by,gender,dob,address,city,pincode,state,country) VALUES(?,?,?,?,now(),?,?,now(),?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String password=GeneralUtils.encrypt(user.getPassword());
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getEmail());
				statement.setString(2, user.getFirstName());
				statement.setString(3, user.getLastName());
				statement.setString(4, password);
				statement.setString(5, "SELF");
				statement.setInt(6, Gender.FEMALE.getValue());
				statement.setString(7, user.getAddress());
				statement.setString(8, user.getCity());
				statement.setString(9, user.getPincode().toString());
				statement.setString(10, user.getState());
				statement.setString(11, "India");
				return statement;
			}
		},keyHolder);
		user.setUserId(keyHolder.getKey().intValue());
		return user;
	}

	@Override
	public User signIn(User user) {
		User dBUser=null;
		final String sql = "SELECT * FROM  users WHERE email = ? AND password = ?";
		dBUser = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),user.getEmail(),user.getPassword());
		return dBUser;
	}

	@Override
	public User getUserByEmail(String email) {
		User dBUser=null;
		final String sql = "SELECT * FROM  users WHERE email = ?";
		dBUser = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),email);
		return dBUser;
	}

	
	@Override
	public UserInfo addUserProfile(final UserInfo userInfo) {
		final String sql = "INSERT INTO user_profile (course_name,course_specialization,course_year,education_type,course_marks,college,board_name_1,board_marks_1,board_year_1,board_medium_1,board_name_2,board_marks_2,board_year_2,board_medium_2,work_preference,start_time,location,company_name,start_date,end_date,project_details) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
						
						@Override
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
							statement.setString(1, userInfo.getGraduation().getName());             // values from form are converted to varchar for database usage
							statement.setString(2, userInfo.getGraduation().getSpecialization());         // insert into db
							statement.setInt(3, userInfo.getGraduation().getYearOfPassing());
							statement.setInt(4, userInfo.getGraduation().getEducationType().getValue());
							statement.setString(5, userInfo.getGraduation().getMarks());
							statement.setString(6, userInfo.getGraduation().getUniversityName());
							statement.setString(7, userInfo.getTwelfthStandard().getName());
							statement.setString(8, userInfo.getTwelfthStandard().getMarks());
							statement.setInt(9, userInfo.getTwelfthStandard().getYearOfPassing());
							statement.setString(10, userInfo.getTwelfthStandard().getBoard());
							statement.setString(11, userInfo.getTenthStandard().getName());
							statement.setString(12, userInfo.getTenthStandard().getMarks());
							statement.setInt(13, userInfo.getTenthStandard().getYearOfPassing());
							statement.setString(14, userInfo.getTenthStandard().getBoard());
							statement.setInt(15, userInfo.getWorkExperience().getPreference().getValue());
							statement.setInt(16, userInfo.getWorkExperience().getStartDate().getValue());
							statement.setString(17, userInfo.getWorkExperience().getLocation());
							statement.setString(18, userInfo.getInternship().getCompany());
							statement.setInt(19, userInfo.getInternship().getDuration_start());
							statement.setInt(20, userInfo.getInternship().getDuration_end());
							statement.setString(21, userInfo.getInternship().getDetails());
							return statement;
						}
					},keyHolder);
					userInfo.setUser_profile_id(keyHolder.getKey().intValue());
					return userInfo;
				}

	@Override
	public void updateProfile(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE user_profile set course_name= ?,course_specialization= ?,course_year= ?,education_type= ?,course_marks= ?,college,board_name_1= ?,board_marks_1= ?,board_year_1= ?,board_medium_1= ?,board_name_2= ?,board_marks_2= ?,board_year_2= ?,board_medium_2= ?,work_preference= ?,start_time= ?,location= ?,company_name= ?,start_date= ?,end_date= ?,project_details= ?";
		
	}

	@Override
	public JobInfo addJobProfile(final JobInfo jobInfo) {
		final String sql = "INSERT INTO job_profile (bio,industry,functional_area,role,work_location,job_type,employ_type,skills,marital) VALUES(?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
						
						@Override
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
							statement.setString(1, jobInfo.getBio());             // values from form are converted to varchar for database usage
							statement.setString(2, jobInfo.getIndustry());         // insert into db
							statement.setString(3, jobInfo.getFunctionalArea());
							statement.setString(4, jobInfo.getRole());
							statement.setString(5, jobInfo.getWorkLocation());
							statement.setInt(6, jobInfo.getJobType().getValue());
							statement.setInt(7, jobInfo.getEmploymentType().getValue());
							statement.setString(8, jobInfo.getSkills());
							statement.setString(9, jobInfo.getMaritalStatus());
							return statement;
						}
					},keyHolder);
					jobInfo.setJob_profile_id(keyHolder.getKey().intValue());
					return jobInfo;
				}

	
	@Override
	public void updatejob(JobInfo jobInfo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE job_profile set bio= ?,industry= ?,functional_area= ?,role= ?,work_location= ?,job_type= ?,employ_type= ?,skills= ?,marital= ?";
	}

	@Override
	public UserInfo getUserInfo(int userId) {
		// TODO Auto-generated method stub
		
		return null;
	}

}












