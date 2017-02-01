package co.com.bancolombia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol_integrante database table.
 * 
 */
@Entity
@Table(name="rol_integrante")
@NamedQuery(name="RolIntegrante.findAll", query="SELECT r FROM RolIntegrante r")
public class RolIntegrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRolIntegrante;

	private String rolIntegrante;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="rolIntegrante")
	private List<Integrante> integrantes;

	public RolIntegrante() {
	}

	public int getIdRolIntegrante() {
		return this.idRolIntegrante;
	}

	public void setIdRolIntegrante(int idRolIntegrante) {
		this.idRolIntegrante = idRolIntegrante;
	}

	public String getRolIntegrante() {
		return this.rolIntegrante;
	}

	public void setRolIntegrante(String rolIntegrante) {
		this.rolIntegrante = rolIntegrante;
	}

	public List<Integrante> getIntegrantes() {
		return this.integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public Integrante addIntegrante(Integrante integrante) {
		getIntegrantes().add(integrante);
		integrante.setRolIntegrante(this);

		return integrante;
	}

	public Integrante removeIntegrante(Integrante integrante) {
		getIntegrantes().remove(integrante);
		integrante.setRolIntegrante(null);

		return integrante;
	}

}