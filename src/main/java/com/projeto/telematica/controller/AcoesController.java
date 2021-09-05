package com.projeto.telematica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.telematica.model.Empresa;
import com.projeto.telematica.repository.EmpresaRepository;

@Controller
@RequestMapping("/cadastro_acoes")
public class AcoesController {

	private static final String CADASTRO_ACOES = "acoes";

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@RequestMapping("/novo")
	public String novo() {
		return CADASTRO_ACOES;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Empresa empresa) {
		empresaRepository.save(empresa);
		return CADASTRO_ACOES;

	}
}
