package YouTube.entidades;

public class Canais {

	private Usuarios usuario;
	private String nomecanal;
	private String descricao;
	private String publico;
	private int inscritos;


public Canais(Usuarios usuario, String nomecanal, String descricao, String publico, int inscritos) {
	super();
	this.usuario = usuario;
	this.nomecanal = nomecanal;
	this.descricao = descricao;
	this.publico = publico;
	this.inscritos = inscritos;
}

// --------------------- GETTERS E SETTERS ----------------------------
	
	public Canais() {
	// TODO Auto-generated constructor stub
}

	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public String getNomecanal() {
		return nomecanal;
	}
	public void setNomecanal(String nomecanal) {
		this.nomecanal = nomecanal;
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

	public int getInscritos() {
		return inscritos;
	}

	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}
	

}
