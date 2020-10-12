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

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;
import com.matrix.matrixtienda_api.modelo.ClientDTO;
import com.matrix.matrixtienda_api.modelo.ClientRequest;
import com.matrix.matrixtienda_api.modelo.ClientResponse;
import com.matrix.matrixtienda_api.modelo.FiltersAlquileresDTO;
import com.matrix.matrixtienda_api.modelo.FiltersJuegoDTO;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.GenericoResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.MarcaRequest;
import com.matrix.matrixtienda_api.modelo.MarcaResponse;
import com.matrix.matrixtienda_api.modelo.PersonaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;
import com.matrix.matrixtienda_api.service.IClientService;
import com.matrix.matrixtienda_api.service.IGameService;
import com.matrix.matrixtienda_api.service.IVentasService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/matrixtienda")
public class MatrixTiendaController {

	 private static final Logger log = LoggerFactory.getLogger(MatrixTiendaController.class);
		
		@Autowired
		IVentasService ventasService;
		
		@Autowired
		IGameService gameService;
		
		@Autowired
		IClientService clientService;
		
		@GetMapping("/getMarcas")
		public List<MarcaDTO> getMarcas() throws Exception{
			log.info("Entro en el metodo getMarcas");
			return gameService.getMarcas();
		}
		
		@GetMapping("/getPlataformas")
		public List<PlataformaDTO> getPlataformas() throws Exception{
			return gameService.getPlataformas();
		}
		
		@GetMapping("/getRoles")
		public List<RolDTO> getRoles() throws Exception{
			log.info("Entro en el metodo getRoles");
			return gameService.getRoles();
		}
		
		@GetMapping("/getPersonas")
		public List<PersonaDTO> getPersonas() throws Exception{
			log.info("Entro en el metodo getPersonas");
			return gameService.getPersonas();
		}
			
		@GetMapping("/getGames")
		public List<GameDTO> getGames() throws Exception{
			log.info("Entro en el metodo getGames");
			return gameService.getGames();
		}
		
		@PostMapping("/getGamexFilters")
		public List<GameDTO> getGamexFilters(@RequestBody FiltersJuegoDTO request) throws Exception{
			log.info("Entro en el metodo getGamexFilters "+request.toString());
			return gameService.getGamexFilters(request);
		}
		
		@GetMapping("/getGameTop")
		public List<GameDTO> getGameTop() throws Exception{
			log.info("Entro en el metodo getGameTop");
			return gameService.getGameTop();
		}
		
		@GetMapping("/getClients")
		public List<ClientDTO> getClients() throws Exception{
			log.info("Entro en el metodo getClients ");
			return clientService.getClients();
		}
		
		@GetMapping("/getClientFrecuentyer")
		public List<ClientDTO> getClientFrecuentyer() throws Exception{
			log.info("Entro en el metodo getClientFrecuentyer ");
			return clientService.getClientFrecuentyer();
		}
		
		@GetMapping("/getAlquileres")
		public List<AlquilarJuegoDTO> getAlquileres() throws Exception{
			log.info("Entro en el metodo getAlquileres ");
			FiltersAlquileresDTO request = new FiltersAlquileresDTO();
			return ventasService.getAlquileresxFiltro(request);
		}
		
		@GetMapping("/getAlquileres/{documentoCliente}")
		public List<AlquilarJuegoDTO> getAlquileres(@PathVariable("documentoCliente") String documentoCliente) throws Exception{
			log.info("Entro en el metodo getAlquileres "+documentoCliente);
			FiltersAlquileresDTO request = new FiltersAlquileresDTO();
			request.setDocumentoCliente(documentoCliente);
			return ventasService.getAlquileresxFiltro(request);
		}
		
		@PostMapping("/getAlquileresxFiltro")
		public List<AlquilarJuegoDTO> getAlquileresxFiltro(@RequestBody FiltersAlquileresDTO request) throws Exception{
			log.info("Entro en el metodo getAlquileresxFiltro "+request.toString());
			return ventasService.getAlquileresxFiltro(request);
		}
		
		@PostMapping("/getValueAlquiler")
		public AlquilarJuegoDTO getValueAlquiler(@RequestBody AlquilarJuegoRequest request) throws Exception{
			log.info("Entro en el metodo getValueAlquiler ");
			return ventasService.getValueAlquiler(request);
		}
		
		@PostMapping("/createUpdateGame")
		public GameResponse createUpdateGame(@RequestBody GameRequest request) throws Exception{
			log.info("Entro en el metodo createUpdateGame "+request.toString());
			return gameService.createUpdateGame(request);
		}
		
		@PostMapping("/createUpdateMarca")
		public MarcaResponse createUpdateMarca(@RequestBody MarcaRequest request) throws Exception{
			log.info("Entro en el metodo createUpdateMarca "+request.toString());
			return gameService.createUpdateMarca(request);
		}
		
		@PostMapping("/createUpdateAlquiler")
		public AlquilarJuegoResponse createUpdateAlquiler(@RequestBody AlquilarJuegoRequest request) throws Exception{
			log.info("Entro en el metodo createUpdateAlquiler "+request.toString());
			return ventasService.createUpdateAlquiler(request);
		}
		
		@PostMapping("/createUpdateClient")
		public ClientResponse createUpdateClient(@RequestBody ClientRequest request) throws Exception{
			log.info("Entro en el metodo createUpdateClient "+request.toString());
			return clientService.createUpdateClient(request);
		}
		
		@GetMapping("/getGamexId/{idJuego}")
		public GameDTO getGamexId(@PathVariable("idJuego") Integer idJuego) throws Exception{
			log.info("Entro en el metodo getGamexId "+idJuego);
			GameRequest request = new GameRequest();
			request.setIdJuego(idJuego);
			return gameService.getGamexId(request);
		}
		
		@GetMapping("/getPlataformasxGame/{idJuego}")
		public List<PlataformaDTO> getPlataformasxGame(@PathVariable("idJuego") Integer idJuego) throws Exception{
			log.info("Entro en el metodo getPlataformasxGame "+idJuego);
			return gameService.getPlataformasxGame(idJuego);
		}
		
		@GetMapping("/getClientxId/{idCliente}")
		public ClientDTO getClientxId(@PathVariable("idCliente") Integer idCliente) throws Exception{
			log.info("Entro en el metodo getClientxId "+idCliente);
			ClientRequest request = new ClientRequest();
			request.setIdCliente(idCliente);
			return clientService.getClientxId(request);
		}
		
		@GetMapping("/validateClient/{documentoCliente}")
		public GenericoResponse validteClient(@PathVariable("documentoCliente") String documentoCliente) throws Exception{
			log.info("Entro en el metodo validteClient "+documentoCliente);
			return clientService.validteClient(documentoCliente);
		}
		
		
}
