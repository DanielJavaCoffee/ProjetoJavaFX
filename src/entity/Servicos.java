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
		return "Servi�o contratado: " + this.nome + " Tempo Do Servi�o: " + this.tempoDeDuracao + " Descri��o: " + this.descricao + " Valor Do Servi�o: "
				+ this.valor + " ID Do Servi�o: " + this.id;
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
