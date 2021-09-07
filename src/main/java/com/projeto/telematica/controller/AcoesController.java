package com.projeto.telematica.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.Setor;
import com.projeto.telematica.model.TipoConta;
import com.projeto.telematica.service.AcoesService;

@Controller
@RequestMapping("/cadastro_acoes")
public class AcoesController {

	private static final String CADASTRO_ACOES = "acoes";

	@Autowired
	private AcoesService acoesService;

	@RequestMapping("/novo")
	public String novo() {
		return CADASTRO_ACOES;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(CadastroAcao acao, RedirectAttributes atributes) {
		String tiker = acao.getTiker().toUpperCase();
		acao.setTiker(tiker);
		acoesService.salvar(acao);
		ModelAndView mv = new ModelAndView(CADASTRO_ACOES);
		mv.addObject("mensagem", "Ação salva com sucesso!!");
		return mv;

	}

	@ModelAttribute("todosTipoConta")
	public List<TipoConta> todosTipoConta() {
		return Arrays.asList(TipoConta.values());

	}
	
	@ModelAttribute("todosSetores")
	public List<Setor> todosSetores(){
		return Arrays.asList(Setor.values());
	}
}
