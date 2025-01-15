package com.admin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Student;
import com.admin.repository.StudentRepository;
import com.admin.service.StudentService;

//service annotation used for object creation,life cycle maintain purpose and bussiness logic means find data,delete data,update data etc..

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		
	    Student student = studentRepository.findById(id).orElse(null);
		return student;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
		
	}

}
