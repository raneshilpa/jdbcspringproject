package org.spring.jdbc;

import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig
{
    @Bean("ds")
    public DataSource getDataSouce()
    {
     DriverManagerDataSource ds= new DriverManagerDataSource();
     ds.setDriverClassName("com.mysql.jdbc.Driver");
     ds.setUrl("jdbc:mysql://localhost:3306/sys?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("sql@2022");
        return ds;

    }
    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSouce());
        return jdbcTemplate;


    }
    @Bean(name = {"studentDao"})
    public StudentDao getStudentDao()
    {
        StudentDaoImpl studentDao = new StudentDaoImpl();

        studentDao.setJdbcTemplate(getTemplate());
        return studentDao;

    }

}
