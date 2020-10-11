package com.matrix.matrixtienda_api.modelo;

public class ClientRequest extends ClientDTO{

	public ClientRequest() {
		
	}
	
	public ClientRequest(Integer idCliente, String documento, String tipoDocumento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String celular, String telefono,
			String email, Integer edad) {
		super(idCliente, documento, tipoDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, celular,
				telefono, email, edad);
		// TODO Auto-generated constructor stub
	}

}
