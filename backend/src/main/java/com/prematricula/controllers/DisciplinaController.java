package com.prematricula.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prematricula.models.Disciplina;
import com.prematricula.repository.DisciplinaRepository;

@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository repositorio;
	
	@GetMapping("/disciplinas")
	public @ResponseBody Iterable<Disciplina> getAlunos() {
		Iterable<Disciplina> disciplinas = repositorio.findAll();
		return disciplinas;
	}
}
