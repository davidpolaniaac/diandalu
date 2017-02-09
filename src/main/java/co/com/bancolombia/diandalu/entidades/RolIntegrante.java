package co.com.bancolombia.diandalu.entidades;

import java.io.Serializable;
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


	public int getIdRolIntegrante() {
		return this.idRol;
	}

	public void setIdRolIntegrante(int idRolIntegrante) {
		this.idRol = idRolIntegrante;
	}

	public String getRolIntegrante() {
		return this.nombre;
	}

	public void setRolIntegrante(String rolIntegrante) {
		this.nombre = rolIntegrante;
	}

}