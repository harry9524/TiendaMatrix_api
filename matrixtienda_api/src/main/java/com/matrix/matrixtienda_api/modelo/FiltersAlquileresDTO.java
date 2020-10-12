package com.matrix.matrixtienda_api.modelo;

public class FiltersAlquileresDTO {

	private String soloVentasDia="N";
	private String documentoCliente;
	
	public String getSoloVentasDia() {
		return soloVentasDia;
	}

	public void setSoloVentasDia(String soloVentasDia) {
		this.soloVentasDia = soloVentasDia;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	@Override
	public String toString() {
		return "FiltersAlquileresDTO [soloVentasDia=" + soloVentasDia + ", documentoCliente=" + documentoCliente + "]";
	}
	
}
