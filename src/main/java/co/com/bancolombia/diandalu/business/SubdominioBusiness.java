package co.com.bancolombia.diandalu.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import co.com.bancolombia.diandalu.entidades.Integrante;
import co.com.bancolombia.diandalu.entidades.Subdominio;
import co.com.bancolombia.diandalu.excepciones.ExistenciaSubdominio;

public class SubdominioBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Subdominio getSubdominio(int id) {
		return entityManager.find(Subdominio.class, id);  
	}
	
	@Transactional
	public void updateSubdominio(Subdominio subdominio) {
		 entityManager.merge(subdominio);
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
	public List<Subdominio> mostrarTodosLosSubdominios() {
		
		return entityManager.createNamedQuery("Subdominio.findAll",Subdominio.class)
				.getResultList();
	}

}
