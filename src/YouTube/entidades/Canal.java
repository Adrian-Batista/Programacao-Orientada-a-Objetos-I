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
			if (Main.canal.get(indice).getNome().contentEquals(auxiliar)) {
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
			if (Main.canal.get(indice).getNome().contentEquals(auxiliar)) {
				Main.LimparTela();
				System.out.printf("Canal já existente, escolha outro nome!! \n\n");
				return true;
			}
		}
		Main.LimparTela();
		System.out.printf("Nome do Canal disponível!! \n\n");
		return false;
	}
	public static boolean VerificarEmailCanalBoolean(String auxiliar) {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getEmail().contentEquals(auxiliar)) {
				Main.LimparTela();
				System.out.printf("E-mail já existente, escolha outro!! \n\n");
				return true;
			}
		}
		Main.LimparTela();
		System.out.printf("E-mail disponível!! \n\n");
		return false;
	}
	
	@Override
	public void MetodoAbstrato() {
		System.out.println("Método abstrato da classe Canal!");
		
	}

	// --------------------- GETTERS E SETTERS ----------------------------

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

	public void setInscrito(Inscricao inscricao) {
		this.inscrito = inscricao;
	}

}
