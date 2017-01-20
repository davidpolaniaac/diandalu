package co.com.bancolombia.diandalu.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/swat")
public class Equipo {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> swat(){
		
		List<String> nombres = new ArrayList<String>();
		
		nombres.add("David Polania");
		nombres.add("Lucas Espinal");
		nombres.add("Andres Lopez");
		nombres.add("Luisa Betancur");
		nombres.add("Diana Durango");
		nombres.add("Lina Granados");
		
		return nombres;
	}
	
	@Path("agente/{id}")
	@GET
	public String agenteSwat(@PathParam("id") int id){
		
		List<String> nombres = new ArrayList<String>();
		
		nombres.add("David Polania");
		nombres.add("Lucas Espinal");
		nombres.add("Andres Lopez");
		nombres.add("Luisa Betancur");
		nombres.add("Diana Durango");
		nombres.add("Lina Granados");
		
		return nombres.get(id);
	}
}