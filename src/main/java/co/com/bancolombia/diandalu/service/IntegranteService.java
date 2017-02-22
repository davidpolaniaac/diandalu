package co.com.bancolombia.diandalu.service;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.com.bancolombia.diandalu.business.IntegranteBusiness;
import co.com.bancolombia.diandalu.dto.IntegranteDTO;

@Path("/integrantes")
public class IntegranteService {
	
	@Inject
	private IntegranteBusiness integranteBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IntegranteDTO> getIntegrantes(){	
		
		return integranteBusiness.obtenerIntegrantes();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveIntegrante(IntegranteDTO integranteDTO){	
		
		integranteBusiness.saveIntegrate(integranteDTO);
	}
	
}
