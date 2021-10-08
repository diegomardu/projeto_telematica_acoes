package com.projeto.telematica.model;


import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_cotacoes")
public class CadastroCotacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valorMinimo;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valorMaximo;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal cotacaoAbertura;

    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal cotacaoFechamento;
    private String data;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private CadastroAcao acao;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CadastroCotacao)) return false;
        CadastroCotacao that = (CadastroCotacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
