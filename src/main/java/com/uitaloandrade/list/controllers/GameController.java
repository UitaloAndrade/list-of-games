package com.uitaloandrade.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uitaloandrade.list.dto.GameDTO;
import com.uitaloandrade.list.dto.GameMinDTO;
import com.uitaloandrade.list.services.GameService;

@RestController // usado para tornar essa classe a controladora da API.
@RequestMapping(value = "/games") // configura o caminho que vai ser respondido pela API.
public class GameController { // Responsavel por fornecer os dados para o front, e a API.

	@Autowired
	private GameService gameService;

	@GetMapping(value = "/{id}") 
	public GameDTO findById(@PathVariable Long id) { // a anotation usada e para garantir que o id na requisicao seja compativel com a do metodo
		GameDTO result = gameService.findById(id); 
		return result;
	}

	// mapeamento da requisicao HTTP
	@GetMapping // endPoint para buscar os objetos
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
