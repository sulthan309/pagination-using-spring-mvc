package com.pagination.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pagination.bean.Student;

//@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private HibernateTemplate template;
	@Override
	public List<Student> getStudentByPage(int pageId, int total) {
		int start=(pageId-1)*total;
		int end=pageId*total;
		List<Student> studentList=template.loadAll(Student.class);
		return studentList.subList(start, end<studentList.size()?end:studentList.size());
	}
	
	
	
	
}
