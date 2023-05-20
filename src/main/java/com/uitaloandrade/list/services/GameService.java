package com.uitaloandrade.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uitaloandrade.list.dto.GameMinDTO;
import com.uitaloandrade.list.entities.Game;
import com.uitaloandrade.list.repositories.GameRepository;

/*
 * Como essa classe e uma classe comum, e preciso registrar ela como sendo um componente do sistema
 * para que o Framework possa gerenciar esses componentes.
 * Pode ser registrada como @Component ou no caso de uma clase Service pode se utilizar o apelido que
 * o propio Framework disponibiliza, o @service. Ambos fazem a mesma coisa.
 */
@Service
public class GameService {
	
	//Injetando um componente GameRepository.
	@Autowired // anotation usado para criar dependencias
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll(); // metodo usado para fazer uma consulta ao BD e retornar todos os dados
		//stream permite fazer operacoes com uma sequencia de dados.
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

}
