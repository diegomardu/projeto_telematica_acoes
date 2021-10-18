package com.projeto.telematica.DTO;

import com.projeto.telematica.model.CadastroAcao;
import com.projeto.telematica.model.CadastroBalanco;
import com.projeto.telematica.service.BalancoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroBalancoDTO {

    @Autowired
    private BalancoService balancoService;

    private Long acaoID;

    private Double receitaLiquida;

    private Double receitaBruta;

    private Double receitasFinanceiras;

    private Double deducoes;

    private Double impostos;

    private Double custosFixos;

    private Double lucroBruto;

    private Double lucroLiquido;

    private Double despesaFinanceiras;

    private Double ebitida;

    private Double resultadoFinanceiro;

    private String dataCadastro;

    public Long getAcaoID() {
        return acaoID;
    }

    public void setAcaoID(Long acaoID) {
        this.acaoID = acaoID;
    }

    public BalancoService getBalancoService() {
        return balancoService;
    }

    public void setBalancoService(BalancoService balancoService) {
        this.balancoService = balancoService;
    }

    public Double getReceitaLiquida() {
        return receitaLiquida;
    }

    public void setReceitaLiquida(Double receitaLiquida) {
        this.receitaLiquida = receitaLiquida;
    }

    public Double getReceitaBruta() {
        return receitaBruta;
    }

    public void setReceitaBruta(Double receitaBruta) {
        this.receitaBruta = receitaBruta;
    }

    public Double getReceitasFinanceiras() {
        return receitasFinanceiras;
    }

    public void setReceitasFinanceiras(Double receitasFinanceiras) {
        this.receitasFinanceiras = receitasFinanceiras;
    }

    public Double getDeducoes() {
        return deducoes;
    }

    public void setDeducoes(Double deducoes) {
        this.deducoes = deducoes;
    }

    public Double getImpostos() {
        return impostos;
    }

    public void setImpostos(Double impostos) {
        this.impostos = impostos;
    }

    public Double getCustosFixos() {
        return custosFixos;
    }

    public void setCustosFixos(Double custosFixos) {
        this.custosFixos = custosFixos;
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

    public Double getDespesaFinanceiras() {
        return despesaFinanceiras;
    }

    public void setDespesaFinanceiras(Double despesaFinanceiras) {
        this.despesaFinanceiras = despesaFinanceiras;
    }

    public Double getEbitida() {
        return ebitida;
    }

    public void setEbitida(Double ebitida) {
        this.ebitida = ebitida;
    }

    public Double getResultadoFinanceiro() {
        return resultadoFinanceiro;
    }

    public void setResultadoFinanceiro(Double resultadoFinanceiro) {
        this.resultadoFinanceiro = resultadoFinanceiro;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public CadastroBalancoDTO() {
    }

    public CadastroBalanco toTransformModel() {
        CadastroBalanco balanco = new CadastroBalanco();
        CadastroAcao acao = new CadastroAcao();
        acao.setCodigo(acaoID);
        balanco.setReceitaBruta(receitaBruta);
        balanco.setReceitasFinanceiras(receitasFinanceiras);
        balanco.setDeducoes(deducoes);
        balanco.setDespesaFinanceiras(despesaFinanceiras);
        balanco.setCustosFixos(custosFixos);
        balanco.setImpostos(impostos);
        balanco.setAcao(acao);
        balanco.setResultadoFinanceiro(calculaResultadoFianceiro(receitasFinanceiras,despesaFinanceiras));
        balanco.setReceitaLiquida(calculaReceitaLiquida(receitaBruta, deducoes));
        balanco.setLucroLiquido(calculaLucroLiquido(receitaBruta, custosFixos, impostos));
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        balanco.setDataCadastro(df.format(date));
        double lucroL = balanco.getLucroLiquido();
        double resultadoF = balanco.getResultadoFinanceiro();
        balanco.setEbitida(calculaEbit(lucroL,resultadoF,impostos));
        return balanco;

    }

    public Double calculaResultadoFianceiro(Double receitasFinanceiras, Double despesaFinanceiras){
        return receitasFinanceiras - despesaFinanceiras;
    }

    public Double calculaReceitaLiquida(Double receitaBruta, Double deducoes){
        return receitaBruta - deducoes;
    }

    public Double calculaLucroLiquido(Double receitaBruta, Double custosFixos, Double impostos){
        return receitaBruta - (custosFixos + impostos);
    }

    public Double calculaEbit(Double lucroLiquido, Double resultadoFinanceiro, Double impostos){
        return lucroLiquido + resultadoFinanceiro + impostos;
    }



}