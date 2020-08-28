package YouTube.entidades;

import YouTube.Main;

public class Canais {

	private Usuarios usuario;
	private String nomecanal;
	private String descricao;
	private PublicoAlvo publico;
	private Inscricoes inscritos;


	public Canais(Usuarios usuario, String nomecanal, String descricao, PublicoAlvo publico, Inscricoes inscritos) {
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
				System.out.printf("Canal Localizado!! \n\n");
				return 1;
			}
		}
		Main.LimparTela();
		System.out.printf("Canal n�o Localizado!! \n\n");
		return 0;
	}
	public static boolean VerificarNomeCanal1(String auxiliar) {
		for (int indice = 0; indice < Main.canais.size(); indice++) {
			if (Main.canais.get(indice).getNomecanal().contentEquals(auxiliar)) {
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

	public Inscricoes getInscritos() {
		return inscritos;
	}

	public void setInscritos(Inscricoes inscritos) {
		this.inscritos = inscritos;
	}


}
