package YouTube.entidades;

import YouTube.Main;

public class Canal extends Perfil{
	
	private String descricao;
	private PublicoAlvo publico;
	private Inscricao inscrito;

	public Canal(String nome, String email, String descricao, PublicoAlvo publico, Inscricao inscrito) {
		super(nome, email);
		this.descricao = descricao;
		this.publico = publico;
		this.inscrito = inscrito;
	}
	public Canal(String nome, String email, String descricao) {
		super(nome, email);
		this.descricao = descricao;
		this.publico = null;
		this.inscrito = null;
	}

	public static int VerificarCanalInt(String auxiliar) {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getNomecanal().contentEquals(auxiliar)) {
				Main.LimparTela();
				System.out.printf("Canal Localizado!! \n\n");
				return 1;
			}
		}
		Main.LimparTela();
		System.out.printf("Canal n�o Localizado!! \n\n");
		return 0;
	}
	public static boolean VerificarCanalBoolean(String auxiliar) {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getNomecanal().contentEquals(auxiliar)) {
				Main.LimparTela();
				System.out.printf("Canal j� existente, escolha outro nome!! \n\n");
				return true;
			}
		}
		Main.LimparTela();
		System.out.printf("Nome do Canal dispon�vel!! \n\n");
		return false;
	}

	// --------------------- GETTERS E SETTERS ----------------------------

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
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

	public Inscricao getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscricao inscrito) {
		this.inscrito = inscrito;
	}


}
