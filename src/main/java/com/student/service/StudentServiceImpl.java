package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;
import com.student.service.IStudentRepository;
import com.student.service.IStudentService;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Integer saveStudent(Student student) {
		// TODO Auto-generated method stub
		Student savedStudent = studentRepository.save(student);
		
		return savedStudent.getId() ;
	}
	@Override
	public List<Student> getAllStudents()
	{
	return studentRepository.findAll();
	}
	@Override
	public Optional<Student> getStudent(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}
	@Override
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		
	}
	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		studentRepository.deleteAll();
		
	}
	@Override
	public Student updateStudent(Student student , Integer id)
	{
		Student existingStudent = studentRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Student", "Id", id));
				existingStudent.setFirstname(student.getFirstname());
				existingStudent.setLastname(student.getLastname());
				existingStudent.setStudentClass(student.getStudentClass());
				existingStudent.setDateOfBirth(student.getDateOfBirth());
				existingStudent.setSubject(student.getSubject());
		
		studentRepository.save(existingStudent);
		return existingStudent;
	}
	@Override
	public List<Student> getStudent(String studentClass) {
		return studentRepository.findByClass(studentClass);
	} 
	}

	

