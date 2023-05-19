package com.uitaloandrade.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uitaloandrade.list.entities.Game;

/*
 * Essa classe nao e colocada uma anotation porque como ela herda de JpaRepository o sistema ja entende 
 * que ela e responsavel pelo acesso ao BD.
 */
public interface GameRepository extends JpaRepository<Game, Long>{	//Camada de Acesso a dados = responsavel por acessar os dados que estao no BD

	
}
