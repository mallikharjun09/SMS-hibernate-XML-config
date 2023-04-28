package com.tmf.sms.sms_backend.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.tmf.sms.sms_backend.dao.CourseDAO;
import com.tmf.sms.sms_backend.dao.CourseDAOImpl;
import com.tmf.sms.sms_backend.model.Course;

public class ServiceImplementation implements CourseServices{

	private CourseDAO dao;
	private BufferedReader reader;
	private InputStreamReader isr;
	
	public ServiceImplementation(){
		try {
			dao = new CourseDAOImpl();
			isr = new InputStreamReader(System.in);
			reader = new BufferedReader(isr);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	@Override
	public boolean addCourse() {
		boolean result=false;
		try {
			System.out.println("Enter the Course Id ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Enter the Course Name ");
			String name = reader.readLine();
			System.out.println("Enter the Duration of the Course ");
			int duration = Integer.parseInt(reader.readLine());
			System.out.println("Enter the Fee of the Course");
			double fee = Double.parseDouble(reader.readLine());
			String curr_status="Valid";
			
			Course course = new Course(id,name,duration,curr_status,fee);
			dao.addCourse(course);
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean updateCourse() {
		boolean result=false;
		try {
			System.out.println("Enter the Course Id ");
			int id = Integer.parseInt(reader.readLine());
			Course course = dao.getCourse(id);
			if(course.getCid() != 0) {
				System.out.println("Enter the Course Name ");
				String name = reader.readLine();
				System.out.println("Enter the Duration of the Course ");
				int duration = Integer.parseInt(reader.readLine());
				System.out.println("Enter the Fee of the Course");
				double fee = Double.parseDouble(reader.readLine());
				String curr_status="Valid";
				course = new Course(id,name,duration,curr_status,fee);
				
				dao.updateCourse(course);
				result=true;
			}
			else {
				System.out.println("Sorry Course has not present..");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public void getCourse(int cid) {
		System.out.println(dao.getCourse(cid));
	}

	@Override
	public void getCourse(String cname) {
		System.out.println(dao.getCourse(cname));
	}

	@Override
	public void getCourse() {
		List<Course> courses = dao.getCourse();
		for(Course crs : courses) {
			System.out.println(crs);
		}
	}

	@Override
	public boolean deleteCourse() {
		boolean result=false;
		try {
			System.out.println("Enter the Course Id ");
			int id = Integer.parseInt(reader.readLine());
			Course course = dao.getCourse(id);
			if(course.getCid() != 0) {
				System.out.println("Course Deleted Successfully..");
				String curr_status="Invalid";
				course.setCurr_status(curr_status);
				dao.updateCourse(course);
				result=true;
			}
			else {
				System.out.println("Sorry Course has not present..");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public void menu() {
		try {
			while(true) {
				System.out.println("Welcome to Student Monitoring System.....");
				System.out.println("-----------------------------------------");
				System.out.println("\tPress 1 for Add New Course");
				System.out.println("\tPress 2 for Display All Courses");
				System.out.println("\tPress 3 for Update a Course Details");
				System.out.println("\tPress 4 for Display Course By Id");
				System.out.println("\tPress 5 for Display Course By name");
				System.out.println("\tPress 6 for Delete a Course");
				System.out.println("\tPress 9 for Exit...");
				System.out.println("\n\tChoose one of these options...");
				int choice = Integer.parseInt(reader.readLine());
				switch(choice) {
				case 1 : addCourse();break;
				case 2 : getCourse();break;
				case 3 : updateCourse();break;
				case 4 : System.out.println("Enter the Course Id ");
						  int id = Integer.parseInt(reader.readLine());
						  getCourse(id);
						  break;
				case 5 : System.out.println("Enter the Course Name ");
						  String name = reader.readLine();
						  getCourse(name);
						  break;
				case 6 : deleteCourse();break;
				case 9 : System.exit(choice);
				default : System.out.println("Sorry you have entered a Wrong choice..");
				          System.out.println("Press enter to get back to the menu");
				          reader.readLine();
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
