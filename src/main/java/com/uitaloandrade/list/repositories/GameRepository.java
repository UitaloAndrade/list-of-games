package com.uitaloandrade.list.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uitaloandrade.list.entities.Game;
import com.uitaloandrade.list.projections.GameMinProjection;

/*
 * Essa classe nao e colocada uma anotation porque como ela herda de JpaRepository o sistema ja entende 
 * que ela e responsavel pelo acesso ao BD.
 */
public interface GameRepository extends JpaRepository<Game, Long>{	//Camada de Acesso a dados = responsavel por acessar os dados que estao no BD

	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

}
