package co.com.bancolombia.diandalu.adapter;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import co.com.bancolombia.diandalu.dto.IntegranteDTO;
import co.com.bancolombia.diandalu.entidades.Integrante;


public class IntegranteAdapter {
	
	@Inject
	private RolIntegranteAdapter rolIntegranteAdapter;
	
	public IntegranteDTO integranteToIntegranteDto(Integrante integrante) {
		
		IntegranteDTO integranteDTO = new IntegranteDTO();
		integranteDTO.setIdIntegrante(integrante.getIdIntegrante());
		integranteDTO.setNombre(integrante.getNombre());
		integranteDTO.setCedula(integrante.getCedula());
		integranteDTO.setEmail(integrante.getEmail());
		
		integranteDTO.setRolIntegranteDto(rolIntegranteAdapter.rolIntegranteToRolIntegranteDto(integrante.getRolIntegrante()));
		
		return integranteDTO;
	}
	
	public Integrante integranteDtoToIntegrante(IntegranteDTO integranteDTO) {
		
		Integrante integrante = new Integrante();
		integrante.setIdIntegrante(integranteDTO.getIdIntegrante());
		integrante.setNombre(integranteDTO.getNombre());
		integrante.setCedula(integranteDTO.getCedula());
		integrante.setEmail(integranteDTO.getEmail());

		integrante.setRolIntegrante(rolIntegranteAdapter.rolIntegranteDtoToRolIntegrante(integranteDTO.getRolIntegranteDto()));
		
		return integrante;
	}

	public List<IntegranteDTO> listIntegranteToListIntegranteDTO(List<Integrante> listaIntegrantes) {
		
		List<IntegranteDTO> listaIntegranteDTO = new ArrayList<>();
		
		for (Integrante integrante : listaIntegrantes) {
			listaIntegranteDTO.add(integranteToIntegranteDto(integrante));
		}
		
		return listaIntegranteDTO;
	}
	
	public List<Integrante> listIntegranteDtoToListIntegrante(List<IntegranteDTO> listaIntegrantesDTO) {
		
		List<Integrante> listaIntegrante = new ArrayList<>();
		
		for (IntegranteDTO integranteDTO : listaIntegrantesDTO) {
			listaIntegrante.add(integranteDtoToIntegrante(integranteDTO));
		}
		
		return listaIntegrante;
	}

}
