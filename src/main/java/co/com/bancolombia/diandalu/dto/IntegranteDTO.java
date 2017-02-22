package co.com.bancolombia.diandalu.dto;


public class IntegranteDTO{
	
	private int idIntegrante;

	private int cedula;

	private String email;

	private String nombre;
	
	private RolIntegranteDTO rolIntegranteDto;
	
	public RolIntegranteDTO getRolIntegranteDto() {
		return rolIntegranteDto;
	}

	public void setRolIntegranteDto(RolIntegranteDTO rolIntegranteDto) {
		this.rolIntegranteDto = rolIntegranteDto;
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}