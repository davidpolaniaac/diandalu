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
import co.com.bancolombia.business.IntegranteBusiness;
import co.com.bancolombia.entidades.Integrante;

@RunWith(MockitoJUnitRunner.class)
public class IntegranteServiceTest {
	
	@Mock
	private IntegranteBusiness integranteBusiness;
	
	@InjectMocks
	private IntegranteService integranteService;
	
	private List<Integrante> integrantes;
	
	@Before
	public void init(){
		
		integrantes = new ArrayList<Integrante>();
		integrantes.add(new Integrante());
		integrantes.add(new Integrante());	
	}
	
	@Test
	public void testGetIntegrantes(){
		
		//arrange
		Mockito.when(integranteBusiness.obtenerIntegrantes()).thenReturn(integrantes);
		
		//act
		List<Integrante> integrantesObtenidos = integranteService.getIntegrantes();
		
		//assert
		
		assertEquals(integrantes.get(0), integrantesObtenidos.get(0));
		assertEquals(integrantes.get(1), integrantesObtenidos.get(1));
	}


	@Test
	public void testSaveIntegrante(){
		//arrange
		Integrante integrante = new Integrante();
		//act
		
		integranteService.saveIntegrante(integrante);
		
		//assert
		
		Mockito.verify(integranteBusiness).saveIntegrate(integrante);
	}
	
	

}
