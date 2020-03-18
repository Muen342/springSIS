package com.springsis.controller;
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.springsis.model.Attendance;
import com.springsis.model.Course;
import com.springsis.model.Student;
import com.springsis.dao.AttendanceDao;
import com.springsis.dao.CourseDao;
import com.springsis.dao.StudentDAO;

public class AttendanceController {

	@Autowired    
    AttendanceDao attendance_dao;
	CourseDao course_dao;
	StudentDAO dao;
	
//	@RequestMapping(value="/editattendance/{id}")
//    public String editattendance(@PathVariable int id, Model m)  {
//    	Course course = course_dao.getCourseById(id);
//    	System.out.println("COURSES: " + course.getStudents());
//    	m.addAttribute("course", course);
//    	return "editattendance";
//    }
}
