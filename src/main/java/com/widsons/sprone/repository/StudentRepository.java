package com.widsons.sprone.repository;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.widsons.sprone.domain.Student;

@Repository
public class StudentRepository extends AbstractDao<Long, Student>{
	
	public List<Student> findByName(String name){
		return (List<Student>) createEntityCriteria().add(Restrictions.like("name", name)).list();
	}
	
}
