package com.student.service;

import java.util.List;
import java.util.Optional;


import com.student.model.Student;



	public interface IStudentService {
		Integer saveStudent(Student student);
		public List<Student> getAllStudents();
		Optional<Student> getStudent(Integer id);
		public void deleteStudent(Integer id);
		public void  deleteAllStudents();
		Student updateStudent(Student student , Integer id);
     	List<Student> getStudent(String studentClass);
		
}
