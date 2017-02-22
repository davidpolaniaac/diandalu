package co.com.bancolombia.diandalu.adapter;

import co.com.bancolombia.diandalu.dto.RolIntegranteDTO;
import co.com.bancolombia.diandalu.entidades.RolIntegrante;

public class RolIntegranteAdapter {
	
	public RolIntegranteDTO rolIntegranteToRolIntegranteDto(RolIntegrante rolIntegrante){
		
		RolIntegranteDTO rolIntegranteDTO = new RolIntegranteDTO();
		rolIntegranteDTO.setIdRol(rolIntegrante.getIdRol());
		rolIntegranteDTO.setNombre(rolIntegrante.getNombre());
		
		return rolIntegranteDTO;
	}

	public RolIntegrante rolIntegranteDtoToRolIntegrante(RolIntegranteDTO rolIntegranteDTO) {
		RolIntegrante rolIntegrante = new RolIntegrante();
		rolIntegrante.setIdRol(rolIntegranteDTO.getIdRol());
		rolIntegrante.setNombre(rolIntegranteDTO.getNombre());
		
		return rolIntegrante;
	}

}
