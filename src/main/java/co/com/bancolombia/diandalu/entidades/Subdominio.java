package co.com.bancolombia.diandalu.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Set;


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

	@NotNull(message = "Descripcion cannot be null")
	@Size(min = 5, max = 100, message = "Descripcion must be between 5 and 100 characters")
	private String descripcion;

	@Size(min = 2, max = 45, message = "Nombre must be between 2 and 45 characters")
	@NotNull(message = "Name cannot be null")
	private String nombre;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Integrante_has_Subdominio", joinColumns = {
			@JoinColumn(name = "Integrante_idIntegrante", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "Subdominio_idSubdominio",
					nullable = false, updatable = false) })
	@JsonManagedReference
	private Set<Integrante> integrantes = new HashSet<>(0);

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

	public Set<Integrante> getIntegrantes() {
		return this.integrantes;
	}

	public void setIntegrantes(Set<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

}