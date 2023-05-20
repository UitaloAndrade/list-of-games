package com.uitaloandrade.list.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uitaloandrade.list.dto.GameListDTO;
import com.uitaloandrade.list.services.GameListService;

@RestController // usado para tornar essa classe a controladora da API.
@RequestMapping(value = "/lists") // configura o caminho que vai ser respondido pela API.
public class GameListController { // Responsavel por fornecer os dados para o front, e a API.

	@Autowired
	private GameListService gameListService;

	// mapeamento da requisicao HTTP
	@GetMapping // endPoint para buscar os objetos
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
