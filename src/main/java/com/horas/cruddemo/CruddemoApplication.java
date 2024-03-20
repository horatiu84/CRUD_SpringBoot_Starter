package com.horas.cruddemo;

import com.horas.cruddemo.dao.StudentDAO;
import com.horas.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//System.out.println("Hello World");

			// create one student
			  //createStudent(studentDAO);

			// create multiple students
			 // createMultipleStudents(studentDAO);

			// read student
			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByFirstName(studentDAO);

			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id:  " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby
		System.out.println("Updating the student ...");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByFirstName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByFirstName("Paul");

		//display list of students
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Donald","Duck","donald@duck.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrive the student based on the id
		System.out.println("Retriving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display the student
		System.out.println("Found my student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 new student object ... ");
		Student tempStudent1 = new Student("John","Evu","jhon@paiu.com");
		Student tempStudent2 = new Student("Bob","Evu","bob@paiu.com");
		Student tempStudent3 = new Student("Mary","Evu","mary@paiu.com");


		// save the studentes objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Paul","Evu","paiam@paiu.com");


		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Save student. GEnerated id : " + tempStudent.getId());
	}

}
