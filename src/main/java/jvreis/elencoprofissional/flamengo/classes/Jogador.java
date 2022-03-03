package jvreis.elencoprofissional.flamengo.classes;

public class Jogador {
	public String apelido;
	public String nome;
	public String numero;
	public String posicao;
	public String nascimento;
	public String cidade;
	public String link;
	
    public Jogador(String apelido, String nome, String numero, String posicao, String nascimento, String cidade, String link) {
    	this.apelido = apelido;
    	this.nome = nome;
    	this.numero = numero;
    	this.posicao = posicao;
    	this.nascimento = nascimento;
    	this.cidade = cidade;
    	this.link = link;
    }
    
	public Jogador() {
    }

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
