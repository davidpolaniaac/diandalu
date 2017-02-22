package co.com.bancolombia.diandalu.dto;

import java.util.List;

public class SubdominioDTO {
	
	private int idSubdominio;
	private String descripcion;
	private String nombre;
	private List<IntegranteDTO> integrantes;
	
	public int getIdSubdominio() {
		return idSubdominio;
	}
	public void setIdSubdominio(int idSubdominio) {
		this.idSubdominio = idSubdominio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<IntegranteDTO> getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(List<IntegranteDTO> integrantes) {
		this.integrantes = integrantes;
	}

}