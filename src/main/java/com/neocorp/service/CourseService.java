package com.neocorp.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

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
	
	public byte[] getData(String path) {
		String res = "";
		byte[] dataBytes = null;
		try {
			URL url  = new URL(path);
			System.out.println("URL Connection Opened");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024]; 
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) { 
                	baos.write(buffer, 0, bytesRead);
                }
                dataBytes = baos.toByteArray();
    			
    			String contentType = connection.getContentType();
                if(contentType.startsWith("text/")) {
                	System.out.println("text fetched successfully!");
                } else if(contentType.startsWith("image/")) {
                	System.out.println("Image fetched successfully!");
                } else {
                	System.out.println("binary fetched successfully!");
                }
                
                inputStream.close();
                
            } else {
                System.out.println("Failed to fetch data or response empty " + connection.getResponseCode());
            }

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("URL Connection closed");
		return dataBytes;

	}

}
