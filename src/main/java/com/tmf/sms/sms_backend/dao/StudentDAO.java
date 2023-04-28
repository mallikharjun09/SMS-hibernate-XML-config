package com.tmf.sms.sms_backend.dao;

import java.util.List;

record Student(int studentId,String studentName,String gender,String qualification,String email, long phoneNumber) {}

public interface StudentDAO {
	boolean addStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(Student student);
	Student getStudent(int studentId);
	List<Student> getStudent();
}
