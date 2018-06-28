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
import com.dew.training.dto.College;
import com.dew.training.dto.Internship;
import com.dew.training.dto.JobInfo;
import com.dew.training.dto.Schooling;
import com.dew.training.dto.User;
import com.dew.training.dto.UserInfo;
import com.dew.training.dto.Work;
import com.dew.training.enums.Gender;
import com.dew.training.enums.JobType;
import com.dew.training.enums.Preference;
import com.dew.training.enums.Start;
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
			user.setPassword(rs.getString("Password"));
			return user;
			
		}
		
	}
		
	private class UserInfoRowMapper implements RowMapper<UserInfo>{
		public UserInfo mapRow(ResultSet rs,int rowNum)throws SQLException{
			UserInfo userInfo=new UserInfo();
			
			userInfo.setUser_id(rs.getInt("user_id"));
			userInfo.setUser_profile_id(rs.getInt("user_profile_id"));
			
			College college = new College();
			college.setName(rs.getString("course_name"));
			college.setSpecialization(rs.getString("course_specialization"));
			college.setYearOfPassing(rs.getInt("course_year"));
			college.setEducationType(rs.getString("education_type"));
			college.setMarks(rs.getString("course_marks"));
			college.setUniversityName(rs.getString("college"));
			userInfo.setGraduation(college);
			
			Schooling twelfth=new Schooling();
			twelfth.setName(rs.getString("board_name_1"));
			twelfth.setMarks(rs.getString("board_marks_1"));
			twelfth.setYearOfPassing(rs.getInt("board_year_1"));
			twelfth.setBoard(rs.getString("board_medium_1"));
			userInfo.setTwelfthStandard(twelfth);
			
			Schooling tenth=new Schooling();
			tenth.setName(rs.getString("board_name_2"));
			tenth.setMarks(rs.getString("board_marks_2"));
			tenth.setYearOfPassing(rs.getInt("board_year_2"));
			tenth.setBoard(rs.getString("board_medium_2"));
			userInfo.setTenthStandard(tenth);
			
			Work work=new Work();
			work.setPreference(Preference.get(rs.getInt("work_preference")));
			work.setStartDate(Start.get(rs.getInt("start_time")));
			work.setLocation(rs.getString("location"));
			userInfo.setWorkExperience(work);
			
			Internship internship=new Internship();
			internship.setCompany(rs.getString("company_name"));
			internship.setDuration_start(rs.getString("start_date"));
			internship.setDuration_end(rs.getString("end_date"));
			internship.setDetails(rs.getString("project_details"));
			userInfo.setInternship(internship);
				
			return userInfo;
		}
		
	}
	
	private class JobInfoRowMapper implements RowMapper<JobInfo>{
		public JobInfo mapRow(ResultSet rs,int rowNum)throws SQLException{
			JobInfo jobInfo=new JobInfo();
			
			jobInfo.setUser_id(rs.getInt("user_id"));
			jobInfo.setJob_profile_id(rs.getInt("job_profile_id"));
			jobInfo.setBio(rs.getString("bio"));
			jobInfo.setIndustry(rs.getString("industry"));
			jobInfo.setFunctionalArea(rs.getString("functional_area"));
			jobInfo.setRole(rs.getString("role"));
			jobInfo.setWorkLocation(rs.getString("work_location"));
			jobInfo.setJobType(JobType.get(rs.getInt("job_type")));
			jobInfo.setEmploymentType(Preference.get(rs.getInt("employ_type")));
			jobInfo.setSkills(rs.getString("skills"));
			jobInfo.setMaritalStatus(rs.getString("marital"));
			
			return jobInfo;
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
	public void getPassword(String password) {
		User dBUser=null;
		final String sql= "Select FROM users WHERE email = ?";
		//dBUser = getJdbcTemplate().getDataSource(sql, password) ;
	
	}
	
	@Override
	public UserInfo addUserProfile(final UserInfo userInfo) {
		final String sql = "INSERT INTO user_profile (course_name,course_specialization,course_year,education_type,"
				+ "course_marks,college,board_name_1,board_marks_1,board_year_1,board_medium_1,board_name_2,board_marks_2,"
				+ "board_year_2,board_medium_2,work_preference,start_time,location,company_name,start_date,end_date,project_details,user_id)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
						
						@Override
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
							statement.setString(1, userInfo.getGraduation().getName());             // values from form are converted to varchar for database usage
							statement.setString(2, userInfo.getGraduation().getSpecialization());         // insert into db
							statement.setInt(3, userInfo.getGraduation().getYearOfPassing());
							statement.setString(4, userInfo.getGraduation().getEducationType());
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
							statement.setString(19, userInfo.getInternship().getDuration_start());
							statement.setString(20, userInfo.getInternship().getDuration_end());
							statement.setString(21, userInfo.getInternship().getDetails());
							statement.setInt(22, 1);
							return statement;
						}
					},keyHolder);
					userInfo.setUser_profile_id(keyHolder.getKey().intValue());
					return userInfo;
				}

	@Override
	public void updateProfile(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE user_profile set course_name= ?,course_specialization= ?,course_year= ?,education_type= ?,course_marks= ?,"
				+ "college= ?,board_name_1= ?,board_marks_1= ?,board_year_1= ?,board_medium_1= ?,board_name_2= ?,board_marks_2= ?,"
				+ "board_year_2= ?,board_medium_2= ?,work_preference= ?,start_time= ?,location= ?,company_name= ?,start_date= ?,end_date= ?,"
				+ "project_details= ? WHERE user_profile_id= ?";
		getJdbcTemplate().update(sql,userInfo.getGraduation().getName(),userInfo.getGraduation().getSpecialization(),userInfo.getGraduation().getYearOfPassing(),
				userInfo.getGraduation().getEducationType(),userInfo.getGraduation().getMarks(),userInfo.getGraduation().getUniversityName(),
				userInfo.getTwelfthStandard().getName(),userInfo.getTwelfthStandard().getMarks(),userInfo.getTwelfthStandard().getYearOfPassing(),
				userInfo.getTwelfthStandard().getBoard(),userInfo.getTenthStandard().getName(),userInfo.getTenthStandard().getMarks(),
				userInfo.getTenthStandard().getYearOfPassing(),userInfo.getTenthStandard().getBoard(),userInfo.getWorkExperience().getPreference().getValue(),
				userInfo.getWorkExperience().getStartDate().getValue(), userInfo.getWorkExperience().getLocation(),userInfo.getInternship().getCompany(),
				userInfo.getInternship().getDuration_start(),userInfo.getInternship().getDuration_end(),userInfo.getInternship().getDetails(),
				userInfo.getUser_profile_id());
		
	}

	@Override
	public JobInfo addJobProfile(final JobInfo jobInfo) {
		final String sql = "INSERT INTO job_profile (bio,industry,functional_area,role,work_location,job_type,employ_type,skills,marital,user_id)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
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
							statement.setInt(10,1);
							return statement;
						}
					},keyHolder);
					jobInfo.setJob_profile_id(keyHolder.getKey().intValue());
					return jobInfo;
				}

	
	@Override
	public void updatejob(JobInfo jobInfo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE job_profile set bio= ?,industry= ?,functional_area= ?,role= ?,work_location= ?,job_type= ?,employ_type= ?,"
				+ "skills= ?,marital= ? WHERE job_profile_id = ?";
		getJdbcTemplate().update(sql,jobInfo.getBio(),jobInfo.getIndustry(),jobInfo.getFunctionalArea(),jobInfo.getRole(),
				jobInfo.getWorkLocation(), jobInfo.getJobType().getValue(), jobInfo.getEmploymentType().getValue(), jobInfo.getSkills(),jobInfo.getMaritalStatus(),
				jobInfo.getJob_profile_id());
	}

	@Override
	public UserInfo getUserInfo(int userId) {
		// TODO Auto-generated method stub
		UserInfo dBUser=null;
		final String sql = "SELECT * FROM  user_profile WHERE user_id= ? ";
		dBUser = getJdbcTemplate().queryForObject(sql, new UserInfoRowMapper(),userId);
		return dBUser;
	}

	@Override
	public JobInfo getJobInfo(int userId) {
		// TODO Auto-generated method stub
		JobInfo dBUser=null;
		final String sql = "SELECT * FROM  job_profile WHERE user_id= ? ";
		dBUser = getJdbcTemplate().queryForObject(sql, new JobInfoRowMapper(),userId);
		return dBUser;
	}

}












