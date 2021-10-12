package com.projeto.telematica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_balanco")
public class CadastroBalanco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal receitaLiquida;
    private BigDecimal custos;
    private BigDecimal lucroBruto;
    private BigDecimal lucroLiquido;
    private BigDecimal despesaOperacional;
    private BigDecimal ebitida;

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
