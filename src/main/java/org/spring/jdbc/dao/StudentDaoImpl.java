package org.spring.jdbc.dao;

import org.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String query="insert into STUDENT(id,name,city)values(?,?,?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        String query="update student set name=?,city=? where id=?";
        int r1 = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r1;
    }

    @Override
    public int delete(int studentId) {
        String query="delete from student where id=?";
        int delete = this.jdbcTemplate.update(query, studentId);

        return delete;
    }
//select data
    @Override
    public Student getStudent(int studentId) {
        String query="select * from student where id=?";
        RowMapper<Student> rowMapper=new RowMapperImpl();

        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

        return student;
    }
//selecting all student
    @Override
    public List<Student> getallStudent() {
        String query="select * from student";
        List<Student> query1 = this.jdbcTemplate.query(query, new RowMapperImpl());

        return query1;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
