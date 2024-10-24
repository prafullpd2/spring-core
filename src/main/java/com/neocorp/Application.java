/**
 * 
 */
package com.neocorp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neocorp.config.AppConfig;
import com.neocorp.httpserver.MyHttpServer;
import com.neocorp.service.CourseService;

/**
 * 
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HELLO SPRINGs");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		CourseService cs = ctx.getBean("courseService", CourseService.class);
		System.out.println(cs.list());
//		cs.getData();
		
		MyHttpServer server = ctx.getBean(MyHttpServer.class);
		server.registerContext("/", exchange -> { 
			String requestMethod = exchange.getRequestMethod();
			System.out.println("request method: "+ requestMethod);
			String res = cs.getData("https://www.google.com");
			
			byte[] bytes  = res.getBytes();
			exchange.sendResponseHeaders( 200, bytes.length);
			exchange.getResponseBody().write(bytes);
			exchange.close();
			
		});
		
		server.registerContext("/eg", exchange -> { 
			String requestMethod = exchange.getRequestMethod();
			System.out.println("request method: "+ requestMethod);
			String res = cs.getData("https://www.example.com");
			
			byte[] bytes  = res.getBytes();
			exchange.sendResponseHeaders( 200, bytes.length);
			exchange.getResponseBody().write(bytes);
			exchange.close();
			
		});
		
		
		
		


	}

}
