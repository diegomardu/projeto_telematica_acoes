package com.projeto.telematica.model;

public enum Setor {
	
	BENS_INDUSTRIAIS("bens_industriais"),
	COMUNICACOES("comunicacoes"),
    CONSUMO_CICLICO("consumo_ciclico"),
    CONSUMO_NAO_CICLICO("consumo_nao_ciclico"),
    FINANCEIRO("financeiro"),
    MATERIAIS_BASICOS("materiais_basicos"),
    PETROLEO_GAS_BIOCOMBUSTIVEIS("petróleo_gas_biocombustiveis"),
    SAUDE("saude"),
    TECNOLOGIA_DA_INFORMACAO("tecnologia_da_informacao"),
    UTILIDADE_PUBLICA("utilidade_tepublica");
	
	private String descricao;

	Setor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
