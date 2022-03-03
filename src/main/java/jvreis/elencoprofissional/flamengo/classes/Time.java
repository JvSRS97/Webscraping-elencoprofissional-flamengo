package jvreis.elencoprofissional.flamengo.classes;


import java.util.ArrayList;
import java.util.List;

public class Time {
	public List<Jogador> goleiros = new ArrayList<>();
	public List<Jogador> zagueiros = new ArrayList<>();
	public List<Jogador> laterais_direitos = new ArrayList<>();
	public List<Jogador> laterais_esquerdos = new ArrayList<>();
	public List<Jogador> volantes = new ArrayList<>();
	public List<Jogador> meias = new ArrayList<>();
	public List<Jogador> atacantes = new ArrayList<>();
	public List<String> links = new ArrayList<>();
	public int qtd_de_jogadores = 30;
	
    public Time(List<Jogador> goleiros, List<Jogador> zagueiros, List<Jogador> laterais_direitos, List<Jogador> laterais_esquerdos, List<Jogador> volantes, List<Jogador> meias, List<Jogador> atacantes, List<String> links) {
    	this.goleiros = goleiros;
    	this.zagueiros = zagueiros;
    	this.laterais_direitos = laterais_direitos;
    	this.laterais_esquerdos = laterais_esquerdos;
    	this.volantes = volantes;
    	this.meias = meias;
    	this.atacantes = atacantes;
    	this.links = links;
    	this.qtd_de_jogadores = 30;
    }

	public Time() {
    }

	public List<Jogador> getGoleiros() {
		return goleiros;
	}

	public void setGoleiros(List<Jogador> goleiros) {
		this.goleiros = goleiros;
	}

	public List<Jogador> getZagueiros() {
		return zagueiros;
	}

	public void setZagueiros(List<Jogador> zagueiros) {
		this.zagueiros = zagueiros;
	}

	public List<Jogador> getLaterais_direitos() {
		return laterais_direitos;
	}

	public void setLaterais_direitos(List<Jogador> laterais_direitos) {
		this.laterais_direitos = laterais_direitos;
	}

	public List<Jogador> getLaterais_esquerdos() {
		return laterais_esquerdos;
	}

	public void setLaterais_esquerdos(List<Jogador> laterais_esquerdos) {
		this.laterais_esquerdos = laterais_esquerdos;
	}

	public List<Jogador> getVolantes() {
		return volantes;
	}

	public void setVolantes(List<Jogador> volantes) {
		this.volantes = volantes;
	}

	public List<Jogador> getMeias() {
		return meias;
	}

	public void setMeias(List<Jogador> meias) {
		this.meias = meias;
	}

	public List<Jogador> getAtacantes() {
		return atacantes;
	}

	public void setAtacantes(List<Jogador> atacantes) {
		this.atacantes = atacantes;
	}

	public int getQtd_de_jogadores() {
		return qtd_de_jogadores;
	}

	public void setQtd_de_jogadores(int qtd_de_jogadores) {
		this.qtd_de_jogadores = qtd_de_jogadores;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
	
}