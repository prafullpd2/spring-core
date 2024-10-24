package com.neocorp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.neocorp.model.Course;
import com.neocorp.repository.CourseRepository;


@Component
public class CourseService implements CrudService<Course> {
	
	private CourseRepository repo;;
	
	
	public CourseService(CourseRepository repository) {
		repo = repository;
		
	}

	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Course create(Course t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Course> get(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Course t, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public String getData(String path) {
		String res = "";
		try {
			URL url  = new URL(path);
			System.out.println("URL Connection Opened");
			
			((HttpURLConnection) url.openConnection()).connect();

			BufferedReader reader = new BufferedReader( new InputStreamReader(url.openStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				res = res + line;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("URL Connection closed");
		return res;

	}

}
