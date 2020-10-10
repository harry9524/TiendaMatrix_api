package com.matrix.matrixtienda_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.service.IMatrixTiendaService;

@RestController
@RequestMapping("/matrixtienda")
public class MatrixTiendaController {

	 private static final Logger log = LoggerFactory.getLogger(MatrixTiendaController.class);
		
		@Autowired
		IMatrixTiendaService service;
		
		@GetMapping("/getGame")
		public GameResponse getGame(@RequestBody GameRequest request){
			log.info(" Info Game a Registrar: "+request.toString());
			return service.getGame(request);
		}
		
		@PostMapping("/registerGame")
		public GameResponse registerGame(@RequestBody GameRequest request){
			log.info(" Info Game a Registrar: "+request.toString());
			return service.registerGame(request);
		}
		
		@PostMapping("/registerClient")
		public ClientResponse registerClient(@RequestBody ClientRequest request){
			log.info(" Info Client a Registrar/Update: "+request.toString());
			return service.registerClient(request);
		}
	
}
