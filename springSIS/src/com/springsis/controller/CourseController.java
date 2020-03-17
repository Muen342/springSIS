package com.springsis.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.springsis.model.Course;
import com.springsis.model.Student;
import com.springsis.dao.StudentDAO;
import com.springsis.dao.CourseDao;
import com.springsis.model.Attendance;
import com.springsis.dao.AttendanceDao;

@Controller
public class CourseController {
	
	@Autowired    
    CourseDao course_dao;//will inject dao from XML file    
	@Autowired    
	AttendanceDao attendance_dao;//will inject dao from XML file 
	
	@Autowired    
	StudentDAO dao;//will inject dao from XML file 
         
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


    @RequestMapping(value="/editcourse/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Course course=course_dao.getCourseById(id);    
        m.addAttribute("command",course);  
        return "courseeditform";    
    }    
    
    @RequestMapping("/showcourse/{id}")    
    public String showcourse(@PathVariable int id, Model m){  
    	Course course=course_dao.getCourseById(id);  
    	m.addAttribute("course",course);  
        return "showcoursepage";    
    }
    
    @RequestMapping("/showcourse/editattendance/{id}")
    public String editattendance(@PathVariable int id, Model m) {
    	Course course = course_dao.getCourseById(id);
    	List<String> students = Arrays.asList(course.getStudents().split(","));
    	int numStudents = students.size();
    	List<Attendance> attendance_list = new ArrayList<Attendance>();
    	ArrayList<String> student_list = new ArrayList<String>();
    	for (int i = 0; i < numStudents; i++) {
    		Attendance a = new Attendance();
    		a.setDate("2020");
    		a.setCourse_id(id);
    		int student_id = Integer.parseInt(students.get(i).substring(1, students.get(i).length()));
    		a.setStudent_id(student_id);
    		attendance_list.add(a);
    		
    		Student s = dao.getStudentById(student_id);
    		student_list.add(s.getName());
    	}
    	
    	
    	
    	m.addAttribute("students", student_list);
    	m.addAttribute("attendance", attendance_list);
    	m.addAttribute("course",course);
    	return "editattendance";
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
