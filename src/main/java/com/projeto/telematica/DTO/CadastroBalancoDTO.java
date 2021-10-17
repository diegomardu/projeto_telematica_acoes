package com.projeto.telematica.DTO;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroBalanco;
import com.projeto.telematica.service.BalancoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastroBalancoDTO {

    @Autowired
    private BalancoService balancoService;

    private Long acaoID;

    private Double receitaLiquida;

    private Double custos;

    private Double lucroBruto;

    private Double lucroLiquido;

    private Double despesaOperacional;

    private Double ebitida;

    private Double receitasFinanceiras;

    private Double despesaFinanceiras;

    public Long getAcaoID() {
        return acaoID;
    }

    public void setAcaoID(Long acaoID) {
        this.acaoID = acaoID;
    }

    public Double getReceitaLiquida() {
        return receitaLiquida;
    }

    public void setReceitaLiquida(Double receitaLiquida) {
        this.receitaLiquida = receitaLiquida;
    }

    public Double getCustos() {
        return custos;
    }

    public void setCustos(Double custos) {
        this.custos = custos;
    }

    public Double getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(Double lucroBruto) {
        this.lucroBruto = lucroBruto;
    }

    public Double getLucroLiquido() {
        return lucroLiquido;
    }

    public void setLucroLiquido(Double lucroLiquido) {
        this.lucroLiquido = lucroLiquido;
    }

    public Double getDespesaOperacional() {
        return despesaOperacional;
    }

    public void setDespesaOperacional(Double despesaOperacional) {
        this.despesaOperacional = despesaOperacional;
    }

    public Double getEbitida() {
        return ebitida;
    }

    public void setEbitida(Double ebitida) {
        this.ebitida = ebitida;
    }

    public Double getReceitasFinanceiras() {
        return receitasFinanceiras;
    }

    public void setReceitasFinanceiras(Double receitasFinanceiras) {
        this.receitasFinanceiras = receitasFinanceiras;
    }

    public Double getDespesaFinanceiras() {
        return despesaFinanceiras;
    }

    public void setDespesaFinanceiras(Double despesaFinanceiras) {
        this.despesaFinanceiras = despesaFinanceiras;
    }

    public CadastroBalancoDTO() {
    }

    public CadastroBalanco toTransformModel() {
        CadastroBalanco balanco = new CadastroBalanco();
        CadastroAcao acao = new CadastroAcao();
        acao.setCodigo(acaoID);
        balanco.setReceitaLiquida(receitaLiquida);
        balanco.setCustosFixos(custos);
        balanco.setLucroBruto(lucroBruto);
        balanco.setLucroLiquido(lucroLiquido);
        balanco.setDespesaFinanceiras(despesaOperacional);
        balanco.setEbitida(ebitida);
        balanco.setAcao(acao);
        balanco.setResultadoFinanceiro(balancoService.calcularResultadoFinaceira(receitasFinanceiras,despesaFinanceiras));
        return balanco;

    }

}