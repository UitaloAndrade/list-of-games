package com.uitaloandrade.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uitaloandrade.list.entities.GameList;

/*
 * Essa classe nao e colocada uma anotation porque como ela herda de JpaRepository o sistema ja entende 
 * que ela e responsavel pelo acesso ao BD.
 */
public interface GameListRepository extends JpaRepository<GameList, Long>{	//Camada de Acesso a dados = responsavel por acessar os dados que estao no BD
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
	
}
