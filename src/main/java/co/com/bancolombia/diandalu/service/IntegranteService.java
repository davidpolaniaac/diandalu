package co.com.bancolombia.diandalu.service;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		
		return integranteBusiness.getIntegrantes();
	}
	
	@GET
	@Path("/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public IntegranteDTO getIntegrante(@PathParam("id") int id){
		return integranteBusiness.getIntegrante(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveIntegrante(IntegranteDTO integranteDTO){	
		
		integranteBusiness.saveIntegrate(integranteDTO);
	}
	
	@DELETE
	@Path("/{id}") 
	public void deleteIntegrante(@PathParam("id") int id){
		integranteBusiness.deleteIntegrante(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateIntegrante(IntegranteDTO integranteDTO){
		integranteBusiness.updateIntegrante(integranteDTO);
	}

}
