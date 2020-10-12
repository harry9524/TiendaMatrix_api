package com.matrix.matrixtienda_api.repository;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.matrix.matrixtienda_api.modelo.AlquilarJuegoDTO;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoRequest;
import com.matrix.matrixtienda_api.modelo.AlquilarJuegoResponse;

@Repository
public class VentaRepositoryImpl implements IVentaRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getGameTop() throws Exception {
		List<Integer> gameTop = jdbcTemplate.query(
				" SELECT ID_JUEGO, COUNT(*) CANTIDAD  FROM ALQUILER_JUEGOS GROUP BY ID_JUEGO ORDER BY CANTIDAD DESC LIMIT 1 ",
						new Object[]{},
						(rs, rowNum) ->
						new Integer(
								rs.getInt("ID_JUEGO")
								)
				);
		return gameTop.get(0);
	}
	
	@Override
	public Integer getClientFrecuentyer() throws Exception {
		List<Integer> clienteFrecuente = jdbcTemplate.query(
				" SELECT ID_CLIENTE, COUNT(*) CANTIDAD  FROM ALQUILER_JUEGOS GROUP BY ID_CLIENTE ORDER BY CANTIDAD DESC LIMIT 1 ",
						new Object[]{},
						(rs, rowNum) ->
						new Integer(
								rs.getInt("ID_CLIENTE")
								)
				);
		return clienteFrecuente.get(0);
	}
	
	@Override
	public List<AlquilarJuegoDTO> getAlquileres() throws Exception {
		List<AlquilarJuegoDTO> alquileres = jdbcTemplate.query(
				" SELECT VENTAS.*, CONCAT(CLI.PRIMER_NOMBRE,' ',CLI.PRIMER_APELLIDO) AS NOMBRE_CLIENTE , JUEG.NOMBRE NOMBRE_JUEGO, "
				+ " CLI.DOCUMENTO AS DOCUMENTO_CLIENTE FROM ALQUILER_JUEGOS VENTAS, CLIENTES CLI, JUEGOS JUEG WHERE ventas.ID_CLIENTE = CLI.ID_CLIENTE "
				+ " AND VENTAS.ID_JUEGO = JUEG.ID_JUEGO ",
						new Object[]{},
						(rs, rowNum) ->
						new AlquilarJuegoDTO(
								rs.getInt("ID_ALQUILER_JUEGO"),
								rs.getInt("ID_JUEGO"),
								rs.getString("NOMBRE_JUEGO"),
								rs.getInt("ID_CLIENTE"),
								rs.getString("NOMBRE_CLIENTE"),
								rs.getDate("FECHA_ALQUILER"),
								rs.getDate("FECHA_VENCIMIENTO"),
								rs.getString("CODIGO_COMPRA"),
								rs.getString("DOCUMENTO_CLIENTE")
								)
				);

		return alquileres;
	}

	public String randomString(int length) {
		
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		       char c = chars[random.nextInt(chars.length)];
		       sb.append(c);
		}
		String output = sb.toString();
		return output;
	}



	@Override
	public AlquilarJuegoResponse createUpdateAlquiler(AlquilarJuegoRequest request) {

		AlquilarJuegoResponse response = new AlquilarJuegoResponse();

		String codigoGenerado = randomString(10);
		System.err.println("codigoGenerado "+codigoGenerado);

		if(request.getIdAlquiler()==null || request.getIdAlquiler()==0) {
			//Se procede a Crear el juego	

			jdbcTemplate.update(
					"INSERT INTO ALQUILER_JUEGOS (ID_JUEGO, ID_CLIENTE, FECHA_ALQUILER, FECHA_VENCIMIENTO, CODIGO_COMPRA) VALUES(?,?,?,?,?)", 
					request.getIdJuego(), request.getIdCliente(), new Date(), new Date(), codigoGenerado);

		}

		if(!response.isExitoso() && response.getMensajeError() != null && response.getMensajeError().length()>0) {
			return response;
		}else {
			response.setExitoso(true);
			return response;
		}

	}

}
