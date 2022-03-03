package entity;

import javax.persistence.Entity;

@Entity
public class Produto {
	
	private Long id;
	private String nome;
	private int valor;
	private String descricao;
	private int precoPorMetro;
	
	public Produto() {
		
	}
	
	public Produto( String nome, int valor, int precoPorMetro,String descricao) {
		this.nome = nome;
		this.valor = valor;
		this.precoPorMetro = precoPorMetro;
		this.descricao = descricao;
		this.id = System.currentTimeMillis();
	}
	
	public String toString() {
		return "Nome: " + this.nome + " Descrição: " + this.descricao + " Valor: " + this.valor + " Preço por metro: " + this.precoPorMetro + " Id: " + this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}
	
	public int getPrecoPorMetro() {
		return precoPorMetro;
	}

	public void setPrecoPorMetro(int precoPorMetro) {
		this.precoPorMetro = precoPorMetro;
	}

	public void setID(Long id) {
		this.id = id;
	}
}
