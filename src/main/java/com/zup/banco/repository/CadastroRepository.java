package com.zup.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.banco.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	
	

}
