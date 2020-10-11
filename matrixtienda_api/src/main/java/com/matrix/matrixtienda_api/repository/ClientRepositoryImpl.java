package com.matrix.matrixtienda_api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;

@Repository
public class ClientRepositoryImpl implements IClientRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ClientResponse registerClient(ClientRequest request) {
		
		ClientResponse response = new ClientResponse();
		
		try {
			jdbcTemplate.update(
					"INSERT INTO CLIENTES (PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, DOCUMENTO, TIPO_DOCUMENTO, "
					+ " CELULAR, TELEFONO, EMAIL, EDAD) VALUES(?,?,?,?,?,?,?,?,?,?)",
					request.getPrimerNombre(), request.getSegundoNombre(), request.getPrimerApellido(), request.getSegundoApellido(), request.getDocumento(), request.getTipoDocumento(), 
					request.getCelular(), request.getTelefono(), request.getEmail(), request.getEdad());
		} catch (DuplicateKeyException e) {
			response.setExitoso(false);
			response.setMensajeError("Ya existe una persona registrada con el documento ingresado "+request.getDocumento());
		}
		
		if(!response.isExitoso() && response.getMensajeError() != null && response.getMensajeError().length()>0) {
			return response;
		}else {
			response.setExitoso(true);
			return response;
		}
		
	}

	@Override
	public ClientResponse getClientxDocumento(ClientRequest request) {
		ClientResponse response = new ClientResponse();
		
		List<ClientDTO> clienteExistente = jdbcTemplate.query(
                "SELECT * FROM CLIENTES WHERE DOCUMENTO = ? ",
                new Object[]{request.getDocumento()},
                (rs, rowNum) ->
                        new ClientDTO(
                        		rs.getInt("ID_CLIENTE"),
                        		rs.getString("DOCUMENTO"),
                        		rs.getString("TIPO_DOCUMENTO"),
                        		rs.getString("PRIMER_NOMBRE"),
                        		rs.getString("SEGUNDO_NOMBRE"),
                        		rs.getString("PRIMER_APELLIDO"),
                        		rs.getString("SEGUNDO_APELLIDO"),
                        		rs.getString("CELULAR"),
                        		rs.getString("TELEFONO"),
                        		rs.getString("EMAIL"),
                        		rs.getInt("EDAD")
                        )
        );
		
		if(clienteExistente.isEmpty()) {
			response.setExitoso(false);
			response.setMensajeError("El cliente con Documento "+request.getDocumento()+" no se encuentra registrado, registrese previamente para continuar con la operación.");
		}else {
			response.setExitoso(true);
			response.setMensajeError(null);
			response.setClient(clienteExistente.get(0));
		}	
		
		return response;
	}
	

}
