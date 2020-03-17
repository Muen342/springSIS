package com.springsis.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.springsis.model.Course;    

public class CourseDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Course c) {
		String sql = "insert into courses(title, description, teacher, credits, students, code)"
				+ " values('" + c.getTitle() + "', '" + c.getDescription() + "','" + c.getTeacher() + "','" +
				c.getCredits() + "','" + c.getStudents() + "','" + c.getCode() + "');";
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
	
	public List<Course> getCourses() {
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

}
