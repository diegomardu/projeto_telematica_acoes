package com.projeto.telematica.DTO;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroCotacao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroCotacaoDTO {

    private Long acaoID;

    private BigDecimal valorMinimo;

    private BigDecimal valorMaximo;

    private BigDecimal cotacaoAbertura;

    private BigDecimal cotacaoFechamento;

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


    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public BigDecimal getCotacaoAbertura() {
        return cotacaoAbertura;
    }

    public void setCotacaoAbertura(BigDecimal cotacaoAbertura) {
        this.cotacaoAbertura = cotacaoAbertura;
    }

    public BigDecimal getCotacaoFechamento() {
        return cotacaoFechamento;
    }

    public void setCotacaoFechamento(BigDecimal cotacaoFechamento) {
        this.cotacaoFechamento = cotacaoFechamento;
    }

    public Long getAcaoID() {
        return acaoID;
    }

    public void setAcaoID(Long acaoID) {
        this.acaoID = acaoID;
    }
}