/**
 * 
 */
package com.neocorp.httpserver;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.net.httpserver.*;

/**
 * 
 */
@Component
public class MyHttpServer {
	private int port;
	private HttpServer server;
	
	@Autowired
	public MyHttpServer(int serverPort) {
		// TODO Auto-generated constructor stub
		System.out.println("PORT: "+serverPort);
		this.port = serverPort;
		
		listen();
	}
	
	private void listen() {
		try {
			this.server  = HttpServer.create(new InetSocketAddress(port), 0);
			System.out.println("STARTED LIOSTNING ON PORT " + port);
			server.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerContext(String path, HttpHandler handler ) {
		
		server.createContext(path, handler);
		
	}
	

}
