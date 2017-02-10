package co.com.bancolombia.diandalu.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import co.com.bancolombia.diandalu.business.SubdominioBusiness;
import co.com.bancolombia.diandalu.entidades.Subdominio;

@RunWith(MockitoJUnitRunner.class)
public class SubdominioBusinessTest {
	
	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private SubdominioBusiness subdominioBusiness;
	
	private List<Subdominio> subdominios;
	
	@Before
	public void init(){
		subdominios = new ArrayList<Subdominio>();
		subdominios.add(new Subdominio());
		subdominios.add(new Subdominio());	
	}

	@Test
	public void debeActualizarElSubDominioCuandoLeEnvieElSubDominioCOnlosCambiosNevos() throws Exception {
		
		//arrange
		Mockito.doAnswer(new Answer<Void>() {
		    @Override
		    public Void answer(InvocationOnMock invocation) throws Throwable {
		    	  Object[] args = invocation.getArguments();
			      Subdominio subdominio = (Subdominio) args[0];
			      subdominio.setNombre("WEB FONDOS");
			      return null;
		    }
		}).when(entityManager).merge(subdominios.get(0));
		    
		//act
		subdominioBusiness.updateSubdominio(subdominios.get(0));
		
		
		//assert
		assertEquals("WEB FONDOS", subdominios.get(0).getNombre());
	}

	@Test
	public void cuandoLeEnvieUnIdDeSubDominioDebeRetornarElSubDominio() throws Exception {
		
		//arrange
		Mockito.when(entityManager.find(Subdominio.class, 1)).thenReturn(subdominios.get(0));
		
		//act
		Subdominio subdominio =subdominioBusiness.getSubdominio(1);
		
		//assert
		assertEquals(subdominios.get(0), subdominio);
	}
	


}
