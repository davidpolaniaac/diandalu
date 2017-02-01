package co.com.bancolombia.diandalu.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Any;

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
import static org.mockito.Matchers.*;

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
		
		//act
		
		integranteService.saveIntegrante(new Integrante());
		
		//assert
		
		Mockito.verify(integranteBusiness).saveIntegrate(any(Integrante.class));
	}
	
	

}
