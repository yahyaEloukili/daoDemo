package org.sid;

import java.util.Date;
import java.util.List;

import org.sid.dao.StudentRepository;
import org.sid.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ScolariteApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
	SpringApplication.run(ScolariteApplication.class, args);
     }
	
	
	@Override
	public void run(String... args) throws Exception {
		studentRepository.save(new Student(null,"eloukili","yahya",new Date(),12));
		studentRepository.save(new Student(null,"naciri","anas",new Date(),10));
		studentRepository.save(new Student(null,"wasim","elghali",new Date(),14));
		
		studentRepository.findAll().forEach(et->{
			System.out.println(et.getNom());
		});
		Student student = studentRepository.findById(1L).get();
		System.out.println("student with id one "+student.getNom());
		List<Student> students = studentRepository.findByScore(12);
		students.forEach(st->{
			System.out.println("student with score 12 "+student.getNom());
		});
		}

}
