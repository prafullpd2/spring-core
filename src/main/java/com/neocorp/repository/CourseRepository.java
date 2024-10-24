/**
 * 
 */
package com.neocorp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neocorp.model.Course;

/**
 * 
 */
@Repository
public class CourseRepository implements CrudRepository<Course> {
	
	

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
//		return null;
		
		List<Course> courses = new ArrayList<>();
		Course springboot = new Course (1, "Start with boot", "Learn to build boot", "http://boot.jj.ll" );
		Course java = new Course (2, "Start with java", "Learn to build java", "http://java" );
		Course js = new Course (3, "Start with js", "Learn to build js", "http://js" );
		Course py = new Course (4, "Start with py", "Learn to build py", "http://py" );
		courses.add(springboot);
		return courses;
	}

}
