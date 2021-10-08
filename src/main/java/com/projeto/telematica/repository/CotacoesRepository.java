package com.projeto.telematica.repository;

import com.projeto.telematica.model.CadastroCotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacoesRepository extends JpaRepository<CadastroCotacao, Long> {

}
