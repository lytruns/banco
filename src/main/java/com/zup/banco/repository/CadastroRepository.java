package com.zup.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.banco.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	List<Cadastro> findByCpf(String cpf);

	List<Cadastro> findByEmail(String email);

}