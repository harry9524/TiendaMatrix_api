package com.matrix.matrixtienda_api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;
import com.matrix.matrixtienda_api.modelo.MarcaDTO;
import com.matrix.matrixtienda_api.modelo.PlataformaDTO;
import com.matrix.matrixtienda_api.modelo.RolDTO;

@Repository
public class GameRepositoryImpl implements IGameRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public GameDTO getGamexId(GameRequest request) throws Exception {

		List<GameDTO> usuarioJuego = jdbcTemplate.query(
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

		if(usuarioJuego.isEmpty()) {
			throw new Exception("No se encontro un juego con los criterios ingresados");
		}

		return usuarioJuego.get(0);
	}

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
	public List<GameDTO> getGames() {

		List<GameDTO> games = jdbcTemplate.query(
				"SELECT * FROM JUEGOS ",
				new Object[]{},
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

		return games;
	}

	@Override
	public List<PlataformaDTO> getPlataformas() {

		List<PlataformaDTO> games = jdbcTemplate.query(
				"SELECT * FROM PLATAFORMAS ",
				new Object[]{},
				(rs, rowNum) ->
				new PlataformaDTO(
						rs.getInt("ID_PLATAFORMA"),
						rs.getString("NOMBRE")
						)
				);

		return games;
	}


}
