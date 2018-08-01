package com.prematricula.models;


import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
/**
 * Implementação da abstração de alunos
 * */
@Entity
public class Aluno {

	
	/** Atributos
	 * email : e-mail do aluno a ser registrado (usado como id para consulta no banco de dados)
	 * nome : nome completo do aluno a ser registrado
	 * matricula : matricula do aluno
	 * periodo : periodo de ingresso na universidade
	 * disciplinas : Conjunto de códigos referentes as disciplinas de interesse
	 * */
	@Id
	@NotEmpty
	@NotBlank
	private String email;
	
	@NotBlank
	@NotEmpty
	private String nome;
	@NotBlank
	@NotEmpty
	private String matricula;
	@NotBlank
	@NotEmpty
	private String periodo;
	
	private HashSet<Integer> disciplinas;
	
	/**
	 * Recupera o Nome do aluno
	 * @return nome do Aluno
	 * */
	public String getNome() {
		return nome;
	}

	/**
	 *  Modifica o nome do aluno
	 * @param Novo nome
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupera a matricula do aluno
	 * @return matricula
	 * */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Modifica a matricula do aluno
	 * @param nova matricula
	 * */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Recupera o periodo de entrada do aluno
	 * @return periodo em que o aluno entrou
	 * */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * Modifica o periodo de entrada do aluno
	 * @param periodo de entrada a ser atualizado
	 * **/
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * Recupera o email do aluno
	 * @return atual email do aluno
	 * **/
	public String getEmail() {
		return email;
	}

	/**
	 * Modifica o email do aluno
	 * @param email a ser atualizado
	 * **/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Recupera uma lista com o código das disciplinas a serem atualizadas
	 * @return Lista com as disciplinas
	 * **/
	public HashSet<Integer> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * Modifica a lista de disciplinas de interesse do aluno
	 * @param nova lista de disciplinas
	 * **/
	public void setDisciplinas(HashSet<Integer> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	/**
	 * Representação em string do objeto
	 * @return String contendo a representação do objeto
	 * **/
	public String toString() {
		String response = "";
		response += this.nome + "," + this.email + "," + this.matricula + "," + this.periodo;
		return response;
	}
}
