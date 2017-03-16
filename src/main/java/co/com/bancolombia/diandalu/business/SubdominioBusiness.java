package co.com.bancolombia.diandalu.business;


import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import co.com.bancolombia.diandalu.adapter.SubdominioAdapter;
import co.com.bancolombia.diandalu.dto.SubdominioDTO;
import co.com.bancolombia.diandalu.entidades.Subdominio;
import co.com.bancolombia.diandalu.excepciones.ExistenciaSubdominio;

public class SubdominioBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private SubdominioAdapter subdominioAdapter;
	
	@Transactional
	public SubdominioDTO getSubdominio(int id) {

		return subdominioAdapter.subdominioToSubdominioDto(entityManager.find(Subdominio.class, id));
	}
	
	@Transactional
	public void updateSubdominio(SubdominioDTO subdominioDTO) {
	
		 entityManager.merge(subdominioAdapter.subdominioDtoToSubdominio(subdominioDTO));
	}
	
	@Transactional
	public void createSubdominio(Subdominio subdominio) {
		List<Subdominio> listaSubdominios = entityManager.createNamedQuery("Subdominio.findAll",Subdominio.class).getResultList();
		if(!listaSubdominios.stream().filter(s->subdominio.getNombre().equals(s.getNombre())).findAny().isPresent()){
			entityManager.persist(subdominio);
		}else{
			throw new ExistenciaSubdominio("El subdominio ya existe");
		}
		
	}
	
	@Transactional
	public List<SubdominioDTO> mostrarTodosLosSubdominios() {
		
		List<Subdominio> listaSubdominio = entityManager.createNamedQuery("Subdominio.findAll",Subdominio.class).getResultList();
		
		return subdominioAdapter.listSubdominioToListSubdominioDTO(listaSubdominio);
	}
	
	@Transactional
	public void deleteSubdominio(int id) {
		
		entityManager.remove(entityManager.find(Subdominio.class, id));
	}

}
