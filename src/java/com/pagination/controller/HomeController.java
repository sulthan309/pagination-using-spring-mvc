package com.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pagination.bean.Student;
import com.pagination.service.DatabaseService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private DatabaseService service;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}
	@RequestMapping("/datafromdb/{page}")
	public String getPaginatedData(@PathVariable Integer page, Model model) {
		int total=5;
		List<Student> studentList=service.getStudentByPage(page, total);
		model.addAttribute("studentList", studentList);
		return "dbdata";
	}
}
