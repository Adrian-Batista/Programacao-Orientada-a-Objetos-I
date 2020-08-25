package YouTube.entidades;

public class Canais {

	private String nome;
	private String autor;
	private String descricao;
	private String publico;

public Canais(String nome, String autor, String descricao, String publico) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.descricao = descricao;
		this.publico = publico;
	}

// --------------------- GETTERS E SETTERS ----------------------------
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPublico() {
		return publico;
	}
	public void setPublico(String publico) {
		this.publico = publico;
	}
	

}
