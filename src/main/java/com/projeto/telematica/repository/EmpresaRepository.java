package com.projeto.telematica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.telematica.model.CadastroAcao;

public interface EmpresaRepository extends JpaRepository<CadastroAcao, Long> {

}
