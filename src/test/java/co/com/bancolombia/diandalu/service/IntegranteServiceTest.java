package co.com.bancolombia.diandalu.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import co.com.bancolombia.diandalu.business.IntegranteBusiness;
import co.com.bancolombia.diandalu.dto.IntegranteDTO;


@RunWith(MockitoJUnitRunner.class)
public class IntegranteServiceTest {
	
	@Mock
	private IntegranteBusiness integranteBusiness;
	
	@InjectMocks
	private IntegranteService integranteService;
	
	private List<IntegranteDTO> integrantesDTO;
	
	@Before
	public void init(){
		
		integrantesDTO = new ArrayList<IntegranteDTO>();
		integrantesDTO.add(new IntegranteDTO());
		integrantesDTO.add(new IntegranteDTO());	
	}
	
	@Test
	public void testGetIntegrantes(){
		
		//arrange
		Mockito.when(integranteBusiness.obtenerIntegrantes()).thenReturn(integrantesDTO);
		
		//act
		List<IntegranteDTO> integrantesObtenidos = integranteService.getIntegrantes();
		
		//assert
		
		assertEquals(integrantesDTO.get(0), integrantesObtenidos.get(0));
		assertEquals(integrantesDTO.get(1), integrantesObtenidos.get(1));
	}


	@Test
	public void testSaveIntegrante(){
		//arrange
		IntegranteDTO integranteDTO = new IntegranteDTO();
		//act
		
		integranteService.saveIntegrante(integranteDTO);
		
		//assert
		
		Mockito.verify(integranteBusiness).saveIntegrate(integranteDTO);
	}
	
	

}
