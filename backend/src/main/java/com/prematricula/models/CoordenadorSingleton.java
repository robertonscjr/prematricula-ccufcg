package com.prematricula.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
/**
 * Classe singleton para a abstração do conceito de coordenador
 * */
@Entity
public class CoordenadorSingleton {
	/**
	 * Credenciais do coordenador
	 * */
	@Id // (Usa a informação de login para mapear o objeto no banco de dados)
	@NotEmpty
	@NotBlank
	private String login;
	@NotEmpty
	@NotBlank
	private String password;
	
	/**
	 * Instância do objeto singleton
	 * */
	private static CoordenadorSingleton instancia = null;
	
	/**
	 * Construtor privado
	 * @param login credencial
	 * @param password credencial
	 * @return CoordenadorSingleton instancia estática do objeto
	 * **/
	private CoordenadorSingleton(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	/**
	 * Método usado para recuperar a referência estática do objeto (Cria uma instância caso ainda nao exista)
	 * @return Instância do coordenador
	 * **/
	public static CoordenadorSingleton getInstanceCoordenador() {
		if(instancia == null) {
			instancia = new CoordenadorSingleton("joao", "12345");
		}
		return instancia;
	}
	
	/**
	 * Valida se as credenciais passadas como parametro são equivalentes as armazenadas no objeto
	 * @param login a ser validado
	 * @param password a ser validado
	 * */
	public Boolean validarCredenciais(String login,String password) {
		CoordenadorSingleton coord = getInstanceCoordenador();
		return (coord.getLogin().toString().equals(login.toString()) && coord.password.toString().equals(password) );
	}
	
	/**
	 * Modifica a credencial password do objeto
	 * @param novo password
	 * **/
	public void setPassword(String newPassword) {
		CoordenadorSingleton coord = getInstanceCoordenador();
		coord.password = newPassword;
	}
	
	/**
	 * Recupera o valor da credencial login
	 * @return login do objeto
	 * **/
	public String getLogin() {
		CoordenadorSingleton coord = getInstanceCoordenador();
		return coord.login;
	}
	
	
	public CoordenadorSingleton() {}
}
