package com.widsons.sprone.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.widsons.sprone.domain.Student;
import com.widsons.sprone.service.StudentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	StudentService studetnService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("name", "fahmi");
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model){
		Student student = new Student();
		student.setName("fahmi");
		student.setAddress("Malang");
		student.setAge(21);
		this.studetnService.save(student);
		model.addAttribute("name", "youre success insert data test");
		return "home";
	}
	
}
