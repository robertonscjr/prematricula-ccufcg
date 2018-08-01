package com.prematricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prematricula.models.CoordenadorSingleton;

/**
 * Interface para gerenciar a entidade CoordenadorSingleton no banco de Dados
 * */
public interface CoordenadorRepository extends JpaRepository<CoordenadorSingleton, String>{

}
