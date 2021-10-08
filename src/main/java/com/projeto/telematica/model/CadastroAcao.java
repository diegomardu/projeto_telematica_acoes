package com.projeto.telematica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_acoes")
public class CadastroAcao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String tiker;
	private String empresa;
	private String subSetor;

	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;

	@Enumerated(EnumType.STRING)
	private Setor setor;

	@OneToMany(mappedBy = "acao")
	private List<CadastroCotacao> cotacoes = new ArrayList<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTiker() {
		return tiker;
	}

	public void setTiker(String tiker) {
		this.tiker = tiker;
	}

	public String getempresa() {
		return empresa;
	}

	public void setempresa(String empresa) {
		this.empresa = empresa;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSubSetor() {
		return subSetor;
	}

	public void setSubSetor(String subSetor) {
		this.subSetor = subSetor;
	}

	public List<CadastroCotacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<CadastroCotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroAcao other = (CadastroAcao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
