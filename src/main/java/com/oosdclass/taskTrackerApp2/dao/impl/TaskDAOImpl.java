package com.oosdclass.taskTrackerApp2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oosdclass.taskTrackerApp2.dao.TaskDAO;
import com.oosdclass.taskTrackerApp2.model.Task;

//Spring Framework: this is a data access layer
@Repository
public class TaskDAOImpl implements TaskDAO {
	//Spring JDBC: data access
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//we use this method to display all tasks in a table
	@Override
	public List<Task> retrieveAllTasks() {
		try {
			//in MySQL, select everything in the row of that task
			String sql = "select * from task";
			List<Task> tasklist = jdbcTemplate.query(sql, new ResultSetExtractor<List<Task>>() {
				@Override
				public List<Task> extractData(ResultSet rs) throws SQLException, DataAccessException {
					//creates list of tasks/array of all task objects (to display all tasks)
					List<Task> list = new ArrayList<Task>();
					while (rs.next()) {
						Task task = new Task();
						task.setTaskID(rs.getInt(1));
						task.setDescription(rs.getString(2));
						task.setAssignedTo(rs.getString(3));
						task.setStatus(rs.getString(4));
						list.add(task);
					}
					return list;
				}
			});
		return tasklist;
		//THROW AN EXCEPTION
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
	//Get ONE task at a time (by taskID)
	@Override
	public Task retrieveByTaskID(int taskID) {
		try {
			String sql = "select * from task where taskId=?";
			Task task = (Task) jdbcTemplate.queryForObject(sql, new Object[] { taskID }, new RowMapper<Task>() {
				@Override
				public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
					//create a new task object (and set the attributes) with the data in each column
					Task task = new Task();
					task.setTaskID(rs.getInt(1));
					task.setDescription(rs.getString(2));
					task.setAssignedTo(rs.getString(3));
					task.setStatus(rs.getString(4));
					return task;
				}
			});
			return task;
			//THROW AN EXCEPTION
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
	//Admin only: create a new task/save new task to database
	@Override
	public void saveTask(Task task) {
		String sql = "Insert into task" +
				"(description, assignedTo, status) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {task.getDescription(),
				task.getAssignedTo(), task.getStatus()
		});
	}
	//Allows the employee to update task STATUS and ASSIGNED TO
	//we use two methods - one for assigned to, one for status - in the controller and service
	//here, we only need one method
	@Override
	public void updateTask(Task task) {
		String sql = "Update task SET assignedTo =?, status = ? where taskId=?";
		jdbcTemplate.update(sql, new Object[] { task.getAssignedTo(), task.getStatus(), task.getTaskID() });
	}
	//Admin can delete a specific task from the adminTasks view page 
	@Override
	public void deleteTask(int taskID) {
		String sql = "DELETE from task where taskID = ?";
		jdbcTemplate.update(sql, new Object[] {taskID});
	}
}