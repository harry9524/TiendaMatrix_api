package com.matrix.matrixtienda_api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.matrix.matrixtienda_api.modelo.FiltersJuegoDTO;
import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.MarcaRequest;
import com.matrix.matrixtienda_api.modelo.MarcaResponse;
import com.matrix.matrixtienda_api.modelo.PersonaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

@Repository
public class GameRepositoryImpl implements IGameRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public GameResponse createUpdateGame(GameRequest request) {
		GameResponse response = new GameResponse();
		if(request.getIdJuego()==null || request.getIdJuego()==0) {
			//Se procede a Crear el juego	

			try {
				jdbcTemplate.update(
						"INSERT INTO JUEGOS (NOMBRE, DESCRIPCION, PRECIO_JUEGO, PRECIO_ALQUILER, ID_MARCA, FECHA_LANZAMIENTO) VALUES(?,?,?,?,?,?)", 
						request.getNombreJuego(), request.getDescripcionJuego(), request.getPrecioJuego(), request.getPrecioAlquilerJuego(), 
						request.getIdMarca(), request.getFechaLanzamientoJuego());
			} catch (DuplicateKeyException e) {
				response.setExitoso(false);
				response.setMensajeError("Ya existe un juego con el nombre ingresado "+request.getNombreJuego());
			}

		}else {
			//Se procede a Actualizar la Información del Juego

			jdbcTemplate.update(
					"UPDATE JUEGOS SET NOMBRE = ?, DESCRIPCION = ?, PRECIO_JUEGO=?, PRECIO_ALQUILER=?, ID_MARCA=?, FECHA_LANZAMIENTO=? WHERE ID_JUEGO = ? ", 
					request.getNombreJuego(), request.getDescripcionJuego(), request.getPrecioJuego(), request.getPrecioAlquilerJuego(), request.getIdMarca(),
					request.getFechaLanzamientoJuego(), request.getIdJuego());
		}

		if(!response.isExitoso() && response.getMensajeError() != null && response.getMensajeError().length()>0) {
			return response;
		}else {
			response.setExitoso(true);
			return response;
		}

	}

	@Override
	public MarcaResponse createUpdateMarca(MarcaRequest request) throws Exception {
		MarcaResponse response = new MarcaResponse();
		if(request.getIdMarca()==null || request.getIdMarca()==0) {
			//Se procede a Crear La Marca de Juego	
			jdbcTemplate.update(
					"INSERT INTO MARCAS (NOMBRE) VALUES(?)", 
					request.getNombreMarca());
		}

		if(!response.isExitoso() && response.getMensajeError() != null && response.getMensajeError().length()>0) {
			return response;
		}else {
			response.setExitoso(true);
			return response;
		}
	}


	@Override
	public List<MarcaDTO> getMarcas() {

		List<MarcaDTO> marcas = jdbcTemplate.query(
				"SELECT * FROM MARCAS ",
				new Object[]{},
				(rs, rowNum) ->
				new MarcaDTO(
						rs.getInt("ID_MARCA"),
						rs.getString("NOMBRE")
						)
				);

		return marcas;
	}

	@Override
	public List<RolDTO> getRoles() {

		List<RolDTO> roles = jdbcTemplate.query(
				"SELECT * FROM ROLES ",
				new Object[]{},
				(rs, rowNum) ->
				new RolDTO(
						rs.getInt("ID_ROL"),
						rs.getString("NOMBRE")
						)
				);

		return roles;
	}

	@Override
	public List<PersonaDTO> getPersonas() throws Exception {
		List<PersonaDTO> personas = jdbcTemplate.query(
				"SELECT * FROM PERSONAS ",
				new Object[]{},
				(rs, rowNum) ->
				new PersonaDTO(
						rs.getInt("ID_PERSONA"),
						rs.getString("NOMBRES"),
						rs.getString("APELLIDOS")
						)
				);

		return personas;
	}

	@Override
	public List<GameDTO> getGamexFilters(FiltersJuegoDTO request) throws Exception {
		List<GameDTO> games = null;
		if(request.getIdJuego()!= null && request.getIdPersona()== null && request.getIdRol()== null && request.getIdMarca()== null) {
			games = jdbcTemplate.query(
					"SELECT * FROM JUEGOS WHERE ID_JUEGO = ? ",
					new Object[]{request.getIdJuego()},
					(rs, rowNum) ->
					new GameDTO(
							rs.getInt("ID_JUEGO"),
							rs.getString("NOMBRE"),
							rs.getString("DESCRIPCION"),
							rs.getInt("PRECIO_JUEGO"),
							rs.getInt("PRECIO_ALQUILER"),
							rs.getInt("ID_MARCA"),
							rs.getDate("FECHA_LANZAMIENTO")
							)
					);
		}else if(request.getIdJuego()== null && request.getIdPersona()==null && request.getIdRol()==null && request.getIdMarca()==null) {
			games = jdbcTemplate.query(
					"SELECT JUE.*, MAR.NOMBRE AS NOMBRE_MARCA FROM JUEGOS JUE, MARCAS MAR WHERE JUE.ID_MARCA = MAR.ID_MARCA ",
					new Object[]{},
					(rs, rowNum) ->
					new GameDTO(
							rs.getInt("ID_JUEGO"),
							rs.getString("NOMBRE"),
							rs.getString("DESCRIPCION"),
							rs.getInt("PRECIO_JUEGO"),
							rs.getInt("PRECIO_ALQUILER"),
							rs.getInt("ID_MARCA"),
							rs.getDate("FECHA_LANZAMIENTO"),
							rs.getString("NOMBRE_MARCA")
							)
					);
		}else if(request.getIdJuego()== null && request.getIdPersona()!=null && request.getIdRol()!=null && request.getIdMarca()==null) {
			games = jdbcTemplate.query(
					" SELECT DISTINCT JUE.*, MAR.NOMBRE AS NOMBRE_MARCA FROM JUEGOS JUE, MARCAS MAR, ROL_JUEGO ROL_JUE, PERSONAS PER " + 
							" WHERE JUE.ID_MARCA = MAR.ID_MARCA AND ROL_JUE.ID_JUEGO = JUE.ID_JUEGO " + 
							" AND ROL_JUE.ID_PERSONA = PER.ID_PERSONA AND ROL_JUE.ID_PERSONA = ? AND ROL_JUE.ID_ROL = ? ",
							new Object[]{request.getIdPersona(), request.getIdRol()},
							(rs, rowNum) ->
					new GameDTO(
							rs.getInt("ID_JUEGO"),
							rs.getString("NOMBRE"),
							rs.getString("DESCRIPCION"),
							rs.getInt("PRECIO_JUEGO"),
							rs.getInt("PRECIO_ALQUILER"),
							rs.getInt("ID_MARCA"),
							rs.getDate("FECHA_LANZAMIENTO"),
							rs.getString("NOMBRE_MARCA")
							)
					);
		}else if(request.getIdJuego()== null && request.getIdPersona()!=null && request.getIdRol()!=null && request.getIdMarca()!=null) {
			games = jdbcTemplate.query(
					" SELECT DISTINCT JUE.*, MAR.NOMBRE AS NOMBRE_MARCA FROM JUEGOS JUE, MARCAS MAR, ROL_JUEGO ROL_JUE, PERSONAS PER " + 
							" WHERE JUE.ID_MARCA = MAR.ID_MARCA AND ROL_JUE.ID_JUEGO = JUE.ID_JUEGO " + 
							" AND ROL_JUE.ID_PERSONA = PER.ID_PERSONA AND ROL_JUE.ID_PERSONA = ? AND ROL_JUE.ID_ROL = ? AND MAR.ID_MARCA = ? ",
							new Object[]{request.getIdPersona(), request.getIdRol(), request.getIdMarca() },
							(rs, rowNum) ->
					new GameDTO(
							rs.getInt("ID_JUEGO"),
							rs.getString("NOMBRE"),
							rs.getString("DESCRIPCION"),
							rs.getInt("PRECIO_JUEGO"),
							rs.getInt("PRECIO_ALQUILER"),
							rs.getInt("ID_MARCA"),
							rs.getDate("FECHA_LANZAMIENTO"),
							rs.getString("NOMBRE_MARCA")
							)
					);
		}
		return games;
	}

	@Override
	public List<PlataformaDTO> getPlataformas() {

		List<PlataformaDTO> plataformas = jdbcTemplate.query(
				"SELECT * FROM PLATAFORMAS ",
				new Object[]{},
				(rs, rowNum) ->
				new PlataformaDTO(
						rs.getInt("ID_PLATAFORMA"),
						rs.getString("NOMBRE")
						)
				);

		return plataformas;
	}

	@Override
	public List<PlataformaDTO> getPlataformasxGame(Integer IdJuego) throws Exception {
		List<PlataformaDTO> plataformas = jdbcTemplate.query(
				" SELECT PLAC.* FROM PLATAFORMAS PLAC, JUEGOS_PLATAFORMA JUEG_PLA WHERE PLAC.ID_PLATAFORMA = JUEG_PLA.ID_PLATAFORMA "
						+" AND JUEG_PLA.ID_JUEGO = ? ",
						new Object[]{IdJuego},
						(rs, rowNum) ->
						new PlataformaDTO(
								rs.getInt("ID_PLATAFORMA"),
								rs.getString("NOMBRE")
								)
				);

		return plataformas;
	}

}
