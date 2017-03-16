package co.com.bancolombia.diandalu.business;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import co.com.bancolombia.diandalu.adapter.IntegranteAdapter;
import co.com.bancolombia.diandalu.dto.IntegranteDTO;
import co.com.bancolombia.diandalu.entidades.Integrante;

public class IntegranteBusiness {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private IntegranteAdapter integranteAdapter;

	@Transactional
	public List<IntegranteDTO> getIntegrantes() {
		List<Integrante> listaIntegrantes = entityManager.createNamedQuery("Integrante.findAll", Integrante.class)
				.getResultList();
		return integranteAdapter.listIntegranteToListIntegranteDTO(listaIntegrantes);
	}

	@Transactional
	public void saveIntegrate(IntegranteDTO integranteDTO) {

		entityManager.persist(integranteAdapter.integranteDtoToIntegrante(integranteDTO));
	}

	@Transactional
	public IntegranteDTO getIntegrante(int id) {

		return integranteAdapter.integranteToIntegranteDto(entityManager.find(Integrante.class, id));
	}
	
	@Transactional
	public void updateIntegrante(IntegranteDTO integranteDTO) {
	
		 entityManager.merge(integranteAdapter.integranteDtoToIntegrante(integranteDTO));
	}
	
	@Transactional
	public void deleteIntegrante(int id){
		entityManager.remove(entityManager.find(Integrante.class, id));
	}
	
}
