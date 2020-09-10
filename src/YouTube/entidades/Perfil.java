package YouTube.entidades;

public class Perfil {
	protected String nome;
	protected String email;
	private int id;
	
	
	public Perfil(String nome, String email, int id) {
		super();
		this.nome = nome;
		this.email = email;
		this.id = id;
	}
	public Perfil(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
		this.id = 0;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
