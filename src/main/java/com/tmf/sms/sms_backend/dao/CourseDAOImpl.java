package com.tmf.sms.sms_backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tmf.sms.sms_backend.config.DBConfig;
import com.tmf.sms.sms_backend.model.Course;

public class CourseDAOImpl implements CourseDAO{

	private boolean status;
	private Connection con = DBConfig.getDBConnection(); 
	@Override
	public boolean addCourse(Course course) {
		status = false;
		try {
			String query = "insert into course values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, course.getCid());
			ps.setString(2, course.getCname());
			ps.setInt(3, course.getDuration());
			ps.setDouble(4, course.getFee());
			ps.setString(5, course.getCurr_status());
			ps.execute();
			System.out.println("Course has been inserted in the given table..");
			status = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean updateCourse(Course course) {
		status = false;
		try {
			String query = "update course set cname=?,duration=?,fee=?,curr_status=? where cid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getDuration());
			ps.setDouble(3, course.getFee());
			ps.setString(4, course.getCurr_status());
			ps.setInt(5, course.getCid());
			
			ps.execute();
			System.out.println("Course has been inserted in the given table..");
			status = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Course getCourse(int cid) {
		Course crs = new Course();
		crs.setCid(0);
		String query = "select * from course where cid=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("Course found with given id : "+cid);
				crs.setCid(rs.getInt("cid"));
				crs.setCname(rs.getString("cname"));
				crs.setCurr_status(rs.getString("curr_status"));
				crs.setDuration(rs.getInt("duration"));
				crs.setFee(rs.getDouble("fee"));
			}
			else {
				System.out.println("Sorry!... No course is present with the given id : "+cid);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return crs;
	}

	@Override
	public Course getCourse(String cname) {
		Course crs = new Course();
		crs.setCid(0);
		String query = "select * from course where cname=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("Course found with given name : "+cname);
				crs.setCid(rs.getInt("cid"));
				crs.setCname(rs.getString("cname"));
				crs.setCurr_status(rs.getString("curr_status"));
				crs.setDuration(rs.getInt("duration"));
				crs.setFee(rs.getDouble("fee"));
			}
			else {
				System.out.println("Sorry!... No course is present with the given name : "+cname);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return crs;
	}

	@Override
	public List<Course> getCourse() {
		List<Course> courses = new ArrayList<Course>();
		try {
			String query = "select * from course";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Course crs = new Course();
				crs.setCid(rs.getInt("cid"));
				crs.setCname(rs.getString("cname"));
				crs.setCurr_status(rs.getString("curr_status"));
				crs.setDuration(rs.getInt("duration"));
				crs.setFee(rs.getDouble("fee"));
				
				//Add the object to the list
				courses.add(crs);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public boolean deleteCourse(Course course) {
		status = false;
		try {
			String query = "update course set values curr_status='invalid' where cid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, course.getCurr_status());
			ps.setInt(2, course.getCid());
			
			ps.execute();
			System.out.println("Course has been inserted in the given table..");
			status = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	
}












