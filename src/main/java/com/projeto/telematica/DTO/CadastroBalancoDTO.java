package com.projeto.telematica.DTO;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroBalanco;

import java.math.BigDecimal;

public class CadastroBalancoDTO {

    private Long acaoID;

    private BigDecimal receitaLiquida;

    private BigDecimal custos;

    private BigDecimal lucroBruto;

    private BigDecimal lucroLiquido;

    private BigDecimal despesaOperacional;

    private BigDecimal ebitida;

    public Long getAcaoID() {
        return acaoID;
    }

    public void setAcaoID(Long acaoID) {
        this.acaoID = acaoID;
    }

    public BigDecimal getReceitaLiquida() {
        return receitaLiquida;
    }

    public void setReceitaLiquida(BigDecimal receitaLiquida) {
        this.receitaLiquida = receitaLiquida;
    }

    public BigDecimal getCustos() {
        return custos;
    }

    public void setCustos(BigDecimal custos) {
        this.custos = custos;
    }

    public BigDecimal getLucroBruto() {
        return lucroBruto;
    }

    public void setLucroBruto(BigDecimal lucroBruto) {
        this.lucroBruto = lucroBruto;
    }

    public BigDecimal getLucroLiquido() {
        return lucroLiquido;
    }

    public void setLucroLiquido(BigDecimal lucroLiquido) {
        this.lucroLiquido = lucroLiquido;
    }

    public BigDecimal getDespesaOperacional() {
        return despesaOperacional;
    }

    public void setDespesaOperacional(BigDecimal despesaOperacional) {
        this.despesaOperacional = despesaOperacional;
    }

    public BigDecimal getEbitida() {
        return ebitida;
    }

    public void setEbitida(BigDecimal ebitida) {
        this.ebitida = ebitida;
    }

    public CadastroBalancoDTO() {
    }

    public CadastroBalanco toTransformModel() {
        CadastroBalanco balanco = new CadastroBalanco();
        CadastroAcao acao = new CadastroAcao();
        acao.setCodigo(acaoID);
        balanco.setReceitaLiquida(receitaLiquida);
        balanco.setCustos(custos);
        balanco.setLucroBruto(lucroBruto);
        balanco.setLucroLiquido(lucroLiquido);
        balanco.setDespesaOperacional(despesaOperacional);
        balanco.setEbitida(ebitida);
        balanco.setAcao(acao);
        return balanco;

    }

}