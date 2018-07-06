package com.pagination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagination.bean.Student;
import com.pagination.dao.StudentDao;

@Service
public class DatabaseServiceImpl implements DatabaseService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getStudentByPage(int pageId, int total) {
		return studentDao.getStudentByPage(pageId, total);
	}

	

}
