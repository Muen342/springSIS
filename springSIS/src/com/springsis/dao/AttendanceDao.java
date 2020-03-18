package com.springsis.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.springsis.model.Attendance; 

public class AttendanceDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Attendance c) {
		String sql = "insert into attendance(date, attendance, course_id, student_id)"
				+ " values('" + c.getDate() + "', '" + c.getAttendance() + "'," + c.getCourse_id()+ " ," +
				c.getStudent_id() + ");";
		System.out.println(sql);
		return template.update(sql);
	}
	
	public int update(Attendance c) {
		String sql = "update attendance set date = '" + c.getDate() + "', attendance = '" + c.getAttendance() +
				"' where id=" + c.getId() + ";";
		return template.update(sql);
	}
	
	public int delete(int id) {
		String sql = "delete from attendance where id = " + id + ";";
		return template.update(sql);
	}
	
	public Attendance getAttendanceById(int id) {
		String sql = "select * from attendance where id=? ;";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Attendance>(Attendance.class));
	}
	
	public List<Attendance> getAttendanceByCourse(int course_id) {
		String sql = "select * from attendance where course_id=" + course_id +" ;";
		return template.query(sql, new RowMapper<Attendance>() {
			public Attendance mapRow(ResultSet rs, int row) throws SQLException {
				Attendance c = new Attendance();
				c.setId(rs.getInt(1));
				c.setDate(rs.getDate(2).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				c.setAttendance(rs.getString(3));
				c.setCourse_id(rs.getInt(4));
				c.setStudent_id(rs.getInt(5));
				return c;
			}
		});
	}
	
	public List<Attendance> getAttendance() {
		return template.query("select * from attendance;", new RowMapper<Attendance>() {
			public Attendance mapRow(ResultSet rs, int row) throws SQLException {
				Attendance c = new Attendance();
				c.setId(rs.getInt(1));
				c.setDate(rs.getDate(2).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				c.setAttendance(rs.getString(3));
				c.setCourse_id(rs.getInt(4));
				c.setStudent_id(rs.getInt(5));
				return c;
			}
		});
	}
}
