package com.uitaloandrade.list.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// ORM = Mapeamento Objeto Relacional
//essa anotacao faz a configuracao para que essa classe se torne uma tabela no banco relacional
@Entity
@Table(name = "tb_game") // configura o nome da tabela no banco
public class Game {
	
	@Id // confirura o id como PK(chave primaria)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //configura para que o id seja auto incrementavel no BD
	private Long id;
	private String title;
	
	@Column(name = "game_year") // customiza o nome da coluna no BD
	private Integer year;// é feito a alteracao do nome da coluna porque year e uma palavra reservada do sql
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	// Se nao colocar essa instrucao o espaco destinado para esse campo vai ser de apenas 255 caracteres 
	@Column(columnDefinition = "TEXT") // Instrucao para que a JPA na hora de gerar o BD, gere esse campo como sendo um texto  
	private String shortDescription;
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	public Game() {
	}

	public Game(Long id, String title, Integer year, String genre, String platforms, Double score,
			String imgUrl, String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platform) {
		this.platforms = platform;
	}
	
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}

}
