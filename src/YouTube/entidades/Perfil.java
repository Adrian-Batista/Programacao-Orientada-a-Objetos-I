package YouTube.entidades;

public abstract class Perfil {
	protected String nome;
	protected String email;
	private String senha;
	
	
	public Perfil(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public Perfil(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = null;
	}
		
	public abstract void MetodoAbstrato();
	
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
	
	

}
