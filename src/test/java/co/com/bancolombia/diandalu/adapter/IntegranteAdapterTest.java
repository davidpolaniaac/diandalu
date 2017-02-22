package co.com.bancolombia.diandalu.adapter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.bancolombia.diandalu.dto.IntegranteDTO;
import co.com.bancolombia.diandalu.dto.RolIntegranteDTO;
import co.com.bancolombia.diandalu.entidades.Integrante;
import co.com.bancolombia.diandalu.entidades.RolIntegrante;


@RunWith(MockitoJUnitRunner.class)
public class IntegranteAdapterTest {
	@Mock
	private RolIntegranteAdapter rolIntegranteAdapter;
	@InjectMocks
	private IntegranteAdapter integranteAdapter;

	@Test
	public void testIntegranteToIntegranteDto() throws Exception {
		//arrange
		Integrante integrante = new Integrante();
		integrante.setIdIntegrante(1);
		integrante.setEmail("email@dominio.com");
		integrante.setNombre("Angela Maria");
		integrante.setCedula(12345678);
		integrante.setRolIntegrante(new RolIntegrante());
		
		
		RolIntegranteDTO rolIntegranteDTO = new RolIntegranteDTO();
		
		Mockito.when(rolIntegranteAdapter.rolIntegranteToRolIntegranteDto(integrante.getRolIntegrante())).thenReturn(rolIntegranteDTO);	
		//act
		
		IntegranteDTO integranteDTO = integranteAdapter.integranteToIntegranteDto(integrante);
		
		//assert
		
		assertEquals(integrante.getNombre(), integranteDTO.getNombre());
		assertEquals(integrante.getCedula(), integranteDTO.getCedula());
		assertEquals(integrante.getEmail(), integranteDTO.getEmail());
		assertEquals(rolIntegranteDTO , integranteDTO.getRolIntegranteDto());
		assertEquals(integrante.getIdIntegrante(), integranteDTO.getIdIntegrante());
	}

	@Test
	public void testIntegranteDtoToIntegrante() throws Exception {
		//arrange
		IntegranteDTO integranteDTO = new IntegranteDTO();
		integranteDTO.setIdIntegrante(1);
		integranteDTO.setEmail("email@dominio.com");
		integranteDTO.setNombre("Angela Maria");
		integranteDTO.setCedula(12345678);
		integranteDTO.setRolIntegranteDto(new RolIntegranteDTO());
		
		//act
		
		RolIntegrante rolIntegrante = new RolIntegrante();
		
		Mockito.when(rolIntegranteAdapter.rolIntegranteDtoToRolIntegrante(integranteDTO.getRolIntegranteDto())).thenReturn(rolIntegrante);
		
		Integrante integrante = integranteAdapter.integranteDtoToIntegrante(integranteDTO);
		
		//assert
		
		assertEquals(integranteDTO.getNombre(), integrante.getNombre());
		assertEquals(integranteDTO.getCedula(), integrante.getCedula());
		assertEquals(integranteDTO.getEmail(), integrante.getEmail());
		assertEquals(rolIntegrante, integrante.getRolIntegrante());
		assertEquals(integranteDTO.getIdIntegrante(), integrante.getIdIntegrante());
	}

	@Test
	public void testListIntegranteToListIntegranteDTO() throws Exception {
		//arrange
		List<Integrante> listaIntegrantes = new ArrayList<>();
		
		Integrante integrante= new Integrante();
		integrante.setIdIntegrante(1);
		integrante.setEmail("email@dominio.com");
		integrante.setNombre("Angela Maria");
		integrante.setCedula(12345678);
		integrante.setRolIntegrante(new RolIntegrante());
		
		listaIntegrantes.add(integrante);
		
		RolIntegranteDTO rolIntegranteDTO = new RolIntegranteDTO();
		
		Mockito.when(rolIntegranteAdapter.rolIntegranteToRolIntegranteDto(integrante.getRolIntegrante())).thenReturn(rolIntegranteDTO);	
		
		//act
		
		List<IntegranteDTO> listaIntegranteDTO = integranteAdapter.listIntegranteToListIntegranteDTO(listaIntegrantes);
		
		//assert
		
		assertEquals(listaIntegrantes.get(0).getNombre(), listaIntegranteDTO.get(0).getNombre());
		assertEquals(listaIntegrantes.get(0).getCedula(), listaIntegranteDTO.get(0).getCedula());
		assertEquals(listaIntegrantes.get(0).getEmail(), listaIntegranteDTO.get(0).getEmail());
		assertEquals(rolIntegranteDTO,listaIntegranteDTO.get(0).getRolIntegranteDto());
		assertEquals(listaIntegrantes.get(0).getIdIntegrante(), listaIntegranteDTO.get(0).getIdIntegrante());
	}

	@Test
	public void testListIntegranteDtoToListIntegrante() throws Exception {
		//arrange
		List<IntegranteDTO> listaintegrantesDTO = new ArrayList<>();
		
		IntegranteDTO integranteDTO = new IntegranteDTO();
		integranteDTO.setIdIntegrante(1);
		integranteDTO.setEmail("email@dominio.com");
		integranteDTO.setNombre("Angela Maria");
		integranteDTO.setCedula(12345678);
		integranteDTO.setRolIntegranteDto(new RolIntegranteDTO());
		
		listaintegrantesDTO.add(integranteDTO);
		
		RolIntegrante rolIntegrante = new RolIntegrante();
		
		Mockito.when(rolIntegranteAdapter.rolIntegranteDtoToRolIntegrante(integranteDTO.getRolIntegranteDto())).thenReturn(rolIntegrante);
		
		//act
		
		List<Integrante> listaIntegrante = integranteAdapter.listIntegranteDtoToListIntegrante(listaintegrantesDTO);
		
		//assert
		
		assertEquals(listaintegrantesDTO.get(0).getNombre(), listaIntegrante.get(0).getNombre());
		assertEquals(listaintegrantesDTO.get(0).getCedula(), listaIntegrante.get(0).getCedula());
		assertEquals(listaintegrantesDTO.get(0).getEmail(), listaIntegrante.get(0).getEmail());
		assertEquals(rolIntegrante, listaIntegrante.get(0).getRolIntegrante());
		assertEquals(listaintegrantesDTO.get(0).getIdIntegrante(), listaIntegrante.get(0).getIdIntegrante());
	}

}
