package com.projeto.telematica.service;

import com.projeto.telematica.model.CadastroBalanco;
import com.projeto.telematica.repository.BalancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalancoService {

    @Autowired
    private BalancoRepository balancoRepository;

    public List<CadastroBalanco> pesquisar(){
        return balancoRepository.findAll();
    }

    public void salvar(CadastroBalanco balanco){
        balancoRepository.save(balanco);
    }

    public Double calcularResultadoFinaceira(Double receitasFinanceiras, Double despesasFinanceiras){
        Double receita = receitasFinanceiras - despesasFinanceiras;
        return receita;

    }

}
