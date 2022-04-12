package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@CrossOrigin
	@PostMapping("/create")
	public String createStudent(@RequestBody Student student) {
		
		studentRepository.insert(student);
		return "student added successfully";
	}
	
	@CrossOrigin
	@PostMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		
		studentRepository.deleteById(id);
		return "Student deleted from the record";
	}
	
	@CrossOrigin
	@GetMapping("/list")
	public List<Student> listStudent() {
		
		return studentRepository.findAll();
	}
}
