package com.projeto.telematica.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_balanco")
public class CadastroBalanco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NumberFormat(pattern = "#,##0.00")
    private Double receitaLiquida;

    @NumberFormat(pattern = "#,##0.00")
    private Double receitaBruta;

    @NumberFormat(pattern = "#,##0.00")
    private Double receitasFinanceiras;

    @NumberFormat(pattern = "#,##0.00")
    private Double deducoes;

    @NumberFormat(pattern = "#,##0.00")
    private Double impostos;

    @NumberFormat(pattern = "#,##0.00")
    private Double custosFixos;

    @NumberFormat(pattern = "#,##0.00")
    private Double lucroBruto;

    @NumberFormat(pattern = "#,##0.00")
    private Double lucroLiquido;

    @NumberFormat(pattern = "#,##0.00")
    private Double despesaFinanceiras;

    @NumberFormat(pattern = "#,##0.00")
    private Double ebitida;

    private Double resultadoFinanceiro;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private CadastroAcao acao;

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

    public CadastroAcao getAcao() {
        return acao;
    }

    public void setAcao(CadastroAcao acao) {
        this.acao = acao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getReceitaLiquida() {
        return receitaLiquida;
    }

    public void setReceitaLiquida(Double receitaLiquida) {
        this.receitaLiquida = receitaLiquida;
    }

    public Double getCustosFixos() {
        return custosFixos;
    }

    public void setCustosFixos(Double custos) {
        this.custosFixos = custos;
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

    public void setDespesaFinanceiras(Double despesaOperacional) {
        this.despesaFinanceiras = despesaOperacional;
    }

    public Double getEbitida() {
        return ebitida;
    }

    public void setEbitida(Double ebitida) {
        this.ebitida = ebitida;
    }

    public Double getResultadoFinanceiro(Double resultado) {
        return resultadoFinanceiro;
    }

    public void setResultadoFinanceiro(Double resultadoFinanceiro) {
        this.resultadoFinanceiro = resultadoFinanceiro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CadastroBalanco)) return false;
        CadastroBalanco that = (CadastroBalanco) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
