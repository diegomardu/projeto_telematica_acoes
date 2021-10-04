package com.projeto.telematica.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<CadastroAcao> pesquisar(){
		return acoesRepository.findAll();
	}

	public Optional<CadastroAcao> getAcaoById (Long id){
		return acoesRepository.findById(id);
	}

	public void updateById (CadastroAcao acao){
		CadastroAcao currentAcao  = acoesRepository.getById(acao.getCodigo());
		currentAcao.setTipoConta(acao.getTipoConta());
		currentAcao.setEmpresa(acao.getEmpresa());
		currentAcao.setSubSetor(acao.getSubSetor());
		currentAcao.setSetor(acao.getSetor());
		currentAcao.setTiker(acao.getTiker().toUpperCase());
		acoesRepository.save(currentAcao);
	}
}
