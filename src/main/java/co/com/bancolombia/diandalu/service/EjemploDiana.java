package co.com.bancolombia.diandalu.service;

import java.text.MessageFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/saludar/{nombre}")
public class EjemploDiana {
	
	@GET
	public String Saludar( @PathParam("nombre") String nombre){
		return MessageFormat.format("¡Hola {0}!", nombre);
	}
	
	

}
