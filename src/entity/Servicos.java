package entity;

public class Servicos {
	
	String nome;
	String tempoDeDuracao;
	String descricao;
	long id;
	int valor;

	public Servicos() {

	}

	public Servicos(String nome, int valor, String descricao, String tempoDeServico) {
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.tempoDeDuracao = tempoDeServico;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		return "Serviço contratado: " + this.nome + " Tempo Do Serviço: " + this.tempoDeDuracao + " Descrição: " + this.descricao + " Valor Do Serviço: "
				+ this.valor + " ID Do Serviço: " + this.id;
	}

	public String getTempoDeDuracao() {
		return tempoDeDuracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTempoDeDuracao(String tempoDeDuracao) {
		this.tempoDeDuracao = tempoDeDuracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
