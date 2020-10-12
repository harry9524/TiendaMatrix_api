package com.matrix.matrixtienda_api.modelo;

import java.io.Serializable;
import java.sql.Date;

public class AlquilarJuegoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idAlquiler;
	private Integer idJuego;
	private String 	nombreJuego;
	private Integer idCliente;
	private String 	nombreCliente;
	private Date 	fechaAlquiler;
	private Date 	fechaVencimiento;
	private String 	codigoCompra;
	
	public AlquilarJuegoDTO() {};
	
	public AlquilarJuegoDTO(Integer idAlquiler, Integer idJuego, String nombreJuego, Integer idCliente, String nombreCliente,
			Date fechaAlquiler, Date fechaVencimiento, String codigoCompra) {
		super();
		this.idAlquiler = idAlquiler;
		this.idJuego = idJuego;
		this.nombreJuego = nombreJuego;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaVencimiento = fechaVencimiento;
		this.codigoCompra = codigoCompra;
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

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(String codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	@Override
	public String toString() {
		return "AlquilerDTO [idAlquiler=" + idAlquiler + ", idJuego=" + idJuego + ", nombreJuego=" + nombreJuego
				+ ", idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", fechaAlquiler=" + fechaAlquiler
				+ ", fechaVencimiento=" + fechaVencimiento + ", codigoCompra=" + codigoCompra + "]";
	}
	
}
