package YouTube.entidades;

import YouTube.Main;

public class Canais {

	private Usuarios usuario;
	private String nomecanal;
	private String descricao;
	private PublicoAlvo publico;
	private int inscritos;


public Canais(Usuarios usuario, String nomecanal, String descricao, PublicoAlvo publico, int inscritos) {
	super();
	this.usuario = usuario;
	this.nomecanal = nomecanal;
	this.descricao = descricao;
	this.publico = publico;
	this.inscritos = inscritos;
}

public Canais() {
	// TODO Auto-generated constructor stub
}

public static int VerificarNomeCanal(String auxiliar) {
	for (int indice = 0; indice < Main.canais.size(); indice++) {
		if (Main.canais.get(indice).getNomecanal().contentEquals(auxiliar)) {
			Main.LimparTela();
			System.out.printf("Canal Localizado com Sucesso!! \n\n");
			return 1;
		}
	}
	Main.LimparTela();
	System.out.printf("Canal não Localizado Tente Novamente!! \n\n");
	return 0;
}

// --------------------- GETTERS E SETTERS ----------------------------
	
	

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
	public PublicoAlvo getPublico() {
		return publico;
	}
	public void setPublico(PublicoAlvo publico) {
		this.publico = publico;
	}

	public int getInscritos() {
		return inscritos;
	}

	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}
	

}
