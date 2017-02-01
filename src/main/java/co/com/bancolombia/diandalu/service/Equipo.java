package co.com.bancolombia.diandalu.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.bancolombia.business.IntegranteBusiness;
import co.com.bancolombia.entidades.Integrante;

@Path("/swat")
public class Equipo {
	
	@Inject
	private IntegranteBusiness integranteBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Integrante> swat(){
		
		return integranteBusiness.obtenerIntegrantes();
	
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
