package com.oosdclass.taskTrackerApp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.User;
import com.oosdclass.taskTrackerApp2.service.UserService;
//Spring Framework: this is a controller class; UI layer
@Controller
public class UserController {
	
	//DI/IOC: Autowire the service layer to the UI layer
	@Autowired
	UserService userService;
	
	//GET: display user form
	@RequestMapping(value = "/")
	public ModelAndView login(ModelAndView model) {
		User user = new User();
		model.addObject(user);
		model.setViewName("home");
		return model;
	}
	//POST: post user info
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(User userLoginFormObject) {
		ModelAndView model = null;
		//First Check: Does the user exist?
		if(!userService.doesUserExist(userLoginFormObject)) {
			model = new ModelAndView("home");
			model.addObject("error", "Username does not exist");
		//Second Check: Is the password correct?
		} else if(!userService.isUserValid(userLoginFormObject)) {
			model = new ModelAndView("home");
			model.addObject("error", "User input is not valid");
		//Third Check: Is the user an admin?
		} else if(userService.isUserAdmin(userLoginFormObject)){
			model = new ModelAndView("redirect:/adminTasks");
		//Passed all the checks, send to employee task page
		} else {
			model = new ModelAndView("redirect:/empTasks/" + userLoginFormObject.getUsername());
		}
		//And then, depending on which conditions were met, display that specified model
		return model;
	}
}