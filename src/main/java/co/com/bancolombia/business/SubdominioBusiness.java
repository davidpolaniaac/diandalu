package co.com.bancolombia.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import co.com.bancolombia.entidades.Subdominio;;

public class SubdominioBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<Subdominio> getSubdominios(){	
		return entityManager.createNamedQuery("Subdominio.findAll",Subdominio.class).getResultList();
	}
	
	@Transactional
	public void saveIntegrate(Subdominio subdominio){
		entityManager.persist(subdominio);
	}

	@Transactional
	public void updateSubdominio(Subdominio subdominio) {
		 entityManager.merge(subdominio);
	}

	@Transactional
	public Subdominio getSubdominio(int id) {
		return entityManager.find(Subdominio.class, id);  
	}
}
