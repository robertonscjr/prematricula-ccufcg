package com.prematricula.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
/**
 * Implementação da abstração de Disciplinas
 * */
@Entity
public class Disciplina {
	/** Atributos
	 * codigo : codigo da disciplina no controle acadêmico (usado como id para consulta no banco de dados)
	 * nome : nome da disciplina a ser registrada
	 * vagas : vagas disponíveis para essa disciplina
	 * cargaHoraria : carga horaria da Disciplina
	 * creditos : Número de créditos da disciplina
	 * GRADE : Grade da disciplina
	 * */
	@Id // (Usa a informação do código da disciplina para mapear o objeto no banco de dados)
	private Integer codigo;

	private String nome;
	
	private String grade;	
	
	private Integer vagas;
	
	private Integer cargaHoraria;
	
	private Integer creditos;

	
	/**
	 * Recupera o código da disciplina
	 * @return Código correspondente a disciplina
	 * */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Modifica o código da disciplina
	 * @param novo código
	 * **/
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Recupera o nome da disciplina
	 * @return nome correspondente a disciplina
	 * **/
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica o nome da disciplina
	 * @param novo nome
	 * **/
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Recupera a informação sobre a quantidade de vagas
	 * @return numero de vagas da disciplina
	 * */
	public int getVagas() {
		return vagas;
	}
	
	/**
	 * Modifica o Número de vagas disponíveis
	 * @param novo numero de vagas
	 * */
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	/**
	 * Recupera a informação de carga horária da disciplina
	 * @return carga horária da disciplina
	 * */
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	/**
	 * Modifica o valor de carga horária da disciplina
	 * @param nova carga horária
	 * */
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * Recupera a informaçao do número de créditos da disciplina
	 * @return créditos correspondentes a disciplina
	 * */
	public int getCreditos() {
		return creditos;
	}
	
	/**
	 * Modifica o número de créditos da disciplina
	 * @param novo número de créditos
	 * */
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
}
