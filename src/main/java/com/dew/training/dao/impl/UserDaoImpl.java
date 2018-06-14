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
import com.dew.training.dto.User;
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

}
