package com.pagination.dao;

import java.util.List;

import com.pagination.bean.Student;

public interface StudentDao {
	public List<Student> getStudentByPage(int pageId,int total);
}
