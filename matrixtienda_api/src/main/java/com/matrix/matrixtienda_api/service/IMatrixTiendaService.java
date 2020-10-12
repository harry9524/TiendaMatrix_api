package com.matrix.matrixtienda_api.service;

import java.util.List;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;
import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

public interface IMatrixTiendaService {

	//Juegos
	public List<PlataformaDTO> getPlataformas() throws Exception;
	public List<MarcaDTO> getMarcas() throws Exception;
	public List<RolDTO> getRoles() throws Exception;
	public List<GameDTO> getGames() throws Exception;	
	public GameDTO getGamexId (GameRequest request) throws Exception;	
	public GameResponse createUpdateGame (GameRequest request) throws Exception;
	
	//Clientes
	public List<ClientDTO> getClients() throws Exception;	
	public ClientDTO getClientxId (ClientRequest request) throws Exception;	
	public ClientResponse createUpdateClient (ClientRequest request) throws Exception;
		
	//Ventas
	public List<AlquilarJuegoDTO> getAlquileres() throws Exception;
	public AlquilarJuegoResponse createUpdateAlquiler(AlquilarJuegoRequest request) throws Exception;
	
}
