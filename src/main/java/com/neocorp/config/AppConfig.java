package com.neocorp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.neocorp.repository.CourseRepository;
import com.neocorp.service.CourseService;

@Configuration
@ComponentScan("com.neocorp")
public class AppConfig {
	
	/*
	 * @Bean("courseService") public CourseService getCourseService() { return new
	 * CourseService(getCourserepository()); }
	 * 
	 * @Bean("courseRepository") public CourseRepository getCourserepository() {
	 * return new CourseRepository(); }
	 */
	@Bean
	public int serverPort() {
		return 4300;
	}

}
