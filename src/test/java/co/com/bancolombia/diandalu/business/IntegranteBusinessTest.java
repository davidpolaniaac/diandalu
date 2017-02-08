package co.com.bancolombia.diandalu.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.bancolombia.diandalu.entidades.Integrante;

@RunWith(MockitoJUnitRunner.class)
public class IntegranteBusinessTest {
	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private IntegranteBusiness integranteBusiness;
	@Mock
	TypedQuery<Integrante> typedQuery;
	private List<Integrante> integrantes;
	
	@Before
	public void init(){
		
		integrantes = new ArrayList<Integrante>();
		integrantes.add(new Integrante());
		integrantes.add(new Integrante());	
	}
	
	@Test
	public void testObtenerIntegrantes(){
		
		//arrange
		Mockito.when(entityManager.createNamedQuery("Integrante.findAll",Integrante.class)).thenReturn(typedQuery);
		Mockito.when(typedQuery.getResultList()).thenReturn(integrantes);
		
		//act
		List<Integrante> integrantesObtenidos = integranteBusiness.obtenerIntegrantes();
		
		//assert
		
		assertEquals(integrantes.get(0), integrantesObtenidos.get(0));
		assertEquals(integrantes.get(1), integrantesObtenidos.get(1));
	}


	@Test
	public void testSaveIntegrante(){
		//arrange
		Integrante integrante = new Integrante();
		//act
		
		integranteBusiness.saveIntegrate(integrante);
		
		//assert
		
		Mockito.verify(entityManager).persist(integrante);
	}

}
