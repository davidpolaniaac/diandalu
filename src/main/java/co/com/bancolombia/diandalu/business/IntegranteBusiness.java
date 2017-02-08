package co.com.bancolombia.diandalu.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import co.com.bancolombia.diandalu.entidades.Integrante;

public class IntegranteBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<Integrante> obtenerIntegrantes(){	
		return entityManager.createNamedQuery("Integrante.findAll",Integrante.class)
				.getResultList();
	}
	@Transactional
	public void saveIntegrate(Integrante integrante){
		entityManager.persist(integrante);
	}
	
	
}
