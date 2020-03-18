package com.springsis.controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.springsis.model.Course;
import com.springsis.dao.CourseDao;
import com.springsis.model.Attendance;
import com.springsis.dao.AttendanceDao;
import com.springsis.model.Student;  
import com.springsis.dao.StudentDAO;

@Controller
public class CourseController {
	
	@Autowired    
    CourseDao course_dao;//will inject dao from XML file  
	StudentDAO dao = new StudentDAO();
	AttendanceDao attendance_dao = new AttendanceDao();
         
    @RequestMapping("/courseform")    
    public String showform(Model m){    
        m.addAttribute("command", new Course());  
        return "courseform";   
    }    


    @RequestMapping(value="/savecourse",method = RequestMethod.POST)    
    public String savecourse(@ModelAttribute("course") Course course){    
    	course_dao.save(course);    
        return "redirect:/viewcourse";  
    }    

  
    @RequestMapping("/viewcourse")    
    public String viewcourse(Model m){  
        List<Course> list=course_dao.getCourses();    
        m.addAttribute("list",list);  
        return "viewcourse";    
    }
    
    @RequestMapping(value="/showcourse/{id}")
    public String showcourse(@PathVariable int id, Model m)  {
    	Course course = course_dao.getCourseById(id);
    	m.addAttribute("course", course);
    	return "showcoursepage";
    }
    
    @RequestMapping(value="/saveattendance/{id}",method = RequestMethod.POST)    
    public String saveattendance(WebRequest request, @PathVariable int id){    
    	Iterator<String> params = request.getParameterNames();
    	while (params.hasNext()) {
    		String s = params.next();
    		Attendance a = new Attendance();
    		a.setDate(java.time.LocalDate.now());
    		a.setCourse_id(id);
    		int student_id = Integer.parseInt(s);
    		a.setStudent_id(student_id);
    		a.setAttendance(request.getParameter(s));
    		course_dao.saveAttendance(a);
    	}  
        return "redirect:/showcourse/{id}";  
    }    
    
    @RequestMapping(value="/editattendance/{id}")
    public String editattendance(@PathVariable int id, Model m)  {
    	Course course = course_dao.getCourseById(id);
    	m.addAttribute("course", course);
    	
    	List<String> students = Arrays.asList(course.getStudents().split(","));
    	int numStudents = students.size();
    	List<Student> student_list = new ArrayList<Student>();
    	for (int i = 0; i < numStudents; i++) {
    		int student_id = Integer.parseInt(students.get(i).substring(1, students.get(i).length()-1));
    		
    		Student s = course_dao.getStudent(student_id);
    		student_list.add(s);
    	}
    	
    	m.addAttribute("students", student_list);
    	return "editattendance";
    }
    
    @RequestMapping(value="/showattendance/{id}")
    public String showattendance(@PathVariable int id, Model m) {
    	Course course = course_dao.getCourseById(id);
    	m.addAttribute("course", course);
    	
    	List<String> students = Arrays.asList(course.getStudents().split(","));
    	int numStudents = students.size();
    	HashMap<String, List<String> > attendance = new HashMap<String, List<String> >();
    	List<String> student_list = new ArrayList<String>();
    	for (int i = 0; i < numStudents; i++) {
    		int student_id = Integer.parseInt(students.get(i).substring(1, students.get(i).length()-1));
    		List<String> att = course_dao.getAttendances(id, student_id);
    		student_list.add(course_dao.getStudentNameById(student_id));
    		String name = course_dao.getStudentNameById(student_id);
    		attendance.put(name, att);
    	}
    	
    	List<Date> dates = course_dao.getAttendanceDates(id);
    	
    	
    	System.out.println(attendance);
    	System.out.println(dates);
    	
    	m.addAttribute("dates", dates);
    	m.addAttribute("students", student_list);
    	m.addAttribute("attendance", attendance);
    	
    	return "showattendance";
    }

    @RequestMapping(value="/editcourse/{id}")    
    public String edit(@PathVariable int id, Model m){  
        Course course=course_dao.getCourseById(id);    
        m.addAttribute("command",course);  
        return "courseeditform";    
    }    

  
    @RequestMapping(value="/editsavecourse",method = RequestMethod.POST)    
    public String editsavecourse(@ModelAttribute("course") Course course){    
    	course_dao.update(course);    
        return "redirect:/viewcourse";    
    }    

  
    @RequestMapping(value="/deletecourse/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
    	course_dao.delete(id);    
        return "redirect:/viewcourse";    
    }    
    @RequestMapping("/studentcourses/{id}")    
    public String viewstudentcourses(@PathVariable int id, Model m){ 
    	List<Course> list=course_dao.getStudentCourses(id);  
        m.addAttribute("list", list); 
        return "studentcourses";   
    }    

}
