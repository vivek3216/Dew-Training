package com.dew.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public abstract class JDBCDaoSupport {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public final JdbcTemplate getJdbcTemplate() {
		if(jdbcTemplate==null)
			jdbcTemplate= new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
}
