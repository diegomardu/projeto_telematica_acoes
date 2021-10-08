package com.projeto.telematica.controller;

import com.projeto.telematica.model.CadastroCotacao;
import com.projeto.telematica.repository.CotacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/cotacoes")
public class CotacoesController {

    private static final String CADASTRO_COTACOES = "formVerificar";
    private static final String PESQUISA_ACOES = "PesquisaAcoes";

    @Autowired
    CotacoesRepository cotacoesRepository;

    @RequestMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView(CADASTRO_COTACOES);
        mv.addObject(new CadastroCotacao());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView CadastrarCotacao(@Validated CadastroCotacao cadastroCotacao) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        cadastroCotacao.setData(df.format(date));
        cotacoesRepository.save(cadastroCotacao);
        ModelAndView mv = new ModelAndView(PESQUISA_ACOES);
        mv.addObject("mensagem", "Cotação salva com sucesso!!");
        return mv;

    }

}
