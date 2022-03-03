package jvreis.elencoprofissional.flamengo.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import jvreis.elencoprofissional.flamengo.classes.Jogador;
import jvreis.elencoprofissional.flamengo.classes.Time;

public class ScrapingConfiguration {
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\elencoprofissional.flamengo\\Scraping-time-info.txt";
	private String path_2 = "C:\\Users\\jvict\\eclipse-workspace\\elencoprofissional.flamengo\\Scraping-time-resumo.txt";
	private String path_3 = "C:\\Users\\jvict\\eclipse-workspace\\elencoprofissional.flamengo\\Scraping-links-jogadores.txt";

	private OutputStreamWriter writer;

	public ScrapingConfiguration() {
		executar();
	}

	// ------------------------------------------------------------------
	private void escreverFile(String texto, String caminho) {
		try {
			File arquivo = new File(caminho);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));
			writer.write(texto);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------
	private void executar() {
		Time time;
		time = new Time();

		time = Scraping.search();

		imprimir_time_resumo(time);
		imprimir_time_info(time);
		imprimir_links(time);
		escreverFile(time_info_to_txt(time), path);
		escreverFile(time_resumo_to_txt(time), path_2);
		escreverFile(time_link_to_txt(time), path_3);
	}

	// Para impressão
	private void imprimir_links(Time flamengo) {
			System.out.println("\n-------------------------------\nLinks");
			System.out.println("Goleiros: ");
			for (Jogador goleiro : flamengo.goleiros) {
				System.out.println(goleiro.link);
			}

			System.out.println("\nZagueiros: ");
			for (Jogador zagueiro : flamengo.zagueiros) {
				System.out.println(zagueiro.link);
			}

			System.out.println("\nLaterais Direitos: ");
			for (Jogador lateral_direito : flamengo.laterais_direitos) {
				System.out.println(lateral_direito.link);
			}

			System.out.println("\nLaterais Esquerdos: ");
			for (Jogador lateral_esquerdo : flamengo.laterais_esquerdos) {
				System.out.println(lateral_esquerdo.link);
			}

			System.out.println("\nVolantes: ");
			for (Jogador volante : flamengo.volantes) {
				System.out.println(volante.link);
			}

			System.out.println("\nMeias: ");
			for (Jogador meia : flamengo.meias) {
				System.out.println(meia.link);
			}

			System.out.println("\nAtacantes: ");
			for (Jogador atacante : flamengo.atacantes) {
				System.out.println(atacante.link);
			}
			System.out.println("-------------------------------");		
	}
	
	private void imprimir_time_resumo(Time flamengo) {
		System.out.println("\n-------------------------------");
		System.out.println("Goleiros: ");
		for (Jogador goleiro : flamengo.goleiros) {
			imprimir_jogador_resumo(goleiro);
		}

		System.out.println("\n\nZagueiros: ");
		for (Jogador zagueiro : flamengo.zagueiros) {
			imprimir_jogador_resumo(zagueiro);
		}

		System.out.println("\n\nLaterais Direitos: ");
		for (Jogador lateral_direito : flamengo.laterais_direitos) {
			imprimir_jogador_resumo(lateral_direito);
		}

		System.out.println("\n\nLaterais Esquerdos: ");
		for (Jogador lateral_esquerdo : flamengo.laterais_esquerdos) {
			imprimir_jogador_resumo(lateral_esquerdo);
		}

		System.out.println("\n\nVolantes: ");
		for (Jogador volante : flamengo.volantes) {
			imprimir_jogador_resumo(volante);
		}

		System.out.println("\n\nMeias: ");
		for (Jogador meia : flamengo.meias) {
			imprimir_jogador_resumo(meia);
		}

		System.out.println("\n\nAtacantes: ");
		for (Jogador atacante : flamengo.atacantes) {
			imprimir_jogador_resumo(atacante);
		}
		System.out.println("\n-------------------------------");
	}

	private void imprimir_time_info(Time flamengo) {
		System.out.println("\n-------------------------------");
		System.out.println("Goleiros: ");
		for (Jogador goleiro : flamengo.goleiros) {
			imprimir_jogador_info(goleiro);
		}

		System.out.println("\nZagueiros: ");
		for (Jogador zagueiro : flamengo.zagueiros) {
			imprimir_jogador_info(zagueiro);
		}

		System.out.println("\nLaterais Direitos: ");
		for (Jogador lateral_direito : flamengo.laterais_direitos) {
			imprimir_jogador_info(lateral_direito);
		}

		System.out.println("\nLaterais Esquerdos: ");
		for (Jogador lateral_esquerdo : flamengo.laterais_esquerdos) {
			imprimir_jogador_info(lateral_esquerdo);
		}

		System.out.println("\nVolantes: ");
		for (Jogador volante : flamengo.volantes) {
			imprimir_jogador_info(volante);
		}

		System.out.println("\nMeias: ");
		for (Jogador meia : flamengo.meias) {
			imprimir_jogador_info(meia);
		}

		System.out.println("\nAtacantes: ");
		for (Jogador atacante : flamengo.atacantes) {
			imprimir_jogador_info(atacante);
		}
		System.out.println("-------------------------------");
	}

	private void imprimir_jogador_info(Jogador jogador) {
		String apelido, nome, numero, posicao, nascimento, cidade;
		apelido = jogador.apelido;
		nome = jogador.nome;
		numero = jogador.numero;
		posicao = jogador.posicao;
		nascimento = jogador.nascimento;
		cidade = jogador.cidade;
		System.out.println("[Apelido: " + apelido + ", Nome: " + nome + ", Numero: " + numero + ", " + posicao
				+ ", " + nascimento + ", " + cidade + "]");
	}

	private void imprimir_jogador_resumo(Jogador jogador) {
		String apelido, numero;
		apelido = jogador.apelido;
		numero = jogador.numero;
		System.out.print("[" + apelido + " " + numero + "]");
	}

	// Para gravação de arquivo txt
	private String time_link_to_txt(Time flamengo) {
		String texto = "";
		texto += "\nGoleiros: \n";
		for (Jogador goleiro : flamengo.goleiros) {
			texto += jogador_link_to_txt(goleiro);
		}

		texto += "\n\nZagueiros: \n";
		for (Jogador zagueiro : flamengo.zagueiros) {
			texto += jogador_link_to_txt(zagueiro);
		}

		texto += "\n\nLaterais Direitos: \n";
		for (Jogador lateral_direito : flamengo.laterais_direitos) {
			texto += jogador_link_to_txt(lateral_direito);
		}

		texto += "\n\nLaterais Esquerdos: \n";
		for (Jogador lateral_esquerdo : flamengo.laterais_esquerdos) {
			texto += jogador_link_to_txt(lateral_esquerdo);
		}

		texto += "\nVolantes: \n";
		for (Jogador volante : flamengo.volantes) {
			texto += jogador_link_to_txt(volante);
		}

		texto += "\nMeias: \n";
		for (Jogador meia : flamengo.meias) {
			texto += jogador_link_to_txt(meia);
		}

		texto += "\nAtacantes: \n";
		for (Jogador atacante : flamengo.atacantes) {
			texto += jogador_link_to_txt(atacante);
		}
		return texto;
	}
	
	private String time_info_to_txt(Time flamengo) {
		String texto = "";
		texto += "\nGoleiros: \n";
		for (Jogador goleiro : flamengo.goleiros) {
			texto += jogador_info_to_txt(goleiro);
		}

		texto += "\n\nZagueiros: \n";
		for (Jogador zagueiro : flamengo.zagueiros) {
			texto += jogador_info_to_txt(zagueiro);
		}

		texto += "\n\nLaterais Direitos: \n";
		for (Jogador lateral_direito : flamengo.laterais_direitos) {
			texto += jogador_info_to_txt(lateral_direito);
		}

		texto += "\n\nLaterais Esquerdos: \n";
		for (Jogador lateral_esquerdo : flamengo.laterais_esquerdos) {
			texto += jogador_info_to_txt(lateral_esquerdo);
		}

		texto += "\nVolantes: \n";
		for (Jogador volante : flamengo.volantes) {
			texto += jogador_info_to_txt(volante);
		}

		texto += "\nMeias: \n";
		for (Jogador meia : flamengo.meias) {
			texto += jogador_info_to_txt(meia);
		}

		texto += "\nAtacantes: \n";
		for (Jogador atacante : flamengo.atacantes) {
			texto += jogador_info_to_txt(atacante);
		}
		return texto;
	}

	private String time_resumo_to_txt(Time flamengo) {
		String texto = "";
		texto += "\nGoleiros: \n";
		for (Jogador goleiro : flamengo.goleiros) {
			texto += jogador_resumo_to_txt(goleiro);
		}

		texto += "\n\nZagueiros: \n";
		for (Jogador zagueiro : flamengo.zagueiros) {
			texto += jogador_resumo_to_txt(zagueiro);
		}

		texto += "\n\nLaterais Direitos: \n";
		for (Jogador lateral_direito : flamengo.laterais_direitos) {
			texto += jogador_resumo_to_txt(lateral_direito);
		}

		texto += "\n\nLaterais Esquerdos: \n";
		for (Jogador lateral_esquerdo : flamengo.laterais_esquerdos) {
			texto += jogador_resumo_to_txt(lateral_esquerdo);
		}

		texto += "\nVolantes: \n";
		for (Jogador volante : flamengo.volantes) {
			texto += jogador_resumo_to_txt(volante);
		}

		texto += "\nMeias: \n";
		for (Jogador meia : flamengo.meias) {
			texto += jogador_resumo_to_txt(meia);
		}

		texto += "\nAtacantes: \n";
		for (Jogador atacante : flamengo.atacantes) {
			texto += jogador_resumo_to_txt(atacante);
		}
		return texto;
	}

	private String jogador_info_to_txt(Jogador jogador) {
		String texto = "";
		String apelido, nome, numero, posicao, nascimento, cidade;
		apelido = jogador.apelido;
		nome = jogador.nome;
		numero = jogador.numero;
		posicao = jogador.posicao;
		nascimento = jogador.nascimento;
		cidade = jogador.cidade;

		texto += "Apelido: " + apelido + "\tNome: " + nome + "\tNumero: " + numero + "\t" + posicao + "\t" + nascimento + "\t" + cidade
				+ "\n";

		return texto;
	}

	private String jogador_resumo_to_txt(Jogador jogador) {
		String texto = "";
		String apelido, numero;
		apelido = jogador.apelido;
		numero = jogador.numero;
		texto += apelido + "\t" + numero + "\n";
		return texto;
	}
	
	private String jogador_link_to_txt(Jogador jogador) {
		String texto = "";
		String link;
		link = jogador.link;
		texto += link+"\n";
		return texto;
	}
}
