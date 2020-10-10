package com.matrix.matrixtienda_api.modelo;

public class GenericoResponse {

	private boolean exitoso;
	private String mensajeError;

	public boolean isExitoso() {
		return exitoso;
	}
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
}
