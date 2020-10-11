package com.matrix.matrixtienda_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		@GetMapping("/getGamexId")
		public GameResponse getGamexId(@RequestBody GameRequest request){
			return service.getGamexId(request);
		}
		
		@GetMapping("/getMarcas")
		public List<MarcaDTO> getMarcas(){
			return service.getMarcas();
		}
		
		@GetMapping("/getPlataformas")
		public List<PlataformaDTO> getPlataformas(){
			return service.getPlataformas();
		}
		
		@GetMapping("/getRoles")
		public List<RolDTO> getRoles(){
			log.info("Entro en el metodo getRoles");
			return service.getRoles();
		}
		
		@GetMapping("/getGames")
		public List<GameDTO> getGames(){
			return service.getGames();
		}
		
		@PostMapping("/registerGame")
		public GameResponse registerGame(@RequestBody GameRequest request){
			return service.registerGame(request);
		}
		
		@PostMapping("/registerClient")
		public ClientResponse registerClient(@RequestBody ClientRequest request){
			return service.registerClient(request);
		}
	
		@GetMapping("/getClientxDocumento")
		public ClientResponse getClientxDocumento(@RequestBody ClientRequest request){
			return service.getClientxDocumento(request);
		}
}
