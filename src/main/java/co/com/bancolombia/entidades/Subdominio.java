package co.com.bancolombia.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subdominio database table.
 * 
 */
@Entity
@NamedQuery(name="Subdominio.findAll", query="SELECT s FROM Subdominio s")
public class Subdominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSubdominio;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Integrante
	@ManyToMany
	@JoinTable(
		name="integrante_has_subdominio"
		, joinColumns={
			@JoinColumn(name="Subdominio_idSubdominio")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Integrante_idIntegrante")
			}
		)
	private List<Integrante> integrantes;

	public Subdominio() {
	}

	public int getIdSubdominio() {
		return this.idSubdominio;
	}

	public void setIdSubdominio(int idSubdominio) {
		this.idSubdominio = idSubdominio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

}