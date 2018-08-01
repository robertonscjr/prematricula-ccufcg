package com.prematricula.jsonModels;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
/**
 * Representa os campos esperados na requisição /aluno/pre-matricula
 * */
public class JSONPreMatricula {
	
	@NotEmpty
	private String email;
	@NotEmpty
	private List<Integer> disciplinas;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Integer> getDisciplinas() {
		return (ArrayList<Integer>) disciplinas;
	}
	public void setDisciplinas( List<Integer> disciplinas) {
		this.disciplinas = disciplinas;
	} 

	
}
