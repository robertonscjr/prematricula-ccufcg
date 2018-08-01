package com.prematricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prematricula.models.Aluno;
/**
 * Interface para gerenciar a entidade Aluno no banco de Dados
 * */
public interface AlunoRepository extends JpaRepository<Aluno,String>{

}
