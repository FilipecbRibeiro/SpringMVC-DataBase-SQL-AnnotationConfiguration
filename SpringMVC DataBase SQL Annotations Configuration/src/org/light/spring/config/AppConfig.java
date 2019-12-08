package org.light.spring.config;

import javax.sql.DataSource;

import org.light.spring.DAO.AppDAOImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
	
	//use this instead of XML CONFIGURATION!!!!
	@Bean
	public DataSource getDataSource(){

		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/project_spring?serverTimezone=UTC");
		dataSource.setUsername("filipecbribeiro");
		dataSource.setPassword("Root12340");
		
		return dataSource;
		
	}
	@Bean("DAOBean")
	public AppDAOImplementation AppDAO(){
		
		
		return new AppDAOImplementation(getDataSource());
	}
}
