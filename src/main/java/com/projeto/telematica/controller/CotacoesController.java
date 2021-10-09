package com.projeto.telematica.controller;

import com.projeto.telematica.DTO.CadastroCotacaoDTO;
import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroCotacao;
import com.projeto.telematica.repository.CotacoesRepository;
import com.projeto.telematica.service.AcoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cotacoes")
public class CotacoesController {

    private static final String CADASTRO_COTACOES = "formVerificar";
    private static final String PESQUISA_ACOES = "PesquisaAcoes";

    @Autowired
    CotacoesRepository cotacoesRepository;

    @Autowired
    AcoesService acoesService;

    @RequestMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView(CADASTRO_COTACOES);
        mv.addObject(new CadastroCotacao());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView CadastrarCotacao(@Validated CadastroCotacaoDTO cadastroCotacaoDTO) {
        CadastroCotacao cotacao = cadastroCotacaoDTO.toTransformModel();
        cotacoesRepository.save(cotacao);
        CadastroAcao acao = acoesService.getAcaoById(cotacao.getAcao().getCodigo()).get();
        ModelAndView mv = new ModelAndView(CADASTRO_COTACOES);
        mv.addObject("acao",acao);
        return mv;

    }

    @RequestMapping
    public ModelAndView BuscarCotacao() {
        List<CadastroCotacao> todasCotacoes = cotacoesRepository.findAll();
        ModelAndView mv = new ModelAndView(CADASTRO_COTACOES);
        mv.addObject("cotacoes", todasCotacoes);
        return mv;
    }

}
