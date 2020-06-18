package com.flipkart.rest;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

@Path("/user")
public class UserRestController {
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<User> getUserDetails()
	{
		AdminInterface adminOperation = new AdminOperation();
		return adminOperation.viewAllStudents();
	}
	
	
//	@POST
//	@Path("/post")
//	@Consumes("application/json")
//	@Produces(MediaType.APPLICATION_JSON)
//	
//	public Response CreateTrack(Course course)
//	{
//		System.out.println("Hit Post Service");
//		
//		System.out.println("Course Id "+ course.getCourseid());
//		System.out.println("Course Name "+ course.getCoursename());
//		//System.out.println("Course Fee "+ course.getFee());
//		
//		AdminInterface adminOperation = new AdminOperation();
//		adminOperation.addCourse(course);
//		
//		String result = "Track Saved: " + course;
//		
//		return Response.status(201).entity(result).build();
//	}

	@DELETE
	@Path("/delete/{courseid}")
	public Response deleteCustomer(@PathParam("courseid") int courseid) {
		AdminInterface adminOperation = new AdminOperation();
		adminOperation.deleteCourse(courseid);
		return Response.status(200).entity("Track id "+ courseid + "succesfully deleted").build();
	}
	
//	@PUT
//	@Path("/update")
//	@Consumes("application/json")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Course updateCustomer(@PathParam("courseid") int courseid) {
//		AdminInterface adminOperation = new AdminOperation();
//		adminOperation.editCourse(courseid);
//		
//	}
	
}




