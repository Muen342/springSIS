package com.springsis.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.springsis.model.Student; 

public class StudentDAO {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Student p){    
    String sql="insert into Students(id,name,surname,grade) values("+ p.getId() + ",'"+p.getName()+"','" +p.getSurname()+"',"+p.getGrade()+")";    
    return template.update(sql);    
}    
public int update(Student p){    
    String sql="update Students set name='"+p.getName()+"', grade="+p.getGrade() +",surname='"+p.getSurname()+"' where id="+p.getId()+"";    
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from Students where id="+id+"";    
    return template.update(sql);    
}    
public Student getStudentById(int id){    
    String sql="select * from Students where id=? ;";   
    System.out.println(sql);
    System.out.println(id);
    return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));    
}    
public List<Student> getStudents(){    
    return template.query("select * from Students",new RowMapper<Student>(){    
        public Student mapRow(ResultSet rs, int row) throws SQLException {    
            Student e=new Student();    
            e.setId(rs.getInt(1));    
            e.setName(rs.getString(2));    
            e.setSurname(rs.getString(3));    
            e.setGrade(rs.getInt(4));    
            return e;    
        }    
    });    
}    
}   