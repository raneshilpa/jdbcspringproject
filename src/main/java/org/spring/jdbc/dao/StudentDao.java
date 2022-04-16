package org.spring.jdbc.dao;

import org.spring.jdbc.entities.Student;

import java.util.List;

public interface StudentDao {
public int insert(Student student);
public int change(Student student);
public int delete(int studentId);
public Student getStudent(int studentId);
public List<Student> getallStudent();






}
