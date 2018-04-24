package com.oosdclass.taskTrackerApp2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oosdclass.taskTrackerApp2.dao.UserDAO;
import com.oosdclass.taskTrackerApp2.model.User;

//Spring Framework: this is a data access layer
@Repository
public class UserDAOImpl implements UserDAO {
	//Spring JDBC: data access
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//go grab the user info from the database
	@Override
	public User retrieveByUserName(String username) {
		try {
			String sql = "select * from user where username=?";
			User user = (User) jdbcTemplate.queryForObject(sql, new Object[] { username }, new RowMapper<User>() {
				//create a user object
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					return user;
				}
			});
			return user;
		//THROW AN EXCEPTION
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
}