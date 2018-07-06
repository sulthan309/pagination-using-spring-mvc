package com.pagination.service;

import java.util.List;

import com.pagination.bean.Student;

public interface DatabaseService {
	public List<Student> getStudentByPage(int pageId,int total);
}
