package com.springsis.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.springsis.model.Course;  
import com.springsis.model.Student;  
import com.springsis.model.Attendance;  

public class CourseDao {
	JdbcTemplate template = new JdbcTemplate();
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Course c) {
		String sql = "insert into courses(title, description, teacher, credits, students, code)"
				+ " values('" + c.getTitle() + "', '" + c.getDescription() + "','" + c.getTeacher() + "','" +
				c.getCredits() + "','" + c.getStudents() + "','" + c.getCode() + "');";
		return template.update(sql);
	}
	
	public int saveAttendance(Attendance a) {
		String sql = "insert into attendance(date, attendance, course_id, student_id)"
				+ " values('" + a.getDate() + "', '" + a.getAttendance() + "'," + a.getCourse_id()+ " ," +
				a.getStudent_id() + ");";
		return template.update(sql);
	}
	
	public int update(Course c) {
		String sql = "update courses set title = '" + c.getTitle() + "', description = '" + c.getDescription() +
				"', teacher = '" + c.getTeacher() + "', credits = " + c.getCredits() + ", code = '" + c.getCode() + 
				"' where id=" + c.getId() + ";";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from courses where id = " + id + ";";
		return template.update(sql);
	}
	
	public Course getCourseById(int id) {
		String sql = "select * from courses where id=? ;";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public Student getStudent(int id) {
		String sql = "select * from students where id=? ;";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	public List<Course> getCourses() {
		System.out.println(template);
		return template.query("select * from courses;", new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int row) throws SQLException {
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setDescription(rs.getString(3));
				c.setTeacher(rs.getString(4));
				c.setCredits(rs.getFloat(5));
				c.setStudents(rs.getString(6));
				c.setCode(rs.getString(7));
				return c;
			}
		});
	}
	public List<Course> getStudentCourses(int studId) {
		return template.query("select * from courses where students like '%*" + studId + "*%';", new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int row) throws SQLException {
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setDescription(rs.getString(3));
				c.setTeacher(rs.getString(4));
				c.setCredits(rs.getFloat(5));
				c.setStudents(rs.getString(6));
				c.setCode(rs.getString(7));
				return c;
			}
		});
	}

}
