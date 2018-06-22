package com.dew.training.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.dew.training.dao.JDBCDaoSupport;

public class ApplicationProperties extends JDBCDaoSupport{

	private class ApplicationProperty {

		private String name;
		private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	private static Map<String, String> properties = new HashMap<String, String>();
	
	public void init() {
		// load all properties
		List<ApplicationProperty> allPropertiesFromDb = getJdbcTemplate().query("SELECT property_name, property_value FROM application_properties", new RowMapper<ApplicationProperty>() {
			@Override
			public ApplicationProperty mapRow(ResultSet rs, int rowNum) throws SQLException {
				ApplicationProperty applicationProperty = new ApplicationProperty();
				applicationProperty.setName(rs.getString("property_name"));
				applicationProperty.setValue(rs.getString("property_value"));
				
				return applicationProperty;
			}
		});
		for (ApplicationProperty applicationProperty : allPropertiesFromDb) {
			properties.put(applicationProperty.getName(), applicationProperty.getValue());
		}
		
	}

	public static String getProperty(final String propertyName) {
		String propertyValue = properties.get(propertyName);
		
		return propertyValue;
	}

	public static Map<String, String> getAllProperties(){
		
		return new HashMap<String, String>(properties);
		
	}
	public static void setProperty(String propertyName,String propertyValue){
		properties.put(propertyName, propertyValue);
	}
	public static boolean isProduction() {
		return "prod".equalsIgnoreCase(System.getProperty("env"));
	}

	public static boolean isQA() {
		return "qa".equalsIgnoreCase(System.getProperty("env"));
	}

	public static boolean isDevelopment() {
		return "dev".equalsIgnoreCase(System.getProperty("env"));
	}


}
