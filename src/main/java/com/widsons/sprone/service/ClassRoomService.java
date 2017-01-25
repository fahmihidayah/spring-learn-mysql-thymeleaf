package com.widsons.sprone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widsons.sprone.domain.ClassRoom;
import com.widsons.sprone.repository.ClassRoomRepository;

@Service
@Transactional
public class ClassRoomService {

	@Autowired
	ClassRoomRepository classRoomRepository;
	
	public void save(ClassRoom classRoom){
		classRoomRepository.save(classRoom);
	}
	
	public void update(ClassRoom classRoom){
		ClassRoom oldClassRoom = classRoomRepository.findById(classRoom.getId());
		if(oldClassRoom != null){
			oldClassRoom.setName(classRoom.getName());
			oldClassRoom.setDescription(classRoom.getDescription());
			classRoomRepository.save(oldClassRoom);			
		}
	}
	
	public void delete(ClassRoom classRoom){
		classRoomRepository.delete(classRoom);
	}
	
	public void delete(long id){
		classRoomRepository.delete(id);
	}
	
	public List<ClassRoom> findAll(){
		return classRoomRepository.findAll();
	}
}
