package com.projeto.telematica.repository;

import com.projeto.telematica.model.CadastroBalanco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalancoRepository extends JpaRepository<CadastroBalanco, Long> {
}
