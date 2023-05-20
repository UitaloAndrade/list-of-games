package com.uitaloandrade.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uitaloandrade.list.dto.GameListDTO;
import com.uitaloandrade.list.entities.GameList;
import com.uitaloandrade.list.repositories.GameListRepository;


/*
 * Como essa classe e uma classe comum, e preciso registrar ela como sendo um componente do sistema
 * para que o Framework possa gerenciar esses componentes.
 * Pode ser registrada como @Component ou no caso de uma clase Service pode se utilizar o apelido que
 * o propio Framework disponibiliza, o @service. Ambos fazem a mesma coisa.
 */
@Service
public class GameListService {
	
	//Injetando um componente GameRepository.
	@Autowired // anotation usado para criar dependencias
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll(); // metodo usado para fazer uma consulta ao BD e retornar todos os dados
		//stream permite fazer operacoes com uma sequencia de dados.
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

}
