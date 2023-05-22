package com.uitaloandrade.list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uitaloandrade.list.dto.GameListDTO;
import com.uitaloandrade.list.entities.GameList;
import com.uitaloandrade.list.projections.GameMinProjection;
import com.uitaloandrade.list.repositories.GameListRepository;
import com.uitaloandrade.list.repositories.GameRepository;


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
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll(); // metodo usado para fazer uma consulta ao BD e retornar todos os dados
		//stream permite fazer operacoes com uma sequencia de dados.
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i= min; i<= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}
