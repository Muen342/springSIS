package com.springsis.controller;
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import com.springsis.model.Student;  
import com.springsis.dao.StudentDAO;
import com.springsis.dao.CourseDao;
import com.springsis.model.Course;
@Controller
public class StudentController {
	@Autowired
	StudentDAO dao;
	CourseDao course_dao = new CourseDao();
	@RequestMapping("/studentform")    
    public String showform(Model m){    
        m.addAttribute("command", new Student()); 
        return "studentform";   
    }    
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("student") Student student){    
        dao.save(student);    
        return "redirect:/viewstudent";//will redirect to viewstudent request mapping    
    }    
	  /* It provides list of students in model object */    
    @RequestMapping("/viewstudent")    
    public String viewstudent(Model m){    
        List<Student> list=dao.getStudents();    
        m.addAttribute("list",list);  
        return "viewstudent";    
    }    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editstudent/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Student student=dao.getStudentById(id);    
        m.addAttribute("command",student);  
        return "studenteditform";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("student") Student student){    
        dao.update(student);    
        return "redirect:/viewstudent";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewstudent */    
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewstudent";    
    }     
}
