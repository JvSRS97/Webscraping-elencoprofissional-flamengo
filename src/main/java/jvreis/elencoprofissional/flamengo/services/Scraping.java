package jvreis.elencoprofissional.flamengo.services;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jvreis.elencoprofissional.flamengo.classes.Jogador;
import jvreis.elencoprofissional.flamengo.classes.Time;

public class Scraping {
	// retorna uma lista de Linhas (olhar classe Dados)
	public static Time search() {
		// 1 - URL do site a ser acessado
		String link = ("https://www.flamengo.com.br/elencos/elenco-profissional");

		Document documento = null;
		try {
			// 2 - Conectando e obtendo uma cópia do html inteiro da página
			documento = Jsoup.connect(link).get();
		} catch (Exception e) {
			System.out.println("Site Indisponível ou falha na requisição!");
		}

		Time dados;
		dados = new Time();

		Element tela = documento.getElementsByClass("container py-5").first();// tela completa
		List<Element> row = tela.getElementsByClass("row");// Lista de elementos separados por posicao dos jogadores (7
		// posicoes)
		
		//Pegando os elementos de cada posicao
		//----------------------------
		List<Element> goleiros, zagueiros, laterais_direitos, laterais_esquerdos, volantes, meias, atacantes;
		goleiros = null;
		zagueiros = null;
		laterais_direitos = null;
		laterais_esquerdos = null;
		volantes = null;
		meias = null;
		atacantes = null;

		int contador = 1;
		for (Element elemento : row) {
			if (contador == 1) {// goleiros
				goleiros = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			} else if (contador == 2) {// zagueiros
				zagueiros = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			} else if (contador == 3) {// laterais direitos
				laterais_direitos = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			} else if (contador == 4) {// laterais esquerdos
				laterais_esquerdos = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			} else if (contador == 5) {// volantes
				volantes = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			} else if (contador == 6) {// meias
				meias = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			} else if (contador == 7) {// atacantes
				atacantes = elemento.getElementsByClass("elenco-atleta");
				contador += 1;
			}
		}
		//----------------------------
		
		
		//pegando o link de cada jogador
		//----------------------------	
		int i;
		Jogador bckp;
		List<String> dados_links;
		dados_links = new ArrayList<>();
		
		dados_links = pegar_links(goleiros);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.goleiros.add(bckp);
		}
		
		dados_links = pegar_links(zagueiros);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.zagueiros.add(bckp);
		}
		
		dados_links = pegar_links(laterais_direitos);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.laterais_direitos.add(bckp);
		}
		
		dados_links = pegar_links(laterais_esquerdos);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.laterais_esquerdos.add(bckp);
		}
		
		dados_links = pegar_links(volantes);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.volantes.add(bckp);
		}
		
		dados_links = pegar_links(meias);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.meias.add(bckp);
		}
		
		dados_links = pegar_links(atacantes);
		for(i=0; i < dados_links.size();i++) {
			bckp = acessar_jogador_pg(dados_links.get(i));
			dados.atacantes.add(bckp);
		}		
		return dados;
	}
	//--------------------------------------------------------------------	
		
	public static List<String> pegar_links(List<Element> posicao) {
		List<String> links = new ArrayList<>();
		for(Element jogador : posicao) {
			Element tag_a;
			tag_a = jogador.getElementsByTag("a").first();
			links.add(tag_a.attr("href"));
		}
		return links;
	}
	
	
	// Metodo para acessar a pg do jogador de acordo com o link
	public static Jogador acessar_jogador_pg(String link_jogador) {
	Jogador jogador;
	jogador = new Jogador();
	
	Document documento_1 = null;
	String numero, apelido, nome, posicao, nascimento, cidade;
	
	try {
		// 2 - Conectando e obtendo uma cópia do html inteiro da página
		documento_1 = Jsoup.connect(link_jogador).get();
	} catch (Exception e) {
		System.out.println("Site Indisponível ou falha na requisição!");
	}
	
	Element tela_2 = documento_1.getElementsByClass("card-body pl-10 p-relative info-persona").first();
	numero = tela_2.getElementsByClass("text-danger d-flex justify-content-center align-items-center font-weight-bold shirt-number").text();
	apelido = tela_2.getElementsByTag("h2").first().text();
	nome = tela_2.getElementsByTag("p").first().text();
	//----------
	Element ul;
	Elements li;
	ul = tela_2.getElementsByClass("list-unstyled mb-1").first();
	li = ul.getElementsByTag("li");
	posicao = li.get(0).text();
	nascimento = li.get(1).text();
	cidade = li.get(2).text();
	
	jogador.setNumero(numero);
	jogador.setApelido(apelido);
	jogador.setNome(nome);
	jogador.setPosicao(posicao);
	jogador.setNascimento(nascimento);
	jogador.setCidade(cidade);
	jogador.setLink(link_jogador);
	
	return jogador;
	}
}