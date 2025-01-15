package com.admin.service;

import java.util.List;

import com.admin.model.Student;

public interface StudentService {

	List<Student> getAllStudent();
	
	Student getStudentById(int id);
	
	Student saveStudent(Student student);
	
	void deleteStudent(int id);
}
