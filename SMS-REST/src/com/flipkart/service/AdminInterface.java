package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface AdminInterface {
  
//	public void addUser();
  public void deleteUser(int userId);
//	public void editUser(int userId);
	public void addCourse();
//	public void deleteCourse(int courseId);
//	public void editCourse(int courseId);
	public List<User> viewAllStudents();
	public void deleteCourse(int courseid);
	
}
