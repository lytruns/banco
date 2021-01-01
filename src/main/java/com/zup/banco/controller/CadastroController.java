package com.zup.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.banco.domain.Cadastro;
import com.zup.banco.dto.CadastroRequest;
import com.zup.banco.dto.CadastroResponse;
import com.zup.banco.service.CadastroService;

@RestController
@RequestMapping(value = "/api/cadastro")
public class CadastroController {
	
	@Autowired
	CadastroService cadastroService;

	// Cria Cadastro
	@PostMapping
	public ResponseEntity<CadastroResponse> cadastrar (@RequestBody CadastroRequest cadastroRequest) {

		Cadastro cadastro = cadastroRequest.toModel();
		
		cadastroService.cadastrar(cadastro);
		
		CadastroResponse cadastroResponse  = cadastro.toResponse();
		
		return ResponseEntity.status(HttpStatus.OK).body(cadastroResponse);
		
	}

}
