package com.matrix.matrixtienda_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;
import com.matrix.matrixtienda_api.service.IMatrixTiendaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/matrixtienda")
public class MatrixTiendaController {

	 private static final Logger log = LoggerFactory.getLogger(MatrixTiendaController.class);
		
		@Autowired
		IMatrixTiendaService service;
		
		@GetMapping("/getGamexId/{idJuego}")
		public GameDTO getGamexId(@PathVariable("idJuego") Integer idJuego) throws Exception{
			log.info("Entro en el metodo getGamexId "+idJuego);
			GameRequest request = new GameRequest();
			request.setIdJuego(idJuego);
			return service.getGamexId(request);
		}
		
		@GetMapping("/getMarcas")
		public List<MarcaDTO> getMarcas() throws Exception{
			return service.getMarcas();
		}
		
		@GetMapping("/getPlataformas")
		public List<PlataformaDTO> getPlataformas() throws Exception{
			return service.getPlataformas();
		}
		
		@GetMapping("/getRoles")
		public List<RolDTO> getRoles() throws Exception{
			log.info("Entro en el metodo getRoles");
			return service.getRoles();
		}
		
		@GetMapping("/getGames")
		public List<GameDTO> getGames() throws Exception{
			return service.getGames();
		}
		
		@PostMapping("/createUpdateGame")
		public GameResponse createUpdateGame(@RequestBody GameRequest request) throws Exception{
			log.info("Entro en el metodo createUpdateGame "+request.toString());
			return service.createUpdateGame(request);
		}
		
		@PostMapping("/registerClient")
		public ClientResponse registerClient(@RequestBody ClientRequest request) throws Exception{
			return service.registerClient(request);
		}
	
		@GetMapping("/getClientxDocumento")
		public ClientResponse getClientxDocumento(@RequestBody ClientRequest request) throws Exception{
			return service.getClientxDocumento(request);
		}
}
