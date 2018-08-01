package com.prematricula.jsonModels;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.prematricula.models.Disciplina;
/**
 * Representa os campos esperados na requisição /coordenador/registrar-disciplina
 * */
public class JSONRegistrarDisciplina {
	@NotBlank
	@NotEmpty
	private String login;
	@NotBlank
	@NotEmpty
	private String password;
	
	private Disciplina disciplina;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}
