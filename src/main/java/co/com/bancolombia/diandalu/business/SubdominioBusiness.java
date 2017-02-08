package co.com.bancolombia.diandalu.business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import co.com.bancolombia.diandalu.entidades.Subdominio;

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

}
