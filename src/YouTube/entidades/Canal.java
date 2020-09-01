package YouTube.entidades;

import YouTube.Main;

public class Canal {

	private Usuario usuario;
	private String nomecanal;
	private String descricao;
	private PublicoAlvo publico;
	private Inscricao inscritos;


	public Canal(Usuario usuario, String nomecanal, String descricao, PublicoAlvo publico, Inscricao inscritos) {
		super();
		this.usuario = usuario;
		this.nomecanal = nomecanal;
		this.descricao = descricao;
		this.publico = publico;
		this.inscritos = inscritos;
	}

	public Canal() {
		
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
		System.out.printf("Canal não Localizado!! \n\n");
		return 0;
	}
	public static boolean VerificarCanalBoolean(String auxiliar) {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getNomecanal().contentEquals(auxiliar)) {
				Main.LimparTela();
				System.out.printf("Canal já existente, escolha outro nome!! \n\n");
				return true;
			}
		}
		Main.LimparTela();
		System.out.printf("Nome do Canal disponível!! \n\n");
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

	public Inscricao getInscritos() {
		return inscritos;
	}

	public void setInscritos(Inscricao inscritos) {
		this.inscritos = inscritos;
	}


}
