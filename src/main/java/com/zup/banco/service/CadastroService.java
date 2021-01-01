package com.zup.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.banco.domain.Cadastro;
import com.zup.banco.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	CadastroRepository cadastroRepository;
	
		public Cadastro cadastrar(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
		
	}

}
