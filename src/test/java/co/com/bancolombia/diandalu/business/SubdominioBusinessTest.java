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
import co.com.bancolombia.diandalu.adapter.SubdominioAdapter;
import co.com.bancolombia.diandalu.business.SubdominioBusiness;
import co.com.bancolombia.diandalu.dto.SubdominioDTO;
import co.com.bancolombia.diandalu.entidades.Subdominio;

@RunWith(MockitoJUnitRunner.class)
public class SubdominioBusinessTest {
	
	@Mock
	private EntityManager entityManager;
	@Mock
	private TypedQuery<Subdominio> typedQuery;
	
	@Mock
	private SubdominioAdapter subdominioAdapter;
	
	@InjectMocks
	private SubdominioBusiness subdominioBusiness;
	

	private List<SubdominioDTO> subdominios;
	
	@Before
	public void init(){
		subdominios = new ArrayList<SubdominioDTO>();
		subdominios.add(new SubdominioDTO());
		subdominios.add(new SubdominioDTO());	
	}
	
	@Test
	public void debeActualizarElSubDominioCuandoLeEnvieElSubDominioCOnlosCambiosNevos() throws Exception {
		
		//arrange
		Subdominio subdominio = new Subdominio();
		Mockito.when(subdominioAdapter.subdominioDtoToSubdominio(subdominios.get(0))).thenReturn(subdominio);
		Mockito.doAnswer(new Answer<Void>() {
		    @Override
		    public Void answer(InvocationOnMock invocation) throws Throwable {
		    	  Object[] args = invocation.getArguments();
			      Subdominio subdominio = (Subdominio) args[0];
			      subdominio.setNombre("WEB FONDOS");
			      return null;
		    }
		}).when(entityManager).merge(subdominio);
		    
		//act
		subdominioBusiness.updateSubdominio(subdominios.get(0));
		
		
		//assert
		assertEquals("WEB FONDOS", subdominio.getNombre());
	}



	@Test
	public void cuandoLeEnvieUnIdDeSubDominioDebeRetornarElSubDominio() throws Exception {
		
		//arrange
		
		Subdominio subdominio = new Subdominio();
		
		
		Mockito.when(subdominioAdapter.subdominioToSubdominioDto(subdominio)).thenReturn(subdominios.get(0));
		
		Mockito.when(entityManager.find(Subdominio.class, 1)).thenReturn(subdominio);
		
		//act
		SubdominioDTO subdominioDTO =subdominioBusiness.getSubdominio(1);
		
		//assert
		assertEquals(subdominios.get(0), subdominioDTO);
	}
	
	@Test
	public void debeRetornarTodosLosSubdominiosCuandoSeLosSoliciteAlBusiness() throws Exception {
		
		//arrange
		List<Subdominio> listaSubdominios = new ArrayList<Subdominio>();
		Subdominio subdominioTest1 = new Subdominio();
		listaSubdominios.add(subdominioTest1);
		
		
		Mockito.when(typedQuery.getResultList()).thenReturn(listaSubdominios);
		
		Mockito.when(entityManager.createNamedQuery("Subdominio.findAll", Subdominio.class)).thenReturn(typedQuery);
		
		Mockito.when(subdominioAdapter.listSubdominioToListSubdominioDTO(listaSubdominios)).thenReturn(subdominios);
		
		//act
		List<SubdominioDTO> listaDeSubdominiosObtenidosDeLaBaseDeDatos= subdominioBusiness.mostrarTodosLosSubdominios();
		
		//assert
		assertEquals(subdominios.get(0), listaDeSubdominiosObtenidosDeLaBaseDeDatos.get(0));
	}

	

}
