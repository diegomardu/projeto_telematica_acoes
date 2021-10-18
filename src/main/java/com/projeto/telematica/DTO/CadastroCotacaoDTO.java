package com.projeto.telematica.DTO;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroCotacao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroCotacaoDTO {

    private Long acaoID;

    private Double valorMinimo;

    private Double valorMaximo;

    private Double cotacaoAbertura;

    private Double cotacaoFechamento;

    public CadastroCotacaoDTO() {
    }

    public CadastroCotacao toTransformModel() {
        CadastroCotacao cotacao = new CadastroCotacao();
        CadastroAcao acao = new CadastroAcao();
        acao.setCodigo(acaoID);
        cotacao.setCotacaoAbertura(cotacaoAbertura);
        cotacao.setCotacaoFechamento(cotacaoFechamento);
        cotacao.setValorMaximo(valorMaximo);
        cotacao.setValorMinimo(valorMinimo);
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cotacao.setAcao(acao);
        Date date = new Date();
        cotacao.setData(df.format(date));
        return cotacao;

    }


    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public Double getCotacaoAbertura() {
        return cotacaoAbertura;
    }

    public void setCotacaoAbertura(Double cotacaoAbertura) {
        this.cotacaoAbertura = cotacaoAbertura;
    }

    public Double getCotacaoFechamento() {
        return cotacaoFechamento;
    }

    public void setCotacaoFechamento(Double cotacaoFechamento) {
        this.cotacaoFechamento = cotacaoFechamento;
    }

    public Long getAcaoID() {
        return acaoID;
    }

    public void setAcaoID(Long acaoID) {
        this.acaoID = acaoID;
    }
}