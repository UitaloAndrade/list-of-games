package com.uitaloandrade.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uitaloandrade.list.dto.GameListDTO;
import com.uitaloandrade.list.dto.GameMinDTO;
import com.uitaloandrade.list.services.GameListService;
import com.uitaloandrade.list.services.GameService;

@RestController // usado para tornar essa classe a controladora da API.
@RequestMapping(value = "/lists") // configura o caminho que vai ser respondido pela API.
public class GameListController { // Responsavel por fornecer os dados para o front, e a API.

	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;

	// mapeamento da requisicao HTTP
	@GetMapping // endPoint para buscar os objetos
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
}
