package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;
import java.sql.Date;

public class AlquilarJuegoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idAlquiler;
	private Integer idJuego;
	private String 	nombreJuego;
	private Integer idCliente;
	private String 	documentoCliente;
	private String 	nombreCliente;
	private Date 	fechaInicioPrestamo;
	private Date 	fechaFinPrestamo;
	private String 	codigoCompra;
	private Date 	fechaDevolucion;
	private Integer valorPagado;
	private Integer idPlataforma;
	private String 	nombrePlataforma;
	
	public AlquilarJuegoDTO() {};

	public AlquilarJuegoDTO(Integer idAlquiler, Integer idJuego, String nombreJuego, Integer idCliente,
			String documentoCliente, String nombreCliente, Date fechaInicioPrestamo, Date fechaFinPrestamo,
			String codigoCompra, Date fechaDevolucion, Integer valorPagado, Integer idPlataforma,
			String nombrePlataforma) {
		this.idAlquiler = idAlquiler;
		this.idJuego = idJuego;
		this.nombreJuego = nombreJuego;
		this.idCliente = idCliente;
		this.documentoCliente = documentoCliente;
		this.nombreCliente = nombreCliente;
		this.fechaInicioPrestamo = fechaInicioPrestamo;
		this.fechaFinPrestamo = fechaFinPrestamo;
		this.codigoCompra = codigoCompra;
		this.fechaDevolucion = fechaDevolucion;
		this.valorPagado = valorPagado;
		this.idPlataforma = idPlataforma;
		this.nombrePlataforma = nombrePlataforma;
	}

	public Integer getValorPagado() {
		return valorPagado;
	}

	public void setValorPagado(Integer valorPagado) {
		this.valorPagado = valorPagado;
	}
	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public Date getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}

	public void setFechaFinPrestamo(Date fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(String codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public Integer getIdPlataforma() {
		return idPlataforma;
	}

	public void setIdPlataforma(Integer idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}

	@Override
	public String toString() {
		return "AlquilarJuegoDTO [idAlquiler=" + idAlquiler + ", idJuego=" + idJuego + ", nombreJuego=" + nombreJuego
				+ ", idCliente=" + idCliente + ", documentoCliente=" + documentoCliente + ", nombreCliente="
				+ nombreCliente + ", fechaInicioPrestamo=" + fechaInicioPrestamo + ", fechaFinPrestamo="
				+ fechaFinPrestamo + ", codigoCompra=" + codigoCompra + ", fechaDevolucion=" + fechaDevolucion
				+ ", valorPagado=" + valorPagado + ", idPlataforma=" + idPlataforma + ", nombrePlataforma="
				+ nombrePlataforma + "]";
	}

}
