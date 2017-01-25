package com.widsons.sprone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widsons.sprone.domain.ClassRoom;
import com.widsons.sprone.domain.Student;
import com.widsons.sprone.repository.ClassRoomRepository;
import com.widsons.sprone.repository.StudentRepository;


@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	
	public Student findById(long id){
		return studentRepository.findById(id);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public List<Student> findByName(String name){
		return studentRepository.findByName(name);
	}
	
	public void delete(Student student){
		studentRepository.delete(student);
	}
	
	public void deleteById(long id){
		studentRepository.delete(id);
	}
	
	public void save(Student student){
		studentRepository.save(student);
	}
	
	public void update(Student student){
		Student studentOld = findById(student.getId());
		if(studentOld != null){
			studentOld.setName(student.getName());
			studentOld.setAddress(student.getAddress());
			studentOld.setAge(student.getAge());
		}
	}
	
	public void addStudentToClas(long studentId, long classRoomId){
		ClassRoom classRoom = classRoomRepository.findById(classRoomId);
		Student student = studentRepository.findById(studentId);
		classRoom.getStudents().add(student);
	}
}
