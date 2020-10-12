package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;

public class ClientDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private String documentoCliente;
	private String tipoDocumentoCliente;
	private String primerNombreCliente;
	private String segundoNombreCliente;
	private String primerApellidoCliente;
	private String segundoApellidoCliente;
	private String celularCliente;
	private String telefonoCliente;
	private String emailCliente;
	private Integer edadCliente;

	public ClientDTO() {}

	public ClientDTO(Integer idCliente, String documentoCliente, String tipoDocumentoCliente,
			String primerNombreCliente, String segundoNombreCliente, String primerApellidoCliente,
			String segundoApellidoCliente, String celularCliente, String telefonoCliente, String emailCliente,
			Integer edadCliente) {
		this.idCliente = idCliente;
		this.documentoCliente = documentoCliente;
		this.tipoDocumentoCliente = tipoDocumentoCliente;
		this.primerNombreCliente = primerNombreCliente;
		this.segundoNombreCliente = segundoNombreCliente;
		this.primerApellidoCliente = primerApellidoCliente;
		this.segundoApellidoCliente = segundoApellidoCliente;
		this.celularCliente = celularCliente;
		this.telefonoCliente = telefonoCliente;
		this.emailCliente = emailCliente;
		this.edadCliente = edadCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getTipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}

	public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
		this.tipoDocumentoCliente = tipoDocumentoCliente;
	}

	public String getPrimerNombreCliente() {
		return primerNombreCliente;
	}

	public void setPrimerNombreCliente(String primerNombreCliente) {
		this.primerNombreCliente = primerNombreCliente;
	}

	public String getSegundoNombreCliente() {
		return segundoNombreCliente;
	}

	public void setSegundoNombreCliente(String segundoNombreCliente) {
		this.segundoNombreCliente = segundoNombreCliente;
	}

	public String getPrimerApellidoCliente() {
		return primerApellidoCliente;
	}

	public void setPrimerApellidoCliente(String primerApellidoCliente) {
		this.primerApellidoCliente = primerApellidoCliente;
	}

	public String getSegundoApellidoCliente() {
		return segundoApellidoCliente;
	}

	public void setSegundoApellidoCliente(String segundoApellidoCliente) {
		this.segundoApellidoCliente = segundoApellidoCliente;
	}

	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Integer getEdadCliente() {
		return edadCliente;
	}

	public void setEdadCliente(Integer edadCliente) {
		this.edadCliente = edadCliente;
	}

	@Override
	public String toString() {
		return "ClientDTO [idCliente=" + idCliente + ", documentoCliente=" + documentoCliente
				+ ", tipoDocumentoCliente=" + tipoDocumentoCliente + ", primerNombreCliente=" + primerNombreCliente
				+ ", segundoNombreCliente=" + segundoNombreCliente + ", primerApellidoCliente=" + primerApellidoCliente
				+ ", segundoApellidoCliente=" + segundoApellidoCliente + ", celularCliente=" + celularCliente
				+ ", telefonoCliente=" + telefonoCliente + ", emailCliente=" + emailCliente + ", edadCliente="
				+ edadCliente + "]";
	}


}
