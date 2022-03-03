package entity;

import javax.persistence.Entity;

@Entity
public class Cliente {
	
	private String nome;
	private String email;
	private String dataDeNascimento;
	private String numeroDeTelefone;
	private long id;
	
	public Cliente(String nome, String email, String numeroDeTelefone, String dataDeNascimento) {
		this.nome = nome;
		this.email = email;
		this.numeroDeTelefone = numeroDeTelefone;
		this.dataDeNascimento = dataDeNascimento;
		this.id = System.currentTimeMillis();
	}
	
	public Cliente() {
		
	}

	public String toString() {
		return "Nome: " + this.nome + " Email: " + this.email + " Data De Nascimento: " + this.dataDeNascimento + " Contato: " + this.numeroDeTelefone
				+ "Id: " + this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNumeroDeTelefone() {
		return numeroDeTelefone;
	}

	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
