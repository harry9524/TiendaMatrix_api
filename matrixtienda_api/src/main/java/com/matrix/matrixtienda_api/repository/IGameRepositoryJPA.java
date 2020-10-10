package com.matrix.matrixtienda_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.matrixtienda_api.modelo.GameDTO;

public interface IGameRepositoryJPA extends JpaRepository<GameDTO, Long> {
	
}
