package org.sid.dao;

import java.util.List;

import org.sid.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByScore(int score);
	

}
