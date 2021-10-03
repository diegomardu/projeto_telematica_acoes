package com.projeto.telematica.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.Setor;
import com.projeto.telematica.model.TipoConta;
import com.projeto.telematica.repository.AcoesRepository;
import com.projeto.telematica.service.AcoesService;

@Controller
@RequestMapping("/cadastro_acoes")
public class AcoesController {

	private static final String CADASTRO_ACOES = "acoes";
	private static final String PESQUISA_ACOES = "PesquisaAcoes";
	private static final String VERIFICAR_ACOES = "formVerificar";
	private static final String EDITAR_ACOES = "EditPage";

	@Autowired
	private AcoesService acoesService;
	
	@Autowired
	private AcoesRepository acoesRepository;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_ACOES);
		mv.addObject(new CadastroAcao());

	}

	@RequestMapping("/verificar/{id}")
	public ModelAndView verificar(@PathVariable("id")Long id) {
		ModelAndView mv = new ModelAndView(VERIFICAR_ACOES);
		Optional<CadastroAcao> acao= acoesService.getAcaoById(id);
		mv.addObject("acao",acao.get());
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView CadastrarAcao(@Validated CadastroAcao acao, RedirectAttributes atributes) {
		String tiker = acao.getTiker().toUpperCase();
		acao.setTiker(tiker);
		acoesService.salvar(acao);
		ModelAndView mv = new ModelAndView(CADASTRO_ACOES);
		mv.addObject("mensagem", "Ação salva com sucesso!!");
		return mv;

	}


	@RequestMapping
	public ModelAndView BuscarAcao() {
		List<CadastroAcao> todasAcoes = acoesService.pesquisar();
		ModelAndView mv = new ModelAndView(PESQUISA_ACOES);
		mv.addObject("acoes", todasAcoes);
		return mv;
	}


	@RequestMapping("/editar_acao/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		ModelAndView mv =  new ModelAndView(EDITAR_ACOES);
		Optional<CadastroAcao> acao= acoesService.getAcaoById(id);
		mv.addObject("acao",acao.get());
		return mv;
	}

	@RequestMapping("/edit/{id}")
	public String editbyId(CadastroAcao acao) {
		System.out.println(acao.getCodigo().getClass());
		acoesService.updateById(acao);
		return "redirect:/cadastro_acoes";
	}

	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") CadastroAcao acao) {
		ModelAndView mv =  new ModelAndView(CADASTRO_ACOES);
		mv.addObject(acao);
		return mv;
	}

	
	@RequestMapping("/delete/{codigo}")
	public String exlcuir(@PathVariable("codigo")Long codigo) {
		acoesRepository.deleteById(codigo);
		return "redirect:/cadastro_acoes";
	}

	@ModelAttribute("todosTipoConta")
	public List<TipoConta> todosTipoConta() {
		return Arrays.asList(TipoConta.values());

	}

	@ModelAttribute("todosSetores")
	public List<Setor> todosSetores() {
		return Arrays.asList(Setor.values());
	}
}
