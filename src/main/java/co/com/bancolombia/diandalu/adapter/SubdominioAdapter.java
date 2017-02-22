package co.com.bancolombia.diandalu.adapter;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import co.com.bancolombia.diandalu.dto.SubdominioDTO;
import co.com.bancolombia.diandalu.entidades.Subdominio;

public class SubdominioAdapter {
	
	@Inject
	private IntegranteAdapter integranteAdapter;

	public Subdominio subdominioDtoToSubdominio(SubdominioDTO subdominioDTO){
		
		Subdominio subdominio = new Subdominio();
		subdominio.setIdSubdominio(subdominioDTO.getIdSubdominio());
		subdominio.setNombre(subdominioDTO.getNombre());
		subdominio.setDescripcion(subdominioDTO.getDescripcion());
		subdominio.setIntegrantes(integranteAdapter.listIntegranteDtoToListIntegrante(subdominioDTO.getIntegrantes()));
		
		return subdominio;
	}
	
	public SubdominioDTO subdominioToSubdominioDto(Subdominio subdominio){
			
		SubdominioDTO subdominioDTO = new SubdominioDTO();
		subdominioDTO.setIdSubdominio(subdominio.getIdSubdominio());
		subdominioDTO.setNombre(subdominio.getNombre());
		subdominioDTO.setDescripcion(subdominio.getDescripcion());
		subdominioDTO.setIntegrantes(integranteAdapter.listIntegranteToListIntegranteDTO(subdominio.getIntegrantes()));

		return subdominioDTO;
	}
	
	public List<SubdominioDTO> listSubdominioToListSubdominioDTO(List<Subdominio> listaSubdominio){
		
		List<SubdominioDTO> listaSubdominioDTO = new ArrayList<>();
		
		for (Subdominio subdominio : listaSubdominio) {
			listaSubdominioDTO.add(subdominioToSubdominioDto(subdominio));
		}
		
		return listaSubdominioDTO;
	}
	
	public List<Subdominio> listSubdominioDtoToListSubdominio(List<SubdominioDTO> listaSubdominioDTO){
		
		List<Subdominio> listaSubdominio= new ArrayList<>();
		
		for (SubdominioDTO subdominioDTO : listaSubdominioDTO) {
			listaSubdominio.add(subdominioDtoToSubdominio(subdominioDTO));
		}
		
		return listaSubdominio;
	}
}
