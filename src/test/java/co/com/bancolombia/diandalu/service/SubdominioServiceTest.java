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
import org.mockito.runners.MockitoJUnitRunner;
import co.com.bancolombia.diandalu.business.SubdominioBusiness;
import co.com.bancolombia.diandalu.entidades.Subdominio;


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
	public void debeRetornarUnSubdominioCuandoLeEnvieUnID() throws Exception {
		//arrange
		Mockito.when(subdominioBusiness.getSubdominio(1)).thenReturn(subdominios.get(0));
		
		//act
		Subdominio subdominio = subdominioService.getSubdominioById(1);
		
		//assert
		assertEquals(subdominios.get(0), subdominio);
	}
	
	@Test
	public void debeVerificarQueSellameElMedotoDelGetDelNegocioCuandoLeEnviaIdDelSundominio() throws Exception {
		//arrange
		Mockito.when(subdominioBusiness.getSubdominio(1)).thenReturn(subdominios.get(0));
		
		//act
		subdominioService.getSubdominioById(1);
		
		//assert
		Mockito.verify(subdominioBusiness).getSubdominio(1);
	}
	
	@Test
	public void debeActualizarUnSubdominioCuandoLEnvieElSubdominioConlosNuevosCambios() throws Exception {
		
		//arrange
		Subdominio subdominio = new Subdominio();
		//act
		subdominioService.updateSubdominio(subdominio);
		
		//assert
		Mockito.verify(subdominioBusiness).updateSubdominio(subdominio);;
	}

	
	@Test
	public void testCreateSubdominio(){
		//Arrange
		Subdominio subdominio = new Subdominio();
		//Act
		subdominioService.createSubdominio(subdominio);
		//Assert
		Mockito.verify(subdominioBusiness).createSubdominio(subdominio);
	}
	

}
