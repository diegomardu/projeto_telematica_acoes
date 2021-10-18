package com.projeto.telematica.controller;

import com.projeto.telematica.DTO.CadastroBalancoDTO;
import com.projeto.telematica.DTO.CadastroCotacaoDTO;
import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroBalanco;
import com.projeto.telematica.model.CadastroCotacao;
import com.projeto.telematica.repository.BalancoRepository;
import com.projeto.telematica.service.BalancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.projeto.telematica.repository.AcoesRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/balanco")
public class BalancoController {

    private static final String CADASTRO_BALANCO = "CadastroBalanco";

    @Autowired
    private AcoesRepository acoesRepository;

    @Autowired
    private BalancoService balancoService;

    @RequestMapping("/novo")
    public ModelAndView novoBalanco(){
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView cadastrarBalanco(@Validated CadastroBalancoDTO cadastroBalancoDTO) {
        CadastroBalanco cadastroBalanco = cadastroBalancoDTO.toTransformModel();
        balancoService.salvar(cadastroBalanco);
        CadastroAcao acao = acoesRepository.findById(cadastroBalanco.getAcao().getCodigo()).get();
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        mv.addObject("acao",acao);
        return mv;

    }

    @RequestMapping
    public ModelAndView buscarBalanco() {
        List<CadastroBalanco> balancos = balancoService.pesquisar();
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        mv.addObject("balancos", balancos);
        return mv;
    }

    @RequestMapping("/verificar/{id}")
    public ModelAndView verificar(@PathVariable("id")Long id) {
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        Optional<CadastroAcao> acao = acoesRepository.findById(id);
        mv.addObject("acao",acao.get());
        return mv;

    }
}
