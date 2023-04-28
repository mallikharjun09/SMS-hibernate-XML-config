package com.tmf.sms.sms_backend.dao;

import java.util.List;

import com.tmf.sms.sms_backend.model.Course;

public interface CourseDAO {
	public boolean addCourse(Course course);
	public boolean updateCourse(Course course);
	public Course getCourse(int cid);
	public Course getCourse(String cname);
	public List<Course> getCourse();
	public boolean deleteCourse(Course course);
}
