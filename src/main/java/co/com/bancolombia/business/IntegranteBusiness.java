package co.com.bancolombia.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import co.com.bancolombia.entidades.Integrante;

public class IntegranteBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<Integrante> obtenerIntegrantes(){	
		return entityManager.createNamedQuery("Integrante.findAll",Integrante.class).getResultList();
	}
}
