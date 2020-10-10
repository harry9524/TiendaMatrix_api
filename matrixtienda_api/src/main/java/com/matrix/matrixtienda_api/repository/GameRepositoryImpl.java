package com.matrix.matrixtienda_api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.matrix.matrixtienda_api.modelo.GameDTO;
import com.matrix.matrixtienda_api.modelo.GameRequest;
import com.matrix.matrixtienda_api.modelo.GameResponse;

public class GameRepositoryImpl implements IGameRepository{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public GameResponse getGame(GameRequest request) {
		GameResponse response = new GameResponse();
		
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
                        		rs.getInt("ID_MARCA")
                        )
        );
		
		if(usuarioJuego.isEmpty()) {
			response.setExitoso(false);
			response.setMensajeError("No se encontro un juego con los criterios ingresados");
		}else {
			response.setExitoso(true);
			response.setMensajeError(null);
			response.setGame(usuarioJuego.get(0));
		}	
		
		return response;
	}
	
}
