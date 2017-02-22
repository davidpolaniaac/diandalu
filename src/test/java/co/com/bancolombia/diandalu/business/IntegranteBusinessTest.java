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
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import co.com.bancolombia.diandalu.adapter.IntegranteAdapter;
import co.com.bancolombia.diandalu.dto.IntegranteDTO;
import co.com.bancolombia.diandalu.entidades.Integrante;


@RunWith(MockitoJUnitRunner.class)
public class IntegranteBusinessTest {
	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private IntegranteBusiness integranteBusiness;
	
	@Mock
	private IntegranteAdapter integranteAdapter;
	
	@Mock
	TypedQuery<Integrante> typedQuery;
	

	
	private List<IntegranteDTO> integrantesDTO;
	
	@Before
	public void init(){
		
		integrantesDTO = new ArrayList<IntegranteDTO>();
		integrantesDTO.add(new IntegranteDTO());
		integrantesDTO.add(new IntegranteDTO());	
	}
	
	@Test
	public void debeRetornarTodosLosIntegrantesCuandoSeLosSoliciteAlBusiness(){
		
		//arrange
		List<Integrante> listaIntegrantes = new ArrayList<>();
		Integrante integrante = new Integrante();
		integrante.setNombre("Angela Maria");
		listaIntegrantes.add(integrante);
		
		Mockito.when(entityManager.createNamedQuery("Integrante.findAll",Integrante.class)).thenReturn(typedQuery);
		Mockito.when(typedQuery.getResultList()).thenReturn(listaIntegrantes);
		 List<IntegranteDTO> listaIntegrantesDTO = new ArrayList<>();
	
		Mockito.when(integranteAdapter.listIntegranteToListIntegranteDTO(listaIntegrantes)).thenReturn(listaIntegrantesDTO);
		
		
		//act
		List<IntegranteDTO> integrantesObtenidos = integranteBusiness.obtenerIntegrantes();
		
		//assert
		Mockito.verify(integranteAdapter).listIntegranteToListIntegranteDTO(listaIntegrantes);
		assertEquals(listaIntegrantesDTO, integrantesObtenidos);
	}


	@Test
	public void debeGuardarCuandoSeEnviaUnNuevoIntegrante(){
		//arrange
		IntegranteDTO integranteDTO = new IntegranteDTO();
		Integrante integrante = new Integrante();
		Mockito.when(integranteAdapter.integranteDtoToIntegrante(integranteDTO)).thenReturn(integrante);
		//act
		
		integranteBusiness.saveIntegrate(integranteDTO);
		
		//assert
		
		Mockito.verify(entityManager).persist(integrante);
	}

}
