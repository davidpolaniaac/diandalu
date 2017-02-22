package co.com.bancolombia.diandalu.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.bancolombia.diandalu.dto.IntegranteDTO;
import co.com.bancolombia.diandalu.dto.SubdominioDTO;
import co.com.bancolombia.diandalu.entidades.Integrante;
import co.com.bancolombia.diandalu.entidades.Subdominio;

@RunWith(MockitoJUnitRunner.class)
public class SubdominioAdapterTest {
	@Mock
	private IntegranteAdapter integranteAdapter;
	@InjectMocks
	private SubdominioAdapter subdominioAdapter;

	@Test
	public void testSubdominioDtoToSubdominio() throws Exception {
		//arrange
		SubdominioDTO subdominioDTO = new SubdominioDTO();
		subdominioDTO.setNombre("web fondos");
		subdominioDTO.setDescripcion("subdominio de web fondos");
		subdominioDTO.setIdSubdominio(123);
		subdominioDTO.setIntegrantes(new ArrayList<IntegranteDTO>());

		//act
		
		Subdominio subdominio = subdominioAdapter.subdominioDtoToSubdominio(subdominioDTO);
		
		//assert
		
		assertEquals(subdominioDTO.getNombre(), subdominio.getNombre());
		assertEquals(subdominioDTO.getDescripcion(), subdominio.getDescripcion());
		assertEquals(subdominioDTO.getIntegrantes(), subdominio.getIntegrantes());
		assertEquals(subdominioDTO.getIdSubdominio(), subdominio.getIdSubdominio());
		
	}

	@Test
	public void testSubdominioToSubdominioDto() throws Exception {
		//arrange
		Subdominio subdominio = new Subdominio();
		subdominio.setNombre("web fondos");
		subdominio.setDescripcion("subdominio de web fondos");
		subdominio.setIdSubdominio(123);
		subdominio.setIntegrantes(new ArrayList<Integrante>());
		
		//act
		
		SubdominioDTO subdominioDTO = subdominioAdapter.subdominioToSubdominioDto(subdominio);
		
		//assert
		
		assertEquals(subdominio.getNombre(), subdominioDTO.getNombre());
		assertEquals(subdominio.getDescripcion(), subdominioDTO.getDescripcion());
		assertEquals(subdominio.getIntegrantes(), subdominioDTO.getIntegrantes());
		assertEquals(subdominio.getIdSubdominio(), subdominioDTO.getIdSubdominio());
	}

	@Test
	public void testListSubdominioToListSubdominioDTO() throws Exception {
		//arrange
		List<Subdominio> listaSubdominio = new ArrayList<>();
		
		Subdominio subdominio = new Subdominio();
		subdominio.setNombre("web fondos");
		subdominio.setDescripcion("subdominio de web fondos");
		subdominio.setIdSubdominio(123);
		subdominio.setIntegrantes(new ArrayList<Integrante>());
		
		listaSubdominio.add(subdominio);
	
		//act
		List<SubdominioDTO> listaIntegranteDTO = subdominioAdapter.listSubdominioToListSubdominioDTO(listaSubdominio);
		
		//assert
		assertEquals(listaSubdominio.get(0).getNombre(), listaIntegranteDTO.get(0).getNombre());
		assertEquals(listaSubdominio.get(0).getDescripcion(), listaIntegranteDTO.get(0).getDescripcion());
		assertEquals(listaSubdominio.get(0).getIntegrantes(), listaIntegranteDTO.get(0).getIntegrantes());
		assertEquals(listaSubdominio.get(0).getIdSubdominio(), listaIntegranteDTO.get(0).getIdSubdominio());
	}

	@Test
	public void testListSubdominioDtoToListSubdominio() throws Exception {
		//arrange
		List<SubdominioDTO> listaSubdominioDTO = new ArrayList<>();
		
		SubdominioDTO subdominioDTO = new SubdominioDTO();
		subdominioDTO.setNombre("web fondos");
		subdominioDTO.setDescripcion("subdominio de web fondos");
		subdominioDTO.setIdSubdominio(123);
		subdominioDTO.setIntegrantes(new ArrayList<IntegranteDTO>());
		
		listaSubdominioDTO.add(subdominioDTO);
		
		//act
		List<Subdominio> listaIntegrante = subdominioAdapter.listSubdominioDtoToListSubdominio(listaSubdominioDTO);
		
		//assert
		assertEquals(listaSubdominioDTO.get(0).getNombre(), listaIntegrante.get(0).getNombre());
		assertEquals(listaSubdominioDTO.get(0).getDescripcion(), listaIntegrante.get(0).getDescripcion());
		assertEquals(listaSubdominioDTO.get(0).getIntegrantes(), listaIntegrante.get(0).getIntegrantes());
		assertEquals(listaSubdominioDTO.get(0).getIdSubdominio(), listaIntegrante.get(0).getIdSubdominio());
	}

}
