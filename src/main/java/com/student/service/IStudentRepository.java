package com.student.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByClass(String studentClass);
	
}
