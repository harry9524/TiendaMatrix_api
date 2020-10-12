package com.matrix.matrixtienda_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GenericoResponse;

@Repository
public class ClientRepositoryImpl implements IClientRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ClientResponse createUpdateClient(ClientRequest request) throws Exception{

		ClientResponse response = new ClientResponse();

		if(request.getIdCliente()==null || request.getIdCliente()==0) {
			//Se procede a Crear el Cliente	

			try {
				jdbcTemplate.update(
						"INSERT INTO CLIENTES (PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, DOCUMENTO, TIPO_DOCUMENTO, "
								+ " CELULAR, TELEFONO, EMAIL, EDAD) VALUES(?,?,?,?,?,?,?,?,?,?)",
								request.getPrimerNombreCliente(), request.getSegundoNombreCliente(), request.getPrimerApellidoCliente(), request.getSegundoApellidoCliente(), 
								request.getDocumentoCliente(), request.getTipoDocumentoCliente(), request.getCelularCliente(), request.getTelefonoCliente(), 
								request.getEmailCliente(), request.getEdadCliente());
			} catch (DuplicateKeyException e) {
				response.setExitoso(false);
				response.setMensajeError("Ya existe una persona registrada con el documento ingresado "+request.getDocumentoCliente());
			}

		}else {
			//Se procede a Actualizar la Información del Juego
			jdbcTemplate.update(
					"UPDATE CLIENTES SET PRIMER_NOMBRE = ?, SEGUNDO_NOMBRE =?, PRIMER_APELLIDO =?, SEGUNDO_APELLIDO =?, DOCUMENTO =?, TIPO_DOCUMENTO=?, "
							+ " CELULAR =?, TELEFONO =?, EMAIL =?, EDAD =?) WHERE ID_CLIENTE =?",
							request.getPrimerNombreCliente(), request.getSegundoNombreCliente(), request.getPrimerApellidoCliente(), request.getSegundoApellidoCliente(), 
							request.getDocumentoCliente(), request.getTipoDocumentoCliente(), request.getCelularCliente(), request.getTelefonoCliente(), 
							request.getEmailCliente(), request.getEdadCliente(), request.getIdCliente());
		}

		if(!response.isExitoso() && response.getMensajeError() != null && response.getMensajeError().length()>0) {
			return response;
		}else {
			response.setExitoso(true);
			return response;
		}

	}

	@Override
	public ClientDTO getClientxId(ClientRequest request) throws Exception {
		List<ClientDTO> clienteExistente = null;
		if(request.getIdCliente()!=null && request.getIdCliente()!=0 && request.getDocumentoCliente()==null) {
			
			clienteExistente = jdbcTemplate.query(
					"SELECT * FROM CLIENTES WHERE ID_CLIENTE = ? ",
					new Object[]{request.getIdCliente()},
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
			
		}else if(request.getIdCliente()==null && request.getDocumentoCliente()!=null){
			
			clienteExistente = jdbcTemplate.query(
					"SELECT * FROM CLIENTES WHERE DOCUMENTO = ? ",
					new Object[]{request.getDocumentoCliente()},
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
			
		}else {
			clienteExistente = new ArrayList<ClientDTO>();
			ClientDTO client = new ClientDTO();
			clienteExistente.add(client);
		}
		return clienteExistente.get(0);
	}

	@Override
	public List<ClientDTO> getClients() throws Exception {
		List<ClientDTO> clientes = jdbcTemplate.query(
				"SELECT * FROM CLIENTES ",
				new Object[]{},
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

		return clientes;
	}

	@Override
	public GenericoResponse validteClient(String documentoCliente) throws Exception {
		GenericoResponse response = new GenericoResponse();
		List<ClientDTO> clienteExistente = jdbcTemplate.query(
				"SELECT * FROM CLIENTES WHERE DOCUMENTO = ? ",
				new Object[]{documentoCliente},
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
			response.setMensajeError("El cliente con documento "+documentoCliente+" no existe, por favor creelo en modulo de Administrar Clientes");
		}else {
			response.setExitoso(true);
			response.setMensajeError(null);
		}
		
		return response;
	}

}
