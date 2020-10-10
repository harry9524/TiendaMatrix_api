package com.matrix.matrixtienda_api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class ClienteDTO {
	
	public ClienteDTO(Integer idCliente, String documento, String tipoDocumento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String celular, String telefono,
			String email, Integer edad) {
		super();
		this.idCliente = idCliente;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
		this.edad = edad;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE", nullable = false)
	private Integer idCliente;
	
	@Column(name = "DOCUMENTO", nullable = false, unique = true)
	private String documento;
	
	@Column(name = "TIPO_DOCUMENTO", nullable = false)
	private String tipoDocumento;
	
	@Column(name = "PRIMER_NOMBRE", nullable = false)
	private String primerNombre;
	
	@Column(name = "SEGUNDO_NOMBRE", nullable = true)
	private String segundoNombre;
	
	@Column(name = "PRIMER_APELLIDO", nullable = false)
	private String primerApellido;
	
	@Column(name = "SEGUNDO_APELLIDO", nullable = true)
	private String segundoApellido;
	
	@Column(name = "CELULAR", nullable = false)
	private String celular;
	
	@Column(name = "TELEFONO", nullable = true)
	private String telefono;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "EDAD", nullable = false)
	private Integer edad;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", documento=" + documento + ", tipoDocumento=" + tipoDocumento
				+ ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido="
				+ primerApellido + ", segundoApellido=" + segundoApellido + ", celular=" + celular + ", telefono="
				+ telefono + ", email=" + email + ", edad=" + edad + "]";
	}
	
}