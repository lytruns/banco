package com.zup.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.zup.banco.domain.Cadastro;
import com.zup.banco.repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	CadastroRepository cadastroRepository;

	public Cadastro cadastar(Cadastro cadastro) throws Exception {

		if (existeCPF(cadastro.getCpf())) {

			throw new ResponseStatusException(HttpStatus.CONFLICT, "Cpf já existente na base de dados!");
		}

		else if (existeEmail(cadastro.getEmail())) {

			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já existente na base de dados!");
		}

		else {
			return cadastroRepository.save(cadastro);
		}

	}

	public boolean existeCPF(String cpf) {

		List<Cadastro> cadastro = cadastroRepository.findByCpf(cpf);

		if (cadastro != null && !cadastro.isEmpty()) {

			return true;
		}

		return false;
	}

	public boolean existeEmail(String email) {

		List<Cadastro> cadastro = cadastroRepository.findByEmail(email);

		if (cadastro != null && !cadastro.isEmpty()) {

			return true;
		}

		return false;
	}

	// Buscar Cadastro

	public Cadastro buscar(Long id) {

		return cadastroRepository.findById(id).get();

	}

}
