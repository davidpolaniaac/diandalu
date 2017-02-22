package co.com.bancolombia.diandalu.adapter;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;

import co.com.bancolombia.diandalu.dto.RolIntegranteDTO;
import co.com.bancolombia.diandalu.entidades.RolIntegrante;

public class RolIntegranteAdapterTest {

	@Test
	public void testRolIntegranteToRolIntegranteDto() throws Exception {
		//arrange
		RolIntegrante rolIntegrante = new RolIntegrante();
		rolIntegrante.setIdRol(1);
		rolIntegrante.setNombre("Angela Maria");
		
		RolIntegranteAdapter rolIntegranteAdapter = new RolIntegranteAdapter();
		//act
		RolIntegranteDTO rolIntegranteDTO = rolIntegranteAdapter.rolIntegranteToRolIntegranteDto(rolIntegrante);
		
		//assert
		
		assertEquals(rolIntegrante.getIdRol(), rolIntegranteDTO.getIdRol());
		assertEquals(rolIntegrante.getNombre(), rolIntegranteDTO.getNombre());
	
	}

	@Test
	public void testRolIntegranteDtoToRolIntegrante() throws Exception {
		//arrange
		RolIntegranteDTO rolIntegranteDTO = new RolIntegranteDTO();
		rolIntegranteDTO.setIdRol(1);
		rolIntegranteDTO.setNombre("Angela Maria");
		
		RolIntegranteAdapter rolIntegranteAdapter = new RolIntegranteAdapter();
		//act
		RolIntegrante rolIntegrante = rolIntegranteAdapter.rolIntegranteDtoToRolIntegrante(rolIntegranteDTO);
		
		//assert
		
		assertEquals(rolIntegranteDTO.getIdRol(), rolIntegrante.getIdRol());
		assertEquals(rolIntegranteDTO.getNombre(), rolIntegrante.getNombre());
		
	}

}
