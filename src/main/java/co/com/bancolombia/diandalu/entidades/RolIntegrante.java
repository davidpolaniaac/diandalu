package co.com.bancolombia.diandalu.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

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
	private int idRol;

	private String nombre;

	//bi-directional many-to-one association to Integrante
	@OneToMany(mappedBy="rolIntegrante")
	private List<Integrante> integrantes;

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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