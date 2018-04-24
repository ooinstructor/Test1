package com.oosdclass.taskTrackerApp2.dao;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskDAO {
	//To display all the tasks in the table
	public List<Task> retrieveAllTasks();
	//To display just one task in the table - used for employees' update task
	public Task retrieveByTaskID(int taskID);
	//Create a new task (admin)
	public void saveTask(Task task);
	//Update status or assigned to (employees)
	//we use two methods - one for assigned to, one for status - in the controller and service
	//here, we only need one method
	public void updateTask(Task task);
	//Admin can delete a specific task from the adminTasks view page 
	public void deleteTask(int taskID);
	}