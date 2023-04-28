package com.tmf.sms.sms_backend.services;

import java.util.List;

import com.tmf.sms.sms_backend.model.Course;

public interface CourseServices {
	boolean addCourse();
	boolean updateCourse();
	void getCourse(int cid);
	void getCourse(String cname);
	void getCourse();
	boolean deleteCourse();
	void menu();
}
