package co.com.bancolombia.diandalu.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/saludo")
public class HelloWorld {
	@GET
	public String saludo(){
		return "hello world";
	}
	
	
	
	

}
