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
import co.com.bancolombia.diandalu.dto.SubdominioDTO;
import co.com.bancolombia.diandalu.entidades.Subdominio;


@RunWith(MockitoJUnitRunner.class)
public class SubdominioServiceTest {
	
	@Mock
	private SubdominioBusiness subdominioBusiness;
	@InjectMocks
	private SubdominioService subdominioService;
	
	private List<SubdominioDTO> subdominios;
	
	@Before
	public void init(){
		subdominios = new ArrayList<SubdominioDTO>();
		subdominios.add(new SubdominioDTO());
		subdominios.add(new SubdominioDTO());	
	}
	
	@Test
	public void debeRetornarUnSubdominioCuandoLeEnvieUnID() throws Exception {
		//arrange
		Mockito.when(subdominioBusiness.getSubdominio(1)).thenReturn(subdominios.get(0));
		
		//act
		SubdominioDTO subdominio = subdominioService.getSubdominioById(1);
		
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
		SubdominioDTO subdominio = new SubdominioDTO();
		//act
		subdominioService.updateSubdominio(subdominio);
		
		//assert
		Mockito.verify(subdominioBusiness).updateSubdominio(subdominio);
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
	
	@Test
	public void debeObtenerTodosLosSubdominioCuandoSeLlameAlServicio() throws Exception {
		
		//arrange
		Mockito.when(subdominioBusiness.mostrarTodosLosSubdominios()).thenReturn(subdominios);
		//act
		
		List<SubdominioDTO> listaDeSubdominiosObtenidos= subdominioService.mostrarSubdominios();
		
		
		//assert
		assertEquals(subdominios,listaDeSubdominiosObtenidos);
	}
	
	@Test
	public void debeEliminarUnSubdominioCuandoLlegueUnId(){
		
		//Arrange
		
		
		//Act
		subdominioService.deleteSubdominio(1);
		
		//Assert
		Mockito.verify(subdominioBusiness).deleteSubdominio(1);
	}
	

}
