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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRolIntegrante;

	private String rolIntegrante;

	

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

}