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

import co.com.bancolombia.diandalu.business.SubdominioBusiness;
import co.com.bancolombia.diandalu.dto.SubdominioDTO;
import co.com.bancolombia.diandalu.entidades.Subdominio;

@Path("/subdominios")
public class SubdominioService {
	
	@Inject
	private SubdominioBusiness subdominioBusiness;
	
	@GET  
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)  
	public SubdominioDTO getSubdominioById(@PathParam("id") int id){  
		 return subdominioBusiness.getSubdominio(id);  
	}  
	
	@PUT  
	@Consumes(MediaType.APPLICATION_JSON)  
	public void updateSubdominio(SubdominioDTO subdominioDTO)  {  
		subdominioBusiness.updateSubdominio(subdominioDTO);  
	} 

	@Path ("/crearsubdominio")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createSubdominio(Subdominio subdominio) {
		subdominioBusiness.createSubdominio(subdominio);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubdominioDTO> mostrarSubdominios() {
		return subdominioBusiness.mostrarTodosLosSubdominios();
	}

	@DELETE
	@Path("/{id}")
	public void deleteSubdominio(@PathParam("id") int id) {
		subdominioBusiness.deleteSubdominio(id);
	}

}
