package co.com.bancolombia.diandalu.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import co.com.bancolombia.business.SubdominioBusiness;
import co.com.bancolombia.entidades.Subdominio;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubdominioServiceTest {
	
	@Mock
	private SubdominioBusiness subdominioBusiness;
	@InjectMocks
	private SubdominioService subdominioService;
	
	private List<Subdominio> subdominios;
	
	@Before
	public void init(){
		subdominios = new ArrayList<Subdominio>();
		subdominios.add(new Subdominio());
		subdominios.add(new Subdominio());	
	}
	
	@Test
	public void testGetSubdominioById() throws Exception {
		//arrange
		Mockito.when(subdominioBusiness.getSubdominio(1)).thenReturn(subdominios.get(0));
		
		//act
		Subdominio subdominio = subdominioService.getSubdominioById(1);
		
		//assert
		assertEquals(subdominios.get(0), subdominio);
	}
	
	@Test
	public void testUpdateSubdominio() throws Exception {
		
		//arrange
		
		Mockito.doAnswer(new Answer<Void>() {
		    @Override
		    public Void answer(InvocationOnMock invocation) throws Throwable {
		    	  Object[] args = invocation.getArguments();
			      Subdominio subdominio = (Subdominio) args[0];
			      subdominio.setNombre("WEB FONDOS");
			      return null;
		    }
		}).when(subdominioBusiness).updateSubdominio(subdominios.get(0));
		    
		//act
		subdominioService.updateSubdominio(subdominios.get(0));
		
		
		//assert
		assertEquals("WEB FONDOS", subdominios.get(0).getNombre());
	}

	
	
	

}
