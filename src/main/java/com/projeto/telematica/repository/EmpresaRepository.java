package com.projeto.telematica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.telematica.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
