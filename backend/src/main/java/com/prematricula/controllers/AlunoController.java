package com.prematricula.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prematricula.jsonModels.JSONPreMatricula;
import com.prematricula.models.Aluno;
import com.prematricula.models.Disciplina;
import com.prematricula.repository.AlunoRepository;
import com.prematricula.repository.DisciplinaRepository;


/**
 * Trata as rotas  "/aluno*
 * */
@RestController
@RequestMapping("/aluno")
public class AlunoController {
	private static final int MINIMO_DE_CREDITOS = 14;
	private static final int MAXIMO_DE_CREDITOS = 24;
	/**
	 * Instância que gerencia a entidade aluno no banco de dados
	 * */
	@Autowired
	private AlunoRepository repositorioAlunos;
	/**
	 * Instância que gerencia a entidade disciplina no banco de dados
	 * */
	@Autowired
	private DisciplinaRepository disciplinasRepositorio;
	
	/**
	 * Processamento do endpoint "/aluno" usando o método GET
	 * @return Um Objeto Iteravel para ser transformado em JSON e enviado como resposta a requisição (todos os alunos registrados)
	 * */
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Aluno> getAlunos() {
		Iterable<Aluno> alunos = repositorioAlunos.findAll();
		return alunos;
	}
	
	/**
	 * Processamento do endpoint "/aluno" usando o método POST (registra um novo aluno no banco de dados)
	 * @param Objeto Aluno recebido na requisição Formato JSON : {"nome" : "exemplo", 
	 * 															  "email" : "exemplo@ccc.ufcg.edu.br",
	 * 															  "periodo" : "2017.1",
	 * 															  "matricula": 117118119 }
	 * @return Objeto Aluno criado
	 * */
	@PostMapping()
	public Aluno registrarAluno(@RequestBody @Valid Aluno aluno) {
		return repositorioAlunos.save(aluno);
	}
	
	/**
	 * Processamento do endpoint "/aluno" usando o método DELETE (deleta um aluno que ja esteja no Banco de dados)
     * @param Objeto Aluno recebido na requisição Formato JSON : {"nome" : "exemplo", 
	 * 															  "email" : "exemplo@ccc.ufcg.edu.br",
	 * 															  "periodo" : "2017.1",
	 * 															  "matricula": 117118119 }
	 * @return Objeto Aluno deletado
	 * */
	@DeleteMapping()
	public Aluno deleteAluno(@RequestBody @Valid Aluno aluno) {
		repositorioAlunos.delete(aluno);
		return aluno;
	}
	
	/**
	 * Processamento do endpoint "/aluno/pre-matricula" usando o método POST (Registra as disciplinas de interesse de um certo aluno previamente registrado)
	 * @param ObjetoJSON no formato { "email": "exemplo@ccc.ufcg.edu.br",
	 * 								  "disciplinas" : [1,2,3,4]}
	 * @return mensagem em formato JSON indicando o status da operação
	 * */
	@PostMapping("/pre-matricula")
	public @ResponseBody String registrarPreMatricula(@RequestBody @Valid JSONPreMatricula request) {
		
		if( validaPreMatricula(request) && validaCreditos(request)) {
			Aluno aluno = repositorioAlunos.getOne(request.getEmail());
			aluno.setDisciplinas(new HashSet<Integer>(request.getDisciplinas()));
			repositorioAlunos.save(aluno);
			return "{ \"message\" : \" Pré-Matricula Registrada!\"}";
		}else if(!validaCreditos(request)){
			 return "{\"message\" : \"Número de créditos inválido!\" }";
		}else {
			return "{ \"message\" : \"Error,  Invalid Format\" }";
		}
	}
	
	/**
	 * Valida se o email passado corresponde a algum aluno previamente registrado/ código das disciplinas é válido
	 * @return Boolean
	 * */
	private Boolean validaPreMatricula(JSONPreMatricula request) {
		Boolean codigosValidos = true;
		if( repositorioAlunos.existsById( request.getEmail() ) ) {
			for(Integer codigoDaDisciplina : request.getDisciplinas()) {
				if( !disciplinasRepositorio.existsById((codigoDaDisciplina ))){
					codigosValidos = false;
				}
			}
		}
		return codigosValidos;
	}
	
	private Boolean validaCreditos(JSONPreMatricula request) {
		List<Integer> disciplinas = request.getDisciplinas();
		int somaDeCreditos = 0;
		for(Integer disciplina: disciplinas) {
			somaDeCreditos += disciplinasRepositorio.findById(disciplina).get().getCreditos();
		}
		
		return ( somaDeCreditos > MINIMO_DE_CREDITOS && somaDeCreditos < MAXIMO_DE_CREDITOS);
	}
	
}
