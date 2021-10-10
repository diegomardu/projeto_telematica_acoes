package com.projeto.telematica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_balanco")
public class CadastroBalanco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double receitaLiquida;
    private Double custos;
    private Double lucroBruto;
    private Double lucroLiquido;
    private Double despesaOperacional;
    private Double ebitida;

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
