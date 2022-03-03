package entity;

public class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	private String comfirmarSenha;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email, String senha, String comfirmarSenha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.comfirmarSenha = comfirmarSenha;
	}
	
	public String toString() {
		return "Nome: " + this.nome + " Email: " + this.email + " Senha: " + this.senha;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getComfirmarSenha() {
		return comfirmarSenha;
	}

	public void setComfirmarSenha(String comfirmarSenha) {
		this.comfirmarSenha = comfirmarSenha;
	}
}
