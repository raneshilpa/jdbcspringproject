package org.spring.jdbc;

import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Through xml
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config.xml");

        //Through Java jdbcConfig.java file
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);



//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        //insert
//        String query="insert into STUDENT(id,name,city)values(?,?,?)";
//        int update = jdbcTemplate.update(query, 456, "Titu", "Goa");
//        System.out.println("No of record inserted : "+update);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        Student student= new Student();
        //insert
        student.setId(999);
        student.setName("Singh");
        student.setCity("Punjabnew");

        int result = studentDao.insert(student);
        System.out.println("Student added "+result);

        //update
//
//          student.setId(777);
//          student.setName("Priya");
//          student.setCity("Madras");
//        int change = studentDao.change(student);
//        System.out.println("data changed "+change);
//
        //delete
//        int delete = studentDao.delete(111);
//        System.out.println("Deleted "+delete);

       //row mapper
//
        //get all student info
        List<Student> students = studentDao.getallStudent();
        for(Student s:students)
        {
            System.out.println(s);
        }
    }


}
