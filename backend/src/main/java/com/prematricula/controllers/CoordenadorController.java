package com.prematricula.controllers;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prematricula.jsonModels.JSONExportarCSV;
import com.prematricula.jsonModels.JSONMudarSenha;
import com.prematricula.jsonModels.JSONRegistrarDisciplina;
import com.prematricula.models.Aluno;
import com.prematricula.models.CoordenadorSingleton;
import com.prematricula.models.Disciplina;
import com.prematricula.repository.AlunoRepository;
import com.prematricula.repository.CoordenadorRepository;
import com.prematricula.repository.DisciplinaRepository;

/**
 * Trata as rotas "/coordenador*
 * */
@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {
	
	/**
	 * Singleton referente a entidade coordenador (garante que só existe um único coordenador instanciado no sistema)
	 * */
	private static CoordenadorSingleton coord;
	
	/**
	 * Instância que gerencia a entidade disciplina no banco de dados
	 * */
	@Autowired
	private DisciplinaRepository disciplinasRepositorio;
	
	/**
	 * Instância que gerencia a entidade coordenador no banco de dados
	 * */
	@Autowired
	private CoordenadorRepository coordenadorRepositorio;
	
	/**
	 * Instância que gerencia a entidade aluno no banco de dados
	 * */
	@Autowired
	private AlunoRepository alunosRepositorio;
	
	/**
	 *  Processamento da rota "/coordenador/cadastro-disciplinas".
	 *  Valida as credenciais de coordenador e registra uma nova disciplina no sistema
	 *  @param JSONRegistrarDisciplina Objeto JSON no formato esperado da requisição
	 *  @return JSON indicando se a operação foi bem sucedida
	 *  */
	@PostMapping("/cadastro-disciplinas")
	public  String registrarDisciplina(@RequestBody @Valid JSONRegistrarDisciplina request) {
		coord = coord.getInstanceCoordenador();		
		String response = "";
		if(coord.validarCredenciais(request.getLogin(), request.getPassword())) {
			disciplinasRepositorio.save(request.getDisciplina());
			response = "{ \"message\" : \"Success!\" }";
		}
		else 
		{
			response = "{\"message\" : \"Error, credenciais inválidas! \"}";
		}
		return response;
	}
	
	/**
	 *  Processamento da rota "/coordenador/mudar-senha"
	 *  Valida as credenciais de coordenador e modifica sua senha atual
	 *  @param JSONMudarSenha Objeto no formato esperado do body da requisição
	 *  @return String JSON indicando se a operação foi bem sucedida
	 *  */
	@PostMapping("/mudar-senha")
	public String mudarSenha(@RequestBody @Valid JSONMudarSenha request) {
		coord = coord.getInstanceCoordenador();
		String response = "";
		if(coord.validarCredenciais(request.getLogin(), request.getPassword())) {
			coord.setPassword(request.getNewPassword());
			coordenadorRepositorio.save(coord);
			response = "{ \"message\" : \"Success!\" }";
		}
		else {
			response = "{\"message\" : \"Error, credenciais inválidas! \"}";
		}
		return response;
	}
	
	/**
	 * Processamento da rota /coordenador/csv*
	 * Valida as credenciais de coordenador e retorna JSON com uma String em formato de arquivo csv
	 * @param JSONExportarCsv Objeto no formato esperado do body da requisição
	 * @return String JSON indicando se a operação foi bem sucedida ou nao
	 * */
	@PostMapping("/csv")
	public String exportarCSV(@RequestBody @Valid JSONExportarCSV request) {
		coord = coord.getInstanceCoordenador();
		String response = "";
		if(coord.validarCredenciais(request.getLogin(), request.getPassword())) {
			response = gerarCSV();
		}else {
			response = "Error, credenciais inválidas";
		}
		return response;
	}
	
	/**
	 * Método privado responsável por gerar a string em formato CSV com informações sobre as pre-matriculas
	 * @return String em formato CSV
	 * */
	private String gerarCSV() {
		String csv_buffer = "{ \"csv\": \"nome,email,matricula,periodo,disciplinas \n";
		Iterable<Aluno> alunos =  alunosRepositorio.findAll();
		Iterable<Disciplina> disciplinas = disciplinasRepositorio.findAll();
		
		for(Aluno aluno : alunos) {
			csv_buffer += aluno.toString();
			
			HashSet<Integer> disciplinasDeInteresse = aluno.getDisciplinas();
			if(aluno.getDisciplinas() != null) {
				csv_buffer += ",[ ";
				for(Integer disciplina : disciplinasDeInteresse) {
					csv_buffer += disciplinasRepositorio.findById(disciplina).get().getCodigo() + " ";
				}
				csv_buffer += "]";
			}else {
				csv_buffer += ",None";
			}
			csv_buffer += " \n";
		}
		csv_buffer += "\" }";
		return csv_buffer;
	}
}
