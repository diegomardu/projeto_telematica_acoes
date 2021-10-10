package com.projeto.telematica.controller;

import com.projeto.telematica.DTO.CadastroCotacaoDTO;
import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroBalanco;
import com.projeto.telematica.model.CadastroCotacao;
import com.projeto.telematica.repository.BalancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/balanco")
public class BalancoController {

    private static final String CADASTRO_BALANCO = "CadastroBalanco";

    @Autowired
    private BalancoRepository balancoRepository;

    @RequestMapping("/novo")
    public ModelAndView novoBalanco(){
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView CadastrarBalanco(@Validated  CadastroBalanco cadastroBalanco) {
        balancoRepository.save(cadastroBalanco);
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        return mv;

    }

    @RequestMapping
    public ModelAndView BuscarCotacao() {
        List<CadastroBalanco> balancos = balancoRepository.findAll();
        ModelAndView mv = new ModelAndView(CADASTRO_BALANCO);
        mv.addObject("balancos", balancos);
        return mv;
    }
}
