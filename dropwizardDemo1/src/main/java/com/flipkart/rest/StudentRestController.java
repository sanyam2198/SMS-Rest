// Student Rest Controller class for students to perform view, add, drop courses. Also to view report cards.

package com.flipkart.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.Registration;
import com.flipkart.service.StudentOperation;


@Path("/student")
public class StudentRestController {
StudentOperation studentOperation = new StudentOperation();

//Method to get all the courses from catalog. Uses GET.

@GET
@Path("/catalog")
@Produces(MediaType.APPLICATION_JSON)

public List<Course> getCourseList (){

List<Course> courseList=studentOperation.requestCatalog();
return courseList;
}


//Method to add the course by a student. Uses POST.

@POST
@Path("/addCourse/{courseId}/{userId}")
@Consumes("application/json")
@Produces(MediaType.APPLICATION_JSON)

public Response addCourse
(@PathParam("courseId") int courseId, @PathParam("userId") int userId)
{
	
studentOperation.addCourse(courseId,userId);
String result="Course Id: " + courseId + " added.";

return  Response.
		status(201).
		entity(result).
		build();

}


// Method to drop the course by a student. Uses DELETE.

@DELETE
@Path("/dropCourse/{courseId}/{userId}")

public Response dropCourse
(@PathParam("courseId") int courseId, @PathParam("userId") int userId) 
{

studentOperation.dropCourse(courseId,userId);

String result="Course Id: " + courseId + " dropped.";
return Response.
		status(200).
		entity(result).
		build();
}




@GET
@Path("/reportCard/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public Map<Integer, String> viewGrades (@PathParam("userId") int userId){

return studentOperation.viewGrades(userId);

}
}



