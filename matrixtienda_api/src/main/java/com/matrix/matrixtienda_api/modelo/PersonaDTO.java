package com.matrix.matrixtienda_api.modelo;

public class PersonaDTO {

	private Integer idPersona;
	private Integer idRol;
	private String 	nombresPersona;
	private String 	apellidosPersona;
	
	public PersonaDTO() {}
	
	public PersonaDTO(Integer idPersona, String nombresPersona, String apellidosPersona) {
		this.idPersona = idPersona;
		this.nombresPersona = nombresPersona;
		this.apellidosPersona = apellidosPersona;
	}
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombresPersona() {
		return nombresPersona;
	}
	public void setNombresPersona(String nombresPersona) {
		this.nombresPersona = nombresPersona;
	}
	public String getApellidosPersona() {
		return apellidosPersona;
	}
	public void setApellidosPersona(String apellidosPersona) {
		this.apellidosPersona = apellidosPersona;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	@Override
	public String toString() {
		return "PersonaDTO [idPersona=" + idPersona + ", idRol=" + idRol + ", nombresPersona=" + nombresPersona
				+ ", apellidosPersona=" + apellidosPersona + "]";
	}
		
}
