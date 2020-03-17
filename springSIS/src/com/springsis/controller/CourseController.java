package com.springsis.controller;
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.springsis.model.Course;
import com.springsis.dao.CourseDao;

@Controller
public class CourseController {
	
	@Autowired    
    CourseDao course_dao;//will inject dao from XML file    
         
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
    	System.out.println("hiiiii i'm hereeeeee");
        List<Course> list=course_dao.getCourses();    
        m.addAttribute("list",list);  
        return "viewcourse";    
    }    


    @RequestMapping(value="/editcourse/{id}")    
    public String edit(@PathVariable int id, Model m){    
    	System.out.println("edit CoOURSE");
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
