package com.prematricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prematricula.models.Disciplina;

/**
 * Interface para gerenciar a entidade Disciplinas no banco de Dados
 * */
public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer>{

}
