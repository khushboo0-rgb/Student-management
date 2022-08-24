package com.student.controller;

import java.util.List;
import java.util.Optional;

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


import com.student.model.Student;
import com.student.service.IStudentService;
@RestController
public class StudentController {

	@Autowired
	IStudentService studentService;
	
 
 
 @PostMapping("/saveStudent")
 Integer createStudent(@RequestBody Student student)
 {
	 Integer id = studentService.saveStudent(student);
	 System.out.println(id);
	return id;
 }
 @GetMapping("/allstudents")
 public List<Student> getStudent()
 {
	 return studentService.getAllStudents();
 }
 @GetMapping("/getstudent/{id}")
 public Optional<Student> getStudent(@PathVariable Integer id)
 {
	 Optional<Student> student = studentService.getStudent(id);
	 return student;
 }
 @DeleteMapping("/student/{id}")
 public ResponseEntity<Student> deleteStudent(@PathVariable Integer id)
 {
	 System.out.println(id);
	 	ResponseEntity<Student> responseEntity = new ResponseEntity<>(HttpStatus.OK);
	 	try
	 	{
	 		studentService.deleteStudent(id);
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 		responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 	}
	 	return responseEntity;
	 	
 }	
 @DeleteMapping("/allstudent")
 public ResponseEntity<Student> deleteAllStudent()
 {
	
	 	ResponseEntity<Student> responseEntity = new ResponseEntity<>(HttpStatus.OK);
	 	try
	 	{
	 		studentService.deleteAllStudents();;
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 		responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 	}
	 	return responseEntity;
	 	
 }
	 	
 
 @PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id , @RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
 
 @GetMapping("/getstudentByClass/{studentClass}")
 public List<Student> getStudentByClass(@PathVariable String studentClass)
 {
	 List<Student> student = studentService.getStudent(studentClass);
	 System.out.print("khushboo");
	 System.out.print(student);
	 return student;
 }
}


