package com.projeto.telematica.model;

public enum TipoConta {

	ACAO_ORDINARIA("acao_ordinaria"), ACAO_PREFERENCIAL("acao _referencial");

	private String descricao;

	TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
