package com.uitaloandrade.list.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // usado para indicar o encapsulamento de 2 atributos em uma classe so. cada atributo representa uma coluna no BD.
public class BelongingPK { // classe criada pra representar o id Game e GameList

	@ManyToOne // representa a associacao muitos para um
	@JoinColumn(name = "game_id") // faz a configuracao do nome do campo na tabela
	private Game game;
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList gameList;
	
	public BelongingPK() {
	}

	public BelongingPK(Game game, GameList gameList) {
		this.game = game;
		this.gameList = gameList;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getGameList() {
		return gameList;
	}

	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, gameList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
	}
	
}
