package com.projeto.telematica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.repository.AcoesRepository;

@Service
public class AcoesService {
	
	@Autowired
	private AcoesRepository acoesRepository;
	
	public void salvar(CadastroAcao acao) {
		acoesRepository.save(acao);				
	}
}
