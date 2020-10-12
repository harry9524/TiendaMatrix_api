package com.matrix.matrixtienda_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GenericoResponse;
import com.matrix.matrixtienda_api.repository.IClientRepository;
import com.matrix.matrixtienda_api.repository.IVentaRepository;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	IClientRepository clientRepository;
	
	@Autowired
	IVentaRepository ventaRepository;
	
	@Override
	public List<ClientDTO> getClients() throws Exception {
		return clientRepository.getClients();
	}
	
	@Override
	public ClientResponse createUpdateClient(ClientRequest request) throws Exception{
		return clientRepository.createUpdateClient(request);
	}

	@Override
	public ClientDTO getClientxId(ClientRequest request) throws Exception{
		return clientRepository.getClientxId(request);
	}

	@Override
	public List<ClientDTO> getClientFrecuentyer() throws Exception {

		//Se consulta y obtien el id_cliente del cliente que mas transacciones tenga en la tabla de ALQUILER_JUEGOS
		ClientRequest request = new ClientRequest();
		request.setIdCliente(ventaRepository.getClientFrecuentyer());
		
		//con este id_cliente usamos el metodo de getClientexId para obtener la información de dicho usuario
		List<ClientDTO> clienteFrecuente = new ArrayList<ClientDTO>();
		ClientDTO clientFrecuente = clientRepository.getClientxId(request);
		clienteFrecuente.add(clientFrecuente);
		return clienteFrecuente;
	}

	@Override
	public GenericoResponse validteClient(String documentoCliente) throws Exception {
		return clientRepository.validteClient(documentoCliente);
	}
	
}
