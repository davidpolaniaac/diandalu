package co.com.bancolombia.diandalu.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import co.com.bancolombia.entidades.Subdominio;

public class SubdominioService {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createSubdominio(Subdominio subdominio) {
		// TODO Auto-generated method stub
		
	}

}
