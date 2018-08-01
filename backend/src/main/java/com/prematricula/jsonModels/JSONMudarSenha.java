package com.prematricula.jsonModels;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
/**
 * Representa os campos esperados na requisição /coordenador/mudar-senha
 * */
public class JSONMudarSenha {
	@NotBlank
	@NotEmpty
	private String login;
	@NotBlank
	@NotEmpty
	private String password;
	@NotBlank
	@NotEmpty
	private String newPassword;
	
	
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
