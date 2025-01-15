package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.StudentDTO;
import com.admin.model.Student;
import com.admin.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> showStudent(){
		List<Student> std	= studentService.getAllStudent();
		return new ResponseEntity<>(std,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id){
		Student student = studentService.getStudentById(id);
		
		if(student==null) {
			return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Student> saveStudentObject(@RequestBody StudentDTO studentDTO){
		 
		Student existingstudent = new Student();
		existingstudent.setFirstName(studentDTO.getFirstName());
		existingstudent.setLastName(studentDTO.getLastName());
		existingstudent.setMarks(studentDTO.getMarks());
		existingstudent.setContact(studentDTO.getContact());
		existingstudent.setStandard(studentDTO.getStandard());
		
		Student updatedStudent = studentService.saveStudent(existingstudent);
		return new ResponseEntity<>(updatedStudent,HttpStatus.CREATED);
		
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,@RequestBody StudentDTO studentDTO){
		
		Student existingstudent = studentService.getStudentById(id);
		if(existingstudent==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		existingstudent.setFirstName(studentDTO.getFirstName());
		existingstudent.setLastName(studentDTO.getLastName());
		existingstudent.setMarks(studentDTO.getMarks());
		existingstudent.setContact(studentDTO.getContact());
		existingstudent.setStandard(studentDTO.getStandard());
		
		Student updatedstudent = studentService.saveStudent(existingstudent);
		return new ResponseEntity<>(updatedstudent,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable("id") int id){
		
		Student student = studentService.getStudentById(id);
		if(student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}
