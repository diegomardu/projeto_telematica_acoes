package com.projeto.telematica.model;

public enum Setor {
	
	BENS_INDUSTRIAIS("Bens Industriais"),
	COMUNICACOES("Comunicações"),
    CONSUMO_CICLICO("Consumo Cíclico"),
    CONSUMO_NAO_CICLICO("Consumo não Cíclico"),
    FINANCEIRO("Financeiro"),
    MATERIAIS_BASICOS("Materiais Básicos"),
    PETROLEO_GAS_BIOCOMBUSTIVEIS("Petróleo, Gás e Biocombustíveis"),
    SAUDE("Saúde"),
    TECNOLOGIA_DA_INFORMACAO("Tecnologia da Informação"),
    UTILIDADE_PUBLICA("Utilidade Pública");
	
	private String descricao;

	Setor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
