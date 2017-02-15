package co.com.bancolombia.diandalu.entidades;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the integrante database table.
 * 
 */
@Entity
@NamedQuery(name="Integrante.findAll", query="SELECT i FROM Integrante i")
public class Integrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idIntegrante;

	private int cedula;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to RolIntegrante
	@ManyToOne
	@JoinColumn(name="Rol_Integrante_idRolIntegrante")
	private RolIntegrante rolIntegrante;

	//bi-directional many-to-many association to Subdominio
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="integrantes")
	@JsonBackReference
	@JsonIgnore
	private List<Subdominio> subdominios;

	public int getIdIntegrante() {
		return this.idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public int getCedula() {
		return this.cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public RolIntegrante getRolIntegrante() {
		return this.rolIntegrante;
	}

	public void setRolIntegrante(RolIntegrante rolIntegrante) {
		this.rolIntegrante = rolIntegrante;
	}

	public List<Subdominio> getSubdominios() {
		return this.subdominios;
	}

	public void setSubdominios(List<Subdominio> subdominios) {
		this.subdominios = subdominios;
	}

}