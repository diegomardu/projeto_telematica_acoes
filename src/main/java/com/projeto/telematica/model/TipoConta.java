package com.projeto.telematica.model;

public enum TipoConta {

	ACAO_ORDINARIA("Ações Ordinárias(ON)"), 
	ACAO_PREFERENCIAL("Ações Preferênciais(PN)");

	private String descricao;

	TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
