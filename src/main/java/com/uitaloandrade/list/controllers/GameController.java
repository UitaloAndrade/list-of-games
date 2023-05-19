package com.uitaloandrade.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uitaloandrade.list.dto.GameMinDto;
import com.uitaloandrade.list.services.GameService;

@RestController // usado para tornar essa classe a controladora da API.
@RequestMapping(value = "/games") // configura o caminho que vai ser respondido pela API.
public class GameController { // Responsavel por fornecer os dados para o front, e a API.

	@Autowired
	private GameService gameService;
	
	// mapeamento da requisicao HTTP
	@GetMapping // endPoint para buscar os objetos
	public List<GameMinDto> findAll(){
		List<GameMinDto> result = gameService.findAll();
		return result;
	}
}
