package co.com.bancolombia.diandalu.service;

import java.util.List;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.bancolombia.business.IntegranteBusiness;
import co.com.bancolombia.entidades.Integrante;

@Path("/integrantes")
public class IntegranteService {
	
	@Inject
	private IntegranteBusiness integranteBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Integrante> getIntegrantes(){	
		
		return integranteBusiness.obtenerIntegrantes();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveIntegrante(Integrante integrante){	
		
		integranteBusiness.saveIntegrate(integrante);
	}
	
}
